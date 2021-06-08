package com.app.books.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.util.Set;
import java.util.UUID;

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
    @ApiModelProperty(value = "Book name.", required = true)
    @NotEmpty(message = "Book name required.")
    private String bookName;

    /**
     * Amount of published books.
     */
    @ApiModelProperty(value = "Amount of published books.", required = true)
    private Integer publishedAmount;

    /**
     * Amount of selled books.
     */
    @ApiModelProperty(value = "Amount of selled books.", required = true)
    private Integer soldAmount;

    /**
     * Set of author ids.
     */
    @ApiModelProperty(value = "Authors.", required = true)
    @NotEmpty(message = "The book should contain at least one author.")
    private Set<UUID> authorIds;
}
