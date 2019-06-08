import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import login from '@/components/manage/login.vue'
import index from '@/components/home/index.vue'
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
      component: index
    },
    {
      path: '/login',
      name: 'login',
      component: login
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
