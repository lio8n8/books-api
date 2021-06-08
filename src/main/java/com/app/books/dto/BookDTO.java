package com.app.books.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

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
     * Book id.
     */
    private UUID id;

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

    /**
     * List of book authors.
     */
    private List<AuthorDTO> authors;
}
