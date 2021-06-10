package com.app.books.controllers;

import com.app.books.dto.AuthorDTO;
import com.app.books.dto.AuthorRequestDTO;
import com.app.books.dto.SuccessAuthorRateDTO;
import com.app.books.services.IAuthorsService;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.UUID;

import static com.app.books.Urls.AUTHOR;
import static com.app.books.Urls.AUTHORS;
import static com.app.books.Urls.MOST_SUCCESSFUL_AUTHOR;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Implementation of {@link IAuthorsController}.
 */
@RestController
@AllArgsConstructor
@Api("Authors controller.")
public class AuthorsController implements IAuthorsController {

    /**
     * Conversion service.
     */
    private final ConversionService conversionService;

    /**
     * Authors service.
     */
    private final IAuthorsService authorsService;

    /**
     * {@inheritDoc}
     */
    @Override
    @GetMapping(value = MOST_SUCCESSFUL_AUTHOR, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<SuccessAuthorRateDTO> findSuccessAuthorRate() {
        return new ResponseEntity<>(conversionService.convert(authorsService.findSuccessAuthorRate(), SuccessAuthorRateDTO.class), OK);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @PostMapping(value = AUTHORS, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ApiOperation("Create a new author.")
    public ResponseEntity<AuthorDTO> create(final @Valid @RequestBody AuthorRequestDTO request) {
        return new ResponseEntity<>(conversionService.convert(authorsService.create(request), AuthorDTO.class), CREATED);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @PutMapping(value = AUTHOR, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ApiOperation("Update author data.")
    public ResponseEntity<AuthorDTO> update(final @PathVariable("id") UUID id,
        @Valid @RequestBody final AuthorRequestDTO request) {
        return new ResponseEntity<>(conversionService.convert(authorsService.update(id, request), AuthorDTO.class), OK);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @DeleteMapping(AUTHOR)
    @ApiOperation("Delete author by id.")
    public ResponseEntity deleteById(@PathVariable("id") final UUID id) {
        authorsService.deleteById(id);

        return new ResponseEntity(OK);
    }
}
