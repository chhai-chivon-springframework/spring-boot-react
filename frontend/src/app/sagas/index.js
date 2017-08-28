import { takeEvery, takeLatest } from "redux-saga";
import { fork } from "redux-saga/effects";
import {
    SEND_EMAIL_OR_PHONE,
    USER_SIGN_IN,
    USER_SIGN_UP,
    SET_NEW_PASSWORD,
    OPEN_SIGN_UP,
    CLOSE_SIGN_UP,
    VERIFY_CODE,
    VERIFY_SOCIAL_ACCOUNT_PHONE,
    USER_LOG_OUT,
    SEND_CODE_AGAIN
} from './../actions/user';
import {
    ADMIN_BLOCK_MERCHANT,
    GET_MERCHANT_DETAIL,
    MEMBER_LIST_PRODUCT
} from './../actions/admin';
import{
    GET_MEMBER_DETAIL,
    PROMOTE_MEMBER,
    CHANGE_MEMBER_STATUS,
    FETCH_MEMBER
} from './../actions/member';

import {
    doSendMailOrPhone,
    userSignInSaga,
    userSignUpSaga,
    resetUserPasswordSaga,
    verifyCode,
    verifySocialAccount,
    userLogout,
    sendCodeAgainSaga
} from './users/user';
import {
    doGetMemberDetail,
    doPromoteMember,
    doChangeMemberStatus,
    getMembersSaga
} from './members/member';


import { FILTER_MEMBERS } from './../actions/admin/merchant/merchant';
import { fetchMerchantsSaga } from './admin/merchant/merchant';
import {
    adminBlockMerchantSaga,
    getMerhantDetailSaga,
    memberListProductSaga
} from './admin/admin';

export function* sagas() {
    yield [
        /*user authentication*/
        fork(takeEvery,USER_SIGN_UP,userSignUpSaga),
        fork(takeEvery,USER_SIGN_IN,userSignInSaga),
        fork(takeEvery,VERIFY_CODE,verifyCode),
        fork(takeEvery,VERIFY_SOCIAL_ACCOUNT_PHONE,verifySocialAccount),
        fork(takeEvery,SEND_EMAIL_OR_PHONE,doSendMailOrPhone),
        fork(takeEvery,SET_NEW_PASSWORD,resetUserPasswordSaga),
        fork(takeEvery, USER_LOG_OUT, userLogout),
        fork(takeEvery,SEND_CODE_AGAIN,sendCodeAgainSaga),
        /* admin manage merchant */
        fork(takeEvery,ADMIN_BLOCK_MERCHANT,adminBlockMerchantSaga),
        fork(takeEvery,GET_MERCHANT_DETAIL,getMerhantDetailSaga),
        fork(takeEvery,MEMBER_LIST_PRODUCT,memberListProductSaga),

        /* admin manage member */
        fork(takeEvery,GET_MEMBER_DETAIL,doGetMemberDetail),
        fork(takeEvery,PROMOTE_MEMBER,doPromoteMember),
        fork(takeEvery,CHANGE_MEMBER_STATUS,doChangeMemberStatus),
        fork(takeEvery,FETCH_MEMBER,getMembersSaga),
        fork(takeEvery,FILTER_MEMBERS,fetchMerchantsSaga)
    ];
}