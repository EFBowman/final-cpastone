<template>
  <div class="BreweryContainer">
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
    props:["brewery"]

}
</script>

<style>

</style>