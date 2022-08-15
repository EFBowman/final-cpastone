<template>
  <div class="home">
    <h1>Home</h1> &nbsp;
    <router-link :to="{ name: 'add-brewery' }">Add A New Brewery</router-link>
    <router-link :to="{ name: 'add-beer' }">Add A Beer</router-link>
     <div class="search-breweries">
      <search-breweries />
      </div>
    <div class="brewery-list">
      <brewery-list />
    </div>
   
  </div>
</template>

<script>
// only visible to administrators
import BreweryList from '../components/BreweryList.vue';
import searchBreweries from "@/components/searchBreweries.vue"; 

export default {
  components: { BreweryList, searchBreweries },
  name: "home",
 
};
</script>
