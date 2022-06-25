package com.javarush.island.sheff.entities.organisms.plants;

import com.javarush.island.sheff.entities.organisms.Limit;
import com.javarush.island.sheff.entities.organisms.Organism;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Plant extends Organism {

    private static int ids;

    public Plant(int id, String name, String color, double weight, int[] offspring, Limit limit) {
        super(++id, name, color, weight, offspring, limit);
    }

    public Plant(Plant prototype) {
        this(ids++, prototype.getName(), prototype.getColor(), prototype.getWeight(), prototype.getOffspring(), prototype.getLimit());
    }

    @Override
    public Plant copy() {
        return new Plant(this);
    }
}
