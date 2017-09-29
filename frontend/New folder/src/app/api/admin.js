import axios from 'axios';
import {CONFIG,API_ENDPOINT} from './headers';

export function adminBlockMerchantApi(action){
    return axios.put(API_ENDPOINT + "users/blockmerchant", JSON.stringify(action.status), CONFIG)
        .then(function(response){
            console.log("Api work");
           return response.data
        }).catch(function(error){
            console.log("Error API:",error);
        })
}
export function getMerchantDetailApi(action){
    return axios.get(API_ENDPOINT + "users/getmerchant/" + action.merchant_id, CONFIG)
        .then(function(response){
            console.log("API work",response.data);
            return response.data

        }).catch(function(error){
            console.log("Api Error:",error);
        })
}
export function memberListProductApi(){
    return axios.get(API_ENDPOINT + "member/listproducts", CONFIG)
        .then(function(response){
            console.log("Api Work:",response.data);
            return response.data
        }).catch(function(error){
            console.log("API Error",error);
        })
}