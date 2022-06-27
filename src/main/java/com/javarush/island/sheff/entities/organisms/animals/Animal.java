package com.javarush.island.sheff.entities.organisms.animals;

import com.javarush.island.sheff.entities.abstraction.behavior.Breeding;
import com.javarush.island.sheff.entities.abstraction.behavior.Eating;
import com.javarush.island.sheff.entities.abstraction.behavior.Moving;
import com.javarush.island.sheff.entities.map.Cell;
import com.javarush.island.sheff.entities.organisms.Limit;
import com.javarush.island.sheff.entities.organisms.Organism;
import com.javarush.island.sheff.util.Randomizer;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class Animal extends Organism implements Breeding, Eating, Moving {

    public Animal(int id, int steps, String name, String color, double weight, int[] offspring, boolean femaleGender, boolean canBreed, boolean dead, Limit limit) {
        super(id, steps, name, color, weight, offspring, femaleGender, canBreed, dead, limit);
    }

    @Override
    public Map<String, HashSet<Organism>> eat(Cell currentCell) {



        limit.getRation()
                .forEach((key, value) -> {

                });

        currentCell.getResidents()
                .entrySet()
                .stream()
                .filter((k, v) -> k.getKey());

        currentCell.getResidents()
                .values()
                .stream()
                .flatMap(Collection::stream)
                .forEach(organism -> {
                    if (organism.)
                });

        return currentCell.getResidents();
    }

    @Override
    public Set<Organism> spawn(Cell currentCell) {
        Set<Organism> offsprings = new HashSet<>();
        if (!isDead() && isFemaleGender()
                && getWeight() > getLimit().getMaxWeight() / 2
                && currentCell.getResidents()
                .get(getName())
                .stream()
                .anyMatch(organism -> !organism.isFemaleGender() && !organism.isDead())) {

            offsprings = Stream.generate(this::copy)
                    .limit(Randomizer.getArrayInt(getLimit().getOffspring()))
                    .collect(Collectors.toSet());

            double weight = getWeight() / (offsprings.size() + 1);
            setWeight(weight);
            offsprings.forEach(organism -> organism.setWeight(weight));
            canBreed = false;
        }
        return offsprings;
    }

    @Override
    public void move() {

    }
}