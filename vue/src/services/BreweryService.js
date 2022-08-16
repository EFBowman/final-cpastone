import axios from 'axios';


export default{
    getBreweriesBySearch(searchParams){
        return axios.post('/breweries/search', searchParams)
    },

    createBrewery(brewery){
        return axios.post('', brewery);
    },

    updateBrewery(brewery){
        return axios.put('/update-brewery/{breweryId}', brewery);
    },

    getAllBreweries(){
        return axios.get('/breweries')
    },

    getBreweryNameByBeerId(id) {
        return axios.get(`/brewery/beer/${id}`);
    }
}
