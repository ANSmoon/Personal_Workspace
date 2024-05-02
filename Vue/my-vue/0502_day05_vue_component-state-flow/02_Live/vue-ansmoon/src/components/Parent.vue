<template>
    <div>
        <!-- props -->
        <!-- ParentChild: <ParentChild my-msg="ANSMOON message to parent"/> -->
        
        <!-- emit event 발생 -->
        ParentChild: 
        <ParentChild 
            @some-event="someCallback"
            @emit-args="getBirthday"
            />
        
    </div>
</template>

<script setup>
    import ParentChild from '@/components/ParentChild.vue'
    import {ref} from 'vue';
    
    const someCallback = function(){
        console.log('생일')
    }

    const getBirthday = function(...args){
        console.log(args)
        // 왜 `` 를 사용해야 하는지?
        console.log(`Today is birthday, ${args} 입니다. <3 !!!`)
    }
</script>