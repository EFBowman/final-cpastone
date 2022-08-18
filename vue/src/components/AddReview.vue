<template>
  <form v-on:submit.prevent="addNewReview">

    <div class="form-rating">
      <label for="rating">Rating:</label>
      <select id="rating" v-model.number="newReview.rating">
        <option value="1">1 Star</option>
        <option value="2">2 Stars</option>
        <option value="3">3 Stars</option>
        <option value="4">4 Stars</option>
        <option value="5">5 Stars</option>
      </select>
    </div>

    <div class="form-description">
        <label for="beer-description">How'd you like it?</label>
        <textarea id="beer-description" v-model="newReview.description"> </textarea>
    </div>

    <button id="submit-button" type="submit"> Submit </button>

  </form>
</template>

<script>
import beerService from "@/services/BeerService.js";
import breweryService from "@/services/BreweryService.js";

export default {
    name: "add-review",
    data() {
        return {
            errorMsg: "",
            newReview: {
                userId: "",
                beerId: "",
                beerName: "",
                breweryName: "",
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
        const beerId = this.$store.state.beer.beerId;
        const breweryName = this.$store.state.brewery.name;
        const beerName = this.$store.state.beer.beerName;

        //add to newReview
        this.newReview.userId = userId;
        this.newReview.beerId = beerId;
        this.newReview.breweryName = breweryName;
        this.newReview.beerName = beerName;

        this.$store.commit("ADD_REVIEW", this.newReview);
        beerService.createReview(this.newReview).then(
            () => {
                alert("Review Created")
            }
        ).catch(
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
        this.newReview = {};
    }        
        
    }

}
</script>

<style>
.form-rating {
    display: flex;
    width: 15%;
    margin-left: auto;
    margin-right: auto;
    color: white;
}
.form-description {
    color: white;
}
#beer-description {
    height: 200px;
    width: 50%;
    margin-left: auto;
    margin-right: auto;
}
#submit-button {
    justify-content: center;
}
</style>