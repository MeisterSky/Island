package com.javarush.island.sheff.entity.organisms.animals.predators;

import com.javarush.island.sheff.entity.organisms.Limit;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Boa extends Predator{

    public static int counter = 0;

    public Boa(String name, String color, double weight, Limit limit) {
        super(name, color, weight, limit);
    }

    public Boa(Boa prototype) {
        this(prototype.getName(), prototype.getColor(), prototype.getWeight(), prototype.getLimit());
        ++counter;
    }

    @Override
    public Boa copy() {
        return new Boa(this);
    }

    @Override
    public String toString() {
        return "Boa{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", weight=" + weight +
                ", limit=" + limit +
                '}';
    }
}
