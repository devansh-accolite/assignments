import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

// Inject to module
@Injectable({
  providedIn: 'root'
})
export class BookService {

  constructor(private http: HttpClient) { }

  // Observable used to get output from async funcs
  getAllBooks(): Observable<any> {
    return this.http.get('/library/books');
  }

  getBookById(id): Observable<any> {
    return this.http.get('/library/books/' + id + '/get');
  }

  addBook(book: any): Observable<any> {
    return this.http.post('/library/books', book);
  }

  addBookToCart(book: any): Observable<any> {
    return this.http.post('/library/cart', book);
  }

  getBooksFromCart(): Observable<any> {
    return this.http.get('/library/cart/get');
  }

  removeBookFromCart(id): Observable<any> {
    return this.http.get('/library/cart/' + id + '/remove');
  }

  removeAllBooks(): Observable<any> {
    return this.http.get('/library/cart/remove');
  }

  removeBook(id): Observable<any> {
    return this.http.get('/library/books/' + id + '/remove');
  }
}
