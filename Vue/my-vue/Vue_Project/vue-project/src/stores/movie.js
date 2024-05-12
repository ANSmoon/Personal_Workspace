import { ref, computed } from "vue";
import { defineStore } from "pinia";
import { useRouter } from "vue-router";
import axios from "axios";

const REST_MOVIE_API = 'http://localhost:8080/ssafit/movie'

export const useMovieStore = defineStore('movie', () => {
  const router = useRouter();
  const movieList = ref([])

  const getMovieList = function() {
    axios.get(REST_MOVIE_API)
    .then((response) => {
      movieList.value = response.data
    })
  }

  const movie = ref({})
  const getMovie = function(id) {
    axios.get(`${REST_MOVIE_API}/${id}`)
    .then((response) => {      
      movie.value = response.data
    })
    .then(() => {
      if(movie.value == ""){        
        router.push({ name: 'movie' })
      }
    })
  }
  

  return {getMovieList, movieList, getMovie, movie};
});