package com.example.springintro.service;

import com.example.springintro.model.entity.AgeRestriction;
import com.example.springintro.model.entity.Book;
import com.example.springintro.model.entity.BookSummary;
import com.example.springintro.model.entity.EditionType;

import java.io.IOException;
import java.util.List;

public interface BookService {
    void seedBooks() throws IOException;

    List<Book> findAllBooksAfterYear(int year);

    List<String> findAllAuthorsWithBooksWithReleaseDateBeforeYear(int year);

    List<String> findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(String firstName, String lastName);

    List<String> findAllTitlesByAgeRestriction(String ageRestriction);

    List<String> findAllTitlesByEditionAndCopies(EditionType editionType, int copies);

    List<Book> findAllPriceNotBetween(float lowerBound, float upperBound);

    List<Book> findNotReleasedIn(int releaseYear);

    List<Book> findBooksReleasedBeforeDate(String date);

    List<Book> findAllTitleContaining(String text);

    List<Book> findByAuthorLastNameStartsWith(String search);

    int countBooksWithTitleLongerThan(int length);

    BookSummary getInfoForTitle(String title);

    int addCopiesToBooksAfter(String date, int amount);

    int deleteWithCopiesLessThan(int amount);
}
