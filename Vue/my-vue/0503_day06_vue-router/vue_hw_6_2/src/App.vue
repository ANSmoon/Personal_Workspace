<script setup>
import { RouterLink, RouterView } from 'vue-router'
import MainPage from '../components/MainPage.vue';
</script>

<template>
    <header>
        <img alt="Vue logo" class="logo" src="@/assets/logo.svg" width="125" height="125" />
        <MainPage />
        <div class="wrapper">
            
            <nav>
                <RouterLink to="/">Some</RouterLink>
                <span> | </span>
                <RouterLink to="/other">Other</RouterLink>
            </nav>
    
        </div>
    </header>
    <RouterView />
</template>

<style scoped>

</style>