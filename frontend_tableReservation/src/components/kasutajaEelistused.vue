<script setup>
import { ref, onMounted, computed } from 'vue';
import { useLaudadeStore } from '../stores/laudadeStore.js'
import { useKeelteStore } from '../stores/keelteStore.js'

const store = useLaudadeStore()
const keeled = useKeelteStore()

const minimaalneKuupaev = computed(() => {
    return new Date().toISOString().split('T')[0];
});

onMounted(() => {
    store.algseis(store.viimasedEelistused.kuupaev, store.viimasedEelistused.kellaaeg);
});

function saadaEelistused() {
    store.saadaEelistused(store.viimasedEelistused);
}


</script>

<template>
    <div class="paneel">
        <form class="eelistusteVorm" @submit.prevent="saadaEelistused">
            <div class="vormiRida">
                <label for="kuupaev"><b>{{ keeled.tekst.kuupaev }}</b></label>
                <input id="kuupaev" type="date" v-model="store.viimasedEelistused.kuupaev" :min="minimaalneKuupaev" required />
            </div>
            <div class="vormiRida">
                <label for="kellaaeg"><b>{{ keeled.tekst.kellaaeg }}</b></label>
                <input id="kellaaeg" type="time" v-model="store.viimasedEelistused.kellaaeg" required />
            </div>
            <div class="vormiRida">
                <label for="kylalisteArv"><b>{{ keeled.tekst.kylalisteArv }}</b></label>
                <input id="kylalisteArv" type="number" min="1" max="20" v-model="store.viimasedEelistused.inimesteArv"
                    required />
            </div>
            <div class="vormiRida">
                <label for="koht"><b>{{ keeled.tekst.kohaTyyp }}</b></label>
                <select id="koht" v-model="store.viimasedEelistused.asukoht">
                    <option value="saal">{{ keeled.tekst.tavalineSaal }}</option>
                    <option value="veranda">{{ keeled.tekst.veranda }}</option>
                    <option value="privaatne">{{ keeled.tekst.privaatneRuum }}</option>
                </select>
            </div>
            <div class="vormiRida">
                <label><b>{{ keeled.tekst.eelistused }}</b></label>
                <div class="eelistused-valikud">
                    <label>
                        <input type="checkbox" v-model="store.viimasedEelistused.aknaAll" />
                        {{ keeled.tekst.aknaAll }}
                    </label>
                    <label>
                        <input type="checkbox" v-model="store.viimasedEelistused.vaikneNurk" />
                        {{ keeled.tekst.vaikneNurk }}
                    </label>
                    <label>
                        <input type="checkbox" v-model="store.viimasedEelistused.manguNurk" />
                        {{ keeled.tekst.mangunurgaLahedal }}
                    </label>
                </div>
            </div>
            <button type="submit" class="nupp">{{ keeled.tekst.soovituseNupp }}</button>
        </form>
    </div>
</template>

<style scoped>
.eelistusteVorm {
    display: flex;
    flex-direction: column;
    gap: 16px;
    height: 100%;
}

.nupp {
    background-color: #00983D;
    border: 1px solid #057030;
    color: white;
    padding: 12px;
    border-radius: 8px;
    font-weight: bold;
    cursor: pointer;
    margin-top: auto;
    box-shadow: 1px 1.5px 2px rgba(0, 0, 0, 0.1), 1px 1.5px 3px rgba(0, 0, 0, 0.1);
    transition: 200ms;
}

.nupp:hover {
    background-color: #07883a;
    transform: translateY(-2px);
}

.vormiRida {
    display: flex;
    flex-direction: column;
    gap: 5px;
}

label {
    margin-bottom: 2px;
}

input[type="date"],
input[type="time"],
input[type="number"],
select {
    padding: 4px 8px;
    border-radius: 8px;
    border: 1px solid #bbb;
    font-size: 12px;
    box-shadow: 1px 1px 2px rgba(0, 0, 0, 0.1);
}

input:focus,
select:focus {
    border-color: #000000;
    box-shadow: 0 0 4px rgba(12, 27, 13, 0.068);
    outline: none;
}

input[type="checkbox"] {
    accent-color: #00983D;
}

.eelistused-valikud {
    display: flex;
    flex-direction: column;
    gap: 4px;
}
</style>
