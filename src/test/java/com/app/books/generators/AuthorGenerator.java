package com.app.books.generators;

import com.app.books.FakerInstance;
import com.app.books.dto.AuthorRequestDTO;
import com.app.books.models.Author;

/**
 * Author generator.
 */
public class AuthorGenerator {

    public static Author generateAuthor() {
        return  Author.builder()
                .authorName(FakerInstance.get().name().username())
                .email(FakerInstance.get().internet().emailAddress())
                .phone(FakerInstance.get().phoneNumber().phoneNumber())
                .build();
    }

    public static AuthorRequestDTO generateAuthorRequest() {
        return AuthorRequestDTO.builder()
                .authorName(FakerInstance.get().name().username())
                .email(FakerInstance.get().internet().emailAddress())
                .phone(FakerInstance.get().phoneNumber().phoneNumber())
                .build();
    }
}