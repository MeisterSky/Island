package com.javarush.island.sheff.entities.abstraction.behavior;

import com.javarush.island.sheff.entities.organisms.Organism;

import java.util.HashSet;
import java.util.Map;

public interface Eating {

    Map<String, HashSet<Organism>> eat();
}
