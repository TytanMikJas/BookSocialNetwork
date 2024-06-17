import {Component, OnInit} from '@angular/core';
import {PageResponseBorrowedBookResponse} from "../../../../services/models/page-response-borrowed-book-response";
import {BorrowedBookResponse} from "../../../../services/models/borrowed-book-response";
import {BookService} from "../../../../services/services/book.service";

@Component({
  selector: 'app-returned-books',
  templateUrl: './returned-books.component.html',
  styleUrl: './returned-books.component.scss'
})
export class ReturnedBooksComponent implements OnInit {
  returnedBooks: PageResponseBorrowedBookResponse = {};
  page = 0;
  size = 5;
  message = '';
  level = '';

  constructor(
    private bookService: BookService,
  ) {
  }

  ngOnInit() {
    this.findAllBorrowedBooks();
  }


  private findAllBorrowedBooks() {
    this.bookService.findAllReturnedBooks({
      page: this.page,
      size: this.size
    }).subscribe({
      next: (res) => {
        this.returnedBooks = res;
      }
    })
  }

  goToFirstPage() {
    this.page = 0;
    this.findAllBorrowedBooks();
  }

  goToPreviousPage() {
    this.page--;
    this.findAllBorrowedBooks();
  }

  goToPage(index: number) {
    this.page = index;
    this.findAllBorrowedBooks();
  }

  goToNextPage() {
    this.page++;
    this.findAllBorrowedBooks();
  }

  goToLastPage() {
    this.page = this.returnedBooks.totalPages as number - 1;
    this.findAllBorrowedBooks();
  }

  get isLastPage(): boolean {
    return this.page == this.returnedBooks.totalPages as number - 1;
  }

  approveBookReturn(book: BorrowedBookResponse) {
    if(!book.returned) {
      this.level = 'error';
      this.message = 'Book is not yet returned';
      return;
    }
    this.bookService.approveReturn({
      'book-id': book.id as number
    }).subscribe({
      next: (res) => {
        this.findAllBorrowedBooks();
        this.level = 'success';
        this.message = 'Book return approved successfully';
      },
      error: (err) => {
        this.level = 'error';
        this.message = err.error.errorMsg;
      }
    })
  }
}
