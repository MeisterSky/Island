package com.javarush.island.sheff.entity.organisms;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;

@Getter
@Setter
@AllArgsConstructor
public abstract class Organism {

    protected static int counter;
    protected String name;
    protected String color;
    protected double weight;
    protected int[] offspring;
    protected Limit limit;

    public abstract Organism copy();

    @SneakyThrows
    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " №" + this.getClass().getField("id").getInt(Integer.class) + " {" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", weight=" + weight +
                ", limit=" + limit +
                '}';
    }
}
