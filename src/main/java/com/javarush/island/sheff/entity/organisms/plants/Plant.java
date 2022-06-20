package com.javarush.island.sheff.entity.organisms.plants;

import com.javarush.island.sheff.entity.map.Cell;
import com.javarush.island.sheff.entity.organisms.Limit;
import com.javarush.island.sheff.entity.organisms.Organism;

public class Plant extends Organism {
    public Plant(String name, String color, double weight, Limit limit) {
        super(name, color, weight, limit);
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
