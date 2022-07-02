package com.javarush.island.sheff.entities.abstraction.behavior;

import com.javarush.island.sheff.entities.organisms.Organism;

import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;

public interface Eating {

    void eat(ConcurrentHashMap<String, HashSet<Organism>> map);
}
