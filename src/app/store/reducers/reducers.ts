import { initialUserOrderState, UserOdrerState } from '../state/select.state';
import { _SelectedUser, SelectedUserActions } from '../action/action';

export const userOdrerReducers = (
    state = initialUserOrderState,
    action: SelectedUserActions
): UserOdrerState => {
    switch(action.type) {
        case _SelectedUser.AddUser:
            return {
                ...state,
                user: action.payload
            };
            default:
                return state;
    }
}