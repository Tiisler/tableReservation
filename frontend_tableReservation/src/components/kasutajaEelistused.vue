<script setup>
import { ref } from 'vue';
import { useLaudadeStore } from '../stores/laudadeStore.js'

const store = useLaudadeStore()

const kuupaev = ref('');
const kellaaeg = ref('');
const koht = ref('saal');
const inimesteArv = ref(1);
const aknaAll = ref(false);
const vaikneNurk = ref(false);
const mangunurgaLahedal = ref(false);

function saadaEelistused() {
    store.saadaEelistused({
        kuupaev: kuupaev.value,
        kellaaeg: kellaaeg.value,
        asukoht: koht.value,
        inimesteArv: inimesteArv.value,
        aknaAll: aknaAll.value,
        vaikneNurk: vaikneNurk.value,
        manguNurk: mangunurgaLahedal.value 
    });
}
</script>

<template>
    <div class="paneel">
        <form class="eelistusteVorm" @submit.prevent="saadaEelistused">
            <div class="vormiRida">
                <label for="kuupaev">Kuupäev:</label>
                <input id="kuupaev" type="date" v-model="kuupaev" required />
            </div>
            <div class="vormiRida">
                <label for="kellaaeg">Kellaaeg:</label>
                <input id="kellaaeg" type="time" v-model="kellaaeg" required />
            </div>
            <div class="vormiRida">
                <label for="kylalisteArv">Külaliste arv:</label>
                <input id="kylalisteArv" type="number" min="1" max="20" v-model="inimesteArv" required />
            </div>
            <div class="vormiRida">
                <label for="koht">Koha tüüp:</label>
                <select id="koht" v-model="koht">
                    <option value="saal">Tavaline saal</option>
                    <option value="veranda">Veranda</option>
                    <option value="privaatne">Privaatne ruum</option>
                </select>
            </div>
            <div class="vormiRida">
                <label>Eelistused:</label>
                <div class="eelistused-valikud">
                    <label>
                        <input type="checkbox" v-model="aknaAll" />
                        Akna all
                    </label>
                    <label>
                        <input type="checkbox" v-model="vaikneNurk" />
                        Vaikne nurk
                    </label>
                    <label>
                        <input type="checkbox" v-model="mangunurgaLahedal" />
                        Mängunurga lähedal
                    </label>
                </div>
            </div>
            <button type="submit" class="nupp">Vaata soovitust</button>
        </form>
    </div>
</template>

<style scoped>
.paneel {
    background: #f7f7f7;
    padding: 24px 28px;
    min-width: 260px;
    display: flex;
    flex-direction: column;
    height: auto;
    border-radius: 10px;
    border: black 1px solid;
}

.eelistusteVorm {
    display: flex;
    flex-direction: column;
    gap: 20px;
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
