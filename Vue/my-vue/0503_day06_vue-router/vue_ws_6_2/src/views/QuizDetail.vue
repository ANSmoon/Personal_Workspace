<template>
    <div>
        <b>{{ pass.pk }}번 문제. {{ pass.question }}</b>
        <p>정답 입력</p>
        <input type="text">
    </div>
</template>

<script setup>
    defineProps({
        pass: Object,
    })
</script>

<style scoped>
div{
    border: 1px solid black;
    margin: 20px;
    padding: 10px;
    border-radius: 5px;
}
</style>