import { defineStore } from 'pinia'
import { ref } from 'vue'

export const useLaudadeStore = defineStore('laudadeStore', () => {
    const lauad = ref([])
    const valitudLaud = ref(null)
    const valitudLauaMiinused = ref([])
    const valitudLauaPlussid = ref([])

    const laadiLauad = async () => {
        const response = await fetch('http://localhost:8080/api/lauad')
        lauad.value = await response.json()
    }

    const laualeVajutus = (laud) => {
        if (!laud.onBroneeritud) {
            valitudLaud.value = laud
            muudaValitudMiinusedJaPlussid
        }
    };

    const muudaValitudMiinusedJaPlussid = () => {
        valitudLauaMiinused.value = []
        valitudLauaPlussid.value = []
    };

    const saadaEelistused = async (eelistused) => {
        try {
            const response = await fetch('http://localhost:8080/api/lauad/soovitus', {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(eelistused)
            });
            const soovitus = await response.json();
            valitudLaud.value = soovitus;
        } catch (error) {
            console.error("Viga soovituse leidmisel:", error);
        }
    }

    return {
        lauad,
        valitudLaud,
        valitudLauaMiinused,
        valitudLauaPlussid,
        laadiLauad,
        laualeVajutus,
        saadaEelistused,
    }
})