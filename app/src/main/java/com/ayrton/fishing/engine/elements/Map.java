package com.ayrton.fishing.engine.elements;

import android.content.res.Resources;
import android.graphics.Canvas;

import com.ayrton.fishing.engine.elements.interaction.OnSwipeListener;
import com.ayrton.fishing.engine.elements.util.Screen;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ayrton on 25/10/17.
 */

public class Map {
    private Screen screen;
    private Resources resources;
    private List<Element> elements;
    private List<OnSwipeListener> swipeListeners;

    public Map(Screen screen, Resources resources){
        this.screen = screen;
        this.resources = resources;
        this.elements = new ArrayList<>();
        this.swipeListeners = new ArrayList<>();
        this.elements.add(new Rock(screen.quadranteX2Pixels(0), screen.quadranteY2Pixels(0), resources, screen));
        this.elements.add(new Rock(screen.quadranteX2Pixels(4), screen.quadranteY2Pixels(10), resources, screen));
        this.elements.add(new Island(screen.quadranteX2Pixels(5), screen.quadranteY2Pixels(5), resources, screen));
        Boat boat = new Boat(screen.quadranteX2Pixels(3), screen.quadranteY2Pixels(3), resources, screen);
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
