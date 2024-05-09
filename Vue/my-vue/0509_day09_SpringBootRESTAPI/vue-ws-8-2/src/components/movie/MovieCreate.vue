<template>
  <div>
    <h4>Movie Regist</h4>
    <fieldset>
      <legend>Regist</legend>
      <div>
        <label for="title">Title</label>
        <input type="text" id="title" v-model="movie.title">
      </div>
      <div>
        <label for="director">Director</label>
        <input type="text" id="director" v-model="movie.director">
      </div>
      <div>
        <label for="genre">Genre</label>
        <input type="text" id="genre" v-model="movie.genre">
      </div>
      <div>
        <label for="duration">Duration</label>
        <input type="text" id="duration" v-model="movie.duration">
      </div>
      <div>
        <button @click="createMovie">Regist</button>
      </div>
    </fieldset>
  </div>
</template>

<script setup>
import { useMovieStore } from '@/stores/movieStore';
import { ref } from 'vue'

const movie = ref({
  title:'',
  director:'',
  genre:'',
  duration:'',
})

const store = useMovieStore()

const createMovie = function() {
  store.createMovie(movie.value)
}

</script>

<style>
</style>
