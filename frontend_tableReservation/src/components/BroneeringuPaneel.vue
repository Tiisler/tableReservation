<script setup>
import { ref } from 'vue';
import { useLaudadeStore } from '@/stores/laudadeStore';
import { useKeelteStore } from '@/stores/keelteStore';

const store = useLaudadeStore();
const keeled = useKeelteStore();

const nimi = ref('');
const email = ref('');
const telefoninumber = ref('');

const tagasi = () => {
    store.broneerimisPaneel = false;
};

const broneeri = async () => {
    try {
        const broneeringuAndmed = {
            lauaId: store.valitudLaud.id,
            nimi: nimi.value,
            email: email.value,
            telefoninumber: telefoninumber.value,
            kuupaev: store.viimasedEelistused.kuupaev,
            kellaaeg: store.viimasedEelistused.kellaaeg
        };

        const response = await fetch('https://backend-tablereservation.onrender.com/api/lauad/broneeri', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(broneeringuAndmed)
        });

        if (response.ok) {
            const updatedLaud = await response.json();
            store.valitudLaud = updatedLaud;
            alert(`${keeled.tekst.lauaNr} ${store.valitudLaud.lauaNumber} ${keeled.tekst.broneeringKinnitatud}`);
            await store.uuendaLauad();
            store.soovitatudLaud = null;
            store.valitudLaud = null;
            store.broneerimisPaneel = false;
            nimi.value = '';
            email.value = '';
            telefoninumber.value = '';
        } else {
            alert('Broneerimine ebaõnnestus. Palun proovige uuesti.');
        }
    } catch (error) {
        console.error('Viga:', error);
        alert('Viga broneerimisel!');
    }
};
</script>

<template>
    <div class="paneel">
        <button class="tagasiNupp" @click="tagasi">← {{ keeled.tekst.tagasi }}</button>

        <div class="sisu">
            <h2>{{ keeled.tekst.broneerimisPaneel }}</h2>
            <p class="laud-info">{{ keeled.tekst.lauaNr }} <strong>{{ store.valitudLaud.lauaNumber }}</strong></p>

            <form class="broneerimisvorm" @submit.prevent="broneeri">
                <div class="vormiRida">
                    <label for="nimi"><b>{{ keeled.tekst.nimi }}</b></label>
                    <input id="nimi" type="text" v-model="nimi" required />
                </div>
                <div class="vormiRida">
                    <label for="email"><b>{{ keeled.tekst.email }}</b></label>
                    <input id="email" type="email" v-model="email" required />
                </div>
                <div class="vormiRida">
                    <label for="telefoninumber"><b>{{ keeled.tekst.telefoninumber }}</b></label>
                    <input id="telefoninumber" type="tel" v-model="telefoninumber" required />
                </div>
                <button type="submit" class="nupp broneeringuNupp">
                    {{ keeled.tekst.loplikBroneerimine }}
                </button>
            </form>
        </div>
    </div>
</template>

<style scoped>
.tagasiNupp {
    align-self: flex-start;
    background: none;
    border: none;
    color: #666;
    cursor: pointer;
    font-weight: bold;
    padding: 0;
    margin-bottom: 20px;
    transition: 200ms;
}

.tagasiNupp:hover {
    color: #333;
}

.sisu h2 {
    margin-top: 0;
    margin-bottom: 10px;
}

.laud-info {
    font-size: 1.1em;
    border-bottom: 1px solid #ddd;
    padding-bottom: 15px;
    margin-bottom: 20px;
}

.sisu {
    display: flex;
    flex-direction: column;
    flex: 1;
}

.broneerimisvorm {
    display: flex;
    flex-direction: column;
    gap: 16px;
    flex: 1;
}

.vormiRida {
    display: flex;
    flex-direction: column;
    gap: 6px;
}

.vormiRida label {
    font-size: 0.9em;
    color: #333;
}

.vormiRida input {
    padding: 5px;
    border: 1px solid #ddd;
    border-radius: 9px;
    font-size: 0.95em;
    font-family: inherit;
}

.vormiRida input:focus {
    outline: none;
    border-color: #000000;
    box-shadow: 0 0 4px rgba(12, 27, 13, 0.068);
}

.broneeringuNupp {
    background-color: #4CAF50;
    color: white;
    border: 1px solid #39923c;
    padding: 12px;
    border-radius: 8px;
    font-weight: bold;
    cursor: pointer;
    margin-top: auto;
    box-shadow: 1px 1.5px 2px rgba(0, 0, 0, 0.1), 1px 1.5px 3px rgba(0, 0, 0, 0.1);
    transition: 300ms;
}

.broneeringuNupp:hover {
    background-color: #45a049;
    transform: translateY(-2px);
}
</style>
