<!-- Saaliplaani kuvamise ning laudade valimise paneel -->

<script setup>
import { useLaudadeStore } from '@/stores/laudadeStore';
import { useKeelteStore } from '@/stores/keelteStore';

const store = useLaudadeStore()
const keeled = useKeelteStore()

</script>


<template>
    <svg viewBox="0 0 750 600" preserveAspectRatio="xMidYMid meet">
        <text x="625" y="30" class="tsooniSilt">{{ keeled.tekst.veranda }}</text>
        <text x="625" y="330" class="tsooniSilt">{{ keeled.tekst.privaatneRuum }}</text>
        <text x="75" y="575" class="mangunurk">{{ keeled.tekst.mangunurk }}</text>

        <line x1="0" y1="120" x2="0" y2="500" class="aken" />
        <line x1="750" y1="320" x2="750" y2="570" class="aken" />

        <line x1="500" y1="300" x2="750" y2="300" class="sein" />
        <line x1="500" y1="0" x2="500" y2="600" class="sein" />
        <line x1="166" y1="0" x2="166" y2="100" class="sein" />
        <line x1="332" y1="0" x2="332" y2="100" class="sein" />

        <g v-for="laud in store.lauad" :key="laud.id">
            <rect :x="laud.x" :y="laud.y" @click="store.laualeVajutus(laud)" :class="{
                'broneeritud': laud.onBroneeritud,
                'saadaval': !laud.onBroneeritud,
                'soovitus': store.soovitatudLaud?.id === laud.id,
                'valitud': store.valitudLaud?.id === laud.id
            }" />
            <text :x="laud.x + 20" :y="laud.y + 20" dy=".3em" :class="{
                'hiirBroneeritud': laud.onBroneeritud,
                'hiirSaadaval': !laud.onBroneeritud,
            }">
                {{ laud.lauaNumber }}
            </text>
        </g>
    </svg>
</template>

<style scoped>
rect {
    width: 40px;
    height: 40px;
    rx: 8;
    ry: 8;
    filter: drop-shadow(1.5px 1.5px 1px rgb(24, 23, 23));
}

text {
    text-anchor: middle;
    fill: white;
    font-size: 12;
    cursor: default;
    font-weight: 400;
    pointer-events: none;
}

svg {
    width: 100%;
    max-width: 600px;
    height: auto;
    display: block;
    border: 1px solid black;
    border-radius: 10px;
    background-color: #f7f7f7;
    box-shadow: 2px 2px 2px rgba(0, 0, 0, 0.1), 2px 4px 4px rgba(0, 0, 0, 0.1);
}

.broneeritud {
    fill: rgb(26, 25, 25);
    cursor: not-allowed;
}

.hiirBroneeritud {
    cursor: not-allowed;
}

.saadaval {
    fill: rgb(162, 163, 162);
    cursor: pointer;
}


.hiirSaadaval {
    cursor: pointer;
}

.valitud {
    fill: #93aec4;
    stroke: #516692;
    stroke-width: 2px;
    transform: scale(1.1);
    transform-origin: center;
    transform-box: fill-box;
    transition: all 0.3s cubic-bezier(0.175, 0.885, 0.32, 1.275);
}

.valitud+text {
    font-weight: bold;
}

.soovitus {
    stroke: green;
    animation: pulseeriSoovitus 2s infinite ease-in-out;
}

rect.valitud.soovitus {
    fill: rgb(98, 158, 98);
}

@keyframes pulseeriSoovitus {
    0% {
        filter: drop-shadow(0 0 2px green);
    }

    50% {
        filter: drop-shadow(0 0 3px green);
    }

    100% {
        filter: drop-shadow(0 0 2px green);
    }
}


.tsooniSilt {
    fill: #9ca3af;
    font-size: 15px;
    font-weight: bold;
    letter-spacing: 2px;
    pointer-events: none;
    text-anchor: middle;
}

.sein {
    stroke: black;
    stroke-width: 1;
}

.aken {
    stroke: #7bb2cf;
    stroke-width: 4;
    stroke-linecap: round;
}


.mangunurk {
    font-size: 15px;
    letter-spacing: 2px;
    fill: #00983da6;;
    text-anchor: middle;
    font-weight: bold;
}
</style>