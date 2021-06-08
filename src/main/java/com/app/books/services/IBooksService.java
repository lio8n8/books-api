package com.app.books.services;

import com.app.books.dto.BookRequestDTO;
import com.app.books.dto.SearchRequestDTO;
import com.app.books.models.Book;

import java.util.List;
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
     * @throws RuntimeException throws exception if book does not exist
     */
    Book findById(UUID id);

    /**
     * Find all books by author's name.
     * @param authorName author name
     * @return {@link List} of {@link Book}
     */
    List<Book> findByAuthorName(String authorName);

    /**
     * Find most selling book by author name.
     * @param authorName author name
     * @return {@link Book}
     */
    Book findMostSellingBookByAuthorName(String authorName);

    /**
     * Find most published book by author name.
     * @param authorName author name
     * @return {@link Book}
     */
    Book findMostPublishedBookByAuthorName(String authorName);

    /**
     * Find all books by author's name and sort by sold amount.
     * @param request to search
     * @return {@link List} of {@link Book}
     */
    List<Book> findByAuthorAndSortBySoldAmount(SearchRequestDTO request);

    /**
     * Find all books by author's name and sort by published amount.
     * @param request to search
     * @return {@link List} of {@link Book}
     */
    List<Book> findByAuthorAndSortByPublishedAmount(SearchRequestDTO request);

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
