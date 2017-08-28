import { combineReducers } from "redux";
import { routerReducer } from "react-router-redux";
import { reducer as formReducer } from 'redux-form';
import {
    sendEmailOrPhone,
    userSignInReducer,
    userSignUpReducer,
    resetPasswordReducer,
    signUpModalReducer,
    verifyCodeReducer,
    verifyCodeModalReducer,
    verifySocailAccountPhoneReducer,
    userLogout,
    verifyPhoneModalReducer,
    sendCodeAgainReducer,
    reducerModalSignIn,
    reducerModalForgetPassword,
    reducerModalNewPassword,
} from './users/user';
import {
    adminBlockMerchantReducer,
    getMerchantDetailReducer,
    memberListProductReducer
} from './admin/admin';

import{
    getMemberDetail,
    promoteMember,
    changeMemberStatus,
    getMembersReducer
} from './members/member';
import { fetchMerchantsReducer } from './admin/merchant/merchant';
export const reducers = combineReducers({
    routing: routerReducer,
    form: formReducer,
    userForgetPwd: sendEmailOrPhone,
    userSignUp: userSignUpReducer,
    userSignIn: userSignInReducer,
    userResetPwd: resetPasswordReducer,
    signUpModal: signUpModalReducer,
    verifyCode: verifyCodeReducer,
    verifyCodeModal: verifyCodeModalReducer,
    verifySocialAccountPhone: verifySocailAccountPhoneReducer,
    userLogout: userLogout,
    verifyPhoneModal:verifyPhoneModalReducer,
    sendCodeAgain:sendCodeAgainReducer,
    reducerModalSignIn: reducerModalSignIn,
    reducerModalForgetPassword: reducerModalForgetPassword,
    reducerModalNewPassword: reducerModalNewPassword,

    /* admin manage merchant */
    blockMerchant:adminBlockMerchantReducer,
    merchantDetail:getMerchantDetailReducer,
    memberListProduct:memberListProductReducer,

    /* admin manage member */
    memberDetail: getMemberDetail,
    promotedMember: promoteMember,
    changedMemberStatus : changeMemberStatus,
    members:getMembersReducer,
    merchants: fetchMerchantsReducer
});