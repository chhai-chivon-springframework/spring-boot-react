import { call, put } from 'redux-saga/effects';
import { FILTER_MEMBERS_SUCCESS, FILTER_MEMBERS_FAIL } from '../../../actions/admin/merchant/merchant';
import { getMerchants } from './../../../api/admin/merchant/merchant';

export function* fetchMerchantsSaga(action){
    const response = yield call(getMerchants, action);
    if(!(response == undefined)){
        yield put({type:FILTER_MEMBERS_SUCCESS,response});
    }else{
        yield put({type:FILTER_MEMBERS_FAIL,response});
    }
}
