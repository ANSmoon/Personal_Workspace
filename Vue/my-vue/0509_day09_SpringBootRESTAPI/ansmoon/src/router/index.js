import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import YoutubeView from '@/views/YoutubeView.vue'
import BoardView from '@/views/BoardView.vue'

import BoardList from '@/components/board/BoardList.vue'
import BoardCreate from '@/components/board/BoardCreate.vue'
import BoardUpdate from '@/components/board/BoardUpdate.vue'
import BoardDetail from '@/components/board/BoardDetail.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path: '/youtube',
      name: 'youtube',
      component: YoutubeView
    },
    {
      path: '/board',
      name: 'board',
      component: BoardView,
      children:[
        {
          path:'',
          name:'boardList',
          component: BoardList
        },
        {
          path:'create',
          name:'boardCreate',
          component: BoardCreate
        },
        {
          path:'update',
          name:'boardUpdate',
          component: BoardUpdate
        },
        {
          path:':id',
          name:'boardDetail',
          component: BoardDetail
        },
      ]
    },
  ]
})

export default router