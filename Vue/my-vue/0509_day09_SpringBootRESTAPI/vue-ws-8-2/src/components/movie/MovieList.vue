<template>
  <div>
    <h4>Movie List</h4>
    <hr>
    <table>
      <tr>
        <th>ID</th>
        <th>Title</th>
        <th>Director</th>
        <th>Genre</th>
        <th>Duration</th>
        <th>ViewCnt</th>
      </tr>
      <tr v-for="movie in store.movieList" :key="movie.id">
        <td>{{ movie.id }}</td>
        <td>
          <RouterLink :to="`/movie/${movie.id}`">{{ movie.title }}</RouterLink>
        </td>
        <td>{{ movie.director }}</td>
        <td>{{ movie.genre }}</td>
        <td>{{ movie.duration }}</td>
        <td>{{ movie.viewCnt }}</td>
      </tr>
    </table>
  </div>
</template>

<script setup>
  import { useMovieStore } from '@/stores/movieStore';
  import { onMounted } from 'vue';
  
  const store = useMovieStore();
  onMounted(() =>{
    store.getMovieList();
  })

</script>

<style>
</style>
