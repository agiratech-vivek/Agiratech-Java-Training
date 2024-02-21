package org.multithreading.thread;

public class Downloader extends Thread{

    private String name;

    public Downloader(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        if(currentThread().isAlive()) {
            System.out.println(name + " finished downloading.");
        }
    }
}
