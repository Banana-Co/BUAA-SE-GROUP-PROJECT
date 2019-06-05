<template>
	<div class="wrap">
		<p v-show="showTishi">{{tishi}}</p>
		<input type="text" v-model="loginInfoVo.username" placeholder="请输入用户名" />
		<input type="password" v-model="loginInfoVo.password" placeholder="请输入密码" />
		<button v-on:click="login">登录</button>
		<span v-on:click="ToRegister">没有账号？马上注册</span>
	</div>
</template>

<script>
	import {
		setCookie,
		getCookie
	} from '@/assets/js/cookie.js'
	export default {
		data() {
			return {
				loginInfoVo: {
					username: '',
					password: ''
				},
				responseResult: [],
				showTishi: false,
				tishi: '',
			}
		},
		mounted() {
			/*页面挂载获取cookie，如果存在username的cookie，则跳转到主页，不需登录*/
			if (getCookie('username')) {
				this.$router.push('/home')
			}
		},
		methods: {
			ToRegister() {
				this.$router.replace( {
					path: '/register'
				})
			},
			login() {
					this.$axios
						.post('/login', {
							username: this.loginInfoVo.username,
							password: this.loginInfoVo.password
						})
						.then(successResponse => {
							this.responseResult = JSON.stringify(successResponse.data)
							if (successResponse.data.code === 200) {
								this.$router.replace({
									path: '/index'
								})
							}else if (successResponse.data.code === 300) {
								this.tishi = "该用户不存在"
								this.showTishi = true
							}else if (successResponse.data.code === 400) {
								this.tishi = "密码输入错误"
								this.showTishi = true
							}
						})
						.catch(failResponse => {})
				
				
			}
		}
	}
</script>

<style>
	.wrap {
		text-align: center;
	}

	input {
		display: block;
		width: 250px;
		height: 40px;
		line-height: 40px;
		margin: 0 auto;
		margin-bottom: 10px;
		outline: none;
		border: 1px solid #888;
		padding: 10px;
		box-sizing: border-box;
	}

	p {
		color: red;
	}

	button {
		display: block;
		width: 250px;
		height: 40px;
		line-height: 40px;
		margin: 0 auto;
		border: none;
		background-color: #41b883;
		color: #fff;
		font-size: 16px;
		margin-bottom: 5px;
	}

	span {
		cursor: pointer;
	}

	span:hover {
		color: #41b883;
	}
</style>
