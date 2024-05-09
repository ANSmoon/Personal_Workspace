import { createRouter, createWebHistory } from "vue-router";

import Home from "../views/HomeView.vue";
import Movie from "../views/MovieView.vue"
import MovieCreate from "@/components/movie/MovieCreate.vue";
import MovieDetail from "@/components/movie/MovieDetail.vue";
import MovieList from "@/components/movie/MovieList.vue";

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home,
  },
  {
    path: "/",
    name: "Movie",
    component: Movie,
    children:[
      {
        path:'',
        name:'MovieList',
        component: MovieList,
      },
      {
        path:'create',
        name:'MovieCreate',
        component: MovieCreate,
      },
      {
        path:'detail',
        name:'MovieDetail',
        component: MovieDetail,
      },
    ]
  },
];

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes,
});

export default router;