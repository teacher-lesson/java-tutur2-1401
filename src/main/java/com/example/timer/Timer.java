package com.example.timer;

import lombok.SneakyThrows;

import javax.swing.*;
import java.io.BufferedWriter;
import java.util.concurrent.atomic.AtomicInteger;

public class Timer implements Runnable{

    private final int time;
    private final OutputWindow window;
    private final AtomicInteger current = new AtomicInteger();
    private boolean running;

    public Timer(int time, OutputWindow bufferedWriter) {
        this.time = time;
        window = bufferedWriter;
        current.set(time);
        running = true;
        SwingUtilities.invokeLater(window);
    }

    @Override
    @SneakyThrows
    public void run() {
        while (current.get() > 0) {
            Thread.sleep(1000);
            window.println(String.valueOf(current.get()));
            if (!isRunning()){
                window.clean();
                return;
            }
            current.getAndDecrement();
        }
        SoundUtils.tone(500,500);
        SoundUtils.tone(400,500);
    }

    public int getCurrent() {
        return current.get();
    }

    public boolean isRunning() {
        return running;
    }

    public Timer setRunning(boolean running) {
        this.running = running;
        return this;
    }

    public void reset() {
        current.set(time);
        setRunning(true);
    }
}
