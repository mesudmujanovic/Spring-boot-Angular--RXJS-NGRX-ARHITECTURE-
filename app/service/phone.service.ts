import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BASE_URL } from '../constants/url.address';
import { Phone } from '../interface/phone.interface';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PhoneService {

  private apiBaseUrl = BASE_URL; 

  constructor(private http:HttpClient) { }

  public addPhone(phone: Phone,userId:number): Observable<Phone>{
    return this.http.post<Phone>(`${this.apiBaseUrl}/phone/savePhone/${userId}`,phone)
  }
  
  public getAllPhone(): Observable<Phone[]>{
    return this.http.get<Phone[]>(`${this.apiBaseUrl}/phone/allphone`);
  }

  public deletePhone(phoneId:number): Observable<void>{
    return this.http.delete<void>(`${this.apiBaseUrl}/phone/delete/${phoneId}`);
  }
}
