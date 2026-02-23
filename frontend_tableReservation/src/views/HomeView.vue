<script setup>
import { onMounted } from 'vue'
import { useLaudadeStore } from '@/stores/laudadeStore';

const store = useLaudadeStore()

onMounted(() => {
  store.laadiLauad()
})
</script>

<template>
  <main>
    <ul>
      <li v-for="laud in store.lauad" :key="laud.id">
        Laud {{ laud.lauaNumber }}, kohti: {{ laud.suurus }}
      </li>
    </ul>
  </main>
</template>
