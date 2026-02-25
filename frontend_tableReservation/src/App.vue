<script setup>
import KasutajaEelistused from './components/kasutajaEelistused.vue';
import ValitudLauaPaneel from './components/valitudLauaPaneel.vue';
import HomeView from './views/HomeView.vue';

</script>

<template>
  <div class="suurKast">
    <HomeView></HomeView>
    <KasutajaEelistused></KasutajaEelistused>
    <ValitudLauaPaneel></ValitudLauaPaneel>
  </div>
</template>

<style scoped>
.suurKast {
  display: flex;
  flex-direction: row;
  align-items: flex-start;
  justify-content: center;
  gap: 15px;
  padding: 40px;
  width: 100%;
  box-sizing: border-box;
}
</style>
