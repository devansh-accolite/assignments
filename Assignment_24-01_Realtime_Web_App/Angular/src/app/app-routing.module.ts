import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './component/home/home.component';
import { AppComponent } from './app.component';
import { SearchComponent } from './component/search/search.component';
import { BookComponent } from './component/book/book.component';
import { CartComponent } from './component/cart/cart.component';

const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'search', component: SearchComponent },
  { path: 'book', component: BookComponent },
  { path: 'book/:id', component: BookComponent },
  { path: 'cart', component: CartComponent },
  { path: '', redirectTo: '/home', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
