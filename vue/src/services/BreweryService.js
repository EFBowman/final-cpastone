import axios from 'axios';


export default{
    getAllBreweries(){
        return axios.get('');
    },

    createBrewery(brewery){
        return axios.post('', brewery);
    },

    getAllBeers(){
        return axios.get('/beers');
    },

    createBeer(beer){
        return axios.post('/beers', beer);
    }
}
