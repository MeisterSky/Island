package com.javarush.island.sheff;

import com.javarush.island.sheff.repository.OrganismFactory;
import com.javarush.island.sheff.repository.OrganismTypes;

public class Main {

    public static void main(String[] args) {

        OrganismFactory entityFactory = OrganismFactory.INSTANCE;
        System.out.println(entityFactory);
        System.out.println(entityFactory.getNewOrganism(OrganismTypes.BEAR));
        System.out.println(entityFactory.getNewOrganism(OrganismTypes.BEAR));
        System.out.println(entityFactory.getNewOrganism(OrganismTypes.BEAR).getClass());

    }
}
