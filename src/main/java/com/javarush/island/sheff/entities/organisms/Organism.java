package com.javarush.island.sheff.entities.organisms;

import com.javarush.island.sheff.entities.abstraction.behavior.Breeding;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public abstract class Organism implements Breeding {

    protected int id;
    protected int steps;
    protected String name;
    protected String color;
    protected double weight;
    protected int[] offspring;
    protected boolean femaleGender;
    protected boolean canBreed;
    protected boolean dead;
    protected Limit limit;

    public abstract Organism copy();


    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " №" + id + " {" +
                "HashCode=" + this.hashCode() +
                ", steps=" + steps +
                ", name=\"" + name + '\"' +
                ", color=\"" + color + '\"' +
                ", weight=" + weight +
                ", femaleGender=" + femaleGender +
                ", limit=" + limit +
                '}';
    }
}
