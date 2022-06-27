package com.javarush.island.sheff.entities.organisms.animals.herbivores;

import com.javarush.island.sheff.entities.organisms.Limit;
import com.javarush.island.sheff.util.Randomizer;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Horse extends Herbivore {

    private static int ids;

    public Horse(int id, int steps, String name, String color, double weight, int[] offspring, boolean femaleGender, boolean canBreed, boolean dead, Limit limit) {
        super(++id, steps, name, color, weight, offspring, femaleGender, canBreed, dead, limit);
        this.femaleGender = Randomizer.getChance(limit.getFemaleGenderChance());
    }

    private Horse(Horse other) {
        this(ids++, 0, other.getName(), other.getColor(), 0.0, other.getOffspring(), false, false, false, other.getLimit());
    }

    @Override
    public Horse copy() {
        return new Horse(this);
    }
}
