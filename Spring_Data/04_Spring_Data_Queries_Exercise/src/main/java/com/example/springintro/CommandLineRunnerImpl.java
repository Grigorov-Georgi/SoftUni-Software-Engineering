package com.example.springintro;

import com.example.springintro.model.entity.Book;
import com.example.springintro.model.entity.BookSummary;
import com.example.springintro.model.entity.EditionType;
import com.example.springintro.service.AuthorService;
import com.example.springintro.service.BookService;
import com.example.springintro.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Scanner;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;

    public CommandLineRunnerImpl(CategoryService categoryService, AuthorService authorService, BookService bookService) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {
//        seedData();
//        printAllBooksAfterYear(2000);
//        printAllAuthorsNamesWithBooksWithReleaseDateBeforeYear(1990);
//        printAllAuthorsAndNumberOfTheirBooks();
//        pritnALlBooksByAuthorNameOrderByReleaseDate("George", "Powell");
        //01
//        this.bookService.findAllTitlesByAgeRestriction("MiNor").forEach(System.out::println);
        //02
//        this.bookService.findAllTitlesByEditionAndCopies(EditionType.GOLD, 5000).forEach(System.out::println);
        //03
//        this.bookService.findAllPriceNotBetween(5, 40)
//                .forEach(b -> System.out.println(b.getTitle() + " " + b.getPrice()));
        //04
//        this.bookService.findNotReleasedIn(2000)
//                .forEach(b -> System.out.println(b.getTitle()));
        //05
//        this.bookService.findBooksReleasedBeforeDate("12-04-1992")
//                .forEach(b -> System.out.printf("%s %s %.2f%n",
//                        b.getTitle(), b.getEditionType(), b.getPrice()));
        //06
//        this.authorService.findByFirstNameEndingWith("e")
//        .stream()
//        .map(a -> a.getFirstName() + " " + a.getLastName())
//        .forEach(System.out::println);
        //07
//        this.bookService.findAllTitleContaining("WOR")
//        .forEach(b -> System.out.println(b.getTitle()));
        //08
//        this.bookService.findByAuthorLastNameStartsWith("Ric")
//        .forEach(b -> System.out.printf("%s (%s %s)%n",
//                b.getTitle(), b.getAuthor().getFirstName(), b.getAuthor().getLastName()));
        //09
//        int length = 40;
//        int totalBooks = this.bookService.countBooksWithTitleLongerThan(length);
//        System.out.printf("There are %d books with longer title than %d symbols%n", totalBooks, length);
        //10
//        this.authorService.getWithTotalCopies()
//                .forEach(a -> System.out.println(
//                        a.getFirstName() + " " + a.getLastName() + " - " + a.getTotalCopies()));
        //11
//        BookSummary bookSummary = this.bookService.getInfoForTitle("Things Fall Apart");
//        System.out.println(bookSummary.getTitle() + " " + bookSummary.getEditionType() +
//                " " + bookSummary.getAgeRestriction() +
//                " " + bookSummary.getPrice());
        //12
//        String date = "12 Oct 2005";
//        int amount = 100;
//        int booksUpdated = this.bookService.addCopiesToBooksAfter("12 Oct 2005", 100);
//        System.out.printf("%d books are released after %s, " +
//                        "so total of %d book copies were added",
//                booksUpdated, "12 Oct 2005", 100 * booksUpdated);
        //13
//        Scanner scanner = new Scanner(System.in);
//        int amount = Integer.parseInt(scanner.nextLine());
//        this.bookService.deleteWithCopiesLessThan(amount);
    }

    private void pritnALlBooksByAuthorNameOrderByReleaseDate(String firstName, String lastName) {
        bookService
                .findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(firstName, lastName)
                .forEach(System.out::println);
    }

    private void printAllAuthorsAndNumberOfTheirBooks() {
        authorService
                .getAllAuthorsOrderByCountOfTheirBooks()
                .forEach(System.out::println);
    }

    private void printAllAuthorsNamesWithBooksWithReleaseDateBeforeYear(int year) {
        bookService
                .findAllAuthorsWithBooksWithReleaseDateBeforeYear(year)
                .forEach(System.out::println);
    }

    private void printAllBooksAfterYear(int year) {
        bookService
                .findAllBooksAfterYear(year)
                .stream()
                .map(Book::getTitle)
                .forEach(System.out::println);
    }

    private void seedData() throws IOException {
        categoryService.seedCategories();
        authorService.seedAuthors();
        bookService.seedBooks();
    }
}
