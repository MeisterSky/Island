package com.javarush.island.sheff.entity.organisms.animals.predators;

import com.javarush.island.sheff.entity.organisms.Limit;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Boa extends Predator{

    public static int id = 0;

    public Boa(String name, String color, double weight, int[] offspring, Limit limit) {
        super(name, color, weight, offspring, limit);
    }

    public Boa(Boa prototype) {
        this(prototype.getName(), prototype.getColor(), prototype.getWeight(), prototype.getOffspring(), prototype.getLimit());
        ++id;
    }

    @Override
    public Boa copy() {
        return new Boa(this);
    }
}
