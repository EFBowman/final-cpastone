<template>
<div>
    <h1> The Reviewery </h1>
    <h2> {{this.$store.state.beer.beerName}} </h2>
    <add-review />
    <review-display />
</div>
</template>

<script>
import AddReview from '../components/AddReview.vue'
import ReviewDisplay from '../components/ReviewDisplay.vue'
export default {
  components: { ReviewDisplay, AddReview },

}
</script>

<style>

</style>