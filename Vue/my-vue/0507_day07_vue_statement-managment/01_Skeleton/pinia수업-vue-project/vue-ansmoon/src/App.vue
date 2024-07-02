<script setup>
  import { useCounterStore } from '@/stores/counter'
  
  const store = useCounterStore()
  
  console.log(store)
  console.log(store.count)
  console.log(store.quartCount)
</script>

<template>
    <h1>ANSMOON</h1>

    <!-- state -->
    <p>state : {{ store.count }}</p>

    <!-- getters -->
    <p>getters : {{ store.quartCount }}</p>

    <!-- actions -->
    <button @click="store.increment">누르셈</button>

</template>

<style scoped>

</style>