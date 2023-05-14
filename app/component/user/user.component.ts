import { Component } from '@angular/core';
import { Form, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { UserService } from '../../service/user.service';
import { catchError, of, Observable, switchMap, map } from 'rxjs';
import { User } from '../../interface/user.interface';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent {

  postForm: FormGroup;
  user$ = this.userService.User;

  constructor(
    private formBuilder: FormBuilder,
    private userService: UserService) {
  }

  ngOnInit(): void {
    this.postForm = this.formBuilder.group({
      name: ['', Validators.required],
      lastname: ['', Validators.required]
    });
    this.getUsers().subscribe(users => {
      console.log("allUsers", users);
    })
    console.log("user",this.user$);
    
  };

  //save user in ngrx store
  addNewUser(user: { name: String, lastname: string }) {
    this.userService.createUser(user);
  }

  //add  and save user in DB
  onSubmit() {
    this.userService.addUser(this.postForm.value).pipe(
      switchMap(() => this.getUsers()),
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

  getUsers(): Observable<User[]> {
    return this.user$ = this.userService.getAllUser().pipe(
      catchError(error => {
        console.log("error", error);
        return of([]);
      })
    )
  };

  onDeleteUser(userId: number): void {
    if (!confirm('are you sure want delete this user')) {
      return;
    }
    this.userService.deleteUser(userId).pipe(
      switchMap(() => this.getUsers())
    ).subscribe((response: User[]) => {
      console.log("delete", response);
    },
      catchError(error => {
        console.log("error delete", error);
        return of([]);
      })
    )
  }

}



