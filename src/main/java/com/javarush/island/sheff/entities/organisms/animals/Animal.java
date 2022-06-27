package com.javarush.island.sheff.entities.organisms.animals;

import com.javarush.island.sheff.entities.abstraction.behavior.Eating;
import com.javarush.island.sheff.entities.abstraction.behavior.Moving;
import com.javarush.island.sheff.entities.organisms.Organism;
import com.javarush.island.sheff.util.Randomizer;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class Animal extends Organism implements Eating, Moving {

    public Animal(Animal other) {
        super(other);
    }

    @Override
    public Set<Organism> spawn() {
        int random = Randomizer.getArrayInt(getLimit().getOffspring());
        this.weight = weight / (random + 1);
        canBreed = false;
        return Stream.generate(this::copy)
                .limit(random)
                .collect(Collectors.toSet());
    }

    @Override
    public Map<String, HashSet<Organism>> eat() {

        return null;
    }

    @Override
    public void move() {

    }

    @Override
    public void endTurn() {

    }
}