package com.dao;

import com.entity.AnbaoFenpeiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.AnbaoFenpeiView;

/**
 * 安保分配 Dao 接口
 *
 * @author 
 */
public interface AnbaoFenpeiDao extends BaseMapper<AnbaoFenpeiEntity> {

   List<AnbaoFenpeiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
