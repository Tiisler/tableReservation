import { defineStore } from 'pinia'
import { ref } from 'vue'

export const useLaudadeStore = defineStore('laudadeStore', () => {
    const lauad = ref([])

    const laadiLauad = async () => {
        const response = await fetch('http://localhost:8080/api/tables')
        lauad.value = await response.json()
    }

    return {
        lauad,
        laadiLauad
    }
})