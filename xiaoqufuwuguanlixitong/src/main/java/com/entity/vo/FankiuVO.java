package com.entity.vo;

import com.entity.FankiuEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 反馈
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("fankiu")
public class FankiuVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 反馈名称
     */

    @TableField(value = "fankiu_name")
    private String fankiuName;


    /**
     * 反馈图片
     */

    @TableField(value = "fankiu_photo")
    private String fankiuPhoto;


    /**
     * 反馈类型
     */

    @TableField(value = "fankiu_types")
    private Integer fankiuTypes;


    /**
     * 申请反馈时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 反馈状态
     */

    @TableField(value = "fankiu_zhuangtai_types")
    private Integer fankiuZhuangtaiTypes;


    /**
     * 反馈详情
     */

    @TableField(value = "fankiu_content")
    private String fankiuContent;


    /**
     * 创建时间 show3 listShow
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
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：反馈名称
	 */
    public String getFankiuName() {
        return fankiuName;
    }


    /**
	 * 获取：反馈名称
	 */

    public void setFankiuName(String fankiuName) {
        this.fankiuName = fankiuName;
    }
    /**
	 * 设置：反馈图片
	 */
    public String getFankiuPhoto() {
        return fankiuPhoto;
    }


    /**
	 * 获取：反馈图片
	 */

    public void setFankiuPhoto(String fankiuPhoto) {
        this.fankiuPhoto = fankiuPhoto;
    }
    /**
	 * 设置：反馈类型
	 */
    public Integer getFankiuTypes() {
        return fankiuTypes;
    }


    /**
	 * 获取：反馈类型
	 */

    public void setFankiuTypes(Integer fankiuTypes) {
        this.fankiuTypes = fankiuTypes;
    }
    /**
	 * 设置：申请反馈时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：申请反馈时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：反馈状态
	 */
    public Integer getFankiuZhuangtaiTypes() {
        return fankiuZhuangtaiTypes;
    }


    /**
	 * 获取：反馈状态
	 */

    public void setFankiuZhuangtaiTypes(Integer fankiuZhuangtaiTypes) {
        this.fankiuZhuangtaiTypes = fankiuZhuangtaiTypes;
    }
    /**
	 * 设置：反馈详情
	 */
    public String getFankiuContent() {
        return fankiuContent;
    }


    /**
	 * 获取：反馈详情
	 */

    public void setFankiuContent(String fankiuContent) {
        this.fankiuContent = fankiuContent;
    }
    /**
	 * 设置：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show3 listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
