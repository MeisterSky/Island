package com.javarush.island.sheff.entities.organisms.animals.herbivores;

import com.javarush.island.sheff.entities.organisms.Limit;
import com.javarush.island.sheff.entities.organisms.animals.Animal;

public abstract class Herbivore extends Animal {

    public Herbivore(int id, String name, String color, double weight, int[] offspring, Limit limit) {
        super(id, name, color, weight, offspring, limit);
    }
}
