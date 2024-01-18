import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProductComponent } from './product/product.component';
import { HomepageComponent } from './homepage/homepage.component';
import { VendorsComponent } from './vendors/vendors.component';
import { StockComponent } from './stock/stock.component';
import { StockInComponent } from './stock-in/stock-in.component';
import { StockOutComponent } from './stock-out/stock-out.component';

const routes: Routes = [
  { path: 'product', component: ProductComponent },
  { path: 'vendors', component: VendorsComponent },
  { path: 'stock', component: StockComponent },
  { path: 'stockIn', component: StockInComponent },
  { path: 'stockOut', component: StockOutComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
