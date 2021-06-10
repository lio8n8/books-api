package com.app.books.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.app.books.serializers.InstantDeserializer;
import com.app.books.serializers.InstantSerializer;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.time.Instant;

/**
 * Contains author request data.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthorRequestDTO {

    /**
     * Author name.
     */
    @NotEmpty(message = "Author name required.")
    @ApiModelProperty(required = true)
    private String authorName;

    /**
     * Author email.
     */
    @NotEmpty(message = "Author email required.")
    @Email
    @ApiModelProperty(required = true)
    private String email;

    /**
     * Author phone.
     */
    private String phone;

    /**
     * Author's birth date.
     */
    // TODO: Add validation for date.
    @JsonDeserialize(using = InstantDeserializer.class)
    @JsonSerialize(using = InstantSerializer.class)
    @ApiModelProperty("Date format: yyyy-MM-dd HH:mm:ss")
    private Instant birthDate;
}
