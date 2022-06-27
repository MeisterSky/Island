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
    private final ImmutableMap<String, Organism> organismMap;

    OrganismFactorySingleton() {

        gsonParser = new JsonParser(Path.of(PATH).toFile());

        organismMap = ImmutableMap.<String, Organism>builder()
                .put(BEAR.getName(), gsonParser.getObject(BEAR))
                .put(BOA.getName(), gsonParser.getObject(BOA))
                .put(BOAR.getName(), gsonParser.getObject(BOAR))
                .put(BUFFALO.getName(), gsonParser.getObject(BUFFALO))
                .put(CATERPILLAR.getName(), gsonParser.getObject(CATERPILLAR))
                .put(DEER.getName(), gsonParser.getObject(DEER))
                .put(DUCK.getName(), gsonParser.getObject(DUCK))
                .put(EAGLE.getName(), gsonParser.getObject(EAGLE))
                .put(FOX.getName(), gsonParser.getObject(FOX))
                .put(GOAT.getName(), gsonParser.getObject(GOAT))
                .put(HORSE.getName(), gsonParser.getObject(HORSE))
                .put(MOUSE.getName(), gsonParser.getObject(MOUSE))
                .put(PLANT.getName(), gsonParser.getObject(PLANT))
                .put(RABBIT.getName(), gsonParser.getObject(RABBIT))
                .put(SHEEP.getName(), gsonParser.getObject(SHEEP))
                .put(WOLF.getName(), gsonParser.getObject(WOLF))
                .build();
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
