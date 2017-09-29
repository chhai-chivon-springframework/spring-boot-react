import { browserHistory } from 'react-router';

export const loadState = () => {
    try {
        const serializedState = sessionStorage.getItem('state')
        if (serializedState === null) {
            return undefined;
        }
        return JSON.parse(serializedState);
    }
    catch (err) {
        return undefined;
    }
};

export const saveState = (state) => {
    try {
        sessionStorage.removeItem('state');
        const serializedState = JSON.stringify(state);
        sessionStorage.setItem('state', serializedState);
    }
    catch (err) {

    }
}

export const clearState = () => {
    try {
        sessionStorage.removeItem('state');
        alert("logout successfully");
        location.assign('/');
    } catch (error) {
        browserHistory.push('/');
    }
}

export const saveSocialId=(state)=>{
    sessionStorage.removeItem('socialId');
    sessionStorage.setItem('socialId',state);
}

export const loadSocialId=()=>{
    try {
        const serializedState = sessionStorage.getItem('socialId')
        if (serializedState === null) {
            return undefined;
        }
        return serializedState;
    }
    catch (err) {
        return undefined;
    }
}


export const saveCodeStatus=(state)=>{
    sessionStorage.removeItem('codeStatus');
    sessionStorage.setItem('codeStatus',state);
}

export const loadCodeStatus=()=>{
    try {
        const serializedState = sessionStorage.getItem('codeStatus')
        if (serializedState === null) {
            return undefined;
        }
        return serializedState;
    }
    catch (err) {
        return undefined;
    }
}

export const savePhone=(state)=>{
    sessionStorage.removeItem('phone');
    sessionStorage.setItem('phone',state);
}

export const loadPhone=()=>{
    try {
        const serializedState = sessionStorage.getItem('phone')
        if (serializedState === null) {
            return undefined;
        }
        return serializedState;
    }
    catch (err) {
        return undefined;
    }
}
