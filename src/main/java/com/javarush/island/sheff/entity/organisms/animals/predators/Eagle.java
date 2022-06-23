package com.javarush.island.sheff.entity.organisms.animals.predators;

import com.javarush.island.sheff.entity.organisms.Limit;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Eagle extends Predator{

    public static int counter = 0;

    public Eagle(String name, String color, double weight, Limit limit) {
        super(name, color, weight, limit);
    }

    public Eagle(Eagle prototype) {
        this(prototype.getName(), prototype.getColor(), prototype.getWeight(), prototype.getLimit());
        ++counter;
    }

    @Override
    public Eagle copy() {
        return new Eagle(this);
    }

    @Override
    public String toString() {
        return "Eagle{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", weight=" + weight +
                ", limit=" + limit +
                '}';
    }
}
