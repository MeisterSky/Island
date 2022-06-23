package com.javarush.island.sheff.repository;

public enum Singleton {
    INSTANCE;
    private Singleton() {
        System.out.println("Here");
    }

}
