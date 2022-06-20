package com.javarush.island.sheff.entity.map;

import com.javarush.island.sheff.entity.organisms.Organism;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
@Setter
@RequiredArgsConstructor
public class Cell {

    private final Map<Type, Set<Organism>> residents;
    private List<Cell> nextCell;
}

