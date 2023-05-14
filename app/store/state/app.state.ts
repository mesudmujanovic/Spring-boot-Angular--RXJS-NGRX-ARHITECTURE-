import { UserOdrerState, initialUserOrderState } from "./select.state";


export interface AppState{
    order: UserOdrerState;
}

export const initialAppState: AppState={
    order: initialUserOrderState
}

export function getInitialState(): AppState{
    return initialAppState;
}