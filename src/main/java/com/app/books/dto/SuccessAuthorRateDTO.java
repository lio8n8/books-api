package com.app.books.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Contains author data with computed success author rate.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SuccessAuthorRateDTO {

    /**
     * Author name.
     */
    private String authorName;

    /**
     * Success author rate (sum of all successBootRate/number of books).
     */
    private Double successAuthorRate;
}
