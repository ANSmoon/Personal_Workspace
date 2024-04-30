<template>
    <div class="container">
        <h1>가수 정보 페이지에 오신 것을 환영합니다.</h1>
    
        <h5>여러분이 좋아하는 가수와 아티스트에 대한 정보를 탐색해보세요.</h5>

        <img :src="imgPath" v-for="imgPath of images" :key="imgPath" alt="Error" />

    
    </div>
</template>

<script setup>
const modules =
    import.meta.glob("/src/assets/*.jpg", { eager: true });
const images = [];
for (const imgPath in modules) {
    images.push(modules[imgPath].default);
}
</script>

<style>
.container {
    display: flex;
    flex-direction: column;
    align-items: center;
    text-align: center;
}

img {
    width: 200px;
}
</style>