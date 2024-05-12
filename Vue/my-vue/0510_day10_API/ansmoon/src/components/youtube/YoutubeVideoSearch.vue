<template>
    <div>
        <h4>Search Component</h4>
        <input type="text" v-model="keyword" />
        <button @click="search">Search</button>
    </div>
  </template>
  
  <script setup>
  import { ref } from 'vue'
  import { useYoutubeStore } from '@/stores/youtube';

  const keyword = ref('')
  const store = useYoutubeStore()

  const search = function() {
    store.youtubeSearch(keyword.value);
  };
  </script>
  
  <style scoped>
  
  </style>