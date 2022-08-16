<template>
  <div class="BreweryContainer">
      <div id="brewery-info">
            
         <router-link v-on:click="saveBrewery" v-bind:to="{name: 'brewery', params: {id: brewery.brewery_id}}">More Information</router-link>
        <h2> {{brewery.name}}</h2>
    
        <h3> {{brewery.street}} {{brewery.city}}, {{brewery.state}} </h3>
        <h3> {{brewery.openHours}}</h3>
        <a href = "brewery.url" />
            
        </div>
        </div>
</template>

<script>

export default {
    name: "brewery-card",
    props:["brewery"],
    methods: {
      saveBrewery() {
        this.$store.commit("SET_CURRENT_BREWERY", this.brewery).then(
          () => this.$router.push({name: "brewery"})
        )}
    }

}


</script>

<style>


</style>