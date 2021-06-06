package com.app.books.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Contains book data.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookDTO {

    /**
     * Book name.
     */
    private String bookName;

    /**
     * Amount of published books.
     */
    private Integer publishedAmount;

    /**
     * Amount of selled books.
     */
    private Integer soldAmount;
}
