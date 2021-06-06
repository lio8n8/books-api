package com.app.books.repositories;

import com.app.books.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Books repository
 */
@Repository
public interface IBooksRepository extends JpaRepository<Book, UUID> {
}
