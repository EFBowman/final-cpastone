<template>
<div class = "beerListContainer">

    <table>
    <tbody>
      <tr v-for="beer in this.$store.state.beers" v-bind:key="beer.id">
        <td>{{ beer.beerName }}</td>
        <td>{{ beer.beerDescription }}</td>
        <td>{{ beer.abv }}</td>
        <td>{{ beer.beerType }}</td>
        </tr>
   </tbody>
  </table>

</div>
</template>

<script>

export default {
  name: 'list-beers',

}
</script>

<style>

</style>