package org.example.view;

import org.example.service.book.BookServiceImpl;
import org.example.service.input.InputService;
import org.example.view.book.BookView;
import org.example.view.member.MemberView;

public class MainView {
    private final InputService inputService;

    public MainView(InputService inputService) {
        this.inputService = inputService;
    }

    public void run() {
        menuHeader();

        BookView bookView = new BookView(inputService, new BookServiceImpl());
        MemberView memberView = new MemberView(inputService);

        while (true) {
            showMenu();
            switch (inputService.readNumber()) {
                case 1 -> bookView.showBookManegmentMenu();
                case 2 -> memberView.showMemberManegmentMenu();
                default -> showErrorMessage();
            }

        }


    }

    private void showErrorMessage() {
        System.out.println("You choise wrong! input form menu");
//        System.out.println();
//        System.out.println();
//        System.out.println();
    }

    public static void showMenu() {
        System.out.println("1 - Book Manegment :");
        System.out.println("2 - Memeber Managment :");
//        System.out.println();
//        System.out.println();
    }

    private static void menuHeader() {
        System.out.println("Library App:");
        System.out.println("====================");
    }
}
