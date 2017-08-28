import axios from 'axios';
import {CONFIG, LOGOUT, API_ENDPOINT} from './headers';

/* This API is used for user forget password */
export function apiSendMailOrPhone(action) {
    return axios.post(API_ENDPOINT + "users/forgetpassword",
        JSON.stringify(action.contact),
        CONFIG)
        .then(function (response) {
            return response.data;
        })
        .catch(function (error) {
            console.log("error API", error)
        });
}

/* This API is used for set new password */
export function apiSetNewPassword(action) {
    return axios.post(API_ENDPOINT + "users/resetpassword",
        JSON.stringify(action.new_password),
        CONFIG)
        .then(function (response) {
            return response.data;
        })
        .catch(function (error) {
            console.log("error API", error)
        });
}


export function userSignInApi(action) {
    return axios.post(API_ENDPOINT + "users/signin", JSON.stringify(action.user), CONFIG)
        .then(function (response) {
            return response.data;
        }).catch(function (error) {
            console.log(error);
            return response.data;
        });
}

export function userSignUpApi(action) {
    return axios.post(API_ENDPOINT + "users/personal/signup", JSON.stringify(action.user), CONFIG)
        .then(function (response) {
            return response.data;
        }).catch(function (error) {
            console.log("error API", error)
        });
}

export function verifyCodeApi(action) {
    return axios.put(API_ENDPOINT + "users/verification/" + action.code, JSON.stringify(action.code), CONFIG)
        .then(function (response) {
            return response.data;
        }).catch(function (error) {
            console.log("error API", error)
        });
}


export function verifySocialAccountPhoneApi(action) {
    return axios.put(API_ENDPOINT + "users/social/" + action.user.socialId, JSON.stringify(action.user), CONFIG)
        .then(function (response) {
            return response.data;
        }).catch(function (error) {
            console.log("error API", error)
        });
}

export function getLogout(action) {
    return axios.post(API_ENDPOINT + "users/signout", {}, {
        headers: {
            'Content-Type': 'application/json',
            'X-Api-Key': 'AbCdEfGhIjK1',
            'X-Auth-Token': action.token
        }
    }).then(function (response) {
        return response.data.data;
    }).catch(function (error) {
        console.log("error API", error)
    });
}

export function sendCodeAgainApi(action){
    return axios.put(API_ENDPOINT + "users/resendcode", JSON.stringify(action.emailOrPhone), CONFIG)
        .then(function (response) {
            return response.data;
        }).catch(function (error) {
            console.log("error API", error)
        });
}

