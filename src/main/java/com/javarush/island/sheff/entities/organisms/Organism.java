package com.javarush.island.sheff.entities.organisms;

import com.javarush.island.sheff.entities.abstraction.behavior.Breeding;
import com.javarush.island.sheff.util.Randomizer;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Set;

@Getter
@AllArgsConstructor
public abstract class Organism implements Breeding {

    protected int id;
    protected int steps;
    protected String name;
    protected double weight;
    protected int[] offspring;
    protected boolean femaleGender;
    protected boolean canBreed;
    protected boolean dead;
    protected Limit limit;

    public Organism() {
    }

    public Organism(Organism other) {
        this();
        id = ++other.id;
        steps = 0;
        name = other.getName();
        weight = other.getWeight();
        offspring = other.getOffspring();
        femaleGender = Randomizer.getChance(50);
        canBreed = false;
        dead = false;
        limit = other.getLimit();
    }

    public abstract Organism copy();

    public abstract Set<Organism> spawn();

    public abstract void endTurn();


    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " №" + id + " {" +
                "HashCode=" + this.hashCode() +
                ", steps=" + steps +
                ", name=\"" + name + '\"' +
                ", weight=" + weight +
                ", femaleGender=" + femaleGender +
                ", limit=" + limit +
                '}';
    }
}
