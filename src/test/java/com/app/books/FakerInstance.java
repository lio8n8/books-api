package com.app.books;

import com.github.javafaker.Faker;

public class FakerInstance {

    private static final Faker instance = new Faker();

    private FakerInstance() { }

    public static Faker get() {
        return instance;
    }
}
