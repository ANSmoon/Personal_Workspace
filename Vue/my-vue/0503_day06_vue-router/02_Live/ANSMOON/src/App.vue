<script setup>
import { RouterLink, RouterView } from 'vue-router'
</script>

<template>
    <header>
        <img alt="Vue logo" class="logo" src="@/assets/logo.svg" width="125" height="125" />
        <nav>
            <!-- <RouterLink to="/">Home</RouterLink> -->
            <!-- <RouterLink to="/about">About</RouterLink> -->
            <RouterLink :to="{name: 'home'}">home</RouterLink>
            <RouterLink :to="{name: 'about'}">about</RouterLink>
            <RouterLink :to="{name: 'user', params: {id: 1}}">user</RouterLink>
            <RouterLink :to="{name: 'login'}">Login</RouterLink>

        </nav>
      </header>
    <RouterView />
</template>

<style scoped>

</style>