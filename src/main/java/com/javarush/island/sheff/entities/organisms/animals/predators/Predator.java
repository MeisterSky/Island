package com.javarush.island.sheff.entities.organisms.animals.predators;

import com.javarush.island.sheff.entities.organisms.Limit;
import com.javarush.island.sheff.entities.organisms.animals.Animal;

public abstract class Predator extends Animal {

    public Predator(int id, int steps, String name, String color, double weight, int[] offspring, boolean femaleGender, boolean canBreed, boolean dead, Limit limit) {
        super(id, steps, name, color, weight, offspring, femaleGender, canBreed, dead, limit);
    }
}
