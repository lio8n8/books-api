package com.app.books.models;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.ManyToMany;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.GenerationType.AUTO;

/**
 * Book entity.
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "book")
@EqualsAndHashCode
public class Book {

    /**
     * Book id.
     */
    @Id
    @GeneratedValue(strategy = AUTO)
    private UUID id;

    /**
     * Book name.
     */
    @Column(name = "book_name")
    private String bookName;

    /**
     * Sold amount of books.
     */
    @Column(name = "sold_amount")
    private Integer soldAmount;

    /**
     * Amount of published books.
     */
    @Column(name = "published_amount")
    private Integer publishedAmount;

    // TODO: Replace List to Set.
    /**
     * List of authors.
     */
    @ManyToMany(cascade = { MERGE, PERSIST })
    @JoinTable(name = "book_author",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private List<Author> authors = new ArrayList<>();
}
