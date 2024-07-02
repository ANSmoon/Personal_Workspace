<template>
    <div class = product>
        <div>{{ product.name }}</div>
        <img :src="product.imagePath" alt="왜 안됨" style="width: 250px;">
        <div>{{ product.price }}🔞</div> 
        <div v-if="product.isFavorite">💖</div>
        <div v-else>🤍</div>
    </div>
</template>

<script setup>
import { useProductStore } from '@/stores/product'
const store = useProductStore()
defineProps({
    product: Object
})
</script>

<style scoped>
.product {
  text-align: center; /* 내부 요소를 가운데 정렬합니다. */
  padding: 20px; /* 내부 여백을 추가합니다. */
  border: 1px solid #ccc; /* 테두리를 추가합니다. */
  border-radius: 5px; /* 테두리를 둥글게 만듭니다. */
  background-color: aliceblue;
  margin: 10px;
}

</style>