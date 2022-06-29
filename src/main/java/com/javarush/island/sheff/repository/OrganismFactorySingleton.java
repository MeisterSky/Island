package com.javarush.island.sheff.repository;

import com.google.common.collect.ImmutableMap;
import com.javarush.island.sheff.entities.organisms.Limit;
import com.javarush.island.sheff.entities.organisms.Organism;
import com.javarush.island.sheff.util.JsonParser;
import lombok.Getter;

import java.nio.file.Path;
import java.util.*;

import static com.javarush.island.sheff.repository.OrganismTypes.*;

@Getter
public enum OrganismFactorySingleton implements OrganismFactory {
    INSTANCE;

    private static final String PATH = "src/main/resources/organisms.json";

    private final JsonParser gsonParser;
    private final Map<String, Organism> organismMap;

    OrganismFactorySingleton() {

        gsonParser = new JsonParser(Path.of(PATH).toFile());

        organismMap = new HashMap<>();
                organismMap.put(BEAR.getName(), gsonParser.getObject(BEAR));
                organismMap.put(BOA.getName(), gsonParser.getObject(BOA));
                organismMap.put(BOAR.getName(), gsonParser.getObject(BOAR));
                organismMap.put(BUFFALO.getName(), gsonParser.getObject(BUFFALO));
                organismMap.put(CATERPILLAR.getName(), gsonParser.getObject(CATERPILLAR));
                organismMap.put(DEER.getName(), gsonParser.getObject(DEER));
                organismMap.put(DUCK.getName(), gsonParser.getObject(DUCK));
                organismMap.put(EAGLE.getName(), gsonParser.getObject(EAGLE));
                organismMap.put(FOX.getName(), gsonParser.getObject(FOX));
                organismMap.put(GOAT.getName(), gsonParser.getObject(GOAT));
                organismMap.put(HORSE.getName(), gsonParser.getObject(HORSE));
                organismMap.put(MOUSE.getName(), gsonParser.getObject(MOUSE));
                organismMap.put(PLANT.getName(), gsonParser.getObject(PLANT));
                organismMap.put(RABBIT.getName(), gsonParser.getObject(RABBIT));
                organismMap.put(SHEEP.getName(), gsonParser.getObject(SHEEP));
                organismMap.put(WOLF.getName(), gsonParser.getObject(WOLF));
    }

    public Organism getNewOrganism(OrganismTypes organismType) {
        return Objects.requireNonNull(organismMap.get(organismType.getName())).copy();
    }

    public Limit getPrototypeOrganismLimit(OrganismTypes organismType) {
        return Objects.requireNonNull(organismMap.get(organismType.getName())).getLimit();
    }

    public Map<String, HashSet<Organism>> getOrganismNamesMap() {
        Map<String, HashSet<Organism>> organismMap = new HashMap<>();
        this.organismMap.forEach((k, v) -> organismMap.put(k, new HashSet<>()));
        return organismMap;
    }

    @Override
    public String toString() {
        return "OrganismFactorySingleton{" +
                "organismMap=" + organismMap +
                '}';
    }
}
