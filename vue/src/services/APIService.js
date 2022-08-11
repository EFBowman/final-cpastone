import axios from 'axios';


const http = axios.create({
    baseURL:"https://api.openbrewerydb.org/breweries?"
});
    const ByState = "by_state="

    const ByCity = "by_city="

    const ByName = "by_name="

    const ByType = "by_type="

export default {
    
    getBreweriesByState() {
        return http.get(ByState);
    },
    
    getBreweryByCity() {
        return http.get(ByCity);
    },

    getBreweryByName() {
        return http.get(ByName);
    },

    getBreweryByType() {
        return http.get(ByType);
    }

}