package com.javarush.island.sheff.entities.organisms.animals.predators;

import com.javarush.island.sheff.entities.organisms.Limit;
import com.javarush.island.sheff.entities.organisms.animals.Animal;

public abstract class Predator extends Animal {

    public Predator(int id, String name, String color, double weight, int[] offspring, Limit limit) {
        super(id, name, color, weight, offspring, limit);
    }
}
