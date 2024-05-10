<template>
  <div>
    <h2>Movie View</h2>
    <hr />
    <div class="thumbnails">
      <div v-for="movie in store.movieList" :key="movie.id" class="thumbnail">
        <RouterLink :to="`/movie/${movie.id}`">
          <!-- 영상 재생 iframe -->
          <iframe width="600" height="300"
            :src="movie.link"
            title="Video Player"
            class="video-player"
            frameborder="0"
            allowfullscreen
          ></iframe>
          <p class="title">{{ truncateTitle(movie.title) }}</p>
        </RouterLink>
      </div>
    </div>
  </div>
</template>

<script setup>
import { useMovieStore } from "@/stores/movie";
import { onMounted } from "vue";

const store = useMovieStore();
onMounted(() => {
  store.getMovieList();
});

function truncateTitle(title) {
  // 일정 길이 이상인 경우 ...으로 표시
  const maxLength = 20;
  if (title.length > maxLength) {
    return title.substring(0, maxLength) + "...";
  }
  return title;
}
</script>

<style scoped>

</style>
