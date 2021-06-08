package com.app.books.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

/**
 * Contains author request data.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SearchRequestDTO {

    /**
     * Search query.
     */
    @NotEmpty(message = "Search query required.")
    @ApiModelProperty(required = true)
    private String searchQuery;
}
