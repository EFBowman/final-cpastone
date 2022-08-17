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
        </tr>
   </tbody>
  </table>

</div>
</template>

<script>
import BeerService from '../services/BeerService.js'

export default {
  name: 'list-beers',
   props:["beer"],
    methods: {
      saveBeer() {
        this.$store.commit("SET_CURRENT_BEER", this.beer);
        BeerService.getAllReviewsByBeerId(this.beer.beerId).then(
          (response) => {
            const reviews = response.data;
            this.$store.commit("SET_REVIEWS_DATA", reviews);
          }
        )
        this.$router.push({name: 'beer-reviews', params: {id: this.beer.beerId}});
        }
    }

}
</script>

<style>

</style>