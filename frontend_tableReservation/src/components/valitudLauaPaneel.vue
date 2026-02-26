<script setup>
import { computed } from 'vue';
import { useLaudadeStore } from '@/stores/laudadeStore';

const store = useLaudadeStore();

const tagasi = () => {
    store.valitudLaud = null;
};

const broneeri = () => {
    alert(`Laud nr ${store.valitudLaud.lauaNumber} on edukalt broneeritud!`);
    store.valitudLaud = null;
};

const plussidJaMiinused = computed(() => {
    const laud = store.valitudLaud;
    const eelmised = store.viimasedEelistused;
    
    if (!laud || !eelmised) return { plussid: [], miinused: [] };

    const plussid = [];
    const miinused = [];

    if (eelmised.aknaAll) {
        laud.aknaJuures ? plussid.push("Akna all") : miinused.push("Ei ole akna all");
    }
    if (eelmised.vaikneNurk) {
        laud.vaiksesNurgas ? plussid.push("Vaikne nurk") : miinused.push("Ei ole vaikses nurgas");
    }
    if (eelmised.manguNurk) {
        laud.manguNurgas ? plussid.push("Mängunurga lähedal") : miinused.push("Kaugemal mängunurgast");
    }

    return { plussid, miinused };
});
</script>

<template>
    <div class="paneel info-paneel">
        <button class="tagasi-nupp" @click="tagasi">← Tagasi</button>
        
        <div class="sisu">
            <h2>Laud nr {{ store.valitudLaud.lauaNumber }}</h2>
            <p class="kohti">Kohti: <strong>{{ store.valitudLaud.kohtadeArv }}</strong></p>
            
            <div v-if="plussidJaMiinused.plussid.length > 0" class="listi-grupp">
                <h4>Plussid:</h4>
                <ul>
                    <li v-for="p in plussidJaMiinused.plussid" :key="p" class="pluss">{{ p }}</li>
                </ul>
            </div>

            <div v-if="plussidJaMiinused.miinused.length > 0" class="listi-grupp">
                <h4>Miinused:</h4>
                <ul>
                    <li v-for="m in plussidJaMiinused.miinused" :key="m" class="miinus">{{ m }}</li>
                </ul>
            </div>
        </div>

        <button class="nupp broneeri-nupp" @click="broneeri">Broneeri</button>
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
    border: none;
    padding: 12px;
    border-radius: 8px;
    font-weight: bold;
    cursor: pointer;
    margin-top: auto;
}
</style>