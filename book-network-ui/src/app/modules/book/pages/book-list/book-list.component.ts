import {Component, OnInit} from '@angular/core';
import {BookService} from "../../../../services/services/book.service";
import {Router} from "@angular/router";
import {PageResponseBookResponse} from "../../../../services/models/page-response-book-response";

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrl: './book-list.component.scss'
})
export class BookListComponent implements OnInit {
  bookResponse: PageResponseBookResponse = {};
  page = 0;
  size = 10;

  ngOnInit() {
    console.log("INIT");
    this.findAllBooks();
  }

  constructor(
    private bookService: BookService,
    private router: Router
  ) {
  }

  private findAllBooks() {
    this.bookService.findAllBooks({
      page: this.page,
      size: this.size,
    }).subscribe({
      next: (books) => {
        this.bookResponse = books;
        console.log(books.content);
      }
    });
  }
}