package com.app.books.converters;

import com.app.books.dto.AuthorDTO;
import com.app.books.dto.BookDTO;
import com.app.books.models.Book;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

/**
 * Converts {@link Book} to {@link BookDTO}.
 */
@Component
public class BookConverter implements Converter<Book, BookDTO> {

    /**
     * Conversion service.
     */
    private final ConversionService conversionService;

    public BookConverter(@Lazy final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public BookDTO convert(final Book source) {
        BookDTO bookDTO = BookDTO.builder()
                .id(source.getId())
                .bookName(source.getBookName())
                .soldAmount(source.getSoldAmount())
                .publishedAmount(source.getPublishedAmount())
                .successRate(source.getSuccessRate())
                .build();

        if (null != source.getAuthors() && !source.getAuthors().isEmpty()) {
            bookDTO.setAuthors(source.getAuthors()
                    .stream()
                    .map(a -> conversionService.convert(a, AuthorDTO.class))
                    .collect(Collectors.toList()));
        }

        return bookDTO;
    }
}
