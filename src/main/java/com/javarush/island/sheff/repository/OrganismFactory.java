package com.javarush.island.sheff.repository;

import com.javarush.island.sheff.entities.organisms.Organism;

import java.util.HashSet;
import java.util.Map;

public interface OrganismFactory {

    Organism getNewOrganism(OrganismTypes organismType);

    Map<String, HashSet<Organism>> getOrganismNamesMap();

}
