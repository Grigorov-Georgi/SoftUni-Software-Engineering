package com.example.demo;

import com.example.demo.entities.Author;
import com.example.demo.entities.Book;
import com.example.demo.repositories.AuthorRepository;
import com.example.demo.repositories.BookRepository;
import com.example.demo.services.SeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private final SeedService seedService;
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @Autowired
    public ConsoleRunner(SeedService seedService, BookRepository bookRepository, AuthorRepository authorRepository){
        this.seedService = seedService;
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public void run(String... args) throws Exception {
//        this.seedService.seedAuthors();
//        this.seedService.seedCategories();
//        this.seedService.seedAll();

//        this._01_booksAfter2000();
//        this._02_allAuthorsWithBookBefore1990();
//        this._03_allAuthorsOrderedByBookCount();
        this._04_getAllBooksFromGeorgePowell();
    }

    private void _04_getAllBooksFromGeorgePowell() {
        List<Author> author = this.authorRepository.findByFirstNameAndLastName("George", "Powell");
        List<Book> books = this.bookRepository.findAllByAuthorOrderByReleaseDateDescTitleAsc(author.get(0));
        books.forEach(b -> System.out.println(b.getTitle() + " " + b.getReleaseDate() + " " + b.getCopies()));
    }

    private void _03_allAuthorsOrderedByBookCount() {
        List<Author> authors = this.authorRepository.findAll();

        authors.stream()
                .sorted(Comparator.comparingInt(l -> l.getBooks().size()))
                .forEach(author -> System.out.println(author.getFirstName() + " " + author.getLastName()));

    }

    private void _02_allAuthorsWithBookBefore1990() {
        LocalDate year1990 = LocalDate.of(1990, 1, 1);
        List<Author> authors = this.authorRepository.findDistinctByBooksReleaseDateBefore(year1990);
        authors.forEach(a -> System.out.println(a.getFirstName() + " " + a.getLastName()));
    }

    private void _01_booksAfter2000() {
        LocalDate year2000 = LocalDate.of(2000, 12 ,31);
        List<Book> books = bookRepository.findByReleaseDateAfter(year2000);
        books.forEach(b -> System.out.println(b.getReleaseDate() + " " + b.getTitle()));
    }
}
