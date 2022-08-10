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
    background-size: cover;
    background-position: center center;
    background-repeat: no-repeat;
}

</style>