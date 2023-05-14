import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BASE_URL } from '../constants/url.address';
import { User } from '../interface/user.interface';
import { Observable } from 'rxjs';
import { getUserSelector } from '../store/selectors/selector';
import { AppState } from '../store/state/app.state';
import { Store } from '@ngrx/store';
import { AddUser } from '../store/action/action';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private apiBaseUrl = BASE_URL;

  constructor(private http:HttpClient,
              private store: Store<AppState>) { }

  public addUser(user: User): Observable<User>{
    return this.http.post<User>(`${this.apiBaseUrl}/user/user`,user);
  };

  public getAllUser(): Observable<User[]>{
    return this.http.get<User[]>(`${this.apiBaseUrl}/user/allposts`);
  };

  public deleteUser(userId:number): Observable<void>{
    return this.http.delete<void>(`${this.apiBaseUrl}/user/delete/${userId}`)
  }

  get User(){
    return this.store.select(getUserSelector)
  };

  createUser(user: any){
    this.store.dispatch(new AddUser(user));
  }

  public getUserById(userId: number): Observable<User>{
    return this.http.get<User>(`${this.apiBaseUrl}/user/user/${userId}`);
  }
  
}
