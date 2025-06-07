package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.WeixuiEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 反馈处理
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("weixui")
public class WeixuiView extends WeixuiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表

	//级联表 反馈
					 
		/**
		* 反馈 的 用户
		*/
		@ColumnInfo(comment="用户",type="int(11)")
		private Integer fankiuYonghuId;
		/**
		* 反馈名称
		*/

		@ColumnInfo(comment="反馈名称",type="varchar(200)")
		private String fankiuName;
		/**
		* 反馈图片
		*/

		@ColumnInfo(comment="反馈图片",type="varchar(200)")
		private String fankiuPhoto;
		/**
		* 反馈类型
		*/
		@ColumnInfo(comment="反馈类型",type="int(11)")
		private Integer fankiuTypes;
			/**
			* 反馈类型的值
			*/
			@ColumnInfo(comment="反馈类型的字典表值",type="varchar(200)")
			private String fankiuValue;
		/**
		* 反馈状态
		*/
		@ColumnInfo(comment="反馈状态",type="int(11)")
		private Integer fankiuZhuangtaiTypes;
			/**
			* 反馈状态的值
			*/
			@ColumnInfo(comment="反馈状态的字典表值",type="varchar(200)")
			private String fankiuZhuangtaiValue;
		/**
		* 反馈详情
		*/

		@ColumnInfo(comment="反馈详情",type="text")
		private String fankiuContent;
	//级联表 员工
		/**
		* 员工姓名
		*/

		@ColumnInfo(comment="员工姓名",type="varchar(200)")
		private String yuangongName;
		/**
		* 员工手机号
		*/

		@ColumnInfo(comment="员工手机号",type="varchar(200)")
		private String yuangongPhone;
		/**
		* 员工身份证号
		*/

		@ColumnInfo(comment="员工身份证号",type="varchar(200)")
		private String yuangongIdNumber;
		/**
		* 员工照片
		*/

		@ColumnInfo(comment="员工照片",type="varchar(200)")
		private String yuangongPhoto;



	public WeixuiView() {

	}

	public WeixuiView(WeixuiEntity weixuiEntity) {
		try {
			BeanUtils.copyProperties(this, weixuiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}





	//级联表的get和set 反馈
		/**
		* 获取：反馈 的 用户
		*/
		public Integer getFankiuYonghuId() {
			return fankiuYonghuId;
		}
		/**
		* 设置：反馈 的 用户
		*/
		public void setFankiuYonghuId(Integer fankiuYonghuId) {
			this.fankiuYonghuId = fankiuYonghuId;
		}

		/**
		* 获取： 反馈名称
		*/
		public String getFankiuName() {
			return fankiuName;
		}
		/**
		* 设置： 反馈名称
		*/
		public void setFankiuName(String fankiuName) {
			this.fankiuName = fankiuName;
		}

		/**
		* 获取： 反馈图片
		*/
		public String getFankiuPhoto() {
			return fankiuPhoto;
		}
		/**
		* 设置： 反馈图片
		*/
		public void setFankiuPhoto(String fankiuPhoto) {
			this.fankiuPhoto = fankiuPhoto;
		}
		/**
		* 获取： 反馈类型
		*/
		public Integer getFankiuTypes() {
			return fankiuTypes;
		}
		/**
		* 设置： 反馈类型
		*/
		public void setFankiuTypes(Integer fankiuTypes) {
			this.fankiuTypes = fankiuTypes;
		}


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
		/**
		* 获取： 反馈状态
		*/
		public Integer getFankiuZhuangtaiTypes() {
			return fankiuZhuangtaiTypes;
		}
		/**
		* 设置： 反馈状态
		*/
		public void setFankiuZhuangtaiTypes(Integer fankiuZhuangtaiTypes) {
			this.fankiuZhuangtaiTypes = fankiuZhuangtaiTypes;
		}


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

		/**
		* 获取： 反馈详情
		*/
		public String getFankiuContent() {
			return fankiuContent;
		}
		/**
		* 设置： 反馈详情
		*/
		public void setFankiuContent(String fankiuContent) {
			this.fankiuContent = fankiuContent;
		}
	//级联表的get和set 员工

		/**
		* 获取： 员工姓名
		*/
		public String getYuangongName() {
			return yuangongName;
		}
		/**
		* 设置： 员工姓名
		*/
		public void setYuangongName(String yuangongName) {
			this.yuangongName = yuangongName;
		}

		/**
		* 获取： 员工手机号
		*/
		public String getYuangongPhone() {
			return yuangongPhone;
		}
		/**
		* 设置： 员工手机号
		*/
		public void setYuangongPhone(String yuangongPhone) {
			this.yuangongPhone = yuangongPhone;
		}

		/**
		* 获取： 员工身份证号
		*/
		public String getYuangongIdNumber() {
			return yuangongIdNumber;
		}
		/**
		* 设置： 员工身份证号
		*/
		public void setYuangongIdNumber(String yuangongIdNumber) {
			this.yuangongIdNumber = yuangongIdNumber;
		}

		/**
		* 获取： 员工照片
		*/
		public String getYuangongPhoto() {
			return yuangongPhoto;
		}
		/**
		* 设置： 员工照片
		*/
		public void setYuangongPhoto(String yuangongPhoto) {
			this.yuangongPhoto = yuangongPhoto;
		}


	@Override
	public String toString() {
		return "WeixuiView{" +
			", yuangongName=" + yuangongName +
			", yuangongPhone=" + yuangongPhone +
			", yuangongIdNumber=" + yuangongIdNumber +
			", yuangongPhoto=" + yuangongPhoto +
			", fankiuName=" + fankiuName +
			", fankiuPhoto=" + fankiuPhoto +
			", fankiuContent=" + fankiuContent +
			"} " + super.toString();
	}
}
