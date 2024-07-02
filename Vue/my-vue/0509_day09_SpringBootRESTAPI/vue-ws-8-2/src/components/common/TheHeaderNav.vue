<template>
  <div id="container">
    <header>
      <nav>
        <RouterLink :to="{name: 'Home'}">Home</RouterLink> |
        <RouterLink :to="{name: 'Movie'}">Movie</RouterLink> |
        <RouterLink :to="{name: 'MovieList'}">MovieList</RouterLink> |
        <RouterLink :to="{name: 'MovieCreate'}">MovieCreate</RouterLink> |
      </nav>
    </header>
  </div>
</template>
<script setup></script>

<style>
#container{
    text-align: center;
}

nav a{
    font-weight: bold;
    text-decoration: none;
    color: black;
}

nav a.router-link-exact-active{
    color:pink;
}
</style>