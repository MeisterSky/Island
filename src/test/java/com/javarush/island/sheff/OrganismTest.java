package com.javarush.island.sheff;

import com.javarush.island.sheff.entities.abstraction.behavior.Moving;
import com.javarush.island.sheff.entities.map.Cell;
import com.javarush.island.sheff.entities.map.GameMap;
import com.javarush.island.sheff.entities.organisms.Organism;
import com.javarush.island.sheff.entities.organisms.animals.Animal;
import com.javarush.island.sheff.repository.GameMapCreator;
import com.javarush.island.sheff.repository.OrganismFactory;
import com.javarush.island.sheff.repository.OrganismFactorySingleton;
import com.javarush.island.sheff.repository.OrganismTypes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static com.javarush.island.sheff.repository.OrganismTypes.*;
import static java.util.Map.entry;
import static org.junit.jupiter.api.Assertions.*;

public class OrganismTest {

    private OrganismFactory organismFactory;
    private GameMapCreator gameMapCreator;
    private GameMap gameMap;
    private Organism bear;
    private Cell currentCell;
    private Map<String, HashSet<Organism>> residents;

    @BeforeEach
    void setUp() {
        organismFactory = OrganismFactorySingleton.INSTANCE;
        gameMapCreator = new GameMapCreator(organismFactory);
        gameMap = gameMapCreator.createRandomStartGameMap(1, 1, 2, false);
        bear = organismFactory.getNewOrganism(BEAR);
        Cell[][] cells = gameMap.getCells();
        currentCell = cells[0][0];
        residents = currentCell.getResidents();
    }

    @Test
    void creatingEachOrganismTest() {

        Map<String, HashSet<Organism>> organisms = Map.ofEntries(
                entry ("Bear", new HashSet<>(List.of(organismFactory.getNewOrganism(BEAR)))),
                entry ("Boa", new HashSet<>(List.of(organismFactory.getNewOrganism(BOA)))),
                entry ("Boar", new HashSet<>(List.of(organismFactory.getNewOrganism(BOAR)))),
                entry ("Buffalo", new HashSet<>(List.of(organismFactory.getNewOrganism(BUFFALO)))),
                entry ("Caterpillar", new HashSet<>(List.of(organismFactory.getNewOrganism(CATERPILLAR)))),
                entry ("Deer", new HashSet<>(List.of(organismFactory.getNewOrganism(DEER)))),
                entry ("Duck", new HashSet<>(List.of(organismFactory.getNewOrganism(DUCK)))),
                entry ("Eagle", new HashSet<>(List.of(organismFactory.getNewOrganism(EAGLE)))),
                entry ("Fox", new HashSet<>(List.of(organismFactory.getNewOrganism(FOX)))),
                entry ("Goat", new HashSet<>(List.of(organismFactory.getNewOrganism(GOAT)))),
                entry ("Horse", new HashSet<>(List.of(organismFactory.getNewOrganism(HORSE)))),
                entry ("Mouse", new HashSet<>(List.of(organismFactory.getNewOrganism(MOUSE)))),
                entry ("Plant", new HashSet<>(List.of(organismFactory.getNewOrganism(PLANT)))),
                entry ("Rabbit", new HashSet<>(List.of(organismFactory.getNewOrganism(RABBIT)))),
                entry ("Sheep", new HashSet<>(List.of(organismFactory.getNewOrganism(SHEEP)))),
                entry ("Wolf", new HashSet<>(List.of(organismFactory.getNewOrganism(WOLF)))));

        assertEquals(16, organisms.size());
        organisms.forEach((key, value) -> {
            assertTrue(value.stream().findFirst().isPresent());
            assertEquals(value.stream().findFirst().get().getClass(), OrganismTypes.valueOf(key.toUpperCase()).getType());
        });
    }

    @Test
    void animalMoveTest() {

        Map<String, HashSet<Organism>> filtered = new HashMap<>();

        Map<String, HashSet<Organism>> organisms = Map.ofEntries(
                entry ("Bear", new HashSet<>(List.of(organismFactory.getNewOrganism(BEAR)))),
                entry ("Boa", new HashSet<>(List.of(organismFactory.getNewOrganism(BOA)))),
                entry ("Boar", new HashSet<>(List.of(organismFactory.getNewOrganism(BOAR)))),
                entry ("Buffalo", new HashSet<>(List.of(organismFactory.getNewOrganism(BUFFALO)))),
                entry ("Caterpillar", new HashSet<>(List.of(organismFactory.getNewOrganism(CATERPILLAR)))),
                entry ("Deer", new HashSet<>(List.of(organismFactory.getNewOrganism(DEER)))),
                entry ("Duck", new HashSet<>(List.of(organismFactory.getNewOrganism(DUCK)))),
                entry ("Eagle", new HashSet<>(List.of(organismFactory.getNewOrganism(EAGLE)))),
                entry ("Fox", new HashSet<>(List.of(organismFactory.getNewOrganism(FOX)))),
                entry ("Goat", new HashSet<>(List.of(organismFactory.getNewOrganism(GOAT)))),
                entry ("Horse", new HashSet<>(List.of(organismFactory.getNewOrganism(HORSE)))),
                entry ("Mouse", new HashSet<>(List.of(organismFactory.getNewOrganism(MOUSE)))),
                entry ("Plant", new HashSet<>(List.of(organismFactory.getNewOrganism(PLANT)))),
                entry ("Rabbit", new HashSet<>(List.of(organismFactory.getNewOrganism(RABBIT)))),
                entry ("Sheep", new HashSet<>(List.of(organismFactory.getNewOrganism(SHEEP)))),
                entry ("Wolf", new HashSet<>(List.of(organismFactory.getNewOrganism(WOLF)))));

        Animal bear = (Animal) organismFactory.getNewOrganism(BEAR);

            filtered = bear.filterByRation(organisms);
            System.out.println(filtered);

    }
}
