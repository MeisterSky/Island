package com.javarush.island.sheff.entity.organisms;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public abstract class Organism {

    protected String name;
    protected String color;
    protected double weight;
    protected Limit limit;

    @Override
    public String toString() {
        return "Organism{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", weight=" + weight +
                ", limit=" + limit +
                '}';
    }
}
