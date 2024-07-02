<template>
  <div class="main-page">
    <QuizDetail v-for="list in quizList" :pass='list'/>
  </div>
</template>

<script setup>
  import QuizDetail from '@/views/QuizDetail.vue';

  const quizList = [
    {pk: 1, question: 'Python 웹 framework 중 하나로, micro web framework로 빠른 개발을 지원한는 것은?', answer:'flask'},
    {pk: 2, question: '우리반 코딩 원탑은?', answer:'갓근범'},
    {pk: 3, question: '우리반 숨은 권모술수는?', answer:'김성현스'},
    {pk: 4, question: '우리반 세상 착한 사람은?', answer:'나'},
    {pk: 5, question: '우리반 세상 착한 사람을 맨유로 놀리는 사람은?', answer:'김타성'}
  ]

</script>

<style scoped>

</style>
