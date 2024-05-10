import { ref, computed } from "vue";
import { defineStore } from "pinia";
import axios from "axios";

const REST_MOVIE_API = 'http://localhost:8080/ssafit/movie'

export const useMovieStore = defineStore('movie', () => {
  const movieList = ref([])
  const selectedVideo = ref(null)

  const getMovieList = function() {
    axios.get(REST_MOVIE_API)
    .then((response) => {
      movieList.value = response.data
    })
  }

  const clickVideo = function(video){
    selectedVideo.value = video
  }

  return {getMovieList, movieList, clickVideo, selectedVideo};
});