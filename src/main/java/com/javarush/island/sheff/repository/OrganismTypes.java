package com.javarush.island.sheff.repository;

import com.javarush.island.sheff.entity.organisms.animals.herbivores.*;
import com.javarush.island.sheff.entity.organisms.animals.predators.*;
import com.javarush.island.sheff.entity.organisms.plants.Plant;
import lombok.Getter;

import java.lang.reflect.Type;

@Getter
public enum OrganismTypes {

    BEAR("bear", Bear.class),
    BOA("boa", Boa.class),
    BOAR("boar", Boar.class),
    BUFFALO("buffalo", Buffalo.class),
    CATERPILLAR("caterpillar", Caterpillar.class),
    DEER("deer", Deer.class),
    DUCK("duck", Duck.class),
    EAGLE("eagle", Eagle.class),
    FOX("fox", Fox.class),
    GOAT("goat", Goat.class),
    HORSE("horse", Horse.class),
    MOUSE("mouse", Mouse.class),
    PLANT("plant", Plant.class),
    RABBIT("rabbit", Rabbit.class),
    SHEEP("sheep", Sheep.class),
    WOLF("wolf", Wolf.class);

    private final String name;
    private final Type type;

    OrganismTypes(String name, Type type) {
        this.name = name;
        this.type = type;
    }
}
