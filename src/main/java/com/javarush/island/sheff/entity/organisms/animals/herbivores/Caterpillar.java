package com.javarush.island.sheff.entity.organisms.animals.herbivores;

import com.javarush.island.sheff.entity.organisms.Limit;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Caterpillar extends Herbivore {

    public static int id;

    public Caterpillar(String name, String color, double weight, int[] offspring, Limit limit) {
        super(name, color, weight, offspring, limit);
    }

    public Caterpillar(Caterpillar prototype) {
        this(prototype.getName(), prototype.getColor(), prototype.getWeight(), prototype.getOffspring(), prototype.getLimit());
        ++id;
    }

    @Override
    public Caterpillar copy() {
        return new Caterpillar(this);
    }
}
