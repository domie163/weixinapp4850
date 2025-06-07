package com.entity.model;

import com.entity.FankiuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 反馈
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class FankiuModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 反馈名称
     */
    private String fankiuName;


    /**
     * 反馈图片
     */
    private String fankiuPhoto;


    /**
     * 反馈类型
     */
    private Integer fankiuTypes;


    /**
     * 申请反馈时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 反馈状态
     */
    private Integer fankiuZhuangtaiTypes;


    /**
     * 反馈详情
     */
    private String fankiuContent;


    /**
     * 创建时间 show3 listShow
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
	 * 获取：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show3 listShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
