import { Component, OnInit } from '@angular/core';
import { BookService } from 'src/app/providers/book.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.scss']
})
export class SearchComponent implements OnInit {

  book: any;

  constructor(private bookService: BookService) { }

  ngOnInit() {
    this.bookService.getAllBooks().subscribe((response) => {
      if(response) {
        this.book = response;
      }
    });
  }

  addBookToCart(b) {
    this.bookService.addBookToCart(b).subscribe((response) => {
      console.log(response);
    });
  }

  removeBook(b) {
    this.bookService.removeBook(b.id).subscribe((response) => {
      console.log(response);
      this.ngOnInit();
    })
  }

}
