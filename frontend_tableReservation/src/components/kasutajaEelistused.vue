<script setup>
import { ref } from 'vue';
import { useLaudadeStore } from '../stores/laudadeStore.js'

const store = useLaudadeStore()
const aknaAll = ref(false);
const inimesteArv = ref(0);


</script>

<template>
    <div>
        <form @submit.prevent="store.saadaEelistused({ aknaAll: aknaAll, inimesteArv: inimesteArv })">
        <label>
            <input type="number" inimesteArv v-model="inimesteArv" />
            <input type="checkbox" v-model="aknaAll" />
            Akna all
        </label>
        <button type="submit">Salvesta eelistused</button>
        </form>
    </div>
</template>

<style scoped>
</style>
