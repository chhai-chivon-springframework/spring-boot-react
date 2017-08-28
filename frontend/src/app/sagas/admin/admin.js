import { call , put } from 'redux-saga/effects';
import {
    ADMIN_BLOCK_MERCHANT_SUCCESS,
    ADMIN_BLOCK_MERCHANT_FAIL,

    GET_MERCHANT_DETAIL_SUCCESS,
    GET_MERCHANT_DETAIL_FAIL,

    MEMBER_LIST_PRODUCT_SUCCESS,
    MEMBER_LIST_PRODUCT_FAIL
} from './../../actions/admin';

import {
    adminBlockMerchantApi,
    getMerchantDetailApi,
    memberListProductApi
} from './../../api/admin';

export function * adminBlockMerchantSaga(action){
    const response = yield call(adminBlockMerchantApi,action);
    if(!(response==undefined)){
        console.log("Saga action:",response);
        yield put({ type: ADMIN_BLOCK_MERCHANT_SUCCESS , response });

    }else{
        console.log("Error saga");
        yield put({ type: ADMIN_BLOCK_MERCHANT_FAIL , response })
    }
}
export function * getMerhantDetailSaga(action){
    const response = yield call(getMerchantDetailApi , action);
    if(!(response == undefined)){
        console.log("Success Saga",response);
        yield put({type:GET_MERCHANT_DETAIL_SUCCESS, response});
    }else{
        console.log("Error Saga");
        yield put({ type:GET_MERCHANT_DETAIL_FAIL , response })
    }
}

export function * memberListProductSaga(){
    const response = yield call(memberListProductApi);
    if(!(response == undefined)){
        console.log("Saga Work",response);
        yield put({ type:MEMBER_LIST_PRODUCT_SUCCESS , response});
    }else{
        yield put({ type:MEMBER_LIST_PRODUCT_FAIL , response });
    }
}
