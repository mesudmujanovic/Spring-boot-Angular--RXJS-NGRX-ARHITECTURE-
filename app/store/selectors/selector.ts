import { AppState } from "../state/app.state";
import { createSelector } from "@ngrx/store";
import { UserOdrerState } from "../state/select.state";


const orderSelectors = (state: AppState) => state.order;

export const getUserSelector = createSelector(
    orderSelectors,
    (state:UserOdrerState) => state.user
)