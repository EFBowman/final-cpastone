<template>
  <div class="home">
    <h1>Home</h1> &nbsp;
    <router-link :to="{ name: 'add-brewery' }">Add A New Brewery</router-link>
    <router-link :to="{ name: 'add-beer' }">Add A Beer</router-link>
    <div class="brewery-list">
      <brewery-list />
    </div>
  </div>
</template>

<script>
import BreweryList from '../components/BreweryList.vue';

export default {
  components: { BreweryList },
  name: "home"
};
</script>
