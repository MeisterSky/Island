package com.javarush.island.sheff.repository;

import com.javarush.island.sheff.entities.organisms.Organism;

public interface OrganismFactory {

    Organism getNewOrganism(OrganismTypes organismType);

}
