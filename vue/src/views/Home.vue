<template>
  <div class="home">
    <h1 class="home-header">home</h1> &nbsp;
    <router-link :to="{ name: 'add-brewery' }"  v-if="isAdmin" >Add A New Brewery</router-link>
    <!-- <router-link :to="{ name: 'add-beer' }">Add A Beer</router-link> -->
     <div class="search-breweries">
      <search-breweries v-if="!isAdmin"/>
      </div>
    <div class="brewery-list" v-if="isAdmin" >
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
  data() {
    return {
      isAdmin: this.$store.state.user && this.$store.state.user.authorities[0].name === 'ROLE_ADMIN'
    }
  }
  
};
</script>
<style>
.home-header{
  justify-content: center;
  margin-bottom:3%;

}
</style>
