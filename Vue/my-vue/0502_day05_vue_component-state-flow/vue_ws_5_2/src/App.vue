<script setup>
    import BusinessCard from '@/components/BusinessCard.vue'
</script>

<template>
    <div class = "test">
        <h1>Business Management Page</h1>
        <h4>This is Management Page of CEO. It offers list of business's personal information.</h4>
        <h3>CEO's List</h3>
    </div>
    <BusinessCard />
</template>

<style scoped>
.test{
    display: flex;
    flex-direction: column;
    align-items: center;
}

h1{
    border: 1px solid white;
    padding: 20px;
    width: 60%;
    text-align: center;
    background-color: bisque;
}

h3{
    border: 1px solid white;
    padding: 20px;
    width: 30%;
    text-align: center;
    background-color: yellowgreen;
}

h4{
    border: 1px solid white;
    padding: 20px;
    width: 70%;
    text-align: center;
    background-color: coral;
}

</style>