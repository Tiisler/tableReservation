<script setup>
import { onMounted } from 'vue'
import { useLaudadeStore } from '@/stores/laudadeStore';
import laudadePaneel from '@/components/laudadePaneel.vue';


const store = useLaudadeStore()

onMounted(() => {
  store.laadiLauad()
})
</script>

<template>
  <laudadePaneel></laudadePaneel>

</template>

<style scoped></style>
