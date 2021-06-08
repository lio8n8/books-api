package com.app.books.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

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
}
