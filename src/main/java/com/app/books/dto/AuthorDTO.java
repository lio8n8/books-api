package com.app.books.dto;

import com.app.books.serializers.InstantDeserializer;
import com.app.books.serializers.InstantSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
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

    /**
     * Author's birth date.
     */
    @JsonDeserialize(using = InstantDeserializer.class)
    @JsonSerialize(using = InstantSerializer.class)
    private Instant birthDate;
}
