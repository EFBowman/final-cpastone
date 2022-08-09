import axios from 'axios';


export default{
    getAllBreweries(){
        return axios.get('');
    },

    createBrewery(brewery){
        return axios.post('', brewery);
    }
}