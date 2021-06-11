package com.app.books.generators;

import com.app.books.FakerInstance;
import com.app.books.dto.BookRequestDTO;
import com.app.books.models.Book;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Book generator.
 */
public class BookGenerator {
    public static Book generateBook() {
        return  Book.builder()
                .bookName(FakerInstance.get().lorem().sentence())
                .publishedAmount(ThreadLocalRandom.current().nextInt(1, 100))
                .soldAmount(ThreadLocalRandom.current().nextInt(1, 100))
                .build();
    }

    public static BookRequestDTO generateBookRequest() {
        return BookRequestDTO.builder()
                .bookName(FakerInstance.get().lorem().sentence())
                .publishedAmount(ThreadLocalRandom.current().nextInt(1, 100))
                .soldAmount(ThreadLocalRandom.current().nextInt(1, 100))
                .build();
    }
}