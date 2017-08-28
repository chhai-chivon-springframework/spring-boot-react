import axios from 'axios';
import {CONFIG, API_ENDPOINT} from '../../headers';

/**
 * get member api { do query from api database }
 * @param action
 * @returns {Promise<R>|Promise.<T>}
 */
export function getMerchants(action){
    return axios.post(API_ENDPOINT+"users/merchants?start="+action.member.start+"&limit="+action.member.limit, JSON.stringify(action.member.user),CONFIG)
        .then(function (response) {
            return response.data;
        }).catch(function(error){
            console.log("Error Api",error);
        });
}
