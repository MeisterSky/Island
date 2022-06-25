package com.javarush.island.sheff.entity.organisms.animals.herbivores;

import com.javarush.island.sheff.entity.organisms.Limit;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Deer extends Herbivore {

    public static int id;

    public Deer(String name, String color, double weight, int[] offspring, Limit limit) {
        super(name, color, weight, offspring, limit);
    }

    public Deer(Deer prototype) {
        this(prototype.getName(), prototype.getColor(), prototype.getWeight(), prototype.getOffspring(), prototype.getLimit());
        ++id;
    }

    @Override
    public Deer copy() {
        return new Deer(this);
    }
}
