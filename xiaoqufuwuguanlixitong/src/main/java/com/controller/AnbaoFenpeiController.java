
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
 * 安保分配
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/anbaoFenpei")
public class AnbaoFenpeiController {
    private static final Logger logger = LoggerFactory.getLogger(AnbaoFenpeiController.class);

    private static final String TABLE_NAME = "anbaoFenpei";

    @Autowired
    private AnbaoFenpeiService anbaoFenpeiService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表非注册的service
    @Autowired
    private AnbaoService anbaoService;
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
        PageUtils page = anbaoFenpeiService.queryPage(params);

        //字典表数据转换
        List<AnbaoFenpeiView> list =(List<AnbaoFenpeiView>)page.getList();
        for(AnbaoFenpeiView c:list){
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
        AnbaoFenpeiEntity anbaoFenpei = anbaoFenpeiService.selectById(id);
        if(anbaoFenpei !=null){
            //entity转view
            AnbaoFenpeiView view = new AnbaoFenpeiView();
            BeanUtils.copyProperties( anbaoFenpei , view );//把实体数据重构到view中
            //级联表 安保
            //级联表
            AnbaoEntity anbao = anbaoService.selectById(anbaoFenpei.getAnbaoId());
            if(anbao != null){
            BeanUtils.copyProperties( anbao , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setAnbaoId(anbao.getId());
            }
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
    public R save(@RequestBody AnbaoFenpeiEntity anbaoFenpei, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,anbaoFenpei:{}",this.getClass().getName(),anbaoFenpei.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<AnbaoFenpeiEntity> queryWrapper = new EntityWrapper<AnbaoFenpeiEntity>()
            .eq("anbao_fenpei_name", anbaoFenpei.getAnbaoFenpeiName())
            .eq("anbao_id", anbaoFenpei.getAnbaoId())
            .eq("anbao_fenpei", anbaoFenpei.getAnbaoFenpei())
            .eq("anbao_fenpei_types", anbaoFenpei.getAnbaoFenpeiTypes())
            .eq("anbao_fenpei_xiangqing", anbaoFenpei.getAnbaoFenpeiXiangqing())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        AnbaoFenpeiEntity anbaoFenpeiEntity = anbaoFenpeiService.selectOne(queryWrapper);
        if(anbaoFenpeiEntity==null){
            anbaoFenpei.setCreateTime(new Date());
            anbaoFenpeiService.insert(anbaoFenpei);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody AnbaoFenpeiEntity anbaoFenpei, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,anbaoFenpei:{}",this.getClass().getName(),anbaoFenpei.toString());
        AnbaoFenpeiEntity oldAnbaoFenpeiEntity = anbaoFenpeiService.selectById(anbaoFenpei.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<AnbaoFenpeiEntity> queryWrapper = new EntityWrapper<AnbaoFenpeiEntity>()
            .notIn("id",anbaoFenpei.getId())
            .andNew()
            .eq("anbao_fenpei_name", anbaoFenpei.getAnbaoFenpeiName())
            .eq("anbao_id", anbaoFenpei.getAnbaoId())
            .eq("anbao_fenpei", anbaoFenpei.getAnbaoFenpei())
            .eq("anbao_fenpei_types", anbaoFenpei.getAnbaoFenpeiTypes())
            .eq("anbao_fenpei_xiangqing", anbaoFenpei.getAnbaoFenpeiXiangqing())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        AnbaoFenpeiEntity anbaoFenpeiEntity = anbaoFenpeiService.selectOne(queryWrapper);
        if(anbaoFenpeiEntity==null){
            anbaoFenpeiService.updateById(anbaoFenpei);//根据id更新
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
        List<AnbaoFenpeiEntity> oldAnbaoFenpeiList =anbaoFenpeiService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        anbaoFenpeiService.deleteBatchIds(Arrays.asList(ids));

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
            List<AnbaoFenpeiEntity> anbaoFenpeiList = new ArrayList<>();//上传的东西
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
                            AnbaoFenpeiEntity anbaoFenpeiEntity = new AnbaoFenpeiEntity();
//                            anbaoFenpeiEntity.setAnbaoFenpeiName(data.get(0));                    //安排名称 要改的
//                            anbaoFenpeiEntity.setAnbaoId(Integer.valueOf(data.get(0)));   //安保 要改的
//                            anbaoFenpeiEntity.setAnbaoFenpei(data.get(0));                    //安排内容 要改的
//                            anbaoFenpeiEntity.setAnbaoFenpeiTypes(Integer.valueOf(data.get(0)));   //安排类型 要改的
//                            anbaoFenpeiEntity.setAnpaiTime(sdf.parse(data.get(0)));          //安排时间 要改的
//                            anbaoFenpeiEntity.setZhxingTime(sdf.parse(data.get(0)));          //执行时间 要改的
//                            anbaoFenpeiEntity.setAnbaoFenpeiXiangqing(data.get(0));                    //安排详情 要改的
//                            anbaoFenpeiEntity.setCreateTime(date);//时间
                            anbaoFenpeiList.add(anbaoFenpeiEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        anbaoFenpeiService.insertBatch(anbaoFenpeiList);
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
        PageUtils page = anbaoFenpeiService.queryPage(params);

        //字典表数据转换
        List<AnbaoFenpeiView> list =(List<AnbaoFenpeiView>)page.getList();
        for(AnbaoFenpeiView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        AnbaoFenpeiEntity anbaoFenpei = anbaoFenpeiService.selectById(id);
            if(anbaoFenpei !=null){


                //entity转view
                AnbaoFenpeiView view = new AnbaoFenpeiView();
                BeanUtils.copyProperties( anbaoFenpei , view );//把实体数据重构到view中

                //级联表
                    AnbaoEntity anbao = anbaoService.selectById(anbaoFenpei.getAnbaoId());
                if(anbao != null){
                    BeanUtils.copyProperties( anbao , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setAnbaoId(anbao.getId());
                }
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
    public R add(@RequestBody AnbaoFenpeiEntity anbaoFenpei, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,anbaoFenpei:{}",this.getClass().getName(),anbaoFenpei.toString());
        Wrapper<AnbaoFenpeiEntity> queryWrapper = new EntityWrapper<AnbaoFenpeiEntity>()
            .eq("anbao_fenpei_name", anbaoFenpei.getAnbaoFenpeiName())
            .eq("anbao_id", anbaoFenpei.getAnbaoId())
            .eq("anbao_fenpei", anbaoFenpei.getAnbaoFenpei())
            .eq("anbao_fenpei_types", anbaoFenpei.getAnbaoFenpeiTypes())
            .eq("anbao_fenpei_xiangqing", anbaoFenpei.getAnbaoFenpeiXiangqing())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        AnbaoFenpeiEntity anbaoFenpeiEntity = anbaoFenpeiService.selectOne(queryWrapper);
        if(anbaoFenpeiEntity==null){
            anbaoFenpei.setCreateTime(new Date());
        anbaoFenpeiService.insert(anbaoFenpei);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}
