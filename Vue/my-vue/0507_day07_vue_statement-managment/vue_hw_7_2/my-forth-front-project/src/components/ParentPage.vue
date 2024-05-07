<template>
    <div class = parent>
        <h2>ParentPage</h2>
        <span>{{ parent.father }}</span>
        <span>{{ parent.mother }}</span>
        <ChildPage v-for="child in parent.children"
            :child="child"
        />
    </div>
</template>

<script setup>
import ChildPage from '@/components/ChildPage.vue'
import { useFamilyStore } from '@/stores/family'
const store = useFamilyStore()

defineProps({
    parent: Object
})
</script>

<style scoped>
.parent {
  text-align: center; /* 내부 요소를 가운데 정렬합니다. */
  padding: 20px; /* 내부 여백을 추가합니다. */
  border: 1px solid #ccc; /* 테두리를 추가합니다. */
  border-radius: 5px; /* 테두리를 둥글게 만듭니다. */
  background-color: aliceblue
}

.parent h3 {
  margin-bottom: 10px; /* h3 요소 아래 여백을 추가합니다. */
}

.parent span {
  display: block; /* span 요소를 블록 요소로 변경하여 줄 바꿈을 적용합니다. */
  margin-bottom: 5px; /* span 요소 아래 여백을 추가합니다. */
}
</style>