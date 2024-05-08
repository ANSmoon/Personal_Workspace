<template>
    <div v-if="store.selectedVideo">
        <h4>Video Detail</h4>
        <iframe
            width="560"
            height="315"
            :src="videoURL"
            title="Youtube Video Player"
            frameborder="0"
            allow="accelerometer; autoplay; clipboard-wrtie; encrypted-media; gyroscope; picture-in-picture; web-share"
            referrerpolicy="strict-origin-when-cross-origin"
            allowfullscreen
        ></iframe>
    </div>
  </template>
  
  <script setup>
  import { useYoutubeStore } from '@/stores/youtube';
  import { computed } from 'vue'

  const store = useYoutubeStore();
  const videoURL = computed(() => {
    const videoId = store.selectedVideo.id.videoId
    return `https://www.youtube.com/embed/${videoId}`
  })



  </script>
  
  <style scoped>
  
  </style>