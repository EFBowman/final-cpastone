<template>
<div class = "beerListContainer">

    <table>
    <tbody>
      <tr v-for="beer in this.$store.state.beers" v-bind:key="beer.beerId" >
        <div>
        <td>{{ beer.beerName }}</td>
        <td>{{ beer.beerDescription }}</td>
        <td>{{ beer.abv }}</td>
        <td>{{ beer.beerType }}</td>
        </div>
        <button v-on:click="saveBeer(beer)"> See Our Reviewery </button>
        </tr>
   </tbody>
  </table>

</div>
</template>

<script>
import BeerService from '../services/BeerService.js'

export default {
  name: 'list-beers',
    methods: {
      saveBeer(beer) {
        this.$store.commit("SET_CURRENT_BEER", beer);
        BeerService.getAllReviewsByBeerId(beer.beerId).then(
          (response) => {
            const reviews = response.data;
            this.$store.commit("SET_REVIEWS_DATA", reviews);
          }
        )
        this.$router.push({name: 'beer-reviews', params: {id: beer.beerId}});
        }
    }

}
</script>

<style>

</style>