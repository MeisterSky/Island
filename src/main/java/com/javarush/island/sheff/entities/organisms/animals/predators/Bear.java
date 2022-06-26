package com.javarush.island.sheff.entities.organisms.animals.predators;

import com.javarush.island.sheff.entities.organisms.Limit;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Bear extends Predator {

    private static int ids;

    public Bear(int id, String name, String color, double weight, int[] offspring, Limit limit) {
        super(++id, name, color, weight, offspring, limit);
    }

    public Bear(Bear prototype) {
        this(ids++, prototype.getName(), prototype.getColor(), prototype.getWeight(), prototype.getOffspring(), prototype.getLimit());
    }

    @Override
    public Bear copy() {
        return new Bear(this);
    }

}
