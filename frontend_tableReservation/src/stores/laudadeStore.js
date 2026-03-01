import { defineStore } from 'pinia'
import { ref } from 'vue'
import { useKeelteStore } from './keelteStore';

export const useLaudadeStore = defineStore('laudadeStore', () => {
    const lauad = ref([])
    const viimaneAeg = ref("");
    const valitudLaud = ref(null)
    const soovitatudLaud = ref(null)
    const valitudLauaMiinused = ref([])
    const valitudLauaPlussid = ref([])
    const viimasedEelistused = ref({
        kuupaev: new Date().toISOString().split('T')[0],
        kellaaeg: `${String(new Date().getHours()).padStart(2, '0')}:00`,
        asukoht: 'saal',
        inimesteArv: 1,
        aknaAll: false,
        vaikneNurk: false,
        manguNurk: false
    });


    const laualeVajutus = (laud) => {
        if (!laud.onBroneeritud) {
            valitudLaud.value = laud
        }
    };

    const algseis = async (algKuupaev, algKell) => {

        const aeg = `${algKuupaev} ${algKell}`;
        viimaneAeg.value = aeg;
        await laadiLauad(algKuupaev, algKell);
    }

    const laadiLauad = async (kuupaev, kellaaeg) => {
        const url = `http://localhost:8080/api/lauad?kuupaev=${kuupaev}&kellaaeg=${kellaaeg}`;
        const response = await fetch(url);
        const andmed = await response.json();
        lauad.value = andmed;
    }


    const saadaEelistused = async (eelistused) => {
        const keeled = useKeelteStore();
        viimasedEelistused.value = eelistused;
        try {
            const response = await fetch(`http://localhost:8080/api/lauad/soovitus`, {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(eelistused)
            });

            let soovitus = null;
            const text = await response.text();
            if (text) {
                soovitus = JSON.parse(text);
            }
            if (soovitus===null) {
                alert(keeled.tekst.poleLauda);
            }
            soovitatudLaud.value = soovitus;
            valitudLaud.value = soovitus;

            await laadiLauad(eelistused.kuupaev, eelistused.kellaaeg);
        } catch (error) {
            console.error("Viga:", error);
        }
    }

    return {
        lauad,
        valitudLaud,
        valitudLauaMiinused,
        valitudLauaPlussid,
        soovitatudLaud,
        viimasedEelistused,
        laadiLauad,
        laualeVajutus,
        saadaEelistused,
        algseis,
    }
})