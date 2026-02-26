<script setup>
import KasutajaEelistused from './components/kasutajaEelistused.vue';
import ValitudLauaPaneel from './components/valitudLauaPaneel.vue';
import HomeView from './views/HomeView.vue';
import { useLaudadeStore } from './stores/laudadeStore.js';

const store = useLaudadeStore();

</script>

<template>
  <div class="suurKast">
    <HomeView></HomeView>
    <ValitudLauaPaneel v-if="store.valitudLaud" />
    <KasutajaEelistused v-else />
  </div>
</template>

<style scoped>
.suurKast {
  display: flex;
  flex-direction: row;
  flex-wrap: wrap; 
  align-items: flex-start; 
  justify-content: center;
  gap: 20px;
  padding: 40px;
  width: 100%;
  box-sizing: border-box;
}

:deep(.paneel) {
  background: #f7f7f7;
  padding: 24px 28px;
  width: 320px;
  display: flex;
  flex-direction: column;
  border-radius: 10px;
  border: black 1px solid;
  box-sizing: border-box;
  align-self: stretch; 
}

:deep(.HomeViewKonteiner) { 
  align-self: flex-start;
}

@media (max-width: 1037px) {
  .suurKast {
    flex-direction: column-reverse;
    align-items: center;
    padding: 20px;
  }

  :deep(.paneel) {
    width: 100%;
    max-width: 500px;
    min-height: auto;
    align-self: center;
  }

  :deep(.HomeViewKonteiner) {
    align-self: center;
  }
}
</style>
