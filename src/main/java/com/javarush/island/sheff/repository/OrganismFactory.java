package com.javarush.island.sheff.repository;

import com.google.common.collect.ImmutableMap;
import com.javarush.island.sheff.entity.organisms.Organism;
import com.javarush.island.sheff.util.GsonParser;

import java.nio.file.Path;
import java.util.Objects;

public enum OrganismFactory {
    INSTANCE;

    private final GsonParser gsonParser;
    private final ImmutableMap<String, Organism> organismMap;

    OrganismFactory() {

        gsonParser = new GsonParser(Path.of("src/main/resources/organisms.json"));

        organismMap = ImmutableMap.<String, Organism>builder()
                .put(OrganismTypes.BEAR.getName(), gsonParser.getObject(OrganismTypes.BEAR))
                .put(OrganismTypes.BOA.getName(), gsonParser.getObject(OrganismTypes.BOA))
                .put(OrganismTypes.BOAR.getName(), gsonParser.getObject(OrganismTypes.BOAR))
                .put(OrganismTypes.BUFFALO.getName(), gsonParser.getObject(OrganismTypes.BUFFALO))
                .put(OrganismTypes.CATERPILLAR.getName(), gsonParser.getObject(OrganismTypes.CATERPILLAR))
                .put(OrganismTypes.DEER.getName(), gsonParser.getObject(OrganismTypes.DEER))
                .put(OrganismTypes.DUCK.getName(), gsonParser.getObject(OrganismTypes.DUCK))
                .put(OrganismTypes.EAGLE.getName(), gsonParser.getObject(OrganismTypes.EAGLE))
                .put(OrganismTypes.FOX.getName(), gsonParser.getObject(OrganismTypes.FOX))
                .put(OrganismTypes.GOAT.getName(), gsonParser.getObject(OrganismTypes.GOAT))
                .put(OrganismTypes.HORSE.getName(), gsonParser.getObject(OrganismTypes.HORSE))
                .put(OrganismTypes.MOUSE.getName(), gsonParser.getObject(OrganismTypes.MOUSE))
                .put(OrganismTypes.PLANT.getName(), gsonParser.getObject(OrganismTypes.PLANT))
                .put(OrganismTypes.RABBIT.getName(), gsonParser.getObject(OrganismTypes.RABBIT))
                .put(OrganismTypes.SHEEP.getName(), gsonParser.getObject(OrganismTypes.SHEEP))
                .put(OrganismTypes.WOLF.getName(), gsonParser.getObject(OrganismTypes.WOLF))
                .build();
    }

    public Organism getNewOrganism(OrganismTypes organismType) {
        return Objects.requireNonNull(organismMap.get(organismType.getName())).copy();
    }

    @Override
    public String toString() {
        return "OrganismFactory{" +
                "gsonParser=" + gsonParser +
                ", organismMap=" + organismMap +
                '}';
    }
}
