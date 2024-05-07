// main.js에서 정적 source들을 가져온다.
import './assets/style.css'

import { createApp } from 'vue'
import { createPinia } from 'pinia'
import App from './App.vue'

const app = createApp(App)

app.use(createPinia())

app.mount('#app')

// createApp(App).use(createPinia()).mount('app')