<template>
  <div class="ReviewContainer">
      <div id="review-info">
        
        <h2> {{review.beer_name}}</h2>
    
        <h3>{{review.rating}}/5</h3> 
        <p>{{review.description}}</p> 
            
        </div>
        </div>
</template>

<script>
export default {
    name: "individual-review",
    props:["review"]

}
</script>

<style>

</style>