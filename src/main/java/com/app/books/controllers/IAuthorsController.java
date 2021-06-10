package com.app.books.controllers;

import com.app.books.dto.AuthorDTO;
import com.app.books.dto.AuthorRequestDTO;
import com.app.books.dto.SuccessAuthorRateDTO;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

/**
 * Authors controller interface.
 */
public interface IAuthorsController {

    /**
     * Find author with the highest success rate.
     * @return {@link SuccessAuthorRateDTO}
     */
    ResponseEntity<SuccessAuthorRateDTO> findSuccessAuthorRate();

    /**
     * Create author
     * @param request {@link AuthorRequestDTO}
     * @return {@link AuthorDTO}
     */
    ResponseEntity<AuthorDTO> create(AuthorRequestDTO request);

    /**
     * Update author
     * @param id author id
     * @param request {@link AuthorRequestDTO}
     * @return {@link AuthorDTO}
     */
    ResponseEntity<AuthorDTO> update(UUID id, AuthorRequestDTO request);

    /**
     * Delete author by id
     * @param id author id
     * @return empty response
     */
    ResponseEntity deleteById(UUID id);
}
