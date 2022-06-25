package com.javarush.island.sheff.entity.organisms.animals.predators;

import com.javarush.island.sheff.entity.organisms.Limit;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Eagle extends Predator{

    public static int id;

    public Eagle(String name, String color, double weight, int[] offspring, Limit limit) {
        super(name, color, weight, offspring, limit);
    }

    public Eagle(Eagle prototype) {
        this(prototype.getName(), prototype.getColor(), prototype.getWeight(), prototype.getOffspring(), prototype.getLimit());
        ++id;
    }

    @Override
    public Eagle copy() {
        return new Eagle(this);
    }
}
