<script setup>
import KasutajaEelistused from './components/kasutajaEelistused.vue';
import ValitudLauaPaneel from './components/valitudLauaPaneel.vue';
import BroneeringuPaneel from './components/BroneeringuPaneel.vue';
import HomeView from './views/HomeView.vue';
import { useLaudadeStore } from './stores/laudadeStore.js';
import { useKeelteStore } from './stores/keelteStore.js';

const store = useLaudadeStore();
const keeled = useKeelteStore();

</script>

<template>
  <div class="header">
    <div class="vasak">
      <div class="logoJaTekst">
        <img width="110" height="110"
          src="/italia_logo.png"
          alt="">
        <h1 id="pealkiri">Restoran <br>
          <hr id="pealkirjaJoon">Italia
        </h1>
      </div>
    </div>

    <div class="keelevalik">
      <div class="keeleKonteiner">
        <select v-model="keeled.keel" class="keeleValik">
          <option value="ee">🇪🇪</option>
          <option value="en">🇬🇧</option>
        </select>
      </div>
    </div>

  </div>
  <div class="tervitus">
    <h2 class="pealkiri">{{ keeled.tekst.tervitus }}</h2>
    <p class="tekst">{{ keeled.tekst.kirjeldus }}</p>
    <hr class="tervituseJoon">
  </div>
  <div class="suurKast">
    <HomeView></HomeView>
    <BroneeringuPaneel v-if="store.broneerimisPaneel && store.valitudLaud" />
    <ValitudLauaPaneel v-else-if="store.valitudLaud" />
    <KasutajaEelistused v-else />
  </div>
</template>


<style>
html,
body {
  margin: 0;
  padding: 0;
  height: 100%;
  background-color: hsl(0, 4%, 95%);
}
</style>


<style scoped>
.keelevalik {
  display: flex;
  cursor: pointer;
  font-size: 1.2rem;
  margin-left: auto;
}

.keeleKonteiner {
  margin-left: auto;
  padding-right: 20px;
}

.keeleValik {
  background-color: #00983D;
  color: white;
  border: none;
  font-family: 'Noto Color Emoji', 'Segoe UI Emoji', 'Apple Color Emoji', sans-serif;
  padding: 5px 10px;
  border-radius: 8px;
  font-size: 1.25rem;
  font-weight: bold;
  cursor: pointer;
  outline: none;
  transition: all 0.3s ease;
}

.keeleValik:hover {
  transform: translateY(-2px);
}

.keeleValik option {
  background-color: white;
  font-family: 'Noto Color Emoji', 'Segoe UI Emoji', 'Apple Color Emoji', 'Noto Color Emoji', sans-serif;
  font-size: 1.1rem;
}


img {
  transition: transform 0.3s ease;
}

img:hover {
  transform: scale(1.05);
}

.logoJaTekst {
  display: flex;
  align-items: center;
  gap: 10px;
  margin-right: auto;
}

.tervitus {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  margin-bottom: 10px;
  animation: sisseSujumine 0.8s ease-out forwards;
}

.tervituseJoon {
  width: 100%;
  max-width: 600px;
  min-width: 320px;
  border: 0;
  height: 3px;
  background-color: #00983D;
  box-shadow: 0 2px 2px rgba(0, 0, 0, 0.1);
  margin: 12px 0 30px 0;
  border-radius: 2px;
}

.pealkiri {
  color: #00983D;
  font-size: 2.2rem;
  font-weight: bold;
  margin-bottom: 8px;
  letter-spacing: 1px;
  text-shadow: 2px 2px 1px rgba(44, 43, 43, 0.014);
  margin-top: 40px;
  text-align: center;
}


.tekst {
  color: #333;
  font-size: 1.15rem;
  text-align: center;
  max-width: 600px;
  margin-bottom: 0;
  text-shadow: 1.5px 1.5px 1px rgba(0, 0, 0, 0.021);
  margin-bottom: 30px;
}

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
  animation: sisseSujumine 0.8s ease-out 0.3s forwards;
  opacity: 0;
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
  box-shadow: 2px 2px 2px rgba(0, 0, 0, 0.1), 2px 4px 4px rgba(0, 0, 0, 0.1);
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

.header {
  display: flex;
  background-color: #00983D;;
  padding-left: 1.5vh;
  padding-right: 1.5vh;
  align-items: center;
  border-bottom: 2px solid green;
  box-shadow: 2px 1px 4px gray;
}

#pealkirjaJoon {
  margin: none;
  border: 1px solid white;
  box-shadow: 2.5px 2.5px 1px rgba(0, 0, 0, 0.26);
}

@media (min-width: 1037px) {

  .header {
    margin-bottom: 20px;
  }
}

#pealkiri {
  color: white;
  font-weight: bold;
  font-size: 1.75rem;
  text-shadow: 2.5px 2.5px 1px rgba(0, 0, 0, 0.26);
}

@keyframes sisseSujumine {
  from {
    opacity: 0;
    transform: translateY(20px);
  }

  to {
    opacity: 1;
    transform: translateY(0);
  }
}
</style>
