<template>
  <div>
    <TheHeaderNav />
    <RouterView />
  </div>
</template>

<script setup>
import TheHeaderNav from "@/components/common/TheHeaderNav.vue";
</script>

<style>
/* 초기화 작업 */
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  list-style: none;
}

a {
  text-decoration: none;
  color: #787878;
}
</style>