package com.dao;

import com.entity.AnbaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.AnbaoView;

/**
 * 安保 Dao 接口
 *
 * @author 
 */
public interface AnbaoDao extends BaseMapper<AnbaoEntity> {

   List<AnbaoView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
