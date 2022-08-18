<template>
    <div id="brewery-display">
        <h1 class="brewery-header"> {{this.$store.state.brewery.name}}</h1>

      <div class="history">
        <h2> {{this.$store.state.brewery.history}} </h2>
      </div>  
      <div class="brewery-info">
        <p>Address: {{this.$store.state.brewery.street}}, {{this.$store.state.brewery.city}}, {{this.$store.state.brewery.state}} </p>
        <p>Open Hours: {{this.$store.state.brewery.openHours}}</p>
        <p>Phone Number: {{this.$store.state.brewery.phone}}</p>
      </div>
    </div>
</template>

<script>
export default {
    name: "brewery-display"
}
</script>

<style scoped>
#brewery-display {
    display: flex;
}
.brewery-header {
    display: flex;
    justify-content: center;
    font-size: 75px;
    font-weight: bolder;
    border-bottom: 5px solid goldenrod;
    margin-bottom: 0px;
}
body {
    background-color:  #3d3d3d;
}
.brewery-info {
 display: flex;
 flex-wrap: wrap;
 flex-direction: row;
 justify-content: space-evenly;
 align-items: center;
 color: goldenrod;
 font-family: Bebas Neue;
 font-size: 15px;
 margin-bottom:5px;
}


</style>