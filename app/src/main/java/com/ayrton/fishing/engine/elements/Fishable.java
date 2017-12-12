package com.ayrton.fishing.engine.elements;

import android.graphics.Bitmap;

import java.util.List;

/**
 * Created by ayrton on 12/12/17.
 */

public class Fishable extends Element {
    private int valor;
    private Bitmap sprite;

    public Fishable(int x, int y, int valor ) {
        super(x, y, 1, 1);
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    public Bitmap getSprite() {
        return sprite;
    }

    public void setSprite(Bitmap sprite) {
        this.sprite = sprite;
    }

}
