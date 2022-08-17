<template>
 <div class="BreweryDisplay">
    <div id="brewery-display">
        <header>
        <h1> {{this.$store.state.brewery.name}}</h1>
        </header>
<body>
      <div class="history">
        <h2> {{this.$store.state.brewery.history}} </h2>
      </div>  
        <h3> {{this.$store.state.brewery.street}}, {{this.$store.state.brewery.city}}, {{this.$store.state.brewery.state}} </h3>
        <h3> {{this.$store.state.brewery.openHours}}</h3>
        <h3> {{this.$store.state.brewery.phoneNumber}}</h3>
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
    justify-content: center;
    font-size: x-large;
    font-weight: bolder;
}
body {
    background-color: whitesmoke;
}

</style>