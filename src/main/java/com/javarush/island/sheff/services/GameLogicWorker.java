package com.javarush.island.sheff.services;

import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import com.javarush.island.sheff.entities.map.Cell;
import com.javarush.island.sheff.entities.map.GameMap;
import com.javarush.island.sheff.entities.organisms.Organism;
import com.javarush.island.sheff.exception.InitGameException;
import com.javarush.island.sheff.view.SimulatorView;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class GameLogicWorker extends Thread {

    private int day;
    private final SimulatorView simulatorView;
    private final GameMap gameMap;
    private int transferCount;
    private ConcurrentMap<Integer, Cell[]> rows = new ConcurrentHashMap<>();
    private ConcurrentMap<Integer, HashSet<Organism>> organisms;
    private List<Task> callEatTasks;
    private List<Task> callSpawnTasks;
    private List<Task> callSelectOfDirectionTasks;
    private List<Task> transferAnimalsTasks;
    private List<Task> callEndTurnTasks;

    ListeningExecutorService executorService;

    public GameLogicWorker(SimulatorView simulatorView, GameMap gameMap) {
        this.simulatorView = simulatorView;
        this.gameMap = gameMap;
    }

    public void initialize() {
        this.transferCount = gameMap.getTransferCount();
        IntStream.range(0, gameMap.getCells().length).forEach(i -> rows.put(i, gameMap.getCells()[i]));
        simulatorView.startView(gameMap);

        callEatTasks = new ArrayList<>();
        for (int i = 0; i < gameMap.getCells().length; i++) {
            CallEatTask callEatTask = new CallEatTask(rows.get(i));
            callEatTasks.add(callEatTask);
        }
        callSpawnTasks = new ArrayList<>();
        for (int i = 0; i < gameMap.getCells().length; i++) {
            CallSpawnTask callSpawnTask = new CallSpawnTask(rows.get(i));
            callSpawnTasks.add(callSpawnTask);
        }
        callSelectOfDirectionTasks = new ArrayList<>();
        for (int i = 0; i < gameMap.getCells().length; i++) {
            CallSelectOfDirectionTask callSelectOfDirectionTask = new CallSelectOfDirectionTask(rows.get(i));
            callSelectOfDirectionTasks.add(callSelectOfDirectionTask);
        }
        callEndTurnTasks = new ArrayList<>();
        for (int i = 0; i < gameMap.getCells().length; i++) {
            CallEndTurnTask callEndTurnTask = new CallEndTurnTask(rows.get(i));
            callEndTurnTasks.add(callEndTurnTask);
        }
    }

    @Override
    public void run() {
        try {
            runTasks(callEatTasks);
            runTasks(callSpawnTasks);
            runTasks(callSelectOfDirectionTasks);

            organisms = gameMap.getAllOrganismsMap();
            transferAnimalsTasks = new ArrayList<>();
            for (int i = 0; i < gameMap.getCells().length; i++) {
                TransferAnimalsTask transferAnimalsTask = new TransferAnimalsTask(rows.get(i), organisms.get(i));
                transferAnimalsTasks.add(transferAnimalsTask);
            }
            runTasks(transferAnimalsTasks);
            gameMap.updateCells();
            runTasks(callEndTurnTasks);
            simulatorView.updateView(++day);
        } catch (InterruptedException | ExecutionException e) {
            throw new InitGameException("Problem with multithreading " + e);
        }
    }

    private void runTasks(List<Task> tasks) throws InterruptedException, ExecutionException {
        executorService = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(rows.size()));
        List<Future<Long>> futures = executorService.invokeAll(tasks);
        for (Future<Long> f : futures) {
            System.out.println(f.get());
        }
        executorService.shutdown();
        if (executorService.isShutdown()) {
            System.out.println("FINISH");
        }
    }
}