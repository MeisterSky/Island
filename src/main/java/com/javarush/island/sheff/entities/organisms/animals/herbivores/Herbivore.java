package com.javarush.island.sheff.entities.organisms.animals.herbivores;

import com.javarush.island.sheff.entities.organisms.animals.Animal;

public abstract class Herbivore extends Animal {

    public Herbivore(Herbivore other) {
        super(other);
    }
}
