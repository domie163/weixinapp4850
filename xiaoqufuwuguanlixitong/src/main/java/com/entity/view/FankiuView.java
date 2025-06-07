package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.FankiuEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 反馈
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("fankiu")
public class FankiuView extends FankiuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 反馈类型的值
	*/
	@ColumnInfo(comment="反馈类型的字典表值",type="varchar(200)")
	private String fankiuValue;
	/**
	* 反馈状态的值
	*/
	@ColumnInfo(comment="反馈状态的字典表值",type="varchar(200)")
	private String fankiuZhuangtaiValue;

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



	public FankiuView() {

	}

	public FankiuView(FankiuEntity fankiuEntity) {
		try {
			BeanUtils.copyProperties(this, fankiuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 反馈类型的值
	*/
	public String getFankiuValue() {
		return fankiuValue;
	}
	/**
	* 设置： 反馈类型的值
	*/
	public void setFankiuValue(String fankiuValue) {
		this.fankiuValue = fankiuValue;
	}
	//当前表的
	/**
	* 获取： 反馈状态的值
	*/
	public String getFankiuZhuangtaiValue() {
		return fankiuZhuangtaiValue;
	}
	/**
	* 设置： 反馈状态的值
	*/
	public void setFankiuZhuangtaiValue(String fankiuZhuangtaiValue) {
		this.fankiuZhuangtaiValue = fankiuZhuangtaiValue;
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
		return "FankiuView{" +
			", fankiuValue=" + fankiuValue +
			", fankiuZhuangtaiValue=" + fankiuZhuangtaiValue +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			"} " + super.toString();
	}
}
