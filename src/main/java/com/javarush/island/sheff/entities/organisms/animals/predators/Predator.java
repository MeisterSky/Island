package com.javarush.island.sheff.entities.organisms.animals.predators;

import com.javarush.island.sheff.entities.organisms.animals.Animal;

public abstract class Predator extends Animal {

    public Predator(Predator other) {
        super(other);
    }
}
