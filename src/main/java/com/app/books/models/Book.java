package com.app.books.models;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.ManyToMany;
import java.util.UUID;

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
}
