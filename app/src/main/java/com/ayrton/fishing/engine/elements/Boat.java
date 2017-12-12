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

public class Boat extends Viewable implements OnSwipeListener {
    private Screen screen;

    private Direction direction;
    private List<Fishable> fishables;

    public Boat(int x, int y, Resources resources, Screen screen){
        super(x, y, 1, 1);
        this.fishables = new ArrayList<>();
        this.screen = screen;
        Bitmap b = BitmapFactory.decodeResource(resources, R.drawable.barco_d);
        b = Bitmap.createScaledBitmap(b, screen.getLarguraQuandrante(), screen.getAlturaQuadrante(), false);
        this.addSprite(b);
        b = BitmapFactory.decodeResource(resources, R.drawable.barco_e);
        b = Bitmap.createScaledBitmap(b, screen.getLarguraQuandrante(), screen.getAlturaQuadrante(), false);
        this.addSprite(b);
        b = BitmapFactory.decodeResource(resources, R.drawable.barco_c);
        b = Bitmap.createScaledBitmap(b, screen.getLarguraQuandrante(), screen.getAlturaQuadrante(), false);
        this.addSprite(b);
        b = BitmapFactory.decodeResource(resources, R.drawable.barco_b);
        b = Bitmap.createScaledBitmap(b, screen.getLarguraQuandrante(), screen.getAlturaQuadrante(), false);
        this.addSprite(b);
        direction = Direction.RIGHT;
    }

    public void paint(Canvas canvas){

        canvas.drawBitmap(this.getSprite(direction.getIndex()), this.getX(), this.getY(), null);
    }

    @Override
    public boolean verifyCollision(List<Viewable> elements, Direction direction){
        for (Element e : elements){
            if (e != this && e instanceof Viewable){
                Log.d("Verify Collision", "This.getX(): " + this.getX());
                Log.d("Verify Collision", "This.getY(): "+ this.getY());
                Log.d("Verify Collision", "QuadranteX: " + (this.getX() + screen.getLarguraQuandrante()));
                Log.d("Verify Collision", "QuadranteY: "+ (this.getY() + screen.getAlturaQuadrante()));
                Log.d("Verify Collision", "e.getX(): " + e.getX());
                Log.d("Verify Collision", "e.getY(): "+ e.getY());
                switch (direction){
                    case RIGHT:
                        if (verifyRight(e)){
                            return true;
                        }
                        break;
                    case LEFT:
                        if (verifyLeft(e)){
                            return true;
                        }
                        break;
                    case TOP:
                        if (verifyTop(e)){
                            return true;
                        }
                        break;
                    default:
                        if (verifyBottom(e)){
                            return true;
                        }
                }
            }
        }
        return false;
    }

    private boolean verifyRight(Element e){
         return this.getX() + screen.getLarguraQuandrante() == e.getX() &&
                (this.getY() >= e.getY() &&
                        this.getY() < e.getY() + (e.getHeight() * screen.getAlturaQuadrante()) ) ||
                 this.getX()+ screen.getLarguraQuandrante() == screen.getLargura();
    }
    private boolean verifyLeft (Element e){
        return this.getX() == (e.getX() + (e.getWidth() * screen.getLarguraQuandrante())) &&
                (this.getY() >= e.getY() &&
                        this.getY() < e.getY() + (e.getHeight() * screen.getAlturaQuadrante()) ) ||
                this.getX() == 0;
    }
    private boolean verifyTop (Element e){
        return this.getX() >= e.getX() && this.getX() < e.getX() + (e.getWidth() * screen.getLarguraQuandrante()) &&
                this.getY() == (e.getY() + (e.getHeight() *screen.getAlturaQuadrante())) ||
                this.getY() == 0;
    }
    private boolean verifyBottom (Element e){
        return this.getX() >= e.getX() && this.getX() < e.getX() + (e.getWidth() * screen.getLarguraQuandrante()) &&
                (this.getY() + (this.getHeight() * screen.getAlturaQuadrante() )) == e.getY() ||
                this.getY() + screen.getAlturaQuadrante() == screen.getAltura();
    }

    @Override
    public void onSwipeTop() {
        setY(getY() - screen.getAlturaQuadrante());
        direction = Direction.TOP;
    }

    @Override
    public void onSwipeRight() {
        setX(getX() + screen.getLarguraQuandrante());
        direction = Direction.RIGHT;
    }

    @Override
    public void onSwipeLeft() {
        setX(getX() - screen.getLarguraQuandrante());
        direction = Direction.LEFT;
    }

    @Override
    public void onSwipeBottom() {
        setY(getY() + screen.getAlturaQuadrante());
        direction = Direction.BOTTOM;
    }

    public void addFishable(Fishable fishable){
        this.fishables.add(fishable);
    }

    public int getValue(){
        int value = 0;
        for (Fishable e : fishables){
            value += e.getValor();
        }
        return value;
    }
    public List<Fishable> getFishables(){
        return  this.fishables;
    }
}
