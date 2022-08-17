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

export default {
    name: "brewery-card",
    props:["brewery"],
    methods: {
      saveBrewery() {
        this.$store.commit("SET_CURRENT_BREWERY", this.brewery);
        alert(this.brewery.id);
        this.$router.push({name: 'brewery', params: {id: this.brewery.id}});
        }
    }

}


</script>

<style>


</style>