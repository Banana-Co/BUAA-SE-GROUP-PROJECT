<template>
    <div class="wrap">
			<p v-show="showTishi">{{tishi}}</p>
      <input type="text" v-model="loginInfoVo.username" placeholder="请输入用户名" />
      <input type="password" v-model="loginInfoVo.password" placeholder="请输入密码" />
      <button v-on:click="register">注册</button>
			<span v-on:click="ToLogin">已有账号？马上登录</span>
			 <br/>
			<span v-on:click="ToMain">查看用户</span>
      <br/>
			<br/>
			<br/>
			<br/>
      注册验证情况：
			<br/>
			<textarea cols="30" rows="10" v-model="responseResult"></textarea>
    </div>
</template>

<script>

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
  	methods: {
		ToMain() {
			this.$router.push(
				'/main'
			)
		},
  		ToLogin() {
  			this.$router.replace( {
  				path: '/login'
  			})
  		},
  		register() {
  			this.$axios
  				.post('/register', {
  					username: this.loginInfoVo.username,
  					password: this.loginInfoVo.password
  				})
  				.then(successResponse => {
  					this.responseResult = JSON.stringify(successResponse.data)
  					if (successResponse.data.code === 200) {
  						this.$router.push(
  							'/index'
  						)
  					} else if (successResponse.data.code === 300) {
  						this.tishi = "该用户不存在"
  						this.showTishi = true
  					} else if (successResponse.data.code === 400) {
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
