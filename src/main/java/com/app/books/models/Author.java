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
import java.time.Instant;
import java.util.UUID;

import static javax.persistence.GenerationType.AUTO;

/**
 * Author entity.
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode
@Table(name = "author")
public class Author {

    /**
     * Book id.
     */
    @Id
    @GeneratedValue(strategy = AUTO)
    private UUID id;

    /**
     * Author name.
     */
    @Column(name = "author_name")
    private String authorName;

    /**
     * Author email.
     */
    private String email;

    /**
     * Author phone.
     */
    private String phone;

    /**
     * Author birth date.
     */
    @Column(name = "birth_date", columnDefinition = "TIMESTAMP WITH TIME ZONE")
    private Instant birthDate;
}

