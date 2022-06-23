package com.javarush.island.sheff.repository;

import com.javarush.island.sheff.entity.organisms.animals.herbivores.*;
import com.javarush.island.sheff.entity.organisms.animals.predators.*;
import com.javarush.island.sheff.entity.organisms.plants.Plant;
import lombok.Setter;

@Setter
public class Entities {

    private Wolf wolf;
    private Boa boa;
    private Fox fox;
    private Bear bear;
    private Eagle eagle;
    private Horse horse;
    private Deer deer;
    private Rabbit rabbit;
    private Mouse mouse;
    private Goat goat;
    private Sheep sheep;
    private Boar boar;
    private Buffalo buffalo;
    private Duck duck;
    private Caterpillar caterpillar;
    private Plant plant;

    @Override
    public String toString() {
        return "Entity{" +
                "wolf=" + wolf +
                ",\n boa=" + boa +
                ",\n fox=" + fox +
                ",\n bear=" + bear +
                ",\n eagle=" + eagle +
                ",\n horse=" + horse +
                ",\n deer=" + deer +
                ",\n rabbit=" + rabbit +
                ",\n mouse=" + mouse +
                ",\n goat=" + goat +
                ",\n sheep=" + sheep +
                ",\n boar=" + boar +
                ",\n buffalo=" + buffalo +
                ",\n duck=" + duck +
                ",\n caterpillar=" + caterpillar +
                ",\n plant=" + plant +
                '}';
    }
}