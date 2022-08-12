<template>
  <div>
      <table>
        <thead id="brewery-container">
            <tr>
                <th> Name </th>
                <th> Info </th>
                <th> Location </th>
                <th> Hours </th>
            </tr>
        </thead>
          <tbody>
              <tr v-for="brewery in $store.state.breweries" v-bind:key="brewery.id">
                  <td>{{brewery.name}}</td>
                  <td>{{brewery.history}}</td>
                  <td>{{brewery.street}}</td>
                  <td>{{brewery.hours}}</td>
              </tr>
          </tbody>
      </table>
  </div>
  
</template>

<script>


export default {
  name: 'list-breweries',
  data() {
    return {
      breweries: [],
      errorMsg: ""
    }
  }

}
</script>

<style>

</style>