package com.entity.vo;

import com.entity.AnbaoFenpeiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 安保分配
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("anbao_fenpei")
public class AnbaoFenpeiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 安排名称
     */

    @TableField(value = "anbao_fenpei_name")
    private String anbaoFenpeiName;


    /**
     * 安保
     */

    @TableField(value = "anbao_id")
    private Integer anbaoId;


    /**
     * 安排内容
     */

    @TableField(value = "anbao_fenpei")
    private String anbaoFenpei;


    /**
     * 安排类型
     */

    @TableField(value = "anbao_fenpei_types")
    private Integer anbaoFenpeiTypes;


    /**
     * 安排时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "anpai_time")
    private Date anpaiTime;


    /**
     * 执行时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "zhxing_time")
    private Date zhxingTime;


    /**
     * 安排详情
     */

    @TableField(value = "anbao_fenpei_xiangqing")
    private String anbaoFenpeiXiangqing;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：安排名称
	 */
    public String getAnbaoFenpeiName() {
        return anbaoFenpeiName;
    }


    /**
	 * 获取：安排名称
	 */

    public void setAnbaoFenpeiName(String anbaoFenpeiName) {
        this.anbaoFenpeiName = anbaoFenpeiName;
    }
    /**
	 * 设置：安保
	 */
    public Integer getAnbaoId() {
        return anbaoId;
    }


    /**
	 * 获取：安保
	 */

    public void setAnbaoId(Integer anbaoId) {
        this.anbaoId = anbaoId;
    }
    /**
	 * 设置：安排内容
	 */
    public String getAnbaoFenpei() {
        return anbaoFenpei;
    }


    /**
	 * 获取：安排内容
	 */

    public void setAnbaoFenpei(String anbaoFenpei) {
        this.anbaoFenpei = anbaoFenpei;
    }
    /**
	 * 设置：安排类型
	 */
    public Integer getAnbaoFenpeiTypes() {
        return anbaoFenpeiTypes;
    }


    /**
	 * 获取：安排类型
	 */

    public void setAnbaoFenpeiTypes(Integer anbaoFenpeiTypes) {
        this.anbaoFenpeiTypes = anbaoFenpeiTypes;
    }
    /**
	 * 设置：安排时间
	 */
    public Date getAnpaiTime() {
        return anpaiTime;
    }


    /**
	 * 获取：安排时间
	 */

    public void setAnpaiTime(Date anpaiTime) {
        this.anpaiTime = anpaiTime;
    }
    /**
	 * 设置：执行时间
	 */
    public Date getZhxingTime() {
        return zhxingTime;
    }


    /**
	 * 获取：执行时间
	 */

    public void setZhxingTime(Date zhxingTime) {
        this.zhxingTime = zhxingTime;
    }
    /**
	 * 设置：安排详情
	 */
    public String getAnbaoFenpeiXiangqing() {
        return anbaoFenpeiXiangqing;
    }


    /**
	 * 获取：安排详情
	 */

    public void setAnbaoFenpeiXiangqing(String anbaoFenpeiXiangqing) {
        this.anbaoFenpeiXiangqing = anbaoFenpeiXiangqing;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
