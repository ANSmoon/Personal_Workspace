<template>
    <div>
        <h2>TodoForm Page</h2>
        <form @submit.prevent="createTodo(todoText)" ref="formElem">
            <input type="text" v-model="todoText">
            <input type="submit" >
        </form>
    </div>
</template>

<script setup>
import {useCounterStore} from '@/stores/counter'
import {ref} from 'vue'

const store = useCounterStore()
const formElem = ref('')

const createTodo = function(todoText){
    store.createTodo(todoText)
    formElem.value.reset()
}
</script>

<style scoped>

</style>