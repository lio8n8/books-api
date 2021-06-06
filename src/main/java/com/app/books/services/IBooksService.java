package com.app.books.services;

import com.app.books.dto.BookRequestDTO;
import com.app.books.models.Book;

import java.util.UUID;

/**
 * Contains operations related to books.
 */
public interface IBooksService {

    /**
     * Find book by id
     *
     * @param id book id
     *
     * @return {@link Book}
     */
    Book findById(UUID id);

    /**
     * Create book
     *
     * @param request {@link BookRequestDTO}
     *
     * @return created {@link Book}
     */
    Book create(BookRequestDTO request);

    /**
     * Update book
     *
     * @param id book id
     * @param request {@link BookRequestDTO}
     *
     * @return updated {@link Book}
     */
    Book update(UUID id, BookRequestDTO request);

    /**
     * Delete book by id
     *
     * @param id book id
     */
    void deleteById(UUID id);
}
