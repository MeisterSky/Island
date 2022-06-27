package com.javarush.island.sheff.entities.organisms.animals.predators;

import lombok.Getter;

@Getter
public class Boar extends Predator{

    public Boar(Boar other) {
        super(other);
    }

    @Override
    public Boar copy() {
        return new Boar(this);
    }
}
