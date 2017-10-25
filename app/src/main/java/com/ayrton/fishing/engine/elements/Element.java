package com.ayrton.fishing.engine.elements;

/**
 * Created by ayrton on 25/10/17.
 */

public class Element {
    private int x;
    private int y;

    public Element(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
