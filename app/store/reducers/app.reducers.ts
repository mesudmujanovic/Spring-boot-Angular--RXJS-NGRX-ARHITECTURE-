import { AppState } from "../state/app.state";
import { ActionReducerMap } from "@ngrx/store";
import { userOdrerReducers } from "./reducers";


export const appReducers: ActionReducerMap<AppState, any>= {
    order: userOdrerReducers
}