package com.tytan.book.book;

import com.tytan.book.file.FileUtils;
import com.tytan.book.history.BookTransactionHistory;
import org.springframework.stereotype.Service;

@Service
public class BookMapper {
    public Book toBook(BookRequest request) {
        return Book.builder()
                .id(request.id())
                .title(request.title())
                .authorName(request.authorName())
                .synopsis(request.synopsis())
                .archived(false)
                .isbn(request.isbn())
                .shareable(request.shareable())
                .build();
    }

    public BookResponse toBookResponse(Book book) {
        return BookResponse.builder()
                .id(book.getId())
                .title(book.getTitle())
                .authorName(book.getAuthorName())
                .isbn(book.getIsbn())
                .synopsis(book.getSynopsis())
                .rate(book.getRate())
                .archived(book.isArchived())
                .shareable(book.isShareable())
                .owner(book.getOwner().FullName())
                .cover(FileUtils.readFileFromLocation(book.getBookCover()))
                .build();
    }

    public BorrowedBookResponse toBorrowedBookResponse(BookTransactionHistory bookHistory) {
        return BorrowedBookResponse.builder()
                .id(bookHistory.getBook().getId())
                .title(bookHistory.getBook().getTitle())
                .authorName(bookHistory.getBook().getAuthorName())
                .isbn(bookHistory.getBook().getIsbn())
                .rate(bookHistory.getBook().getRate())
                .returned(bookHistory.isReturned())
                .returnApproved(bookHistory.isReturnApproved())
                .build();
    }
}
