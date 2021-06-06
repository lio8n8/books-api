package com.app.books.services;

import com.app.books.dto.AuthorRequestDTO;
import com.app.books.models.Author;

import java.util.UUID;

/**
 * Contains operations related to authors.
 */
public interface IAuthorsService {

    /**
     * Find by id
     *
     * @param id author id
     *
     * @return {@link Author}
     */
    public Author findById(UUID id);

    /**
     * Create author
     *
     * @param request {@link AuthorRequestDTO}
     *
     * @return created {@link Author}
     */
    public Author create(AuthorRequestDTO request);

    /**
     * Update author
     *
     * @param id author id
     * @param request {@link AuthorRequestDTO}
     *
     * @return updated {@link Author}
     */
    public Author update(UUID id, AuthorRequestDTO request);

    /**
     * Delete by author id.
     * @param id
     */
    public void deleteById(UUID id);
}
