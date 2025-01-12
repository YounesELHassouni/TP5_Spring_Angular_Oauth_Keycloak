import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ProductsComponent} from "./vi/products/products.component";
import {CustomersComponent} from "./vi/customers/customers.component";
import {AuthGuard} from "./guards/auth.guard";
import {OrdersComponent} from "./vi/orders/orders.component";
import {OrderDetailsComponent} from "./vi/order-details/order-details.component";

const routes: Routes = [
  {path: 'products', component: ProductsComponent,canActivate: [AuthGuard],data:{roles :['ADMIN']}},
  {path: 'customers', component: CustomersComponent,canActivate: [AuthGuard],data:{roles :['USER']}},
  {path: 'orders', component: OrdersComponent,canActivate: [AuthGuard],data:{roles :['USER']}},
  {path: 'order-details/:id', component: OrderDetailsComponent,canActivate: [AuthGuard],data:{roles :['USER']}}
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
