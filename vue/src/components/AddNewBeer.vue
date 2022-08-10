<template>
  <div>
      <form v-on:submit.prevent="saveBeer">
          <div>
           <label> Beer ID : </label>
           <input type="number" v-model="beer.beerId" />   
         </div>

         <div>
           <label> Brewery ID : </label>
           <input type="text" v-model="beer.breweryId" />   
         </div>

          <div>
           <label> Beer Name : </label>
           <input type="text" v-model="beer.beerName" />   
         </div>

          <div>
           <label> Beer Description : </label>
           <input type="text" v-model="beer.beerDescription" />   
         </div>

          <div>
           <label> Image : </label>
           <input type="text" v-model="beer.image" />   
         </div>

          <div>
           <label> ABV : </label>
           <input type="text" v-model="beer.abv" />   
         </div>

          <div>
           <label> Beer Type : </label>
           <input type="text" v-model="beer.beerType" />   
         </div>

         <button type="submit">Submit</button>

      </form>
  </div>
</template>

<script>
import breweryService from "@/services/BreweryService.js";

export default {
    name:"add-beer", 
    data() {
        return{
        errorMsg:"",
        beer: {
            breweryId:"",
            beerName:"", 
            beerDescription:"", 
            image:"", 
            abv:"", 
            beerType:""
        }
    }
},
methods: {
    saveBeer() {
        breweryService.createBeer(this.beer).then (
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