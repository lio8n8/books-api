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
