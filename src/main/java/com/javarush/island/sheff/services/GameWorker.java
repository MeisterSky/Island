package com.javarush.island.sheff.services;

import com.javarush.island.sheff.entities.Game;
import com.javarush.island.sheff.repository.Settings;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
public class GameWorker extends Thread {
    public static final int CORE_POOL_SIZE = 4;
    private Game game;
    private final int DURATION = Settings.DURATION.getValue();;

    @Override
    public void run() {
//        SimulatorView view = game.getView();
//        view.showMap();
//        view.showStatistics();

        ScheduledExecutorService mainPool = Executors.newScheduledThreadPool(CORE_POOL_SIZE);
    }

    private void runWorkers(List<OrganismWorker> workers) {
        ExecutorService servicePool = Executors.newFixedThreadPool(CORE_POOL_SIZE);
        workers.forEach(servicePool::submit);
        servicePool.shutdown();
        awaitPool(servicePool);
    }

    @SneakyThrows
    private void awaitPool(ExecutorService servicePool) {
        if (servicePool.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS)) {
//            view.showScale();
//            view.showMap();
//            view.showStatistics();
        }

    }
}
