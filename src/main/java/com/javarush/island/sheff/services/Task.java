package com.javarush.island.sheff.services;

import java.util.concurrent.Callable;

public interface Task extends Callable<Long> {

    @Override
    Long call();
}
