package com.example.frame;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        final JFrame jFrame = new JFrame();
        jFrame.setSize(500, 500);
        jFrame.setVisible(true);
        jFrame.setLayout(new FlowLayout());
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jFrame.setTitle("THIS IS TEST");

        final JLabel thisIsLable = new JLabel("This is lable");
//        thisIsLable.setToolTipText("Mouse hover this");

        jFrame.add(thisIsLable);

        final JButton btn = new JButton("Btn");
        btn.setEnabled(false);

        jFrame.add(btn);

    }
}
