<template>
  <div>
    <h4>Detail of movie</h4>
    <hr>
    <div>{{ store.movie.id }}</div>
    <div>{{ store.movie.title }}</div>
    <div>{{ store.movie.director }}</div>
    <div>{{ store.movie.genre }}</div>
    <div>{{ store.movie.duration }}</div>
    <div>{{ store.movie.viewCnt }}</div>

    <button @click="deleteMovie">Delete</button>
  </div>
</template>

<script setup>
import { useMovieStore } from '@/stores/movieStore';
import { onMounted } from 'vue';
import { useRoute, useRouter } from 'vue-router'
import axios from 'axios'

  const store = useMovieStore()
  const route = useRoute()
  const router = useRouter()

  onMounted(() => {
    store.getMovie(route.params.id)
  })

  const deleteMovie = function() {
    axios.delete(`http://localhost:8080/movieapi/movie/${route.params.id}`)
    .then(() =>{
      router.push({name : 'boardList'})
    })
  }
</script>

<style>
</style>
