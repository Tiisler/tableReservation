<script setup>
import { useLaudadeStore } from '@/stores/laudadeStore';

const store = useLaudadeStore()

</script>

<template>
    <svg viewBox="0 0 750 600" preserveAspectRatio="xMidYMid meet">
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
    rx:8;
    ry:8;
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

rect.valitd+text {
    fill:black;
}

.soovitus {
    stroke: green;
    animation: pulseeriSoovitus 2s infinite ease-in-out;
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
</style>