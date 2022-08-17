<template>
  <div class="ReviewContainer">
      <div id="review-info" v-for="review in this.$store.state.reviews" v-bind:key="review.reviewId">
    
        <h3>{{review.rating}}/5</h3> 
        <p>{{review.description}}</p> 
            
        </div>
        </div>
</template>

<script>
export default {
    name: "individual-review"

}
</script>

<style>

</style>