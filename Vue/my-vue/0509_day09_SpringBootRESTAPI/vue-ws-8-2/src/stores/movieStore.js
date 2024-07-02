import { defineStore } from 'pinia'
import { ref } from 'vue'
import axios from 'axios'
import router from '@/router'

const REST_MOVIE_API = 'http://localhost:8080/movieapi/movie'

export const useMovieStore = defineStore('movieStore', () => {

  const createMovie = function (movie){
    axios({
      url: REST_MOVIE_API,
      method: 'POST',
      data: movie
    })
    .then(() =>{
      router.push({name: 'MovieList'})
    })
    .catch((error) =>{
      console.log(error)
    })
  }

  const movieList = ref([])

  const getMovieList = function () {
    axios.get(REST_MOVIE_API)
    .then((response) =>{
      movieList.value = response.data
    })
    .catch((error) =>{
      console.log("영화 정보 받아오기 실패")
    })
  }

  const movie = ref({})

  const getMovie = function(id) {
    axios.get(`${REST_MOVIE_API}/${id}`) 
    .then((response) => {
      movie.value = response.data
    })
    .catch((error) =>{
      console.log("영화 하나 가져오기 안됨")
    })
  }

  return {
    createMovie,
    movieList,
    getMovieList,
    getMovie,
    movie
  };
})
