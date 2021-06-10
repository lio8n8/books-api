package com.app.books.converters;

import com.app.books.dto.SuccessAuthorRateDTO;
import com.app.books.models.SuccessAuthorRate;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Converts {@link SuccessAuthorRate} to {@link SuccessAuthorRateDTO}.
 */
@Component
public class SuccessAuthorRateConverter implements Converter<SuccessAuthorRate, SuccessAuthorRateDTO> {

    /**
     * {@inheritDoc}.
     */
    @Override
    public SuccessAuthorRateDTO convert(final SuccessAuthorRate source) {
        return SuccessAuthorRateDTO.builder()
                .authorName(source.getAuthorName())
                .successAuthorRate(source.getSuccessAuthorRate())
                .build();
    }
}
