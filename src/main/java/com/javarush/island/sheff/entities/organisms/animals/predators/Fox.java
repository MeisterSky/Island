package com.javarush.island.sheff.entities.organisms.animals.predators;

import com.javarush.island.sheff.entities.organisms.Limit;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Fox extends Predator{

    private static int ids;

    public Fox(int id, String name, String color, double weight, int[] offspring, Limit limit) {
        super(++id, name, color, weight, offspring, limit);
    }

    public Fox(Fox prototype) {
        this(ids++, prototype.getName(), prototype.getColor(), prototype.getWeight(), prototype.getOffspring(), prototype.getLimit());
    }

    @Override
    public Fox copy() {
        return new Fox(this);
    }
}