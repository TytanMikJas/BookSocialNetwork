package com.tytan.book.book;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookMapperTest {

    private BookMapper bookMapper;

    @BeforeEach
    void setUp() {
        bookMapper = new BookMapper();
    }

    @Test
    void toBook() {
        BookRequest bookRequest = new BookRequest(2, "Nowa ksiazka", "Tytan", "124", "Piekna ksiazka", true);

        Book newBook = bookMapper.toBook(bookRequest);

        assertEquals(newBook.getId(), bookRequest.id());
        assertEquals(bookRequest.title(), newBook.getTitle());
        assertFalse(newBook.isArchived());
    }

    @Test
    void toBookResponse() {
    }

    @Test
    void toBorrowedBookResponse() {
    }
}