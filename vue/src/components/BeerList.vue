<template>
<div class = "beerListContainer">

    <table>
    <tbody>
      <tr v-for="beer in beers" v-bind:key="beer.breweryId">
        <td>{{ beer.name }}</td>
        <td>{{ beer.abv }}</td>
        <td>{{ beer.beerType }}</td>
        </tr>
   </tbody>
  </table>

</div>
</template>

<script>
import BeerService from '@/services/BeerService.js'

export default {
  name: 'list-beers',
 
  data() {
    return {
      beers: [],
      errorMsg: ""
    }
     
  },
  created(){
    this.loadBeers();
  },
  methods: {
    loadBeers(){
      BeerService.getBeersByBreweryId().then(
        (response) => {
          const beers = response.data;
          this.$store.commit("SET_BEER_DATA", beers);


        })
        }   

  }

}
</script>

<style>

</style>