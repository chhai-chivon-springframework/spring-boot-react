import { FILTER_MEMBERS_SUCCESS, FILTER_MEMBERS_FAIL } from './../../../actions/admin/merchant/merchant';

export function fetchMerchantsReducer(state = [{}], action) {
    switch (action.type){
        case FILTER_MEMBERS_SUCCESS:
            console.log("REDUCER : ", action.response);
            return action.response.data;
        case FILTER_MEMBERS_FAIL:
            console.log("REDUCER : ", action.response);
            return action.response;
        default:
            return state;
    }
}