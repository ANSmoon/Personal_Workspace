import { createRouter, createWebHistory } from "vue-router";
import MovieView from "@/views/MovieView.vue";
import ReviewView from "@/views/ReviewView.vue";
import UserView from "@/views/UserView.vue";

import ReviewList from "@/components/review/ReviewList.vue";
import ReviewDetail from "@/components/review/ReviewDetail.vue";
import ReviewUpdate from "@/components/review/ReviewUpdate.vue";
import ReviewRegist from "@/components/review/ReviewRegist.vue";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: "/movie",
      name: "movie",
      component: MovieView,
    },
    {
      path: "/movie/:movieId",
      name: "review",
      component: ReviewView,
      children: [
        {
          path: "",
          name: "list",
          component: ReviewList,
        },
        {
          path: "review/:reviewId",
          name: "detail",
          component: ReviewDetail,
        },
        {
          path: "review/:reviewId/update",
          name: "updateReview",
          component: ReviewUpdate,
        },
        {
          path: "review/regist",
          name: "registReview",
          component: ReviewRegist,
        }
      ],
    },
    {
      path: "/user",
      name: "user",
      component: UserView,
    },
  ],
});

export default router;
