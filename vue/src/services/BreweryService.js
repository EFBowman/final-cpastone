import axios from 'axios';


export default{
    getAllBreweries(){
        return axios.get('/breweries/search', {
            params: {
                searchTerms: this.$store.state.searchParams
            }
        });
    },

    createBrewery(brewery){
        return axios.post('', brewery);
    },

    updateBrewery(brewery){
        return axios.put('update-brewery/{breweryId}', brewery);
    },

    getAllBeers(){
        return axios.get('/beers');
    },

    createBeer(beer){
        return axios.post('/beers', beer);
    }
}
