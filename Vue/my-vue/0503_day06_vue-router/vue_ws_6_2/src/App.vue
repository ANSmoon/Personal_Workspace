<template>
  <div class="quiz-app">
    <div class="app-header">
      <h1>Quiz 퀴즈</h1>
    </div>

    <div class="app-description">
      <h4>여기는 나락 퀴즈쇼! 당신의 능지를 시험해 보세요!</h4>
    </div>

    <nav class="app-nav">
      |
      <RouterLink to="/" class="nav-link">Home</RouterLink> | 
      <RouterLink to="/quiz" class="nav-link">Quiz</RouterLink> |
    </nav>

  </div>
  <RouterView />
</template>

<script setuo>
  import { RouterLink, RouterView } from 'vue-router';


</script>

<style scoped>

</style>
