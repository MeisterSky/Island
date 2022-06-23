package com.javarush.island.sheff.entity.organisms.animals.predators;

import com.javarush.island.sheff.entity.organisms.Limit;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Bear extends Predator{

    public static int counter = 0;

    public Bear(String name, String color, double weight, Limit limit) {
        super(name, color, weight, limit);
    }

    public Bear(Bear prototype) {
        this(prototype.getName(), prototype.getColor(), prototype.getWeight(), prototype.getLimit());
        ++counter;
    }

    @Override
    public Bear copy() {
        return new Bear(this);
    }

    @Override
    public String toString() {
        return "Bear №" + counter + "{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", weight=" + weight +
                ", limit=" + limit +
                '}';
    }
}
