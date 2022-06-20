package com.javarush.island.sheff.entity.organisms.animals;

import com.javarush.island.sheff.entity.organisms.Limit;
import com.javarush.island.sheff.entity.organisms.Organism;

public abstract class Animal extends Organism {

    public Animal(String name, String color, double weight, Limit limit) {
        super(name, color, weight, limit);
    }
}