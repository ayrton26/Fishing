package com.ayrton.fishing.engine.elements;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ayrton on 25/10/17.
 */

public abstract class Viewable extends Element {

    private List<Bitmap> sprites;

    public Viewable(int x, int y){
        super(x, y);
        sprites = new ArrayList<>();
    }

    public void addSprite(Bitmap bitmap){
        sprites.add(bitmap);
    }

    public Bitmap getSprite(int index){
        return this.sprites.get(index);
    }

    public abstract void paint(Canvas canvas);


}
