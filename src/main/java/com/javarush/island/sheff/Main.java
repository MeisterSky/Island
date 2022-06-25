package com.javarush.island.sheff;

import com.javarush.island.sheff.repository.*;

public class Main {

    public static void main(String[] args) {

        Factory organismFactory = OrganismFactorySingleton.INSTANCE;
        GameMapCreator gameMapCreator = new GameMapCreator(organismFactory);
        int rows = Settings.ROWS.getValue();
        int cols = Settings.COLS.getValue();
        int bear = Settings.NUMBER_OF_BEARS.getValue();
        int start = Settings.START.getValue();
        int eagle = Settings.NUMBER_OF_EAGLES.getValue();

        System.out.println(rows + " " + cols + " " + bear + " " + start + " " + eagle);

        System.out.println(organismFactory);
        System.out.println(organismFactory.getNewOrganism(OrganismTypes.BEAR));
        System.out.println(organismFactory.getNewOrganism(OrganismTypes.BOA));
        System.out.println(organismFactory.getNewOrganism(OrganismTypes.BOAR));
        System.out.println(organismFactory.getNewOrganism(OrganismTypes.BUFFALO));
        System.out.println(organismFactory.getNewOrganism(OrganismTypes.CATERPILLAR));
        System.out.println(organismFactory.getNewOrganism(OrganismTypes.DEER));
        System.out.println(organismFactory.getNewOrganism(OrganismTypes.DUCK));
        System.out.println(organismFactory.getNewOrganism(OrganismTypes.EAGLE));
        System.out.println(organismFactory.getNewOrganism(OrganismTypes.FOX));
        System.out.println(organismFactory.getNewOrganism(OrganismTypes.GOAT));
        System.out.println(organismFactory.getNewOrganism(OrganismTypes.HORSE));
        System.out.println(organismFactory.getNewOrganism(OrganismTypes.MOUSE));
        System.out.println(organismFactory.getNewOrganism(OrganismTypes.PLANT));
        System.out.println(organismFactory.getNewOrganism(OrganismTypes.RABBIT));
        System.out.println(organismFactory.getNewOrganism(OrganismTypes.SHEEP));
        System.out.println(organismFactory.getNewOrganism(OrganismTypes.WOLF));
        System.out.println(organismFactory.getNewOrganism(OrganismTypes.BEAR));
        System.out.println(organismFactory.getNewOrganism(OrganismTypes.EAGLE));
        System.out.println(organismFactory.getNewOrganism(OrganismTypes.BEAR).getClass());
        System.out.println(organismFactory.getNewOrganism(OrganismTypes.EAGLE).getClass());

    }
}
