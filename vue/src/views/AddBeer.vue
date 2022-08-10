<template>
<body>
    <div>
        
        <add-new-beer />
    </div>
    </body>
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
    background-size: cover;
    background-position: center center;
    background-repeat: no-repeat;
}
</style>