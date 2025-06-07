package com.entity.vo;

import com.entity.WeixuiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 反馈处理
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("weixui")
public class WeixuiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 反馈
     */

    @TableField(value = "fankiu_id")
    private Integer fankiuId;


    /**
     * 维修人员
     */

    @TableField(value = "yuangong_id")
    private Integer yuangongId;


    /**
     * 指派时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 备注
     */

    @TableField(value = "weixui_text")
    private String weixuiText;


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
	 * 设置：反馈
	 */
    public Integer getFankiuId() {
        return fankiuId;
    }


    /**
	 * 获取：反馈
	 */

    public void setFankiuId(Integer fankiuId) {
        this.fankiuId = fankiuId;
    }
    /**
	 * 设置：维修人员
	 */
    public Integer getYuangongId() {
        return yuangongId;
    }


    /**
	 * 获取：维修人员
	 */

    public void setYuangongId(Integer yuangongId) {
        this.yuangongId = yuangongId;
    }
    /**
	 * 设置：指派时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：指派时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：备注
	 */
    public String getWeixuiText() {
        return weixuiText;
    }


    /**
	 * 获取：备注
	 */

    public void setWeixuiText(String weixuiText) {
        this.weixuiText = weixuiText;
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
