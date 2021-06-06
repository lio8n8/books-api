package com.app.books.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

/**
 * Contains book request data.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookRequestDTO {

    /**
     * Book name.
     */
    @ApiModelProperty("Book name.")
    @NotEmpty(message = "Book name required.")
    private String bookName;

    /**
     * Amount of published books.
     */
    @ApiModelProperty("Amount of published books.")
    private Integer publishedAmount;

    /**
     * Amount of selled books.
     */
    @ApiModelProperty("Amount of selled books.")
    private Integer soldAmount;
}
