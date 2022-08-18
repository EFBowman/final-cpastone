<template>
  <div class = "brewery-list-container">
    
    <table>
          <thead>
              <tr>
                  <th>Brewery Id</th>
                  <th>Brewer Id</th>
                  <th>Brewery name</th>
                  <th>Phone Number</th>
                  <th>URL</th>
                  <th>Street</th>
                  <th>City</th>
                  <th>State</th>
                  <th>History</th>
                  <th>Open Hours</th>
                  <th>Image</th>
                  <th>Brewery Type</th>
              </tr>
          </thead>
           <tbody>
              <tr v-for="brewery in $store.state.breweries" v-bind:key="brewery.breweryId">
                  <td>{{brewery.id}}</td>
                  <td>{{brewery.brewerId}}</td>
                  <td>{{brewery.name}}</td>
                  <td>{{brewery.phone}}</td>
                  <td>{{brewery.website_url}}</td>
                  <td>{{brewery.street}}</td>
                  <td>{{brewery.city}}</td>
                  <td>{{brewery.state}}</td>
                  <td>{{brewery.history}}</td>
                  <td>{{brewery.openHours}}</td>
                  <td>{{brewery.image}}</td>
                  <td>{{brewery.brewery_type}}</td>
              </tr>
          </tbody>
      </table>
      
  </div>
  
</template>

<script>

import BreweryService from '@/services/BreweryService.js'

export default {
  name: 'list-breweries',
 
  data() {
    return {
      breweries: [],
      errorMsg: ""
    }
     
  },
  created(){
    this.loadBreweries();
  },
  methods: {
    loadBreweries(){
      BreweryService.getAllBreweries().then(
        (response) => {
          const breweries = response.data;
          this.$store.commit("SET_STORE_DATA", breweries);


        })
        }   

  }

}
</script>

<style>
.brewery-list-container {
  background-color: white;
  opacity: 75%;
}
</style>