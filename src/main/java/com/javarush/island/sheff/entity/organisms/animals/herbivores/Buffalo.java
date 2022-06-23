package com.javarush.island.sheff.entity.organisms.animals.herbivores;

import com.javarush.island.sheff.entity.organisms.Limit;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Buffalo extends Herbivore {

    public static int counter = 0;

    public Buffalo(String name, String color, double weight, Limit limit) {
        super(name, color, weight, limit);
    }

    public Buffalo(Buffalo prototype) {
        this(prototype.getName(), prototype.getColor(), prototype.getWeight(), prototype.getLimit());
        ++counter;
    }


    @Override
    public Buffalo copy() {
        return new Buffalo(this);
    }

    @Override
    public String toString() {
        return "Buffalo{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", weight=" + weight +
                ", limit=" + limit +
                '}';
    }
}
