package com.app.books.controllers;

import com.app.books.dto.BookDTO;
import com.app.books.dto.BookRequestDTO;
import com.app.books.services.IBooksService;
import lombok.AllArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * Implementation of {@link IBooksController}
 */
@RestController
@AllArgsConstructor
public class BooksController implements IBooksController {

    /**
     * Books service.
     */
    private final IBooksService booksService;

    /**
     * Conversion service.
     */
    private final ConversionService conversionService;

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<BookDTO> create(final BookRequestDTO request) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<BookDTO> update(final UUID id, final BookRequestDTO request) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity deleteById(final UUID id) {
        return null;
    }
}
