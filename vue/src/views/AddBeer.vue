<template>
    <div>
        <h1>Add Beer</h1>
        <add-new-beer></add-new-beer>
    </div>
</template>

<script>
import AddNewBeer from '../components/AddNewBeer.vue'

export default {
    components: {
        AddNewBeer
    }
}
</script>

<style scoped>

body {
    background-image: url(../../public/img/beerFlight.jpg);
    height: 100vh;
    width: 100vw;
    background-repeat: no-repeat;
}
</style>