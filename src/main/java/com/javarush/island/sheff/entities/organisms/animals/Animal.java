package com.javarush.island.sheff.entities.organisms.animals;

import com.javarush.island.sheff.entities.organisms.Limit;
import com.javarush.island.sheff.entities.organisms.Organism;

public abstract class Animal extends Organism {


    public Animal(int id, String name, String color, double weight, int[] offspring, Limit limit) {
        super(id, name, color, weight, offspring, limit);
    }
}