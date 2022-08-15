<template>
  <div class="home">
    <h1>Home</h1> &nbsp;
    <router-link :to="{ name: 'add-brewery' }">Add A New Brewery</router-link>
    <router-link :to="{ name: 'add-beer' }">Add A Beer</router-link>
    <router-link :to="{ name: 'update-brewery'}">Update A Brewery</router-link> <!-- make only for brewers -->
    <select class="state-selection" v-model="searchParams.state" v-on:click="saveSearchParams, searchForBreweries">
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

    <input class="city-selection" v-model="searchParams.city" type="text" v-on:change="saveSearchParams" />

    <select class="type-selection" v-model="searchParams.breweryType" v-on:click="saveSearchParams">
      <option disabled value="">Please select a brewery type</option>
      <option value ="micro">micro</option>
      <option value ="nano">nano</option>
      <option value ="regional">regional</option>
      <option value="brewpub">brewpub></option>
      <option value ="large">large</option>
      <option value ="planning">planning</option>
      <option value ="bar">bar</option>
      <option value ="contract">contract</option>
      <option value ="proprietor">proprietor</option>
    </select>
    <button type="submit" v-on:submit.prevent="searchForBreweries, clearSearchParams"> Submit </button>
    <div class="brewery-list">
      <brewery-list />
    </div>
  </div>
</template>

<script>
import BreweryList from '../components/BreweryList.vue';
import breweryService from "@/services/BreweryService.js";

export default {
  components: { BreweryList },
  name: "home",
  data() {
    return {
      searchParams: {
        state: "",
        city: "",
        breweryType: ""
      }
    }
  },
  methods: {
    saveSearchParams() {
      this.$store.commit("SAVE_SEARCH_PARAMS", this.searchParams);
    },
    searchForBreweries() {
      breweryService.getAllBreweries();
    },
    clearSearchParams() {
      this.searchParams = {};
    }
  }
};
</script>
