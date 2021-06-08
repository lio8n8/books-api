package com.app.books.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

/**
 * Contains author data.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthorDTO {

    /**
     * Author id.
     */
    private UUID id;

    /**
     * Author name.
     */
    private String authorName;

    /**
     * Author email.
     */
    private String email;

    /**
     * Author phone.
     */
    private String phone;
}
