package com.app.books.services;

import com.app.books.dto.BookRequestDTO;
import com.app.books.models.Book;
import com.app.books.repositories.IBooksRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Implementation of {@link IBooksService}.
 */
@Service
@AllArgsConstructor
public class BooksService implements IBooksService {

    /**
     * Books repository.
     */
    private final IBooksRepository booksRepository;

    /**
     * {@inheritDoc}.
     */
    @Override
    public Book findById(final UUID id) {
        return booksRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found."));
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public Book create(final BookRequestDTO request) {
        return booksRepository.save(Book.builder()
                .build());
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public Book update(final UUID id, final BookRequestDTO request) {
        Book book = findById(id);

        return book;
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public void deleteById(final UUID id) {
        booksRepository.deleteById(id);
    }
}
