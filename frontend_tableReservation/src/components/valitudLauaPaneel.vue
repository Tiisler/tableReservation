<script setup>
import { useLaudadeStore } from '@/stores/laudadeStore';

const store = useLaudadeStore()

</script>


<template>
    <div v-if="store.valitudLaud" class="paneel">
        <p>{{ store.valitudLaud.kohtadeArv }}</p>
        <p>{{ store.valitudLaud.aknaJuures ? 'Akna juures' : 'Ei ole aknale lähedal' }}</p>
        <p>{{ store.valitudLaud.lauaNumber }}</p>
    </div>
</template>


<style scoped></style>