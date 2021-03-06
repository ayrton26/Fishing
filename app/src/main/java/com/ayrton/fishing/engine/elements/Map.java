package com.ayrton.fishing.engine.elements;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.Log;

import com.ayrton.fishing.R;
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
    private List<Viewable> viewables;
    private List<Fishable> fishables;
    private List<OnSwipeListener> swipeListeners;
    private Boat boat;
    private Bitmap mask;

    public Map(Screen screen, Resources resources){
        this.screen = screen;
        this.resources = resources;
        this.viewables = new ArrayList<>();
        this.fishables = new ArrayList<>();
        this.swipeListeners = new ArrayList<>();
        this.viewables.add(new Rock(screen.quadranteX2Pixels(0), screen.quadranteY2Pixels(0), resources, screen));
        this.viewables.add(new Rock(screen.quadranteX2Pixels(4), screen.quadranteY2Pixels(10), resources, screen));
        this.viewables.add(new Island(screen.quadranteX2Pixels(5), screen.quadranteY2Pixels(5), resources, screen));
        this.boat = new Boat(screen.quadranteX2Pixels(3), screen.quadranteY2Pixels(3), resources, screen);
        this.fishables.add(new Fish(screen.quadranteX2Pixels(0), screen.quadranteY2Pixels(1), resources, screen));
        this.fishables.add(new Fish(screen.quadranteX2Pixels(1), screen.quadranteY2Pixels(0), resources, screen));
        this.fishables.add(new Tire(screen.quadranteX2Pixels(4), screen.quadranteY2Pixels(4), resources, screen));
        this.viewables.add(boat);
        this.swipeListeners.add(boat);
        Bitmap b = BitmapFactory.decodeResource(resources, R.drawable.mask_collectable);
        mask = Bitmap.createScaledBitmap(b, screen.getLarguraQuandrante(), screen.getAlturaQuadrante(), false);

    }

    public void paint(Canvas canvas){
        for (Element e : fishables){
            canvas.drawBitmap(this.mask, e.getX(), e.getY(), null);
        }
        for (Viewable v : viewables){
            v.paint(canvas);

        }
        int x = 50;
        for (Fishable e : boat.getFishables()){
            canvas.drawBitmap(e.getSprite(), x, screen.getAltura() - screen.getAlturaQuadrante()*2, null);
            x += screen.getLarguraQuandrante();
        }

    }

    public void onSwipeTop() {
        for (OnSwipeListener e : swipeListeners){
            if (!e.verifyCollision(viewables, Direction.TOP)){
                e.onSwipeTop();
            }
        }
    }
    public void onSwipeRight() {
        for (OnSwipeListener e : swipeListeners){
            if (!e.verifyCollision(viewables, Direction.RIGHT)){
                e.onSwipeRight();
            }

        }
    }
    public void onSwipeLeft() {
        for (OnSwipeListener e : swipeListeners){
            if (!e.verifyCollision(viewables, Direction.LEFT)){
                e.onSwipeLeft();
            }

        }
    }
    public void onSwipeBottom() {
        for (OnSwipeListener e : swipeListeners){
            if (!e.verifyCollision(viewables, Direction.BOTTOM)){
                e.onSwipeBottom();
            }

        }
    }

    public void onDoubleTap(){

        Log.d("Mapa", "DOuble Tap");
        Fishable f = null;
        for (Fishable e: this.fishables){
            if ((e.getX() == boat.getX()) && e.getY() == boat.getY()){
                Log.d("Mapa", "Pescou");
                boat.addFishable(e);
                f = e;
                Log.d("Mapa", "" + boat.getValue());
            }
        }
        this.fishables.remove(f);
    }
}
