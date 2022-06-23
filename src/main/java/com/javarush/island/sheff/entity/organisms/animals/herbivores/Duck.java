package com.javarush.island.sheff.entity.organisms.animals.herbivores;

import com.javarush.island.sheff.entity.organisms.Limit;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Duck extends Herbivore {

    public static int counter = 0;

    public Duck(String name, String color, double weight, Limit limit) {
        super(name, color, weight, limit);
    }

    public Duck(Duck prototype) {
        this(prototype.getName(), prototype.getColor(), prototype.getWeight(), prototype.getLimit());
        ++counter;
    }

    @Override
    public Duck copy() {
        return new Duck(this);
    }

    @Override
    public String toString() {
        return "Duck{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", weight=" + weight +
                ", limit=" + limit +
                '}';
    }
}
