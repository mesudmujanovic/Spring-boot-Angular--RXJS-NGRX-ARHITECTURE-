import {Action} from '@ngrx/store';
import { User } from 'src/app/interface/user.interface';

export enum _SelectedUser{
  AddUser = '[SelectedOrder] Add User',
}

export class AddUser implements Action{
   public readonly type = _SelectedUser.AddUser;
  constructor(public payload: User[]){}
}

export type SelectedUserActions = AddUser;