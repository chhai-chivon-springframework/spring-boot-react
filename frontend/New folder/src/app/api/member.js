import axios from 'axios';
import {CONFIG, API_ENDPOINT} from './headers';

/* TO GET MEMBER DETAIL */
export function apiGetMemberDetail(action) {
    return axios.get(API_ENDPOINT + "users/getmember/"+action.member_id, CONFIG)
        .then(function (response) {
            return response.data;
        })
        .catch(function (error) {
            console.log("error API", error)
        });
}
/* TO PROMOTE MEMBER TO BE MERCHANT */
export function apiPromoteMember(action){
    return axios.put(API_ENDPOINT + "users/promotemember", JSON.stringify(action.promote), CONFIG)
        .then(function (response) {
            return response.data;
        })
        .catch(function (error) {
            console.log("error API", error)
        });
}
/* TO CHANGE MEMBER STATUS */
export function apiChangeMemberStatus(action){
    return axios.put(API_ENDPOINT + "users/changememberstatus", JSON.stringify(action.status), CONFIG)
        .then(function (response) {
            return response.data;
        })
        .catch(function (error) {
            console.log("error API", error)
        });
}

/**
 * get member api { do query from api database }
 * @param action
 * @returns {Promise<R>|Promise.<T>}
 */
export function getMembersApi(action){
    console.log("get Member API : ",action.member.user);
    return axios.post(API_ENDPOINT+"users/members?start="+action.member.start+"&limit="+action.member.limit,JSON.stringify(action.member.user),CONFIG)
        .then(function (response) {
            return response.data;
        }).catch(function(error){
            console.log("Error Api",error);
        });
}
