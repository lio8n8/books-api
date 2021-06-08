package com.app.books;

/**
 * Contains application urls.
 */
public interface Urls {

    /**
     * Api
     */
    String API = "/api";

    /**
     * Version.
     */
    String V1 = API + "/v1";

    /**
     * Books url;
     */
    String BOOKS = V1 + "/books";

    /**
     * Endpoint url to search books by different criterias.
     */
    String BOOKS_SEARCH = BOOKS + "/search";

    /**
     * Endpoint url to get the most selling book.
     */
    String MOST_SELLING_BOOK = BOOKS + "/most-selling";

    /**
     * Endpoint url to get most selling books list.
     */
    String MOST_SELLING_BOOKS_LIST = BOOKS + "/most-selling-list";

    /**
     * Endpoint url to get the most published book.
     */
    String MOST_PUBLISHED = BOOKS + "/most-published";

    /**
     * Endpoint url to get most published books list.
     */
    String MOST_PUBLISHED_BOOKS_LIST = BOOKS + "most-published-list";

    /**
     * Book url.
     */
    String BOOK = BOOKS + "/{id}";

    /**
     * Authors url.
     */
    String AUTHORS = V1 + "/authors";

    /**
     * Author url.
     */
    String AUTHOR = AUTHORS + "/{id}";
}
