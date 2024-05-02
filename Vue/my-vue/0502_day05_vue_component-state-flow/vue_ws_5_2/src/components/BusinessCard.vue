<template>
    <businessCardDetail :businessCards="businessCards"/>
</template>

<script setup>
    import businessCardDetail from '@/components/businessCardDetail.vue'

    // 부모 component에서 배열 선언
    const businessCards = [
        {name: `Elon Musk`, title:`Tesla`},
        {name: `Larry Ellison`, title:`Oracle`},
        {name: `Bill Gates`, title:`Microsoft`},
        {name: `Larry Page`, title:`Google`},
        {name: `Sergey Brin`, title:`Google`},
    ]
</script>

<style scoped>

</style>