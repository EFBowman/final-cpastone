<template>
  <div id="form-div">
      <form id="new-beer-form" v-on:submit.prevent="saveBeer">
          <h2>Add A Beer</h2>
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

         <button id="submit-button" type="submit">Submit</button>

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
            brewery_id:"",
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
            ); this.beer = {};
            alert("This beer has been added!");
        }
    }
}

</script>

<style>
#new-beer-form {
    display: flexbox;
}

h2 {
    display: flex;
    justify-content: center;
}

div {
    display: flex;
    flex-direction: column;
    justify-content: center;
    padding-bottom: 2%;
}

label {
    display: flex;
    justify-content: center;
}

img {
    display: flex;
    margin-left: auto;
    margin-right: auto;
}

#form-div {
    margin-left: 30%;
    margin-right: 30%;
    background-color: white;
    opacity: 75%;
    border-radius: 10px;
    margin-top: 5%;
    padding-left: 2%;
    padding-right: 2%;
    padding-bottom: 2%;
}

#submit-button {
    display: flex;
    margin-left: auto;
    margin-right: auto;
}

</style>