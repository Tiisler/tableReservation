<script setup>
import { useLaudadeStore } from '@/stores/laudadeStore';

const store = useLaudadeStore()

</script>

<template>
    <svg viewBox="0 0 750 600" preserveAspectRatio="xMidYMid meet">
        <g v-for="laud in store.lauad" :key="laud.id">
            <rect :x="laud.x" :y="laud.y" @click="store.laualeVajutus(laud)"
                :class="laud.onBroneeritud ? 'broneeritud' : 'saadaval'" />
            <text :x="laud.x + 20" :y="laud.y + 20" dy=".3em"
                :class="laud.onBroneeritud ? 'hiirBroneeritud' : 'hiirSaadaval'">
                {{ laud.lauaNumber }}
            </text>
        </g>
    </svg>
</template>

<style scoped>
rect {
    width: 40px;
    height: 40px;
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
    pointer-events: none;
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
</style>