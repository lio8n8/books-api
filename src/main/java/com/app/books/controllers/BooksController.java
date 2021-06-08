package com.app.books.controllers;

import com.app.books.dto.BookDTO;
import com.app.books.dto.BookRequestDTO;
import com.app.books.dto.SearchRequestDTO;
import com.app.books.services.IBooksService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.app.books.Urls.BOOKS;
import static com.app.books.Urls.BOOK;
import static com.app.books.Urls.BOOKS_SEARCH;
import static com.app.books.Urls.MOST_PUBLISHED;
import static com.app.books.Urls.MOST_PUBLISHED_BOOKS_LIST;
import static com.app.books.Urls.MOST_SELLING_BOOK;
import static com.app.books.Urls.MOST_SELLING_BOOKS_LIST;
import static com.app.books.Urls.MOST_SUCCESSFUL_BOOKS_LIST;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Implementation of {@link IBooksController}
 */
@RestController
@AllArgsConstructor
@Api("Books controller.")
public class BooksController implements IBooksController {

    /**
     * Books service.
     */
    private final IBooksService booksService;

    /**
     * Conversion service.
     */
    private final ConversionService conversionService;

    /**
     * {@inheritDoc}
     */
    @Override
    @GetMapping(value = BOOKS_SEARCH, produces = APPLICATION_JSON_VALUE)
    @ApiOperation("Find books by author name.")
    public ResponseEntity<Collection<BookDTO>> findAllByAuthorName(@RequestParam("authorname") final String authorName) {
        return new ResponseEntity<>(
                booksService.findByAuthorName(authorName)
                        .stream()
                        .map(b -> conversionService.convert(b, BookDTO.class)).collect(Collectors.toList()), OK);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @GetMapping(value = MOST_SELLING_BOOK, produces = APPLICATION_JSON_VALUE)
    @ApiOperation("Find the most selling book by author name.")
    public ResponseEntity<BookDTO> findMostSellingByAuthorName(@RequestParam("authorname")final String authorName) {
        return new ResponseEntity<>(conversionService.convert(
                booksService.findMostSellingBookByAuthorName(authorName), BookDTO.class), OK);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @GetMapping(value = MOST_PUBLISHED, produces = APPLICATION_JSON_VALUE)
    @ApiOperation("Find the most published book by author name.")
    public ResponseEntity<BookDTO> findMostPublishedByAuthorName(@RequestParam("authorname") final String authorName) {
        return new ResponseEntity<>(conversionService.convert(
                booksService.findMostPublishedBookByAuthorName(authorName), BookDTO.class), OK);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @PostMapping(
            value = MOST_SELLING_BOOKS_LIST,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE
    )
    @ApiOperation("Find most selling book list by author name")
    public ResponseEntity<Collection<BookDTO>> findMostSelling(@Valid @RequestBody final SearchRequestDTO request) {
        return new ResponseEntity<>(
                booksService.findByAuthorAndSortBySoldAmount(request)
                        .stream()
                        .map(b -> conversionService.convert(b, BookDTO.class)).collect(Collectors.toList()), OK);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @PostMapping(
            value = MOST_PUBLISHED_BOOKS_LIST,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE
    )
    @ApiOperation("Find most published book list by author name.")
    public ResponseEntity<Collection<BookDTO>> findMostPublished(@Valid @RequestBody final SearchRequestDTO request) {
        return new ResponseEntity<>(
                booksService.findByAuthorAndSortByPublishedAmount(request)
                        .stream()
                        .map(b -> conversionService.convert(b, BookDTO.class)).collect(Collectors.toList()), OK);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @PostMapping(
            value = MOST_SUCCESSFUL_BOOKS_LIST,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE
    )
    @ApiOperation("Find most successful book list by author name.")
    public ResponseEntity<Collection<BookDTO>> findMostSuccessful(@Valid @RequestBody final SearchRequestDTO request) {
        return new ResponseEntity<>(
                booksService.findByAuthorAndSortBySuccessRate(request)
                        .stream()
                        .map(b -> conversionService.convert(b, BookDTO.class)).collect(Collectors.toList()), OK);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @PostMapping(value = BOOKS, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ApiOperation("Create a new book.")
    public ResponseEntity<BookDTO> create(final @Valid @RequestBody BookRequestDTO request) {
        return new ResponseEntity<>(conversionService.convert(booksService.create(request), BookDTO.class), CREATED);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @PutMapping(value = BOOK,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE
    )
    @ApiOperation("Update book.")
    public ResponseEntity<BookDTO> update(@PathVariable("id") final UUID id,
        @Valid @RequestBody final BookRequestDTO request) {
        return new ResponseEntity<>(conversionService.convert(booksService.update(id, request), BookDTO.class), OK);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @DeleteMapping(BOOK)
    @ApiOperation("Delete book by id.")
    public ResponseEntity deleteById(@PathVariable("id") final UUID id) {
        booksService.deleteById(id);

        return new ResponseEntity(OK);
    }
}
