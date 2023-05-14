import { Component } from '@angular/core';
import { FormControl, FormGroup, FormBuilder, Form, Validators } from '@angular/forms';
import { Observable, catchError, of, switchMap } from 'rxjs';
import { Phone } from 'src/app/interface/phone.interface';
import { PhoneService } from 'src/app/service/phone.service';
import { UserService } from '../../service/user.service';
import { User } from 'src/app/interface/user.interface';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-phone',
  templateUrl: './phone.component.html',
  styleUrls: ['./phone.component.css']
})
export class PhoneComponent {

  phoneForm: FormGroup;
  allPhone$: Observable<Phone[]>;

 constructor(private phoneService: PhoneService,
  private formBuilder: FormBuilder,
  private userService: UserService,
  private route: ActivatedRoute){}

ngOnInit(): void{

  this.phoneForm = this.formBuilder.group({
    title: ['', Validators.required],
    model: ['', Validators.required]
  });
  
  this.getAllPhone().subscribe( phone => {
    console.log("AllPhone",phone); })
}

onSubmit() {
  const userId = +this.route.snapshot.paramMap.get('id'); // dodajemo + ispred da bismo pretvorili u broj
  const phone = this.phoneForm.value;
  this.phoneService.addPhone(phone, userId).pipe(
    switchMap( () => this.getAllPhone()),
    catchError( error =>{
      console.log(error);
      return of([]);
    })
  ).subscribe( (response: Phone[]) => {
    if(response){
      this.phoneForm.reset();
    } else{
      console.log("error addPhone");
    }
  })
}

 getAllPhone(): Observable<Phone[]>{
  return this.allPhone$ = this.phoneService.getAllPhone().pipe(
    catchError( error => {
      console.log(error)
      return of([]);
    })
  )
 };

}
