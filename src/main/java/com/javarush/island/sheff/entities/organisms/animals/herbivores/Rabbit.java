package com.javarush.island.sheff.entities.organisms.animals.herbivores;

import com.javarush.island.sheff.entities.organisms.Limit;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Rabbit extends Herbivore {

    private static int ids;

    public Rabbit(int id, String name, String color, double weight, int[] offspring, Limit limit) {
        super(++id, name, color, weight, offspring, limit);
    }

    public Rabbit(Rabbit prototype) {
        this(ids++, prototype.getName(), prototype.getColor(), prototype.getWeight(), prototype.getOffspring(), prototype.getLimit());
    }

    @Override
    public Rabbit copy() {
        return new Rabbit(this);
    }
}
