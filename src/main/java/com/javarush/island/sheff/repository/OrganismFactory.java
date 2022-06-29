package com.javarush.island.sheff.repository;

import com.javarush.island.sheff.entities.organisms.Limit;
import com.javarush.island.sheff.entities.organisms.Organism;

import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;

public interface OrganismFactory {

    Organism getNewOrganism(OrganismTypes organismType);

    ConcurrentHashMap<String, HashSet<Organism>> getNewOrganismNamesMap();

    Limit getPrototypeOrganismLimit(OrganismTypes organismType);

}
