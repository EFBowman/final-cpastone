<template>
  <form v-on:submit.prevent="addNewReview">
    <div class="form-element">
        <label for="beer-name-selection">What beer did you drink?</label>
        <select id="beer-name-selection" v-model="newReview.beer_name"> 
            <option>------------</option>
            <!-- beer names as options -->
           
        </select>
    </div>

    <div class="form-element">
      <label for="rating">Rating:</label>
      <select id="rating" v-model.number="newReview.rating">
        <option value="1">1 Star</option>
        <option value="2">2 Stars</option>
        <option value="3">3 Stars</option>
        <option value="4">4 Stars</option>
        <option value="5">5 Stars</option>
      </select>
    </div>

    <div class="form-element">
        <label for="beer-description">How'd you like it?</label>
        <textarea id="beer-description" v-model="newReview.description"> </textarea>
    </div>


  </form>
</template>

<script>
import beerService from "@/services/BeerService.js";
import breweryService from "@/services/BreweryService.js";

export default {
    name: "add-review",
    data() {
        return {
            newReview: {
                user_id: "",
                beer_id: "",
                beer_name: "",
                brewery_name: "",
                description: "",
                rating: 0
            }
        }
    },
    methods: {
        //also auto populate beer_id from whichever beer_name is chosen
    getBeerIdFromBeerName(name) {
        return beerService.getBeerIdFromBeerName(name).then(
            (response) => { 
                const beerId = response.data;
                return beerId;

            });
    },

    //auto populate brewery name from which beer is chosen
    getBreweryNameByBeerId(id) {
        return breweryService.getBreweryNameByBeerId(id).then(
           (response) => {
               const breweryName = response.data;
               return breweryName;
           }
        )
        
        ;
    },

    addNewReview() {
        //collecting info
        const userId = this.$store.state.user.user_id;
        const beerId = this.getBeerIdFromBeerName(this.beer_name);
        const breweryName = this.getBreweryNameByBeerId(beerId);

        //add to newReview
        this.newReview.user_id = userId;
        this.newReview.beer_id = beerId;
        this.newReview.brewery_name = breweryName;

        this.$store.commit("ADD_REVIEW", this.newReview);
        beerService.createReview(this.newReview);
    }        
        
    }

}
</script>

<style>

</style>