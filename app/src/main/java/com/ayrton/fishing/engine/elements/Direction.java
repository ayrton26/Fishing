package com.ayrton.fishing.engine.elements;

/**
 * Created by ayrton on 31/10/17.
 */

public enum Direction {
    RIGHT(0),
    LEFT(1),
    TOP(2),
    BOTTOM(3);

    private int index;
    Direction(int index){
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}
