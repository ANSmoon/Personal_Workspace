<template>
    <div class='person-box' v-for="(person, index) in peopleArray" :key="index">
    
        <h3>This is Child Page</h3>
    
        <p>Name: {{ person.name }}</p>
    
        <p>Age: {{ person.age }}</p>
    
    </div>
</template>
  
<script setup>
import { defineProps } from 'vue';

const props = defineProps({
    peopleArray: {
        type: Array
    }
});
</script>
  
<style scoped>
.person-box {
    border: 1px solid #ccc;
    margin-bottom: 10px;
    padding: 10px;
}
</style>