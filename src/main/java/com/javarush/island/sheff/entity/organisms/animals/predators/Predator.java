package com.javarush.island.sheff.entity.organisms.animals.predators;

import com.javarush.island.sheff.entity.organisms.Limit;
import com.javarush.island.sheff.entity.organisms.animals.Animal;

public abstract class Predator extends Animal {
    public Predator(String name, String color, double weight, Limit limit) {
        super(name, color, weight, limit);
    }


}
