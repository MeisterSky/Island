package com.javarush.island.sheff.entities.organisms.plants;

import com.javarush.island.sheff.entities.abstraction.behavior.Breeding;
import com.javarush.island.sheff.entities.map.Cell;
import com.javarush.island.sheff.entities.organisms.Limit;
import com.javarush.island.sheff.entities.organisms.Organism;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
@Setter
public class Plant extends Organism implements Breeding {

    private static int ids;

    public Plant(int id, int steps, String name, String color, double weight, int[] offspring, boolean femaleGender, boolean canBreed, boolean dead, Limit limit) {
        super(++id, steps, name, color, weight, offspring, femaleGender, canBreed, dead, limit);
    }

    private Plant(Plant other) {
        this(ids++, 0, other.getName(), other.getColor(), 0.0, other.getOffspring(), false, false, false, other.getLimit());
    }

    @Override
    public Plant copy() {
        return new Plant(this);
    }

    public Set<Organism> spawn(Cell currentCell) {

        Set<Organism> all = currentCell.getResidents()
                .values()
                .stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());

        if (all.size() > getLimit().getMaxCount()) {
            this.weight = this.weight < this.limit.getMaxWeight() - this.limit.getMaxWeight() / 1.5 - 10 ?
                    this.weight * 1.5 + 10 : this.limit.getMaxWeight();
        } else {
            this.weight = this.limit.getMaxWeight();
        }

        canBreed = false;
        return Stream.generate(this::copy)
                .limit(getLimit().getMaxCount())
                .collect(Collectors.toSet());
    }
}
