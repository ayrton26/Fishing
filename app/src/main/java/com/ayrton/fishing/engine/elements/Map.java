package com.ayrton.fishing.engine.elements;

import android.content.res.Resources;
import android.graphics.Canvas;

import com.ayrton.fishing.engine.elements.interaction.OnSwipeListener;
import com.ayrton.fishing.engine.elements.interaction.OnSwipeTouchListener;
import com.ayrton.fishing.engine.elements.util.Tela;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ayrton on 25/10/17.
 */

public class Map {
    private Tela tela;
    private Resources resources;
    private List<Element> elements;
    private List<OnSwipeListener> swipeListeners;

    public Map(Tela tela, Resources resources){
        this.tela = tela;
        this.resources = resources;
        this.elements = new ArrayList<>();
        this.swipeListeners = new ArrayList<>();
        this.elements.add(new Rock(tela.quadranteX2Pixels(0), tela.quadranteY2Pixels(0), resources, tela));
        this.elements.add(new Rock(tela.quadranteX2Pixels(4), tela.quadranteY2Pixels(10), resources, tela));
        this.elements.add(new Island(tela.quadranteX2Pixels(5), tela.quadranteY2Pixels(5), resources, tela));
        Boat boat = new Boat(tela.quadranteX2Pixels(3), tela.quadranteY2Pixels(3), resources, tela);
        this.elements.add(boat);
        this.swipeListeners.add(boat);
    }

    public void paint(Canvas canvas){
        for (Element e : elements){
            if (e instanceof Viewable){
                Viewable v = (Viewable) e;
                v.paint(canvas);
            }
        }
    }

    public void onSwipeTop() {
        for (OnSwipeListener e : swipeListeners){
            e.onSwipeTop();
        }
    }
    public void onSwipeRight() {
        for (OnSwipeListener e : swipeListeners){
            e.onSwipeRight();
        }
    }
    public void onSwipeLeft() {
        for (OnSwipeListener e : swipeListeners){
            e.onSwipeLeft();
        }
    }
    public void onSwipeBottom() {
        for (OnSwipeListener e : swipeListeners){
            e.onSwipeBottom();
        }
    }
}
