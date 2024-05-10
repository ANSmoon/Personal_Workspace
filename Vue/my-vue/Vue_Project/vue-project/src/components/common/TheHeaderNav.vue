<template>
  <div id = "container">
    <RouterLink :to="{name:'movie'}">SSAFIT</RouterLink>
    <div>
      <RouterLink :to="{name:'user'}">로그인</RouterLink> |
      <RouterLink :to="{name:'user'}">회원가입</RouterLink>
    </div>
  </div>
</template>

<script setup>

</script>

<style scoped>
#container{
    text-align: center;
}

</style>