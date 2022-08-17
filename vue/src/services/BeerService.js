import axios from 'axios';

export default {

    getAllBeers(){
        return axios.get('/beers');
    },

    createBeer(beer){
        return axios.post('/beers', beer);
    },

    createReview(review) {
        return axios.post('/beer/reviews', review);
    },

    getAllReviewsByBeerId(id) {
        return axios.get(`/beer/${id}/reviews`);
    },

    getBeerIdByName(name) {
        return axios.get(`/beer/${name}`);
    },

    getBeersByBreweryId(breweryId) {
        return axios.get(`/breweries/${breweryId}/beers`)
    }

}