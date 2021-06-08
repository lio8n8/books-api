package com.app.books.services;

import com.app.books.dto.BookRequestDTO;
import com.app.books.dto.SearchRequestDTO;
import com.app.books.models.Author;
import com.app.books.models.Book;
import com.app.books.repositories.IBooksRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Implementation of {@link IBooksService}.
 */
@Service
@AllArgsConstructor
public class BooksService implements IBooksService {

    /**
     * Books repository.
     */
    private final IBooksRepository booksRepository;

    /**
     * Authors service.
     */
    private final IAuthorsService authorsService;

    /**
     * {@inheritDoc}.
     */
    @Override
    public Book findById(final UUID id) {
        return booksRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found."));
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public List<Book> findByAuthorName(final String authorName) {
        return booksRepository.findByAuthorsAuthorName(authorName);
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public Book findMostSellingBookByAuthorName(final String authorName) {
        return booksRepository.findTopByAuthorsAuthorNameOrderBySoldAmountDesc(authorName);
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public Book findMostPublishedBookByAuthorName(final String authorName) {
        return booksRepository.findTopByAuthorsAuthorNameOrderByPublishedAmountDesc(authorName);
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public List<Book> findByAuthorAndSortBySoldAmount(final SearchRequestDTO request) {
        return booksRepository.findByAuthorsAuthorNameContainingIgnoreCaseOrderBySoldAmountDesc(request.getSearchQuery());
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public List<Book> findByAuthorAndSortByPublishedAmount(final SearchRequestDTO request) {
        return booksRepository.findByAuthorsAuthorNameContainingIgnoreCaseOrderByPublishedAmountDesc(request.getSearchQuery());
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public List<Book> findByAuthorAndSortBySuccessRate(final SearchRequestDTO request) {
        return booksRepository.findByAuthorsAuthorNameContainingIgnoreCaseOrderBySuccessRateDesc(request.getSearchQuery());
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public Book create(final BookRequestDTO request) {
        return booksRepository.save(Book.builder()
                .bookName(request.getBookName())
                .publishedAmount(request.getPublishedAmount())
                .soldAmount(request.getSoldAmount())
                .authors(buildAuthorsList(request.getAuthorIds()))
                .build());
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public Book update(final UUID id, final BookRequestDTO request) {
        Book book = findById(id);

        book.setBookName(request.getBookName());
        book.setPublishedAmount(request.getPublishedAmount());
        book.setSoldAmount(request.getSoldAmount());

        book.getAuthors().clear();
        book.getAuthors().addAll(buildAuthorsList(request.getAuthorIds()));

        return booksRepository.save(book);
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public void deleteById(final UUID id) {
        booksRepository.deleteById(id);
    }

    /**
     * Find all authors by id and create list.
     * @param ids list of author ids.
     * @return list of authors.
     * @throws RuntimeException throws exception if author does not exist.
     */
    private List<Author> buildAuthorsList(final Set<UUID> ids) {
        return ids.stream().map(authorsService::findById).collect(Collectors.toList());
    }
}
