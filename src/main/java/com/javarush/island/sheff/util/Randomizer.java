package com.javarush.island.sheff.util;

import java.util.concurrent.ThreadLocalRandom;

public class Randomizer {

    public static int getInt(int origin, int bound) {
        return ThreadLocalRandom.current().nextInt(origin, bound);
    }

    public static int getZeroToBound(int bound) {
        return ThreadLocalRandom.current().nextInt(0, bound);
    }

    public static boolean getChance(int chance) {
        return getZeroToBound(100) < chance;
    }
}
