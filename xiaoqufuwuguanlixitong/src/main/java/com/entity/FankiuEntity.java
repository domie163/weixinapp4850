package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 反馈
 *
 * @author 
 * @email
 */
@TableName("fankiu")
public class FankiuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public FankiuEntity() {

	}

	public FankiuEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 反馈名称
     */
    @ColumnInfo(comment="反馈名称",type="varchar(200)")
    @TableField(value = "fankiu_name")

    private String fankiuName;


    /**
     * 反馈图片
     */
    @ColumnInfo(comment="反馈图片",type="varchar(200)")
    @TableField(value = "fankiu_photo")

    private String fankiuPhoto;


    /**
     * 反馈类型
     */
    @ColumnInfo(comment="反馈类型",type="int(11)")
    @TableField(value = "fankiu_types")

    private Integer fankiuTypes;


    /**
     * 申请反馈时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="申请反馈时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 反馈状态
     */
    @ColumnInfo(comment="反馈状态",type="int(11)")
    @TableField(value = "fankiu_zhuangtai_types")

    private Integer fankiuZhuangtaiTypes;


    /**
     * 反馈详情
     */
    @ColumnInfo(comment="反馈详情",type="text")
    @TableField(value = "fankiu_content")

    private String fankiuContent;


    /**
     * 创建时间  listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 设置：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }
    /**
	 * 设置：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：反馈名称
	 */
    public String getFankiuName() {
        return fankiuName;
    }
    /**
	 * 设置：反馈名称
	 */

    public void setFankiuName(String fankiuName) {
        this.fankiuName = fankiuName;
    }
    /**
	 * 获取：反馈图片
	 */
    public String getFankiuPhoto() {
        return fankiuPhoto;
    }
    /**
	 * 设置：反馈图片
	 */

    public void setFankiuPhoto(String fankiuPhoto) {
        this.fankiuPhoto = fankiuPhoto;
    }
    /**
	 * 获取：反馈类型
	 */
    public Integer getFankiuTypes() {
        return fankiuTypes;
    }
    /**
	 * 设置：反馈类型
	 */

    public void setFankiuTypes(Integer fankiuTypes) {
        this.fankiuTypes = fankiuTypes;
    }
    /**
	 * 获取：申请反馈时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：申请反馈时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：反馈状态
	 */
    public Integer getFankiuZhuangtaiTypes() {
        return fankiuZhuangtaiTypes;
    }
    /**
	 * 设置：反馈状态
	 */

    public void setFankiuZhuangtaiTypes(Integer fankiuZhuangtaiTypes) {
        this.fankiuZhuangtaiTypes = fankiuZhuangtaiTypes;
    }
    /**
	 * 获取：反馈详情
	 */
    public String getFankiuContent() {
        return fankiuContent;
    }
    /**
	 * 设置：反馈详情
	 */

    public void setFankiuContent(String fankiuContent) {
        this.fankiuContent = fankiuContent;
    }
    /**
	 * 获取：创建时间  listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间  listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Fankiu{" +
            ", id=" + id +
            ", yonghuId=" + yonghuId +
            ", fankiuName=" + fankiuName +
            ", fankiuPhoto=" + fankiuPhoto +
            ", fankiuTypes=" + fankiuTypes +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", fankiuZhuangtaiTypes=" + fankiuZhuangtaiTypes +
            ", fankiuContent=" + fankiuContent +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
