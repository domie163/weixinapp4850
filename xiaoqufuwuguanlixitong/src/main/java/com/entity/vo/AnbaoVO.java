package com.entity.vo;

import com.entity.AnbaoEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 安保
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("anbao")
public class AnbaoVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 安保姓名
     */

    @TableField(value = "anbao_name")
    private String anbaoName;


    /**
     * 安保手机号
     */

    @TableField(value = "anbao_phone")
    private String anbaoPhone;


    /**
     * 安保身份证号
     */

    @TableField(value = "anbao_id_number")
    private String anbaoIdNumber;


    /**
     * 安保照片
     */

    @TableField(value = "anbao_photo")
    private String anbaoPhoto;


    /**
     * 性别
     */

    @TableField(value = "sex_types")
    private Integer sexTypes;


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
	 * 设置：安保姓名
	 */
    public String getAnbaoName() {
        return anbaoName;
    }


    /**
	 * 获取：安保姓名
	 */

    public void setAnbaoName(String anbaoName) {
        this.anbaoName = anbaoName;
    }
    /**
	 * 设置：安保手机号
	 */
    public String getAnbaoPhone() {
        return anbaoPhone;
    }


    /**
	 * 获取：安保手机号
	 */

    public void setAnbaoPhone(String anbaoPhone) {
        this.anbaoPhone = anbaoPhone;
    }
    /**
	 * 设置：安保身份证号
	 */
    public String getAnbaoIdNumber() {
        return anbaoIdNumber;
    }


    /**
	 * 获取：安保身份证号
	 */

    public void setAnbaoIdNumber(String anbaoIdNumber) {
        this.anbaoIdNumber = anbaoIdNumber;
    }
    /**
	 * 设置：安保照片
	 */
    public String getAnbaoPhoto() {
        return anbaoPhoto;
    }


    /**
	 * 获取：安保照片
	 */

    public void setAnbaoPhoto(String anbaoPhoto) {
        this.anbaoPhoto = anbaoPhoto;
    }
    /**
	 * 设置：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 获取：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
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
