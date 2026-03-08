// Hoiab kasutaja keelevalikut ja tõlkeid, et rakendus saaks kuvada tekste vastavalt valitud keelele

import { defineStore } from 'pinia';
import { ref, computed } from 'vue'

export const useKeelteStore = defineStore('keeleStore', () => {
    const keel = ref('ee')
    const tolked = {
        ee: {
            tervitus: 'Tere tulemast Restorani Italia!',
            kirjeldus: 'Broneerige laud meie hubases restoranis ja nautige autentset Itaalia kööki.',
            kuupaev: 'Kuupäev:',
            kellaaeg: 'Kellaaeg:',
            kylalisteArv: 'Külaliste arv:',
            kohaTyyp: 'Koha tüüp:',
            tavalineSaal: 'Tavaline saal',
            veranda: 'Veranda',
            privaatneRuum: 'Privaatne ruum',
            eelistused: 'Eelistused:',
            aknaAll: 'Akna all',
            vaikneNurk: 'Vaikne nurk',
            mangunurgaLahedal: 'Mängunurga lähedal',
            soovituseNupp: 'Vaata soovitust',
            broneeri: 'Broneeri',
            broneeringKinnitatud: 'edukalt broneeritud!',
            lauaNr: 'Laud nr',
            kohti: 'Kohti:',
            tagasi: 'Tagasi',
            plussid: 'Plussid:',
            miinused: 'Miinused:',
            poleAknaJuures: 'Pole akna juures',
            poleVaikses: 'Pole vaikses nurgas',
            poleMangunurgas: 'Pole mängunurga lähedal',
            mangunurk: 'Mängunurk',
            poleLauda: 'Valitud ajaks pole sellist lauda saadaval. Vabandame!',
            nimi: 'Nimi:',
            email: 'Email:',
            telefoninumber: 'Telefoninumber:',
            loplikBroneerimine: 'Broneeri laud',
            broneerimisPaneel: 'Broneeringu andmed'
        },
        en: {
            tervitus: 'Welcome to Restaurant Italia!',
            kirjeldus: 'Book a table in our cozy restaurant and enjoy authentic Italian cuisine.',
            kuupaev: 'Date:',
            kellaaeg: 'Time:',
            kylalisteArv: 'Number of guests:',
            kohaTyyp: 'Location type:',
            tavalineSaal: 'Main hall',
            veranda: 'Terrace',
            privaatneRuum: 'Private room',
            eelistused: 'Preferences:',
            aknaAll: 'By the window',
            vaikneNurk: 'Quiet corner',
            mangunurgaLahedal: 'Near the play area',
            broneeringKinnitatud: 'successfully booked!',
            soovituseNupp: 'See recommendation',
            broneeri: 'Book',
            lauaNr: 'Table nr',
            kohti: 'Seats:',
            tagasi: 'Back',
            plussid: 'Pros:',
            miinused: 'Cons:',
            poleAknaJuures: 'Not by the window',
            poleVaikses: 'Not in a quiet corner',
            poleMangunurgas: 'Not near the play area',
            mangunurk: 'Play area',
            poleLauda: 'No such tables available for the selected time. We apologize!',
            nimi: 'Name:',
            email: 'Email:',
            telefoninumber: 'Phone number:',
            loplikBroneerimine: 'Book table',
            broneerimisPaneel: 'Booking details'
        
        }
    }

    const tekst = computed(() => tolked[keel.value])

    return { keel, tekst }
})

