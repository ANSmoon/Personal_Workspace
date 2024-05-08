import { createRouter, createWebHistory } from 'vue-router'
import QuizMain from '@/views/QuizMain.vue';
import QuizView from '@/views/QuizView.vue';


const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: QuizMain,
    },
    {
      path: '/quiz',
      name: 'quiz',
      component: QuizView,
    },
  ]
})

export default router
