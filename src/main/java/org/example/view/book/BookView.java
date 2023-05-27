package org.example.view.book;

import org.example.core.utils.TerminalUtils;
import org.example.domain.book.Book;
import org.example.service.book.BookService;
import org.example.service.input.InputService;

import java.util.Arrays;
import java.util.Date;

public class BookView {

    private final InputService inputService;
    private final BookService service;

    public BookView(InputService inputService, BookService service) {
        this.inputService = inputService;
        this.service = service;
    }

    public void showBookManegmentMenu() {
        TerminalUtils.clearScreen();
        header();

        while (true) {
            bookMenu();
            switch (inputService.readNumber()) {
                case 1 -> showReadBookByIdMenu();
                case 2 -> showAllBook();
                case 3 -> showNewBookMenu();
                case 4 -> showUpdateMenu();
                case 0 -> {
                    return;
                }
                default -> System.out.println("Your input is not valid!");
            }


        }
    }

    private void showUpdateMenu() {
        TerminalUtils.clearScreen();
        System.out.println("Please input id (0 to back) :");
        while (true) {
            long id = inputService.readBigNumber();
            if (id == 0) {
                return;
            }

            Book read = service.read(id);
            if (read == null) {
                System.out.println("Id not fount please input again (0 to back)");
                continue;
            }

            System.out.println("you are editing : " + read);

            System.out.println("Input name : (current : " + read.getName() + ")");
            String name = inputService.readWord();
            System.out.println("What isbn number of " + name + "(current : " + read.getIsbn() + ")");
            String isbn = inputService.readWord();
            System.out.println("What date of book writen " + name + "(current : " + read.getWriterDate() + ")");
            Date date = inputService.readDate();

            service.update(id, new Book(
                    name,
                    isbn,
                    date,
                    "ALAKI",
                    1200.0D
            ));

            return;
        }
    }

    private void showAllBook() {
        TerminalUtils.clearScreen();

        System.out.println(Arrays.toString(service.readAll()));
    }

    private void showReadBookByIdMenu() {
        TerminalUtils.clearScreen();

        System.out.println("Enter id of book :");
        long id = inputService.readBigNumber();
        System.out.println(service.read(id));
    }

    private void showNewBookMenu() {
        TerminalUtils.clearScreen();

        System.out.println("Input name :");
        String name = inputService.readWord();
        System.out.println("What isbn number of " + name);
        String isbn = inputService.readWord();
        System.out.println("What date of book writen " + name);
        Date date = inputService.readDate();
        //FIXME
//        System.out.println("What isbn number of " + name);
//        String writerName = inputService.readWord();
//        System.out.println("What isbn number of " + name);
//        String price = inputService.readWord();


        service.create(new Book(
                name,
                isbn,
                date,
                "ALAKI", //TODO
                1200.0D
        ));


    }

    private void bookMenu() {
        System.out.println("1 - Read book by id :");
        System.out.println("2 - Read all book.");
        System.out.println("3 - Add new book :");
        System.out.println("4 - Update book by id :");
        System.out.println();
    }

    private static void header() {
        System.out.println("Book Manegment :");
        System.out.println("========================");
    }


}
