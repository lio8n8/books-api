package com.app.books.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Contains author data with computed success author rate.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@SqlResultSetMapping(name = "calcSuccessAuthorRate",
        columns = { @ColumnResult(name = "authorName", type = String.class),
                @ColumnResult(name = "id", type = String.class),
                @ColumnResult(name = "successAuthorRate", type = Double.class) })
public class SuccessAuthorRate {

    /**
     * Author name.
     */
    private String authorName;

    /**
     * Author id.
     */
    @Id
    private String id;

    /**
     * Success author rate (sum of all successBootRate/number of books).
     */
    private Double successAuthorRate;
}

