<template>
	<view class="content">
		<form class="app-update-pv">
			<view
				:style='{"boxShadow":"0","backgroundColor":"rgba(255, 255, 255, 0.25)","borderColor":"rgba(228, 232, 230, 1)","margin":"0 0 0px 0","borderWidth":"2rpx","borderStyle":"none none solid none ","height":"100rpx"}'
				class="cu-form-group">
				<view :style='{"width":"160rpx","fontSize":"28rpx","color":"var(--publicMainColor)","textAlign":"left"}'
					class="title">反馈名称</view>
				<input disabled
					:style='{"padding":"0 30rpx","boxShadow":"0 0 0px rgba(0,0,0,.6) inset","margin":"0","borderColor":"var(--publicMainColor)","backgroundColor":"var(--publicSubColor)","color":"#fff","textAlign":"left","borderRadius":"20rpx 0","borderWidth":"0 10rpx","fontSize":"28rpx","borderStyle":"solid","height":"88rpx","marginTop":"7rpx"}'
					:disabled="ro.fankiuName" type="text" v-model="ruleForm.fankiuName" placeholder="反馈名称"></input>
			</view>
			<view
				:style='{"boxShadow":"0 0 0px rgba(0,0,0,.3)","backgroundColor":"rgba(255, 255, 255, 0.25)","borderColor":"rgba(218, 220, 219, 1)","margin":"0 0 0px 0","borderWidth":"2rpx","borderStyle":"none none solid none ","height":"108rpx"}'
				class="cu-form-group" @tap="fankiuPhotoTap">
				<view :style='{"width":"160rpx","fontSize":"28rpx","color":"var(--publicMainColor)","textAlign":"left"}'
					class="title">反馈图片</view>
				<view class="right-input" style="padding:0;textAlign:left">
					<image
						:style='{"width":"68rpx","boxShadow":"0 0 0px rgba(0,0,0,.3)","borderRadius":"100%","textAlign":"left","height":"68rpx"}'
						class="avator" v-if="ruleForm.fankiuPhoto" :src="baseUrl+ruleForm.fankiuPhoto"
						mode="aspectFill">
					</image>
					<image
						:style='{"width":"68rpx","boxShadow":"0 0 0px rgba(0,0,0,.3)","borderRadius":"100%","textAlign":"left","height":"68rpx"}'
						class="avator" v-else src="../../static/gen/upload.png" mode="aspectFill"></image>
				</view>
			</view>
			<view
				:style='{"boxShadow":"0","backgroundColor":"rgba(255, 255, 255, 0.25)","borderColor":"rgba(228, 232, 230, 1)","margin":"0 0 0px 0","borderWidth":"2rpx","borderStyle":"none none solid none ","height":"100rpx"}'
				class="cu-form-group">
				<view :style='{"width":"160rpx","fontSize":"28rpx","color":"var(--publicMainColor)","textAlign":"left"}'
					class="title">反馈类型</view>
				<picker @change="fankiuTypesChange" :value="fankiuTypesIndex" :range="fankiuTypesOptions"
					range-key="indexName">
					<view
						:style='{"padding":"0 30rpx","boxShadow":"0 0 0px rgba(0,0,0,.6) inset","margin":"0","borderColor":"var(--publicMainColor)","backgroundColor":"var(--publicSubColor)","color":"#fff","textAlign":"left","borderRadius":"20rpx 0","borderWidth":"0 10rpx","fontSize":"28rpx","borderStyle":"solid","height":"88rpx","marginTop":"7rpx"}'
						class="uni-input">{{ruleForm.fankiuTypes?ruleForm.fankiuValue:"请选择反馈类型"}}</view>
				</picker>
			</view>
			<!-- <view :style='{"boxShadow":"0","backgroundColor":"rgba(255, 255, 255, 0.25)","borderColor":"rgba(228, 232, 230, 1)","margin":"0 0 0px 0","borderWidth":"2rpx","borderStyle":"none none solid none ","height":"100rpx"}'
                      class="cu-form-group">
                    <view :style='{"width":"160rpx","fontSize":"28rpx","color":"var(--publicMainColor)","textAlign":"left"}'
                          class="title">反馈状态</view>
                    <picker @change="fankiuZhuangtaiTypesChange" :value="fankiuZhuangtaiTypesIndex" :range="fankiuZhuangtaiTypesOptions" range-key="indexName">
                        <view
                                :style='{"padding":"0 30rpx","boxShadow":"0 0 0px rgba(0,0,0,.6) inset","margin":"0","borderColor":"var(--publicMainColor)","backgroundColor":"var(--publicSubColor)","color":"#fff","textAlign":"left","borderRadius":"20rpx 0","borderWidth":"0 10rpx","fontSize":"28rpx","borderStyle":"solid","height":"88rpx","marginTop":"7rpx"}'
                                class="uni-input">{{ruleForm.fankiuZhuangtaiTypes?ruleForm.fankiuZhuangtaiValue:"请选择反馈状态"}}</view>
                    </picker>
                </view> -->
			<!-- text后缀 -->
			<view
				:style='{"boxShadow":"0","backgroundColor":"rgba(255, 255, 255, 0.25)","borderColor":"rgba(228, 232, 230, 1)","margin":"0 0 0px 0","borderWidth":"2rpx","borderStyle":"none none solid none ","height":"210rpx"}'
				class="cu-form-group">
				<view :style='{"width":"160rpx","fontSize":"28rpx","color":"var(--publicMainColor)","textAlign":"left"}'
					class="title">反馈详情</view>
				<textarea
					:style='{"padding":"0 30rpx","boxShadow":"0 0 0px rgba(0,0,0,.6) inset","margin":"0","borderColor":"var(--publicMainColor)","backgroundColor":"var(--publicSubColor)","color":"#fff","textAlign":"left","borderRadius":"20rpx 0","borderWidth":"0 10rpx","fontSize":"28rpx","borderStyle":"solid","height":"88rpx","marginTop":"7rpx","height":"200rpx"}'
					:disabled="ro.fankiuContent" v-model="ruleForm.fankiuContent" placeholder="反馈详情" />
			</view>

			<view class="btn">
				<button
					:style='{"boxShadow":"0 0 16rpx rgba(0,0,0,0) inset","backgroundColor":"var(--publicMainColor)","borderColor":"#409EFF","borderRadius":"8rpx","color":"rgba(255, 255, 255, 1)","borderWidth":"0","width":"70%","fontSize":"32rpx","borderStyle":"solid","height":"80rpx"}'
					@tap="onSubmitTap" class="bg-red">提交</button>
			</view>
		</form>

		<w-picker mode="dateTime" step="1" :current="false" :hasSecond="false" @confirm="insertTimeConfirm"
			ref="insertTime" themeColor="#333333"></w-picker>
		<w-picker mode="dateTime" step="1" :current="false" :hasSecond="false" @confirm="createTimeConfirm"
			ref="createTime" themeColor="#333333"></w-picker>


	</view>
</template>

<script>
	import wPicker from "@/components/w-picker/w-picker.vue";
import { login } from "../../api";

	export default {
		data() {
			return {
				cross: '',
				ro: {
					yonghuId: false,
					fankiuName: false,
					fankiuPhoto: false,
					fankiuTypes: false,
					insertTime: false,
					fankiuZhuangtaiTypes: false,
					fankiuContent: false,
					createTime: false,
				},
				ruleForm: {
					yonghuId: '',
					fankiuName: '',
					fankiuPhoto: '',
					fankiuTypes: '', //数字
					fankiuValue: '', //数字对应的值
					insertTime: '',
					fankiuZhuangtaiTypes: '', //数字
					fankiuZhuangtaiValue: '', //数字对应的值
					fankiuContent: '',
					createTime: '',
				},
				// 登陆用户信息
				user: {},
				fankiuTypesOptions: [],
				fankiuTypesIndex: 0,
				fankiuZhuangtaiTypesOptions: [],
				fankiuZhuangtaiTypesIndex: 0,

			}
		},
		components: {
			wPicker
		},
		computed: {
			baseUrl() {
				return this.$base.url;
			},
		},
		async onLoad(options) {
			
			/*下拉框*/
			let fankiuTypesParams = {
				page: 1,
				limit: 100,
				dicCode: 'fankiu_types',
			}
			let fankiuTypes = await this.$api.page(`dictionary`, fankiuTypesParams);
			this.fankiuTypesOptions = fankiuTypes.data.list
			/*下拉框*/
			let fankiuZhuangtaiTypesParams = {
				page: 1,
				limit: 100,
				dicCode: 'fankiu_zhuangtai_types',
			}
			let fankiuZhuangtaiTypes = await this.$api.page(`dictionary`, fankiuZhuangtaiTypesParams);
			this.fankiuZhuangtaiTypesOptions = fankiuZhuangtaiTypes.data.list


			// 如果是更新操作
			if (options.id) {
				this.ruleForm.id = options.id;
				// 获取信息
				let res = await this.$api.info(`fankiu`, this.ruleForm.id);
				this.ruleForm = res.data;
				
			}
			if (options.fankiuId) {
				this.ruleForm.fankiuId = options.fankiuId;
			}
			// 跨表
			// this.styleChange()
		},
		methods: {
			// 下拉变化
			fankiuTypesChange(e) {
				this.fankiuTypesIndex = e.target.value
				this.ruleForm.fankiuValue = this.fankiuTypesOptions[this.fankiuTypesIndex].indexName
				this.ruleForm.fankiuTypes = this.fankiuTypesOptions[this.fankiuTypesIndex].codeIndex
			},
			fankiuZhuangtaiTypesChange(e) {
				this.fankiuZhuangtaiTypesIndex = e.target.value
				this.ruleForm.fankiuZhuangtaiValue = this.fankiuZhuangtaiTypesOptions[this.fankiuZhuangtaiTypesIndex]
					.indexName
				this.ruleForm.fankiuZhuangtaiTypes = this.fankiuZhuangtaiTypesOptions[this.fankiuZhuangtaiTypesIndex]
					.codeIndex
			},


			// styleChange() {
			// 	this.$nextTick(() => {
			// 		// document.querySelectorAll('.app-update-pv .cu-form-group .uni-yaoxianStyle-yaoxianStyle').forEach(el=>{
			// 		//   el.style.backgroundColor = this.addUpdateForm.yaoxianStyle.content.backgroundColor
			// 		// })
			// 	})
			// },


			fankiuPhotoTap() {
				let _this = this;
				this.$api.upload(function(res) {
					_this.ruleForm.fankiuPhoto = 'upload/' + res.file;
					_this.$forceUpdate();
					_this.$nextTick(() => {
						// _this.styleChange()
					})
				});
			},
			
			
			// 日期控件
			insertTimeConfirm(val) {
				this.ruleForm.insertTime = val.result;
				this.$forceUpdate();
			},
			// 日期控件
			createTimeConfirm(val) {
				this.ruleForm.createTime = val.result;
				this.$forceUpdate();
			},




			getUUID() {
				return new Date().getTime();
			},
			async onSubmitTap() {
				// await this.$api.session(`yonghu`,)
				if ((!this.ruleForm.fankiuName)) {
					this.$utils.msg(`反馈名称不能为空`);
					return
				}
				if ((!this.ruleForm.fankiuPhoto)) {
					this.$utils.msg(`反馈图片不能为空`);
					return
				}
				// if ((!this.ruleForm.fankiuZhuangtaiTypes)) {
				// 	this.$utils.msg(`反馈状态不能为空`);
				// 	return
				// }
				this.ruleForm.fankiuZhuangtaiTypes=2
				this.ruleForm.yonghuId=uni.getStorageSync("userid")
				if (this.ruleForm.id) {
					
					await this.$api.update(`fankiu`, this.ruleForm);
				} else {
					await this.$api.add(`fankiu`, this.ruleForm);
				}
				uni.setStorageSync('pingluenStateState', true);
				this.$utils.msgBack('提交成功');
			},
			getDate(type) {
				const date = new Date();
				let year = date.getFullYear();
				let month = date.getMonth() + 1;
				let day = date.getDate();
				if (type === 'start') {
					year = year - 60;
				} else if (type === 'end') {
					year = year + 2;
				}
				month = month > 9 ? month : '0' + month;;
				day = day > 9 ? day : '0' + day;
				return `${year}-${month}-${day}`;
			},
			toggleTab(str) {
				this.$refs[str].show();
			}
		}
	}
</script>
<style lang="scss" scoped>
	.container {
		padding: 20upx;
	}

	.content:after {
		position: fixed;
		top: 0;
		right: 0;
		left: 0;
		bottom: 0;
		content: '';
		background-attachment: fixed;
		background-size: cover;
		background-position: center;
	}

	textarea {
		border: 1upx solid #EEEEEE;
		border-radius: 20upx;
		padding: 20upx;
	}

	.title {
		width: 180upx;
	}

	.avator {
		width: 150upx;
		height: 60upx;
	}

	.right-input {
		flex: 1;
		text-align: left;
		padding: 0 24upx;
	}

	.cu-form-group.active {
		justify-content: space-between;
	}

	.cu-form-group .title {
		height: auto;
		line-height: 30rpx
	}

	.btn {
		display: flex;
		align-items: center;
		justify-content: center;
		flex-wrap: wrap;
		padding: 20upx 0;
	}

	.cu-form-group {
		padding: 0 24upx;
		background-color: transparent;
		min-height: inherit;
	}

	.cu-form-group+.cu-form-group {
		border: 0;
	}

	.cu-form-group uni-input {
		padding: 0 30upx;
	}

	.uni-input {
		padding: 0 30upx;
	}

	.cu-form-group uni-textarea {
		padding: 30upx;
		margin: 0;
	}

	.cu-form-group uni-picker::after {
		line-height: 80rpx;
	}

	.select .uni-input {
		line-height: 80rpx;
	}

	.input .right-input {
		line-height: 88rpx;
	}
</style>
