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
body * {
  text-decoration: none;
  color: black;
}

.app-description{
  border : 1px solid black;
  padding : 10px;
  margin-bottom: 20px;
}

.app-header{
  border : 1px solid black;
  padding : 10px;
  background-color: orange;
  color: white;
}

.app-nav{
  border : 1px solid black;
  padding : 10px;
}

.quiz-app{
  border : 1px solid black;
  padding : 10px;
  text-align: center;
}

</style>
