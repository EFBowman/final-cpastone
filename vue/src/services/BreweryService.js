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

    getAllBeers(){
        return axios.get('/beers');
    },

    createBeer(beer){
        return axios.post('/beers', beer);
    },

    getAllBreweries(){
        return axios.get('/breweries')
    },

    createReview(review) {
        return axios.post('/beer/reviews', review);
    },

    getAllReviewsByBeerId(id) {
        return axios.get(`/beer/${id}/reviews`);
    }
}
