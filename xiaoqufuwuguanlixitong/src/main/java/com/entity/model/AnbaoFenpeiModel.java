package com.entity.model;

import com.entity.AnbaoFenpeiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 安保分配
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class AnbaoFenpeiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 安排名称
     */
    private String anbaoFenpeiName;


    /**
     * 安保
     */
    private Integer anbaoId;


    /**
     * 安排内容
     */
    private String anbaoFenpei;


    /**
     * 安排类型
     */
    private Integer anbaoFenpeiTypes;


    /**
     * 安排时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date anpaiTime;


    /**
     * 执行时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date zhxingTime;


    /**
     * 安排详情
     */
    private String anbaoFenpeiXiangqing;


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
	 * 获取：安排名称
	 */
    public String getAnbaoFenpeiName() {
        return anbaoFenpeiName;
    }


    /**
	 * 设置：安排名称
	 */
    public void setAnbaoFenpeiName(String anbaoFenpeiName) {
        this.anbaoFenpeiName = anbaoFenpeiName;
    }
    /**
	 * 获取：安保
	 */
    public Integer getAnbaoId() {
        return anbaoId;
    }


    /**
	 * 设置：安保
	 */
    public void setAnbaoId(Integer anbaoId) {
        this.anbaoId = anbaoId;
    }
    /**
	 * 获取：安排内容
	 */
    public String getAnbaoFenpei() {
        return anbaoFenpei;
    }


    /**
	 * 设置：安排内容
	 */
    public void setAnbaoFenpei(String anbaoFenpei) {
        this.anbaoFenpei = anbaoFenpei;
    }
    /**
	 * 获取：安排类型
	 */
    public Integer getAnbaoFenpeiTypes() {
        return anbaoFenpeiTypes;
    }


    /**
	 * 设置：安排类型
	 */
    public void setAnbaoFenpeiTypes(Integer anbaoFenpeiTypes) {
        this.anbaoFenpeiTypes = anbaoFenpeiTypes;
    }
    /**
	 * 获取：安排时间
	 */
    public Date getAnpaiTime() {
        return anpaiTime;
    }


    /**
	 * 设置：安排时间
	 */
    public void setAnpaiTime(Date anpaiTime) {
        this.anpaiTime = anpaiTime;
    }
    /**
	 * 获取：执行时间
	 */
    public Date getZhxingTime() {
        return zhxingTime;
    }


    /**
	 * 设置：执行时间
	 */
    public void setZhxingTime(Date zhxingTime) {
        this.zhxingTime = zhxingTime;
    }
    /**
	 * 获取：安排详情
	 */
    public String getAnbaoFenpeiXiangqing() {
        return anbaoFenpeiXiangqing;
    }


    /**
	 * 设置：安排详情
	 */
    public void setAnbaoFenpeiXiangqing(String anbaoFenpeiXiangqing) {
        this.anbaoFenpeiXiangqing = anbaoFenpeiXiangqing;
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
