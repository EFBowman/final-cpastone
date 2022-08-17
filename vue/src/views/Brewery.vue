<template>
<div class= "BreweryPage">
  <brewery-display />
  <beer-list />
</div>
</template>

<script>
import BeerList from '../components/BeerList.vue'
import BreweryDisplay from '../components/BreweryDisplay.vue'
export default {
  components: {BreweryDisplay, BeerList }

}
</script>

<style>

</style>