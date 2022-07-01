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
    protected boolean femaleGender;
    protected boolean canBreed;
    protected boolean dead;
    protected Limit limit;
    protected Location location;

    public Organism() {
    }

    public Organism(Organism other) {
        this();
        id = ++other.id;
        limit = other.getLimit();
        steps = limit.getMaxSpeed();
        name = other.getName();
        weight = other.getWeight();
        femaleGender = Randomizer.getChance(50);
        canBreed = femaleGender;
        dead = false;
        location = new Location(other.getLocation());
    }

    public abstract Organism copy();

    public abstract Set<Organism> spawn();

    public abstract void endTurn();

    public int getCol() {
        return location.getCol();
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " №" + id + " {" +
                "HashCode=" + this.hashCode() +
                ", steps=" + steps +
                ", location=" + location +
                ", name=\"" + name + '\"' +
                ", weight=" + weight +
                ", femaleGender=" + femaleGender +
                ", limit=" + limit +
                '}';
    }
}
