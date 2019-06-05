import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import BlogLogin from '@/components/manage/BlogLogin.vue'
import BlogIndex from '@/components/home/BlogIndex.vue'
import Login from '@/components/manage/Login.vue'
import index from '@/components/home/Index.vue'
import register from '@/components/manage/register.vue'
import main from '@/components/main/Main.vue'
Vue.use(Router)

export default new Router({
  routes: [
		{
      path: '/',
      redirect: '/login'
    },
		{
		  path: '/hello',
		  name: 'HelloWorld',
		  component: HelloWorld
		},
    {
      path: '/index',
      name: 'index',
      component: BlogIndex
    },
    {
      path: '/manage',
      redirect: '/login'
    },
    {
      path: '/login',
      name: 'BlogLogin',
      component: BlogLogin
    },
		{
		  path: '/home',
		  name: 'home',
		  component: index
		  },
			{
			  path: '/register',
			  name: 'register',
			  component: register
			  },
    {
      path: '/main',
      name: 'main',
      component: main
    }
  ]
})
