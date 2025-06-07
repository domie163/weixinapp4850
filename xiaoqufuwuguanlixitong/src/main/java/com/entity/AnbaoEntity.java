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
 * 安保
 *
 * @author 
 * @email
 */
@TableName("anbao")
public class AnbaoEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public AnbaoEntity() {

	}

	public AnbaoEntity(T t) {
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
     * 安保姓名
     */
    @ColumnInfo(comment="安保姓名",type="varchar(200)")
    @TableField(value = "anbao_name")

    private String anbaoName;


    /**
     * 安保手机号
     */
    @ColumnInfo(comment="安保手机号",type="varchar(200)")
    @TableField(value = "anbao_phone")

    private String anbaoPhone;


    /**
     * 安保身份证号
     */
    @ColumnInfo(comment="安保身份证号",type="varchar(200)")
    @TableField(value = "anbao_id_number")

    private String anbaoIdNumber;


    /**
     * 安保照片
     */
    @ColumnInfo(comment="安保照片",type="varchar(200)")
    @TableField(value = "anbao_photo")

    private String anbaoPhoto;


    /**
     * 性别
     */
    @ColumnInfo(comment="性别",type="int(11)")
    @TableField(value = "sex_types")

    private Integer sexTypes;


    /**
     * 创建时间
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
	 * 获取：安保姓名
	 */
    public String getAnbaoName() {
        return anbaoName;
    }
    /**
	 * 设置：安保姓名
	 */

    public void setAnbaoName(String anbaoName) {
        this.anbaoName = anbaoName;
    }
    /**
	 * 获取：安保手机号
	 */
    public String getAnbaoPhone() {
        return anbaoPhone;
    }
    /**
	 * 设置：安保手机号
	 */

    public void setAnbaoPhone(String anbaoPhone) {
        this.anbaoPhone = anbaoPhone;
    }
    /**
	 * 获取：安保身份证号
	 */
    public String getAnbaoIdNumber() {
        return anbaoIdNumber;
    }
    /**
	 * 设置：安保身份证号
	 */

    public void setAnbaoIdNumber(String anbaoIdNumber) {
        this.anbaoIdNumber = anbaoIdNumber;
    }
    /**
	 * 获取：安保照片
	 */
    public String getAnbaoPhoto() {
        return anbaoPhoto;
    }
    /**
	 * 设置：安保照片
	 */

    public void setAnbaoPhoto(String anbaoPhoto) {
        this.anbaoPhoto = anbaoPhoto;
    }
    /**
	 * 获取：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }
    /**
	 * 设置：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Anbao{" +
            ", id=" + id +
            ", anbaoName=" + anbaoName +
            ", anbaoPhone=" + anbaoPhone +
            ", anbaoIdNumber=" + anbaoIdNumber +
            ", anbaoPhoto=" + anbaoPhoto +
            ", sexTypes=" + sexTypes +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
