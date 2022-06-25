package com.javarush.island.sheff.repository;

import com.javarush.island.sheff.entity.organisms.animals.herbivores.*;
import com.javarush.island.sheff.entity.organisms.animals.predators.*;
import com.javarush.island.sheff.entity.organisms.plants.Plant;
import lombok.Getter;

import java.lang.reflect.Type;

@Getter
public enum OrganismTypes {

    BEAR("Bear", Bear.class),
    BOA("Boa", Boa.class),
    BOAR("Boar", Boar.class),
    BUFFALO("Buffalo", Buffalo.class),
    CATERPILLAR("Caterpillar", Caterpillar.class),
    DEER("Deer", Deer.class),
    DUCK("Duck", Duck.class),
    EAGLE("Eagle", Eagle.class),
    FOX("Fox", Fox.class),
    GOAT("Goat", Goat.class),
    HORSE("Horse", Horse.class),
    MOUSE("Mouse", Mouse.class),
    PLANT("Plant", Plant.class),
    RABBIT("Rabbit", Rabbit.class),
    SHEEP("Sheep", Sheep.class),
    WOLF("Wolf", Wolf.class);

    private final String name;
    private final Type type;

    OrganismTypes(String name, Type type) {
        this.name = name;
        this.type = type;
    }
}
