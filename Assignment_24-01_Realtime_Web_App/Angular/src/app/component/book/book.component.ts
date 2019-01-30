import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { BookService } from 'src/app/providers/book.service';

@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.scss']
})
export class BookComponent implements OnInit {

  book: any = null;
  bookId: any;

  id: number;

  constructor(private route: ActivatedRoute, private bookService: BookService, private router: Router) { }

  ngOnInit() {
    this.bookId = this.route.snapshot.paramMap.get('id');
    
    if (this.bookId != null) {
      this.bookService.getBookById(this.bookId).subscribe((response) => {
        console.log(response);
        if (response) {
          this.book = response;
        } else {
          this.book = null;
        }
      });
    }
  }

  redirectTo() {
    console.log(this.id);
    this.router.navigateByUrl('/book/' + this.id).then((e) => {
      if(e) {
        console.log("Failed");
      } else {
        console.log("Success");
      }
    });
  }

}
