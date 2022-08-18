<template>
  <div id="app">
    <div id="nav">
      <router-link class="link" v-bind:to="{ name: 'home' }">Home</router-link>&nbsp; &nbsp;
      <router-link class="link" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
      <router-link class="link" v-bind:to="{ name: 'login' }" v-if="$store.state.token === ''">Login</router-link>
    </div>
      <router-view />
  </div>
</template>
<style>
html{
  background-color:rgb(61, 61,61);
}
#app{
  background-color:rgb(61, 61, 61);
}
.link{
  color:whitesmoke;
}
</style>