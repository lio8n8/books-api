package com.app.books.controllers;

import com.app.books.dto.AuthorDTO;
import com.app.books.dto.AuthorRequestDTO;
import com.app.books.services.IAuthorsService;
import lombok.AllArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * Implementation of {@link IAuthorsController}.
 */
@RestController
@AllArgsConstructor
public class AuthorsController implements IAuthorsController {

    /**
     * Conversion service.
     */
    private final ConversionService conversionService;

    /**
     * Authors service.
     */
    private final IAuthorsService authorsService;

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<AuthorDTO> create(final AuthorRequestDTO request) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<AuthorDTO> update(final UUID id, final AuthorRequestDTO request) {
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
