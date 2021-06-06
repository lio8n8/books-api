package com.app.books.controllers;

import com.app.books.dto.BookDTO;
import com.app.books.dto.BookRequestDTO;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

/**
 * Books controller interface.
 */
public interface IBooksController {

    /**
     * Create a new book
     * @param request {@link BookRequestDTO}
     * @return {@link BookDTO}
     */
    ResponseEntity<BookDTO> create(BookRequestDTO request);

    /**
     * Update book
     * @param id book id
     * @param request {@link BookRequestDTO}
     * @return {@link BookDTO}
     */
    ResponseEntity<BookDTO> update(UUID id, BookRequestDTO request);

    /**
     * Delete book by id
     * @param id book id
     * @return empty response
     */
    ResponseEntity deleteById(UUID id);
}
