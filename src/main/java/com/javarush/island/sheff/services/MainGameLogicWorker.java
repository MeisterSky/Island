package com.javarush.island.sheff.services;

import com.javarush.island.sheff.entities.map.GameMap;
import com.javarush.island.sheff.repository.GameMapCreator;
import com.javarush.island.sheff.repository.OrganismFactory;
import com.javarush.island.sheff.repository.OrganismFactorySingleton;
import com.javarush.island.sheff.repository.OrganismTypes;
import com.javarush.island.sheff.view.SimulatorView;
import lombok.SneakyThrows;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

import static com.javarush.island.sheff.repository.Settings.*;

public class MainGameLogicWorker extends Thread {

    public static final int CORE_POOL_SIZE = ROWS.getValue();
    public static SimulatorView simulatorView = new SimulatorView();

    @SneakyThrows
    public static void main(String[] args) {

        OrganismFactory organismFactory = OrganismFactorySingleton.INSTANCE;
        GameMapCreator gameMapCreator = new GameMapCreator(organismFactory);
        GameMap gameMap = gameMapCreator.createRandomStartGameMapFromSettings();
        int transferCount = gameMap.getAllOrganisms()
                .stream()
                .max((o1, o2) -> Math.max(o1.getLimit().getMaxSpeed(), o2.getLimit().getMaxSpeed()))
                .orElse(organismFactory.getNewOrganism(OrganismTypes.HORSE)).getLimit().getMaxSpeed();

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(CORE_POOL_SIZE);

        List<CallSpawnTask> callSpawnTasks = Arrays.stream(gameMap
                        .getCells())
                .map(CallSpawnTask::new)
                .toList();

        List<CallEatTask> callEatTasks = Arrays.stream(gameMap
                        .getCells())
                .map(CallEatTask::new)
                .toList();

        List<CallSelectOfDirectionTask> callSelectOfDirectionTasks = Arrays.stream(gameMap
                        .getCells())
                .map(CallSelectOfDirectionTask::new)
                .toList();

        List<TransferAnimalsTask> transferAnimalsTasks = Arrays.stream(gameMap
                        .getCells())
                .map(TransferAnimalsTask::new)
                .toList();

        List<CallEndTurnTask> callEndTurnTasks = Arrays.stream(gameMap
                        .getCells())
                .map(CallEndTurnTask::new)
                .toList();

        scheduledExecutorService.scheduleAtFixedRate(() -> {
            runTasks(callSpawnTasks);
            runTasks(callEatTasks);
            for (int i = 0; i < transferCount; i++) {
                runTasks(callSelectOfDirectionTasks);
                runTasks(transferAnimalsTasks);
            }
            runTasks(callEndTurnTasks);
        }, DURATION.getValue(), DURATION.getValue(), TimeUnit.MILLISECONDS);
    }

    private static void runTasks(List<? extends Task> tasks) {
        ExecutorService servicePool = Executors.newFixedThreadPool(tasks.size());
        tasks.forEach(servicePool::submit);
        servicePool.shutdown();
        awaitPool(servicePool);
    }

    @SneakyThrows
    private static void awaitPool(ExecutorService servicePool) {
        if (servicePool.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS)) {
            simulatorView.update();
        }
    }
}
