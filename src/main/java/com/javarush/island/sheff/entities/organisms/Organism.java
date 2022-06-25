package com.javarush.island.sheff.entities.organisms;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public abstract class Organism {

    protected int id;
    protected String name;
    protected String color;
    protected double weight;
    protected int[] offspring;
    protected Limit limit;

    public abstract Organism copy();


    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " №" + id + " {" +
                "HashCode=" + this.hashCode() +
                ", name=\"" + name + '\"' +
                ", color=\"" + color + '\"' +
                ", weight=" + weight +
                ", limit=" + limit +
                '}';
    }
}
