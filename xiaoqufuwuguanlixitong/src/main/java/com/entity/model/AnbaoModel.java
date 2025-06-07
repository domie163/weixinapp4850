package com.entity.model;

import com.entity.AnbaoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 安保
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class AnbaoModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 安保姓名
     */
    private String anbaoName;


    /**
     * 安保手机号
     */
    private String anbaoPhone;


    /**
     * 安保身份证号
     */
    private String anbaoIdNumber;


    /**
     * 安保照片
     */
    private String anbaoPhoto;


    /**
     * 性别
     */
    private Integer sexTypes;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
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

    }
