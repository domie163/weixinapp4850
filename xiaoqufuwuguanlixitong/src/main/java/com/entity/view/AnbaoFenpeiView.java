package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.AnbaoFenpeiEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 安保分配
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("anbao_fenpei")
public class AnbaoFenpeiView extends AnbaoFenpeiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 安排类型的值
	*/
	@ColumnInfo(comment="安排类型的字典表值",type="varchar(200)")
	private String anbaoFenpeiValue;

	//级联表 安保
		/**
		* 安保姓名
		*/

		@ColumnInfo(comment="安保姓名",type="varchar(200)")
		private String anbaoName;
		/**
		* 安保手机号
		*/

		@ColumnInfo(comment="安保手机号",type="varchar(200)")
		private String anbaoPhone;
		/**
		* 安保身份证号
		*/

		@ColumnInfo(comment="安保身份证号",type="varchar(200)")
		private String anbaoIdNumber;
		/**
		* 安保照片
		*/

		@ColumnInfo(comment="安保照片",type="varchar(200)")
		private String anbaoPhoto;
		/**
		* 性别
		*/
		@ColumnInfo(comment="性别",type="int(11)")
		private Integer sexTypes;
			/**
			* 性别的值
			*/
			@ColumnInfo(comment="性别的字典表值",type="varchar(200)")
			private String sexValue;



	public AnbaoFenpeiView() {

	}

	public AnbaoFenpeiView(AnbaoFenpeiEntity anbaoFenpeiEntity) {
		try {
			BeanUtils.copyProperties(this, anbaoFenpeiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 安排类型的值
	*/
	public String getAnbaoFenpeiValue() {
		return anbaoFenpeiValue;
	}
	/**
	* 设置： 安排类型的值
	*/
	public void setAnbaoFenpeiValue(String anbaoFenpeiValue) {
		this.anbaoFenpeiValue = anbaoFenpeiValue;
	}


	//级联表的get和set 安保

		/**
		* 获取： 安保姓名
		*/
		public String getAnbaoName() {
			return anbaoName;
		}
		/**
		* 设置： 安保姓名
		*/
		public void setAnbaoName(String anbaoName) {
			this.anbaoName = anbaoName;
		}

		/**
		* 获取： 安保手机号
		*/
		public String getAnbaoPhone() {
			return anbaoPhone;
		}
		/**
		* 设置： 安保手机号
		*/
		public void setAnbaoPhone(String anbaoPhone) {
			this.anbaoPhone = anbaoPhone;
		}

		/**
		* 获取： 安保身份证号
		*/
		public String getAnbaoIdNumber() {
			return anbaoIdNumber;
		}
		/**
		* 设置： 安保身份证号
		*/
		public void setAnbaoIdNumber(String anbaoIdNumber) {
			this.anbaoIdNumber = anbaoIdNumber;
		}

		/**
		* 获取： 安保照片
		*/
		public String getAnbaoPhoto() {
			return anbaoPhoto;
		}
		/**
		* 设置： 安保照片
		*/
		public void setAnbaoPhoto(String anbaoPhoto) {
			this.anbaoPhoto = anbaoPhoto;
		}
		/**
		* 获取： 性别
		*/
		public Integer getSexTypes() {
			return sexTypes;
		}
		/**
		* 设置： 性别
		*/
		public void setSexTypes(Integer sexTypes) {
			this.sexTypes = sexTypes;
		}


			/**
			* 获取： 性别的值
			*/
			public String getSexValue() {
				return sexValue;
			}
			/**
			* 设置： 性别的值
			*/
			public void setSexValue(String sexValue) {
				this.sexValue = sexValue;
			}


	@Override
	public String toString() {
		return "AnbaoFenpeiView{" +
			", anbaoFenpeiValue=" + anbaoFenpeiValue +
			", anbaoName=" + anbaoName +
			", anbaoPhone=" + anbaoPhone +
			", anbaoIdNumber=" + anbaoIdNumber +
			", anbaoPhoto=" + anbaoPhoto +
			"} " + super.toString();
	}
}
