<script setup>
import { ref, onMounted } from 'vue';
import { useLaudadeStore } from '../stores/laudadeStore.js'

const store = useLaudadeStore()

const kuupaev = ref('');
const kellaaeg = ref('');
const koht = ref('saal');
const inimesteArv = ref(1);
const aknaAll = ref(false);
const vaikneNurk = ref(false);
const mangunurgaLahedal = ref(false);

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
                <label for="kuupaev">Kuupäev:</label>
                <input id="kuupaev" type="date" v-model="store.viimasedEelistused.kuupaev" required />
            </div>
            <div class="vormiRida">
                <label for="kellaaeg">Kellaaeg:</label>
                <input id="kellaaeg" type="time" v-model="store.viimasedEelistused.kellaaeg" required />
            </div>
            <div class="vormiRida">
                <label for="kylalisteArv">Külaliste arv:</label>
                <input id="kylalisteArv" type="number" min="1" max="20" v-model="store.viimasedEelistused.inimesteArv" required />
            </div>
            <div class="vormiRida">
                <label for="koht">Koha tüüp:</label>
                <select id="koht" v-model="store.viimasedEelistused.asukoht">
                    <option value="saal">Tavaline saal</option>
                    <option value="veranda">Veranda</option>
                    <option value="privaatne">Privaatne ruum</option>
                </select>
            </div>
            <div class="vormiRida">
                <label>Eelistused:</label>
                <div class="eelistused-valikud">
                    <label>
                        <input type="checkbox" v-model="store.viimasedEelistused.aknaAll" />
                        Akna all
                    </label>
                    <label>
                        <input type="checkbox" v-model="store.viimasedEelistused.vaikneNurk" />
                        Vaikne nurk
                    </label>
                    <label>
                        <input type="checkbox" v-model="store.viimasedEelistused.manguNurk" />
                        Mängunurga lähedal
                    </label>
                </div>
            </div>
            <button type="submit" class="nupp">Vaata soovitust</button>
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
    background-color: #4CAF50;
    color: white;
    border: none;
    padding: 12px;
    border-radius: 8px;
    font-weight: bold;
    cursor: pointer;
    margin-top: auto;
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
}

.eelistused-valikud {
    display: flex;
    flex-direction: column;
    gap: 4px;
}
</style>
