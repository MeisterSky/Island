package com.javarush.island.sheff.entity.organisms.plants;

import com.javarush.island.sheff.entity.organisms.Limit;
import com.javarush.island.sheff.entity.organisms.Organism;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Plant extends Organism {

    public static int counter = 0;

    public Plant(String name, String color, double weight, Limit limit) {
        super(name, color, weight, limit);
    }

    public Plant(Plant prototype) {
        this(prototype.getName(), prototype.getColor(), prototype.getWeight(), prototype.getLimit());
        ++counter;
    }

    @Override
    public Plant copy() {
        return new Plant(this);
    }

    @Override
    public String toString() {
        return "Plant{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", weight=" + weight +
                ", limit=" + limit +
                '}';
    }
}
