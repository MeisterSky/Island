package com.javarush.island.sheff.entity.organisms.animals.predators;

import com.javarush.island.sheff.entity.organisms.Limit;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Fox extends Predator{

    public static int counter = 0;

    public Fox(String name, String color, double weight, Limit limit) {
        super(name, color, weight, limit);
    }

    public Fox(Fox prototype) {
        this(prototype.getName(), prototype.getColor(), prototype.getWeight(), prototype.getLimit());
        ++counter;
    }

    @Override
    public Fox copy() {
        return new Fox(this);
    }

    @Override
    public String toString() {
        return "Fox{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", weight=" + weight +
                ", limit=" + limit +
                '}';
    }
}
