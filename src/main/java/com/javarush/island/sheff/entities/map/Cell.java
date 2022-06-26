package com.javarush.island.sheff.entities.map;

import com.javarush.island.sheff.entities.organisms.Organism;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class Cell {

    private Map<String, HashSet<Organism>> residents;
    private List<Cell> nextCell;

    public Cell(Map<String, HashSet<Organism>> residents) {
        this.residents = residents;
    }
}

