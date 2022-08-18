<template>
<div class = "beerListContainer">

    <table>
    <tbody class="beer-info">
      <tr class="beer-card" v-for="beer in this.$store.state.beers" v-bind:key="beer.beerId" >
        <div>
        <td>Name: {{ beer.beerName }}</td>
        <td>Description: {{ beer.beerDescription }}</td>
        <td>ABV: {{ beer.abv }}</td>
        <td>Style: {{ beer.beerType }}</td>
        </div>
        <button v-on:click="saveBeer(beer)"> See Reviews </button>
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

.beer-card {
   display: flex;
  border-radius: 5px;
  background-color: whitesmoke;
  flex-direction: row;
  justify-content: space-around;
  align-items:center;
  height:150px;
  width:350px;
  padding:10px;
  outline: none !important;
  border: 3px solid goldenrod;
  border-radius: 5px;
  font-family: Bebas Neue;
}

.beer-info{
  flex-direction: row;
  display:flex;
  flex-wrap: wrap;
  gap:10px;
}


</style>