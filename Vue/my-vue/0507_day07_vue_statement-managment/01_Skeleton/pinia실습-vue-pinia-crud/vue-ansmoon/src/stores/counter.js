import { ref, computed } from 'vue'
import { defineStore } from 'pinia'

// store
export const useCounterStore = defineStore('counter', () => {
  // 저장소 : state, getters, actions
  // id
  let id = 1

  // 내가 실제로 해야 할 일
  const todos = ref([
    { id: id++, text: 'Coding', isDone: false},
    { id: id++, text: 'Eating lunch', isDone: false},
    { id: id++, text: 'Gaming', isDone: false},
    { id: id++, text: 'Studying', isDone: false}
  ])

  // action
  const createTodo = function(todoText){
    todos.value.push({
      id: id++,
      text: todoText,
      isDone: false
    })
  }

  return {
    todos,
    createTodo
  }
})