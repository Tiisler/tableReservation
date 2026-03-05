<script setup>
import { computed } from 'vue';
import { useLaudadeStore } from '@/stores/laudadeStore';
import { useKeelteStore } from '@/stores/keelteStore';

const store = useLaudadeStore();
const keeled = useKeelteStore();

const tagasi = () => {
    store.valitudLaud = null;
};

const broneeri = () => {
    store.broneerimisPaneel = true;
};

const plussidJaMiinused = computed(() => {
    const laud = store.valitudLaud;
    const eelmised = store.viimasedEelistused;
    
    if (!laud || !eelmised) return { plussid: [], miinused: [] };

    const plussid = [];
    const miinused = [];

    if (eelmised.aknaAll) {
        laud.aknaJuures ? plussid.push(keeled.tekst.aknaAll) : miinused.push(keeled.tekst.poleAknaJuures);
    }
    if (eelmised.vaikneNurk) {
        laud.vaiksesNurgas ? plussid.push(keeled.tekst.vaikneNurk) : miinused.push(keeled.tekst.poleVaikses);
    }
    if (eelmised.manguNurk) {
        laud.manguNurgas ? plussid.push(keeled.tekst.mangunurgaLahedal) : miinused.push(keeled.tekst.poleMangunurgas);
    }

    return { plussid, miinused };
});
</script>

<template>
    <div class="paneel info-paneel">
        <button class="tagasi-nupp" @click="tagasi">← {{ keeled.tekst.tagasi }}</button>
        
        <div class="sisu">
            <h2> {{ keeled.tekst.lauaNr }} {{ store.valitudLaud.lauaNumber }}</h2>
            <p class="kohti">{{ keeled.tekst.kohti }} <strong>{{ store.valitudLaud.kohtadeArv }}</strong></p>
            
            <div v-if="plussidJaMiinused.plussid.length > 0" class="listi-grupp">
                <h4>{{ keeled.tekst.plussid }}</h4>
                <ul>
                    <li v-for="p in plussidJaMiinused.plussid" :key="p" class="pluss">{{ p }}</li>
                </ul>
            </div>

            <div v-if="plussidJaMiinused.miinused.length > 0" class="listi-grupp">
                <h4>{{ keeled.tekst.miinused }}</h4>
                <ul>
                    <li v-for="m in plussidJaMiinused.miinused" :key="m" class="miinus">{{ m }}</li>
                </ul>
            </div>
        </div>

        <button class="nupp broneeri-nupp" @click="broneeri">{{ keeled.tekst.broneeri }}</button>
    </div>
</template>

<style scoped>

.tagasi-nupp {
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

.tagasi-nupp:hover {
    color: #333;
}

.sisu h2 { 
    margin-top: 0; 
}

.kohti { 
    font-size: 1.1em; 
    border-bottom: 1px solid #ddd; 
    padding-bottom: 10px; 
}

.listi-grupp h4 { 
    margin-bottom: 5px; 
    font-size: 0.9em; 
    color: #555; 
}

ul { 
    list-style: none; 
    padding: 0; 
    margin: 0 0 15px 0; 
}

li { 
    padding: 4px 0; 
    font-size: 0.95em; 
}

.pluss { 
    color: green; 
}
.pluss::before { 
    content: "✓ "; 
}
.miinus { 
    color: #cc0000; 
}
.miinus::before { 
    content: "✕ "; 
}

.broneeri-nupp {
    background-color: #4CAF50;
    color: white;
    border: 1px solid #39923c;
    padding: 12px;
    border-radius: 8px;
    font-weight: bold;
    cursor: pointer;
    margin-top: auto;
    box-shadow: 1px 1.5px 2px rgba(0, 0, 0, 0.1), 1px 1.5px 3px rgba(0, 0, 0, 0.1);
    transition: 0.3s;
}

.broneeri-nupp:hover {
    background-color: #45a049;
    transform: translateY(-2px);
}

</style>