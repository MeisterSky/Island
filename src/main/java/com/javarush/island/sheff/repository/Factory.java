package com.javarush.island.sheff.repository;

import com.javarush.island.sheff.entity.organisms.Organism;

public interface Factory {

    Organism getNewOrganism(OrganismTypes organismType);
}
