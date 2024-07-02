<template>
    ProductView Page
    <div class = "갓근범">
        <ProductDetail 
            v-for="product in store.productList"
            :product="product"
        />
    </div>
</template>

<script setup>
    import ProductDetail from '@/components/ProductDetail.vue'
    
    // store를 import 한다.
    import { useProductStore } from '@/stores/product'
    const store = useProductStore()
</script>

<style scoped>
.갓근범{
    display:flex;
    flex-wrap: wrap;
    justify-content: center;
}
</style>