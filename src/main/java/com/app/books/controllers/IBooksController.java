package com.app.books.controllers;

import com.app.books.dto.BookDTO;
import com.app.books.dto.BookRequestDTO;
import com.app.books.dto.SearchRequestDTO;
import org.springframework.http.ResponseEntity;

import java.util.Collection;
import java.util.UUID;

/**
 * Books controller interface.
 */
public interface IBooksController {

    /**
     * Find all books for requested author's name.
     * @param authorName author name
     * @return {@link Collection} of {@link BookDTO}
     */
    ResponseEntity<Collection<BookDTO>> findAllByAuthorName(String authorName);

    /**
     * Find the most selling book for request author's name.
     * @param authorName author name
     * @return {@link BookDTO}
     */
    ResponseEntity<BookDTO> findMostSellingByAuthorName(String authorName);

    /**
     * Find the most published book for requested author's name.
     * @param authorName author name
     * @return {@link BookDTO}
     */
    ResponseEntity<BookDTO> findMostPublishedByAuthorName(String authorName);

    /**
     * Find most selling books.
     * @param request {@link SearchRequestDTO}
     * @return {@link Collection} of {@link BookDTO}
     */
    ResponseEntity<Collection<BookDTO>> findMostSelling(SearchRequestDTO request);

    /**
     * Find most published books.
     * @param request {@link SearchRequestDTO}
     * @return {@link Collection} of {@link BookDTO}
     */
    ResponseEntity<Collection<BookDTO>> findMostPublished(SearchRequestDTO request);

    /**
     * Find most successful books.
     * @param request {@link SearchRequestDTO}
     * @return {@link Collection} of {@link BookDTO}
     */
    ResponseEntity<Collection<BookDTO>> findMostSuccessful(SearchRequestDTO request);

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
