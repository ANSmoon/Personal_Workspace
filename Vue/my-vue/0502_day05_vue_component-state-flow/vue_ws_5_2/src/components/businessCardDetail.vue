<template>
    <div class="detail">
        <div class="detail-box" v-for="(person, index) in businessCards" :key="index">
            <p class=Name> Name : {{ person.name }}</p>
            <p class="Company"> Company : {{ person.title }}</p>
        </div>
    </div>
</template>

<script setup>
import { defineProps } from 'vue';

const props = defineProps({
    businessCards: {
        type: Array
    }
})
</script>

<style scoped>
.detail-box {
    border: 1px solid #000;
    padding: 10px;
    margin:10px;
    width: 40%;
    text-align: center;
    background-color: whitesmoke;
    border-style: unset;
}

.detail {
    display: flex;
    flex-wrap: wrap;
    justify-content: center;

}

.Name{
    font-size: larger;
    color: red;
    font-style: italic;
    font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
}

.Company{
    color: cadetblue;
    font-style: italic;
    font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
}

</style>