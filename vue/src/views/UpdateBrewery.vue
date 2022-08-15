<template>
<body>
  <div>
      <update-brewery v-bind:existingBrewery="breweryToEdit" />
  </div>
</body>
</template>

<script>
import BreweryService from '../services/BreweryService.js'
import UpdateBrewery from '../components/UpdateBrewery.vue'

export default {
  components: {
    UpdateBrewery
  },
  data() {
        return {
            breweryToEdit: {}
        }
    },
    created() {
        if(this.$route.params.breweryId) {
            BreweryService.get(this.$route.params.breweryId).then(
                response => {
                    this.breweryToEdit = response.data;
                }
            );
        } else {
            this.isReady = true;
        }
    }
}
</script>

<style scoped>

body {
    background-image: url(../../public/img/brewery.png);
    background-size: cover;
    background-position: center center;
    background-repeat: no-repeat;
}

</style>