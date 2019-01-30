import { Component, OnInit } from '@angular/core';
import { BookService } from 'src/app/providers/book.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.scss']
})
export class CartComponent implements OnInit {

  book: any[];

  constructor(private bookService: BookService) { }

  ngOnInit() {
    this.bookService.getBooksFromCart().subscribe((response) => {
      console.log(response);
      if(response && response.length > 0) {
        this.book = response;
      } else {
        this.book = null;
      }
    });
  }

  removeBookFromCart(id) {
    this.bookService.removeBookFromCart(id).subscribe((response) => {
      console.log(response);
      this.ngOnInit();
    })
  }

  removeAllBooks() {
    this.bookService.removeAllBooks().subscribe((response) => {
      console.log(response);
      this.ngOnInit();
    });
  }

}
