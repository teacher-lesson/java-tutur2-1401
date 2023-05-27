package org.example.service.input;

import org.example.core.exception.CharInvalidateException;
import org.example.service.validation.charvalidation.CharValidation;
import org.example.service.validation.charvalidation.EnglishCharValidation;
import org.example.service.validation.charvalidation.NumberValidation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ConsoleService implements InputService {
    private final Scanner scanner;
    private final CharValidation englishValidation;
    private final CharValidation numberValidation;

    public ConsoleService(Scanner scanner, EnglishCharValidation englishValidation, NumberValidation numberValidation) {
        this.scanner = scanner;
        this.englishValidation = englishValidation;
        this.numberValidation = numberValidation;
    }

    @Override
    public String readWord() {
        return scanner.nextLine();
    }

    @Override
    public String readEnglishWord() {
        while (true) {
            try {
                String input = readWord();
                englishValidation.validateInput(input);
                return input;
            } catch (CharInvalidateException e) {
                System.out.println("Input not validate. Enter again :");
            }
        }
    }

    @Override
    public int readNumber() {
        while (true) {

            try {
                String input = readWord();
                numberValidation.validateInput(input);
                return Integer.parseInt(input);
            } catch (CharInvalidateException ex) {
                System.out.println("Input not validate. Enter again a number:");
            }
        }
    }

    @Override
    public long readBigNumber() {
        while (true) {
            try {
                String input = readWord();
                numberValidation.validateInput(input);
                return Long.parseLong(input);
            } catch (CharInvalidateException ex) {
                System.out.println("Input not validate. Enter again a number:");
            }
        }
    }

    @Override
    public Date readDate() {
        while (true) {
            try {
                String input = readWord();
                SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
                return format.parse(input);
            } catch (ParseException ex) {
                System.out.println("Input not validate. Enter again a number:");
            }
        }
    }
}
