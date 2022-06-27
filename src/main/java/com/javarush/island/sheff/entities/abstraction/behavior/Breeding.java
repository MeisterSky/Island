package com.javarush.island.sheff.entities.abstraction.behavior;

import com.javarush.island.sheff.entities.map.Cell;
import com.javarush.island.sheff.entities.organisms.Organism;

import java.util.Set;

public interface Breeding {

    Set<Organism> spawn(Cell currentCell);
}
