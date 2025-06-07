
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 安保
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/anbao")
public class AnbaoController {
    private static final Logger logger = LoggerFactory.getLogger(AnbaoController.class);

    private static final String TABLE_NAME = "anbao";

    @Autowired
    private AnbaoService anbaoService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表非注册的service
    //注册表service
    @Autowired
    private YonghuService yonghuService;
    @Autowired
    private YuangongService yuangongService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("住户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("员工".equals(role))
            params.put("yuangongId",request.getSession().getAttribute("userId"));
        CommonUtil.checkMap(params);
        PageUtils page = anbaoService.queryPage(params);

        //字典表数据转换
        List<AnbaoView> list =(List<AnbaoView>)page.getList();
        for(AnbaoView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        AnbaoEntity anbao = anbaoService.selectById(id);
        if(anbao !=null){
            //entity转view
            AnbaoView view = new AnbaoView();
            BeanUtils.copyProperties( anbao , view );//把实体数据重构到view中
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody AnbaoEntity anbao, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,anbao:{}",this.getClass().getName(),anbao.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<AnbaoEntity> queryWrapper = new EntityWrapper<AnbaoEntity>()
            .eq("anbao_name", anbao.getAnbaoName())
            .eq("anbao_phone", anbao.getAnbaoPhone())
            .eq("anbao_id_number", anbao.getAnbaoIdNumber())
            .eq("sex_types", anbao.getSexTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        AnbaoEntity anbaoEntity = anbaoService.selectOne(queryWrapper);
        if(anbaoEntity==null){
            anbao.setCreateTime(new Date());
            anbaoService.insert(anbao);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody AnbaoEntity anbao, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,anbao:{}",this.getClass().getName(),anbao.toString());
        AnbaoEntity oldAnbaoEntity = anbaoService.selectById(anbao.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<AnbaoEntity> queryWrapper = new EntityWrapper<AnbaoEntity>()
            .notIn("id",anbao.getId())
            .andNew()
            .eq("anbao_name", anbao.getAnbaoName())
            .eq("anbao_phone", anbao.getAnbaoPhone())
            .eq("anbao_id_number", anbao.getAnbaoIdNumber())
            .eq("sex_types", anbao.getSexTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        AnbaoEntity anbaoEntity = anbaoService.selectOne(queryWrapper);
        if("".equals(anbao.getAnbaoPhoto()) || "null".equals(anbao.getAnbaoPhoto())){
                anbao.setAnbaoPhoto(null);
        }
        if(anbaoEntity==null){
            anbaoService.updateById(anbao);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<AnbaoEntity> oldAnbaoList =anbaoService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        anbaoService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<AnbaoEntity> anbaoList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            AnbaoEntity anbaoEntity = new AnbaoEntity();
//                            anbaoEntity.setAnbaoName(data.get(0));                    //安保姓名 要改的
//                            anbaoEntity.setAnbaoPhone(data.get(0));                    //安保手机号 要改的
//                            anbaoEntity.setAnbaoIdNumber(data.get(0));                    //安保身份证号 要改的
//                            anbaoEntity.setAnbaoPhoto("");//详情和图片
//                            anbaoEntity.setSexTypes(Integer.valueOf(data.get(0)));   //性别 要改的
//                            anbaoEntity.setCreateTime(date);//时间
                            anbaoList.add(anbaoEntity);


                            //把要查询是否重复的字段放入map中
                                //安保手机号
                                if(seachFields.containsKey("anbaoPhone")){
                                    List<String> anbaoPhone = seachFields.get("anbaoPhone");
                                    anbaoPhone.add(data.get(0));//要改的
                                }else{
                                    List<String> anbaoPhone = new ArrayList<>();
                                    anbaoPhone.add(data.get(0));//要改的
                                    seachFields.put("anbaoPhone",anbaoPhone);
                                }
                                //安保身份证号
                                if(seachFields.containsKey("anbaoIdNumber")){
                                    List<String> anbaoIdNumber = seachFields.get("anbaoIdNumber");
                                    anbaoIdNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> anbaoIdNumber = new ArrayList<>();
                                    anbaoIdNumber.add(data.get(0));//要改的
                                    seachFields.put("anbaoIdNumber",anbaoIdNumber);
                                }
                        }

                        //查询是否重复
                         //安保手机号
                        List<AnbaoEntity> anbaoEntities_anbaoPhone = anbaoService.selectList(new EntityWrapper<AnbaoEntity>().in("anbao_phone", seachFields.get("anbaoPhone")));
                        if(anbaoEntities_anbaoPhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(AnbaoEntity s:anbaoEntities_anbaoPhone){
                                repeatFields.add(s.getAnbaoPhone());
                            }
                            return R.error(511,"数据库的该表中的 [安保手机号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //安保身份证号
                        List<AnbaoEntity> anbaoEntities_anbaoIdNumber = anbaoService.selectList(new EntityWrapper<AnbaoEntity>().in("anbao_id_number", seachFields.get("anbaoIdNumber")));
                        if(anbaoEntities_anbaoIdNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(AnbaoEntity s:anbaoEntities_anbaoIdNumber){
                                repeatFields.add(s.getAnbaoIdNumber());
                            }
                            return R.error(511,"数据库的该表中的 [安保身份证号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        anbaoService.insertBatch(anbaoList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }





    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = anbaoService.queryPage(params);

        //字典表数据转换
        List<AnbaoView> list =(List<AnbaoView>)page.getList();
        for(AnbaoView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        AnbaoEntity anbao = anbaoService.selectById(id);
            if(anbao !=null){


                //entity转view
                AnbaoView view = new AnbaoView();
                BeanUtils.copyProperties( anbao , view );//把实体数据重构到view中

                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody AnbaoEntity anbao, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,anbao:{}",this.getClass().getName(),anbao.toString());
        Wrapper<AnbaoEntity> queryWrapper = new EntityWrapper<AnbaoEntity>()
            .eq("anbao_name", anbao.getAnbaoName())
            .eq("anbao_phone", anbao.getAnbaoPhone())
            .eq("anbao_id_number", anbao.getAnbaoIdNumber())
            .eq("sex_types", anbao.getSexTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        AnbaoEntity anbaoEntity = anbaoService.selectOne(queryWrapper);
        if(anbaoEntity==null){
            anbao.setCreateTime(new Date());
        anbaoService.insert(anbao);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}
