<template>
<div>
<div class ="search-table">
<select class="state-selection" v-model="searchParams.state">
      <option disabled value="">Please select a state</option>
      <option value="Alabama">Alabama</option>	
      <option value="Alaska">Alaska</option>	<option value="Arizona">Arizona</option>	<option value="Arkansas">Arkansas</option>	<option value="California">California</option>	<option value="Colorado">Colorado</option>
      <option value="Connecticut">Connecticut</option>	<option value="Delaware">Delaware</option>	<option value="District of Columbia">District of Columbia</option>	<option value="Florida">Florida</option>	<option value="Georgia">Georgia</option>
      <option value="Hawaii">Hawaii</option>	<option value="Idaho">Idaho</option>	<option value="Illinois">Illinois</option>	<option value="Indiana">Indiana</option>	<option value="Iowa">Iowa</option>
      <option value="Kansas">Kansas</option>	<option value="Kentucky">Kentucky</option>	<option value="Louisiana">Louisiana</option>	<option value="Maine">Maine</option>	<option value="Maryland">Maryland</option>
      <option value="Massachusetts">Massachusetts</option>	<option value="Michigan">Michigan</option>	<option value="Minnesota">Minnesota</option>	<option value="Mississippi">Mississippi</option>	<option value="Missouri">Missouri</option>
      <option value="Montana">Montana</option>	<option value="Nebraska">Nebraska</option>	<option value="Nevada">Nevada</option>	<option value="New Hampshire">New Hampshire</option>	<option value="New Jersey">New Jersey</option>
      <option value="New Mexico">New Mexico</option>	<option value="New York">New York</option>	<option value="North Carolina">North Carolina</option>	<option value="North Dakota">North Dakota</option>
      <option value="Ohio">Ohio</option>	<option value="Oklahoma">Oklahoma</option>	<option value="Oregon">Oregon</option>	<option value="Pennsylvania">Pennsylvania</option>	<option value="Rhode Island">Rhode Island</option>
      <option value="South Carolina">South Carolina</option>	<option value="South Dakota">South Dakota</option>	<option value="Tennessee">Tennessee</option>	<option value="Texas">Texas</option>	<option value="Utah">Utah</option>
      <option value="Vermont">Vermont</option>	<option value="Virginia">Virginia</option>	<option value="Washington">Washington</option>	<option value="West Virginia">West Virginia</option>	<option value="Wisconsin">Wisconsin</option>	<option value="Wyoming">Wyoming</option>
    </select>

    <input class="city-selection" v-model="searchParams.city" placeholder = "Search by city" type="text" />

    <select class="type-selection" v-model="searchParams.brewery_type">
      <option disabled value="">Search by brewery type</option>
      <option value ="micro">Microbrewery</option>
      <option value ="nano">Nanobrewery</option>
      <option value ="regional">Regional</option>
      <option value="brewpub">Brewpub</option>
      <option value ="large">Large</option>
      <option value ="planning">Planning</option>
      <option value ="bar">Bar</option>
      <option value ="contract">Contract</option>
      <option value ="proprietor">Proprietor</option>
    </select>
    <button v-on:click="searchForBreweries"> Submit </button>
    </div>
    <div class = "brewery-cards" v-if="this.hasSearched">
      <brewery-card v-for="brewery in $store.state.breweries" v-bind:key="brewery.breweryId"
    v-bind:brewery="brewery"></brewery-card>
      </div>
      </div>
</template>

<script>
import BreweryService from "@/services/BreweryService"
import BreweryCard from '@/components/BreweryCard.vue'
export default {
  name:'search-bar',
   components: {
      BreweryCard
  },
   data() {
    return {
      hasSearched: false,
      searchParams: {
        state: "",
        city: "",
        brewery_type: ""
      }
    }
  },
  methods: {
    saveSearchParams() {
      this.$store.commit("SAVE_SEARCH_PARAMS", this.searchParams);
    },
    searchForBreweries() {
    
      this.saveSearchParams();

      BreweryService.getBreweriesBySearch(this.searchParams).then (
        response => {
          const searchList = response.data
          this.$store.commit("SET_STORE_DATA", searchList);
          this.clearSearchParams();
            this.hasSearched = true;
        }
      );
      

     

    },
     loadBreweriesByState(){
          BreweryService.getBreweriesBySearch(this.searchParams);
     },


    clearSearchParams() {
      this.searchParams = {};
    }
  }
  
}
</script>

<style scoped>

</style>