<template>
<body>
  <div>
      <add-new-brewery />
  </div>
</body>
</template>

<script>
import AddNewBrewery from '../components/AddNewBrewery.vue';
export default {
  components: {
      AddNewBrewery
  }
}
</script>

<style scoped>

body {
    background-image: url(../../public/img/brewery.png);
    height: 100vh;
    width: 100vw;
    background-repeat: no-repeat;
}

</style>