package com.app.books.repositories;

import com.app.books.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

/**
 * Books repository
 */
@Repository
public interface IBooksRepository extends JpaRepository<Book, UUID> {

    /**
     * Find all books by author's name.
     * @param authorName author name
     * @return {@link List} of {@link Book}
     */
    List<Book> findByAuthorsAuthorName(String authorName);

    /**
     * Find the most selling book by author name.
     * @param authorName author name
     * @return {@link Book}
     */
    Book findTopByAuthorsAuthorNameOrderBySoldAmountDesc(String authorName);

    /**
     * Find most published book by author name.
     * @param authorName author name
     * @return {@link Book}
     */
    Book findTopByAuthorsAuthorNameOrderByPublishedAmountDesc(String authorName);

    /**
     * Find all books by author's name and sort by sold amount.
     * @param query author name query
     * @return {@link List} of {@link Book}
     */
    List<Book> findByAuthorsAuthorNameContainingIgnoreCaseOrderBySoldAmountDesc(String query);

    /**
     * Find all books by author's name and sort by published amount.
     * @param query author name query
     * @return {@link List} of {@link Book}
     */
    List<Book> findByAuthorsAuthorNameContainingIgnoreCaseOrderByPublishedAmountDesc(String query);

    /**
     * Find all books by author's name and sort by success rate.
     * @param query author name query
     * @return {@link List} of {@link Book}
     */
    List<Book> findByAuthorsAuthorNameContainingIgnoreCaseOrderBySuccessRateDesc(String query);
}
