<template>
    <div class = children>
        <div>ChildPage</div>
        <br>
        {{ child.name }}
    </div>
</template>

<script setup>
defineProps({
    child: Object
})

import { useFamilyStore } from '@/stores/family'
const store = useFamilyStore()
</script>

<style scoped>
.children {
  text-align: center; /* 내부 요소를 가운데 정렬합니다. */
  margin: 10px 0; /* 상하 여백을 추가합니다. */
  padding: 10px; /* 내부 여백을 추가합니다. */
  border: 1px solid #ccc; /* 테두리를 추가합니다. */
  border-radius: 5px; /* 테두리를 둥글게 만듭니다. */
  background-color: blanchedalmond;
}

.children > div{
    font-size: larger;
    font-weight: 500;
}
</style>