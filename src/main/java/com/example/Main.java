package com.example;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        final String year = JOptionPane.showInputDialog("Input your birthday year");

        final int age = 2023 - Integer.parseInt(year);

        JOptionPane.showMessageDialog(null, String.format("Your age is %d", age));
    }
}
