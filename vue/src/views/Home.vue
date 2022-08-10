<template>
  <div class="home">
    <h1>Home</h1> &nbsp;
    <router-link :to="{ name: 'add-brewery' }">Add A New Brewery</router-link>
    <router-link :to="{ name: 'add-beer' }">Add A Beer</router-link>
  </div>
</template>

<script>
export default {
  name: "home"
};
</script>
