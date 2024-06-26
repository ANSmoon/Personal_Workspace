import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import UserView from '../views/UserView.vue'
import LoginView from '../views/LoginView.vue'

const isAuthenticated = true
const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path: '/about',
      name: 'about',
      // route level code-splitting
      // this generates a separate chunk (About.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import('../views/AboutView.vue'),
    },
    {
      path: '/user/:id',
      name: 'user',
      component: UserView,
    },
    {
      path:'/login',
      name:'login',
      component: LoginView,
      // 이미 로그인 햇으면 loginview 안들어와도 괜찮다 home으로 
      beforeEnter: ((to, from) => {
        if(isAuthenticated === true) {
          console.log('로그인 되어있습니다.')
          return  {name:'home'}
        }
        else {
          console.log('로그인하러 가세요! 아니면 코드에서 isAuthenticated를 true로 바꾸세요!')
        }
      })
    }
  ]
})

export default router