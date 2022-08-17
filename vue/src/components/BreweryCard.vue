<template>
  <div class="BreweryContainer" v-on:click="saveBrewery()">
      <div id="brewery-info">
        <h2> {{brewery.name}}</h2>
    
        <h3> {{brewery.street}} {{brewery.city}}, {{brewery.state}} </h3>
        <h3> {{brewery.openHours}}</h3>
        <a href = "brewery.url" />
            
        </div>
        </div>
</template>

<script>
import BeerService from '../services/BeerService.js'

export default {
    name: "brewery-card",
    props:["brewery"],
    methods: {
      saveBrewery() {
        this.$store.commit("SET_CURRENT_BREWERY", this.brewery);
        BeerService.getBeersByBreweryId(this.brewery.id).then(
          (response) => {
            const beers = response.data;
            this.$store.commit("SET_BEER_DATA", beers);
          }
        )
        this.$router.push({name: 'brewery', params: {id: this.brewery.id}});
        }
    }

}


</script>

<style>


</style>