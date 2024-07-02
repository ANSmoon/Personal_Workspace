<template>
    <div>
        <h4>TodoListItem Page</h4>
        <span>{{ myTodo.text }} - {{ myTodo.isDone }}</span>
    </div>
</template>

<script setup>
defineProps({
    myTodo: Object, 
})
</script>

<style scoped>

</style>