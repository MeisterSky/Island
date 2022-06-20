package com.javarush.island.sheff.services;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Job extends Thread{

    ExecutorService threadPool = Executors.newCachedThreadPool();

}
