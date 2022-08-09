<template>
  <div>
      <form v-on:submit.prevent="saveBrewery">
          <div>
           <label> Brewer ID : </label>
           <input type="number" v-model="brewery.brewerId" />   
         </div>

         <div>
           <label> Brewery Name : </label>
           <input type="text" v-model="brewery.name" />   
         </div>

          <div>
           <label> Phone Number : </label>
           <input type="text" v-model="brewery.phoneNumber" />   
         </div>

          <div>
           <label> Email Address : </label>
           <input type="text" v-model="brewery.emailAddress" />   
         </div>

          <div>
           <label> Address : </label>
           <input type="text" v-model="brewery.address" />   
         </div>

          <div>
           <label> History : </label>
           <input type="text" v-model="brewery.history" />   
         </div>

          <div>
           <label> Open Hours: </label>
           <input type="text" v-model="brewery.openHours" />   
         </div>

          <div>
           <label> Images : </label>
           <input type="text" v-model="brewery.image" />   
         </div>

          <div>
           <label> Brewery Type : </label>
           <input type="text" v-model="brewery.breweryType" />   
         </div>

         <button type="submit">Submit</button>

      </form>
  </div>
</template>

<script>
import breweryService from "@/services/BreweryService.js";

export default {
    name:"add-brewery", 
    data() {
        return{
        errorMsg:"",
        brewery: {
            brewerId:"", 
            name:"",
            phoneNumber:"", 
            emailAddress:"", 
            address:"", 
            history:"", 
            openHours:"", 
            image:"", 
            breweryType:"" 
        }
    }
},
methods: {
    saveBrewery() {
        breweryService.createBrewery(this.brewery).then (
           (response) => {
               return response.status;
           }
        )
        .catch(
                error => {
                    if(error.response) {
                        this.errorMsg = error.response.statusText;
                    } else if (error.request) {
                        this.errorMsg = "We couldn't find the server";
                    } else {
                        this.errorMsg = "Error - we couldn't create the request";
                    }
                }
            );
        }
    }
}

</script>

<style>

</style>