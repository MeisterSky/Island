package com.javarush.island.sheff.entity.organisms.animals.herbivores;

import com.javarush.island.sheff.entity.organisms.Limit;
import com.javarush.island.sheff.entity.organisms.animals.Animal;

public abstract class Herbivore extends Animal {

    public Herbivore(String name, String color, double weight, Limit limit) {
        super(name, color, weight, limit);
    }
}
