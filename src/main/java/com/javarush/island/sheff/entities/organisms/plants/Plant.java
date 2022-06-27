package com.javarush.island.sheff.entities.organisms.plants;

import com.javarush.island.sheff.entities.abstraction.behavior.Breeding;
import com.javarush.island.sheff.entities.organisms.Organism;
import lombok.Getter;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
public class Plant extends Organism implements Breeding {

    public Plant(Plant other) {
    super(other);
    }

    @Override
    public Plant copy() {
        return new Plant(this);
    }

    @Override
    public Set<Organism> spawn() {

        if (weight < limit.getMaxWeight()) {
            weight = weight < limit.getMaxWeight() - limit.getMaxWeight() / 1.5 ?
                    weight * 1.5 : limit.getMaxWeight();
        }
        canBreed = false;
        return Stream.generate(this::copy)
                .limit(getLimit().getMaxCount())
                .collect(Collectors.toSet());
    }

    @Override
    public void endTurn() {
        canBreed = true;
        weight = weight <= limit.getMaxWeight() - 10 ? +10 : weight;
    }
}