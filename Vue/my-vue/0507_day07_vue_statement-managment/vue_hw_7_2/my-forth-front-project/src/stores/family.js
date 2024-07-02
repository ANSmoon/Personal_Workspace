import { ref } from 'vue'
import { defineStore } from 'pinia'

// store
export const useFamilyStore = defineStore('family', () => {
  // 저장소 : state, getters, actions
  
  // state
  const familyInfo = ref([
    {
      familyName: 'Mediche',
      father: 'Lodovico De Mediche',
      mother: 'Maria Sarviaty',
      children: [
        {name: 'Teledo El Leonor'},
        {name: 'Kosimo 1th'},
      ]
    },
    {
      familyName: '전주 이씨',
      father: '이도',
      mother: '소헌왕후',
      children: [
        {name: '이향'},
        {name: '이유'},
      ]
    },
  ])

  // action 



  return {
    familyInfo
  }
  
})