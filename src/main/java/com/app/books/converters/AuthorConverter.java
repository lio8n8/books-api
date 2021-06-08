package com.app.books.converters;

import com.app.books.dto.AuthorDTO;
import com.app.books.models.Author;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Converts {@link Author} to {@link AuthorDTO}.
 */
@Component
public class AuthorConverter implements Converter<Author, AuthorDTO> {

    /**
     * {@inheritDoc}.
     */
    @Override
    public AuthorDTO convert(final Author source) {
        return AuthorDTO.builder()
                .id(source.getId())
                .authorName(source.getAuthorName())
                .email(source.getEmail())
                .phone(source.getPhone())
                .build();
    }
}
