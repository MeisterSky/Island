package com.javarush.island.sheff.entities.organisms.animals;

import com.javarush.island.sheff.entities.abstraction.behavior.Breeding;
import com.javarush.island.sheff.entities.abstraction.behavior.Eating;
import com.javarush.island.sheff.entities.abstraction.behavior.Moving;
import com.javarush.island.sheff.entities.organisms.Limit;
import com.javarush.island.sheff.entities.organisms.Organism;

public abstract class Animal extends Organism implements Breeding, Eating, Moving {

    public Animal(int id, String name, String color, double weight, int[] offspring, Limit limit) {
        super(id, name, color, weight, offspring, limit);
    }

    @Override
    public void spawn() {

    }

    @Override
    public void eat() {

    }

    @Override
    public void move() {

    }
}