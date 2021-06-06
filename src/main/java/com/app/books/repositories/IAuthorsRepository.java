package com.app.books.repositories;

import com.app.books.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Authors repository.
 */
@Repository
public interface IAuthorsRepository extends JpaRepository<Author, UUID> {
}
