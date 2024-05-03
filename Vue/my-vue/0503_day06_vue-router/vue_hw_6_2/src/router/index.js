import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/SomeView.vue'
import OtherView from '../views/OtherView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'some',
      component: HomeView
    },
    {
      path: '/other',
      name: 'other',
      component: OtherView
      // component: () => import('../views/OtherView.vue')
    },
  ]
})

export default router