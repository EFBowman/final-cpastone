<template>
<div>
    <h1 id="the-reviewery"> The Reviewery </h1>
    <h2> {{this.$store.state.beer.beerName}} </h2>
    <add-review  v-if="isUser" />
    <review-display />
</div>
</template>

<script>
import AddReview from '../components/AddReview.vue'
import ReviewDisplay from '../components/ReviewDisplay.vue'
export default {
  components: { ReviewDisplay, AddReview },
  data() {
    return {
      isUser: this.$store.state.user && this.$store.state.user.authorities[0].name === 'ROLE_USER'
    }
  }
}
</script>

<style>

#the-reviewery {
  justify-content: center;
}

</style>