package com.javarush.island.sheff.entity.organisms.animals.herbivores;

import com.javarush.island.sheff.entity.organisms.Limit;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Buffalo extends Herbivore {

    public static int id;

    public Buffalo(String name, String color, double weight, int[] offspring, Limit limit) {
        super(name, color, weight, offspring, limit);
    }

    public Buffalo(Buffalo prototype) {
        this(prototype.getName(), prototype.getColor(), prototype.getWeight(), prototype.getOffspring(), prototype.getLimit());
        ++id;
    }


    @Override
    public Buffalo copy() {
        return new Buffalo(this);
    }
}
