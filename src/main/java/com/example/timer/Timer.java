package com.example.timer;

import lombok.SneakyThrows;

public class Timer implements Runnable{

    private int time;
    private int current;
    private boolean running;

    public Timer(int time) {
        this.time = time;
        current = time;
        running = true;
    }

    @Override
    @SneakyThrows
    public void run() {
        while (current > 0) {
            Thread.sleep(1000);
            System.out.println(current);
            if (!isRunning()){
                return;
            }
            current--;
        }
        SoundUtils.tone(500,500);
        SoundUtils.tone(400,500);
    }

    public int getCurrent() {
        return current;
    }

    public boolean isRunning() {
        return running;
    }

    public Timer setRunning(boolean running) {
        this.running = running;
        return this;
    }
}
