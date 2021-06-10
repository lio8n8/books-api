package com.app.books.repositories;

import com.app.books.models.SuccessAuthorRate;

import java.util.List;

public interface IAuthorsRepositoryExt {

    List<SuccessAuthorRate> findSuccessAuthorRate();
}
