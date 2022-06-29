package com.javarush.island.sheff.entities.abstraction.behavior;

import com.javarush.island.sheff.entities.map.Cell;

import java.util.List;

public interface Moving {

    void selectOfDirection(List<Cell> cells);
}
