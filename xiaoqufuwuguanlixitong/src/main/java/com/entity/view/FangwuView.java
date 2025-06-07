package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.FangwuEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 房屋
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("fangwu")
public class FangwuView extends FangwuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 楼栋的值
	*/
	@ColumnInfo(comment="楼栋的字典表值",type="varchar(200)")
	private String loudongValue;
	/**
	* 房屋类型的值
	*/
	@ColumnInfo(comment="房屋类型的字典表值",type="varchar(200)")
	private String fangwuValue;

	//级联表 住户
		/**
		* 住户姓名
		*/

		@ColumnInfo(comment="住户姓名",type="varchar(200)")
		private String yonghuName;
		/**
		* 住户手机号
		*/

		@ColumnInfo(comment="住户手机号",type="varchar(200)")
		private String yonghuPhone;
		/**
		* 住户身份证号
		*/

		@ColumnInfo(comment="住户身份证号",type="varchar(200)")
		private String yonghuIdNumber;
		/**
		* 住户照片
		*/

		@ColumnInfo(comment="住户照片",type="varchar(200)")
		private String yonghuPhoto;



	public FangwuView() {

	}

	public FangwuView(FangwuEntity fangwuEntity) {
		try {
			BeanUtils.copyProperties(this, fangwuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 楼栋的值
	*/
	public String getLoudongValue() {
		return loudongValue;
	}
	/**
	* 设置： 楼栋的值
	*/
	public void setLoudongValue(String loudongValue) {
		this.loudongValue = loudongValue;
	}
	//当前表的
	/**
	* 获取： 房屋类型的值
	*/
	public String getFangwuValue() {
		return fangwuValue;
	}
	/**
	* 设置： 房屋类型的值
	*/
	public void setFangwuValue(String fangwuValue) {
		this.fangwuValue = fangwuValue;
	}


	//级联表的get和set 住户

		/**
		* 获取： 住户姓名
		*/
		public String getYonghuName() {
			return yonghuName;
		}
		/**
		* 设置： 住户姓名
		*/
		public void setYonghuName(String yonghuName) {
			this.yonghuName = yonghuName;
		}

		/**
		* 获取： 住户手机号
		*/
		public String getYonghuPhone() {
			return yonghuPhone;
		}
		/**
		* 设置： 住户手机号
		*/
		public void setYonghuPhone(String yonghuPhone) {
			this.yonghuPhone = yonghuPhone;
		}

		/**
		* 获取： 住户身份证号
		*/
		public String getYonghuIdNumber() {
			return yonghuIdNumber;
		}
		/**
		* 设置： 住户身份证号
		*/
		public void setYonghuIdNumber(String yonghuIdNumber) {
			this.yonghuIdNumber = yonghuIdNumber;
		}

		/**
		* 获取： 住户照片
		*/
		public String getYonghuPhoto() {
			return yonghuPhoto;
		}
		/**
		* 设置： 住户照片
		*/
		public void setYonghuPhoto(String yonghuPhoto) {
			this.yonghuPhoto = yonghuPhoto;
		}


	@Override
	public String toString() {
		return "FangwuView{" +
			", loudongValue=" + loudongValue +
			", fangwuValue=" + fangwuValue +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			"} " + super.toString();
	}
}
