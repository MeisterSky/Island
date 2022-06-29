package com.javarush.island.sheff.services;

public interface Task extends Runnable {

    @Override
    void run();
}
