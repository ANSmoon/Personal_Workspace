<script setup>
    // 자식 page를 ParentPage에 등록
    // child page 배열을 반복해 등록
    import ChildPage from '@/components/ChildPage.vue';

    // children 배열 생성
    const peopleArray = [
        {name : `IU`, age : `30`},
        {name : `Karina`, age : `23`},
        {name : `Yujin`, age : `20`}
    ]    
</script>

<template>
    <div class = "parent-box">
        <h1>This is Parent Page</h1>
        <ChildPage :peopleArray="peopleArray"/>
    </div>
</template>

<style scoped>
  .parent-box{
    border:1px solid #000;
    padding: 10px;
  }
</style>