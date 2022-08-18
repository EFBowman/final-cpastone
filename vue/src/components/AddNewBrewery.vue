<template>
  <div id="form-div">
      <form id="new-brewery-form" v-on:submit.prevent="saveBrewery">
          <h2>New Brewery Information</h2>
          <div>
           <label> Brewer ID: </label>
           <input type="number" id="brewer-id" v-model="brewery.brewerId" />   
          </div>

         <div>
           <label> Brewery Name: </label>
           <input type="text" id="brewery-name" v-model="brewery.name" />   
          </div>

          <div>
           <label> Phone Number: </label>
           <input type="text" id="phone-number" v-model="brewery.phone" />   
          </div>

          <div>
           <label> Website URL: </label>
           <input type="text" id="url" v-model="brewery.website_url" />   
          </div>

          <div>
           <label> Street: </label>
           <input type="text" id="street" v-model="brewery.street" />   
          </div>

          <div>
           <label> City: </label>
           <input type="text" id="city" v-model="brewery.city" />   
          </div>

          <div>
           <label> State: </label>
           <input type="text" id="state" v-model="brewery.state" />   
          </div>

          <div>
           <label> History: </label>
           <input type="text" id="history" v-model="brewery.history" />   
          </div>

          <div>
           <label> Open Hours: </label>
           <input type="text" id="open-hours" v-model="brewery.openHours" />   
          </div>

          <div>
           <label> Images: </label>
           <img src="#" id="img" />   
          </div>

          <div>
           <label> Brewery Type: </label>
           <input type="text" id="brewery-type" v-model="brewery.brewery_type" />   
          </div>

         <button id="submit-button" type="submit">Submit</button>

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
            phone:"", 
            website_url:"", 
            street:"",
            city: "",
            state: "", 
            history:"", 
            openHours:"", 
            image:"", 
            brewery_type:"" 
        }
    }
},
methods: {
    saveBrewery() {
        breweryService.createBrewery(this.brewery).then (
           (response) => {
               if(response.status === 200 || response.status === 201) {
                alert("This brewery has been added!");
               } else {
               return this.response.statusText;
               }
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
            this.brewery = {};
        }
    }
}

</script>

<style>

#new-brewery-form {
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