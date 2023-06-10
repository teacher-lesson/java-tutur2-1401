package com.example.timer;

import javax.swing.*;
import java.awt.*;
import java.io.PrintWriter;
import java.io.StringWriter;

public class OutputWindow implements Runnable {

    private final String title;
    private final JTextArea outputArea;

    public OutputWindow(String title) {
        this.title = title;
        this.outputArea = new JTextArea(15, 50);
        this.outputArea.setEditable(false);
    }

    @Override
    public void run() {
        JFrame frame = new JFrame(this.title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel outputPanel = new JPanel(new FlowLayout());
        outputPanel.add(outputArea);

        frame.add(outputPanel);
        frame.pack();
        frame.setVisible(true);
        frame.setAlwaysOnTop(true);
    }


    public void clean() {
        outputArea.setText("");
    }
    public void println(String msg) {
        outputArea.append(msg + "\n");
    }

    public void println(Throwable t) {
        this.println(t.toString());
    }

    public void print(String msg) {
        outputArea.append(msg);
    }

    public void printStackTrace(Throwable t) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        t.printStackTrace(pw);
        this.println(sw.toString());
    }

}
