package org.example;

import org.example.service.input.ConsoleService;
import org.example.service.input.InputService;
import org.example.service.validation.charvalidation.EnglishCharValidation;
import org.example.service.validation.charvalidation.NumberValidation;
import org.example.view.MainView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final var inputService = new ConsoleService(new Scanner(System.in), new EnglishCharValidation(), new NumberValidation());
        final var mainView = new MainView(inputService);
        mainView.run();
    }
}