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
                <label for="kuupaev"><b>Kuupäev:</b></label>
                <input id="kuupaev" type="date" v-model="store.viimasedEelistused.kuupaev" required />
            </div>
            <div class="vormiRida">
                <label for="kellaaeg"><b>Kellaaeg:</b></label>
                <input id="kellaaeg" type="time" v-model="store.viimasedEelistused.kellaaeg" required />
            </div>
            <div class="vormiRida">
                <label for="kylalisteArv"><b>Külaliste arv:</b></label>
                <input id="kylalisteArv" type="number" min="1" max="20" v-model="store.viimasedEelistused.inimesteArv"
                    required />
            </div>
            <div class="vormiRida">
                <label for="koht"><b>Koha tüüp:</b></label>
                <select id="koht" v-model="store.viimasedEelistused.asukoht">
                    <option value="saal">Tavaline saal</option>
                    <option value="veranda">Veranda</option>
                    <option value="privaatne">Privaatne ruum</option>
                </select>
            </div>
            <div class="vormiRida">
                <label><b>Eelistused:</b></label>
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
    border: 1px solid #39923c;
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
    background-color: #45a049;
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
    border: 1px solid #000000;
    outline: none;
}

input[type="checkbox"] {
    accent-color: #4CAF50;
}

.eelistused-valikud {
    display: flex;
    flex-direction: column;
    gap: 4px;
}
</style>
