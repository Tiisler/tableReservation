import { defineStore } from 'pinia'
import { ref } from 'vue'

export const useLaudadeStore = defineStore('laudadeStore', () => {
    const lauad = ref([])
    const viimaneAeg = ref("");
    const valitudLaud = ref(null)
    const soovitatudLaud = ref(null)
    const valitudLauaMiinused = ref([])
    const valitudLauaPlussid = ref([])

    const laadiLauad = async () => {
        const response = await fetch('http://localhost:8080/api/lauad')
        lauad.value = await response.json()
    }

    const laualeVajutus = (laud) => {
        if (!laud.onBroneeritud) {
            valitudLaud.value = laud
        }
    };

    const algseis = async (algKuupaev, algKell) => {
        const aeg = `${algKuupaev} ${algKell}`;
        viimaneAeg.value = aeg;
        const response = await fetch('http://localhost:8080/api/lauad/genereeri-algseis');
        lauad.value = await response.json();
    }

    const saadaEelistused = async (eelistused) => {
        const praeguneAeg = `${eelistused.kuupaev} ${eelistused.kellaaeg}`;
        const aegMuutus = praeguneAeg !== viimaneAeg.value;
        try {
            const response = await fetch('http://localhost:8080/api/lauad/soovitus', {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify({ ...eelistused, uuendaBroneeringuid: aegMuutus })
            });
            const soovitus = await response.json();
            soovitatudLaud.value = soovitus;
            valitudLaud.value = soovitus;
            viimaneAeg.value = praeguneAeg;
            await laadiLauad();
        } catch (error) {
            console.error("Viga soovituse leidmisel:", error);
        }
    }

    return {
        lauad,
        valitudLaud,
        valitudLauaMiinused,
        valitudLauaPlussid,
        soovitatudLaud,
        laadiLauad,
        laualeVajutus,
        saadaEelistused,
        algseis,
    }
})