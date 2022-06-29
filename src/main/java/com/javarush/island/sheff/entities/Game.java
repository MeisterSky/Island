package com.javarush.island.sheff.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import com.javarush.island.sheff.entities.map.GameMap;
import com.javarush.island.sheff.repository.OrganismFactory;

@Getter
@RequiredArgsConstructor
public class Game {

    private final GameMap gameMap;
    private final OrganismFactory organismFactory;
//    private final SimulatorView view;

}
