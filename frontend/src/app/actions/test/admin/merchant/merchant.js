export const FILTER_MEMBERS = 'FILTER_MEMBERS';
export const FILTER_MEMBERS_SUCCESS = 'FILTER_MEMBERS_SUCCESS';
export const FILTER_MEMBERS_FAIL = 'FILTER_MEMBERS_FAIL';

export function actionFilterMembers(member) {
    return{
        type: FILTER_MEMBERS,
        member: member
    }
}