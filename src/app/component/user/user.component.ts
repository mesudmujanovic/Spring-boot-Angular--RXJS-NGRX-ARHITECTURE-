import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { UserService } from '../../service/user.service';
import { catchError, of, Observable, switchMap,map } from 'rxjs';
import { User } from '../../interface/user.interface';
import { AppState } from 'src/app/store/state/app.state';
import { Store } from '@ngrx/store';
import { getUserSelector } from 'src/app/store/selectors/selector';
import { AddUser } from 'src/app/store/action/action';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent {

  postForm: FormGroup;
  user$: Observable<User[]>;
  selectedUser$: Observable<User> = this.store.select(getUserSelector);

  constructor(
    private formBuilder: FormBuilder,
    private userService: UserService,
    private store: Store<AppState> ) {
  }

  onSelectedUser(us: User){
    this.store.dispatch(new AddUser([us]));
    this.selectedUser$.subscribe(() => {
      console.log("selected",this.selectedUser$);
    })
  }

  ngOnInit(): void {
    this.postForm = this.formBuilder.group({
      name: ['', Validators.required],
      lastname: ['', Validators.required]
    });

    this.getUsers().subscribe(users => {
      console.log("allUsers",users);
    })
  }

  onSubmit() {
    this.userService.addUser(this.postForm.value).pipe(
      switchMap(()=> this.getUsers()),
      catchError(error => {
        console.log(error);
        return of(null)
      })
    ).subscribe((response: User[]) => {
      if (response) {
        console.log("user added", response);
        this.postForm.reset();
      } else {
        console.log("failed");

      }
    })
  };

  getUsers():Observable<User[]>{
    return this.user$ = this.userService.getAllUser().pipe(
      catchError(error => {
        console.log("error",error);
        return of([]);
      })
    )
  };

  onDeleteUser(userId:number):void{
    if(!confirm('Are you sure want delete this user')){
      return;
    }
    this.userService.deleteUser(userId).pipe(
      switchMap(()=> this.getUsers())
    ).subscribe(
      (response: User[])=>{
       console.log(response);
      },
      catchError(error => {
        console.log("error",error);
        return of([]);
      })
    )
  }


}



