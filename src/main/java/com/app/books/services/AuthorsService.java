package com.app.books.services;

import com.app.books.dto.AuthorRequestDTO;
import com.app.books.models.Author;
import com.app.books.repositories.IAuthorsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Implementation of {@link IAuthorsService}.
 */
@Service
@AllArgsConstructor
public class AuthorsService implements IAuthorsService {

    /**
     * Authors repository.
     */
    private final IAuthorsRepository authorsRepository;

    /**
     * {@inheritDoc}.
     */
    @Override
    public Author findById(final UUID id) {
        return authorsRepository.findById(id).orElseThrow(() -> new RuntimeException("Author not found."));
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public Author create(final AuthorRequestDTO request) {
        return authorsRepository.save(Author.builder()
                .authorName(request.getAuthorName())
                .email(request.getEmail())
                .phone(request.getPhone())
                .build());
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public Author update(final UUID id, final AuthorRequestDTO request) {
        Author author = findById(id);

        author.setAuthorName(request.getAuthorName());
        author.setEmail(request.getEmail());
        author.setPhone(request.getPhone());

        return authorsRepository.save(author);
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public void deleteById(final UUID id) {
        authorsRepository.deleteById(id);
    }
}
