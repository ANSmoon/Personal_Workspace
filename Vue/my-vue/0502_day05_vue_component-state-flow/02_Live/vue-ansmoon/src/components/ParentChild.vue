<template>
    <div>
        <!-- <p> {{ myMsg }} </p>
        ParentGrandChild: <ParentGrandChild :my-msg="myMsg"/> -->

        <!-- $emit을 사용 -->
        <!-- <button @click="$emit('someEvent')">Click</button> -->

        <!-- defineEmits buttonClick 사용 -->
        <button @click="$emit('buttonClick')">Click</button>
        <button @click="emitArgs">추가 인자 전달</button>



    </div>
</template>

<script setup>
    import ParentGrandChild from '@/components/ParentGrandChild.vue'
    // 1. props를 받을때 문자배열은 명시적이지 않다.
    // defineProps(['myMsg'])

    // 2. 객체 방식
    const props = defineProps({
        myMsg: String
    })

    console.log(props)
    console.log(props.myMsg)

    // defineEmits
    
    const emit = defineEmits(['someEvent', 'emitArgs'])

    const emitArgs = function() {
        emit('emitArgs', 1, 2, 3)
    }

    const buttonClick = () => {
        emit('someEvent')
    }
</script>