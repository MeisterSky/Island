package com.javarush.island.sheff;

import com.javarush.island.sheff.entities.map.Cell;
import com.javarush.island.sheff.entities.map.GameMap;
import com.javarush.island.sheff.entities.organisms.Limit;
import com.javarush.island.sheff.entities.organisms.Organism;
import com.javarush.island.sheff.entities.organisms.animals.Animal;
import com.javarush.island.sheff.entities.organisms.animals.predators.Bear;
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
    void animalEatTest() {

        Organism testBear = organismFactory.getNewOrganism(BEAR);
        testBear.setWeight(500);
        Organism testBoa1 = organismFactory.getNewOrganism(BOA);
        testBoa1.setWeight(10);
        Organism testBoa2 = organismFactory.getNewOrganism(BOA);
        testBoa2.setWeight(10);
        Organism testGoat = organismFactory.getNewOrganism(BOA);
        testGoat.setWeight(10);
        Organism testWolf = organismFactory.getNewOrganism(WOLF);
        testWolf.setWeight(50);

        Map<String, HashSet<Organism>> organisms = Map.ofEntries(
                entry ("Bear", new HashSet<>(List.of(testBear))),
                entry ("Boa", new HashSet<>(List.of(testBoa1, testBoa2))),
                entry ("Goat", new HashSet<>(List.of(testGoat))),
                entry ("Wolf", new HashSet<>(List.of(testWolf))));

        currentCell.setResidents(organisms);

        Animal hungryBear = (Animal) bear;

        int[] offspring = {0, 0};
        Map<String, Integer> ration = Map.ofEntries(
                entry("Boa", 100),
                entry("Goat", 100));

        Limit limitOfHungryBear = new Limit(500, 80, 5, 2, 0, offspring, ration);

        hungryBear.setLimit(limitOfHungryBear);
        hungryBear.setWeight(400);
        Map<String, HashSet<Organism>> result = hungryBear.eat(currentCell);

        assertEquals(4, result.size());
        assertTrue(result.get("Bear").stream().findFirst().isPresent(), "testBear is missing");
        assertTrue(result.get("Boa").stream().findFirst().isPresent(), "testBoa is missing");
        assertTrue(result.get("Goat").stream().findFirst().isPresent(), "testGoat is missing");
        assertTrue(result.get("Wolf").stream().findFirst().isPresent(), "testWolf is missing");
        assertEquals(500, result.get("Bear").stream().findFirst().get().getWeight(), "Changed weight of testBear, but should not have");
        assertEquals(0, result.get("Boa").stream().findFirst().get().getWeight(), "The weight of testBoa has not changed, but it should have");
        assertEquals(0, result.get("Goat").stream().findFirst().get().getWeight(), "The weight of testGoat has not changed, but it should have");
        assertEquals(50, result.get("Wolf").stream().findFirst().get().getWeight(), "Changed weight of testWolf, but should not have");
    }
}
