<template>
  <div class="ReviewContainer">
    <div v-for="review in this.$store.state.reviews" v-bind:key="review.reviewId">
      <div id="review-info">
        <h3>Rating: {{review.rating}}/5</h3> 
        <p>Review: {{review.description}}</p> 
            
      </div>
    </div>
  </div>
</template>

<script>
export default {
    name: "individual-review"

}
</script>

<style>

.ReviewContainer{
  display: flexbox;
  flex-direction: column;
  justify-content: space-around;
  align-items: left;
  padding:10px;
  outline: none !important;
  font-family: Bebas Neue;
  
}
#review-info{
  display:flex;
  background-color: whitesmoke;
  height: 125px;
  width: 350px;
  gap:10px;
  border-radius: 5px;
  border: 3px solid goldenrod;
  border-radius: 5px;
  
}


</style>