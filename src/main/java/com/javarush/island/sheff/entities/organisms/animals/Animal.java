package com.javarush.island.sheff.entities.organisms.animals;

import com.javarush.island.sheff.entities.abstraction.behavior.Eating;
import com.javarush.island.sheff.entities.abstraction.behavior.Moving;
import com.javarush.island.sheff.entities.map.Cell;
import com.javarush.island.sheff.entities.organisms.Organism;
import com.javarush.island.sheff.util.Randomizer;
import lombok.Getter;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
public abstract class Animal extends Organism implements Eating, Moving {

    private static int counter;

    public Animal(Animal other) {
        super(other);
    }

    @Override
    public Set<Organism> spawn() {
        canBreed = false;
        int random = Randomizer.getFromArrayInt(getLimit().getOffspring());
        this.weight = weight / (random + 1);
        return Stream.generate(this::copy)
                .limit(random - 1)
                .collect(Collectors.toSet());
    }

    @Override
    public void eat(int food) {
        weight += food;
    }

    @Override
    public void move(List<Cell> cells) {
        cells.stream()
                .map(Cell::getResidents)
                .map(this::filterByRation)
                .max(this::compareWeight)
                .map(Map::values)
                .stream()
                .flatMap(Collection::stream)
                .flatMap(HashSet::stream)
                .findFirst().ifPresent(organism -> {
                    System.out.println("Передвижение организма: " + this);
                    System.out.println("Старая локация: " + location);
                    location.setLocation(organism.getLocation());
                    System.out.println("Новая локация: " + location);
                    System.out.println("Походило организмов: " + ++counter);
                });

    }

    public int compareWeight(Map<String, HashSet<Organism>> map1, Map<String, HashSet<Organism>> map2) {
        Double map1Weight = map1.values().stream()
                .flatMap(Set::stream)
                .map(Organism::getWeight)
                .reduce(Double::sum)
                .orElse(0d);

        Double map2Weight = map2.values().stream()
                .flatMap(Set::stream)
                .map(Organism::getWeight)
                .reduce(Double::sum)
                .orElse(0d);
        return map1Weight.compareTo(map2Weight);
    }

    public Map<String, HashSet<Organism>> filterByRation(Map<String, HashSet<Organism>> map) {
        return map.entrySet()
                .stream()
                .filter(entry -> limit.getRation().containsKey(entry.getKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    }

    @Override
    public void endTurn() {
        steps = limit.getMaxSpeed();
        canBreed = isFemaleGender();
        weight = weight - limit.getMaxFood() / 1.5;
    }
}