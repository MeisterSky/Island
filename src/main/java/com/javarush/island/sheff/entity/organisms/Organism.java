package com.javarush.island.sheff.entity.organisms;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public abstract class Organism {

    public String name;
    public String color;
    public double weight;
    public Limit limit;

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
