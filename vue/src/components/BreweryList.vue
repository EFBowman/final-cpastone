<template>
  <div class = "breweryListContainer">
    <brewery-card v-for="brewery in $store.state.breweries" v-bind:key="brewery.breweryId"
    v-bind:card="brewery"></brewery-card>
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
                  <td>{{brewery.breweryId}}</td>
                  <td>{{brewery.brewerId}}</td>
                  <td>{{brewery.name}}</td>
                  <td>{{brewery.phoneNumber}}</td>
                  <td>{{brewery.url}}</td>
                  <td>{{brewery.street}}</td>
                  <td>{{brewery.city}}</td>
                  <td>{{brewery.state}}</td>
                  <td>{{brewery.history}}</td>
                  <td>{{brewery.openHours}}</td>
                  <td>{{brewery.image}}</td>
                  <td>{{brewery.breweryType}}</td>
                  <td>
                      <router-link v-bind:to="{name: 'Edit', params: {breweryId: brewery.breweryId}}">Edit</router-link>
                      &nbsp; &nbsp;
                  </td>
              </tr>
          </tbody>
      </table>
      
  </div>
  
</template>

<script>
import BreweryCard from '@/components/BreweryCard.vue'
import BreweryService from '@/services/BreweryService.js'

export default {
  name: 'list-breweries',
  components: {
      BreweryCard
  },
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


      )
      
    }
  }

}
</script>

<style>

</style>