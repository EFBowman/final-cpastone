<template>
 <div class="BreweryDisplay">
    <div id="brewery-display">
        <header>
        <h1> {{this.$store.brewery.name}}</h1>
        </header>
<body>
      <div class="history">
        <h2> {{this.$store.brewery.history}} </h2>
      </div>  
        <h3> {{this.$store.brewery.street}}, {{this.$store.brewery.city}}, {{this.$store.brewery.state}} </h3>
        <h3> {{brewery.openHours}}</h3>
        <h3> {{this.$store.brewery.phoneNumber}}</h3>
</body>
        </div>
        </div>
</template>

<script>
export default {
    name: "brewery-display"
}
</script>

<style>
.BreweryDisplay {
    display: flex;
}
header {
    display: flex;
    background-color: goldenrod;
    justify-content: center;
    font-size: x-large;
    font-weight: bolder;
    color: black;
}
body {
    background-color: whitesmoke;
}

</style>