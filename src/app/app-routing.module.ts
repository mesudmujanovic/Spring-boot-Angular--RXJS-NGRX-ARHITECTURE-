import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UserComponent } from './component/user/user.component';
import { PhoneComponent } from './component/phone/phone.component';

const routes: Routes = [
  {path:'', component: UserComponent},
  {path:'phone/:id', component: PhoneComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
