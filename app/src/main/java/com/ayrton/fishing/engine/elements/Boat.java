package com.ayrton.fishing.engine.elements;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

import com.ayrton.fishing.R;
import com.ayrton.fishing.engine.elements.interaction.OnSwipeListener;
import com.ayrton.fishing.engine.elements.util.Tela;

/**
 * Created by ayrton on 25/10/17.
 */

public class Boat extends Viewable implements OnSwipeListener {
    private Tela tela;
    private static final int RIGHT = 0;
    private static final int LEFT = 1;
    private static final int TOP = 2;
    private static final int BOTTOM = 3;
    private int direction;

    public Boat(int x, int y, Resources resources, Tela tela){
        super(x, y);
        this.tela = tela;
        Bitmap b = BitmapFactory.decodeResource(resources, R.drawable.barco_d);
        b = Bitmap.createScaledBitmap(b, 2 * tela.getLarguraQuandrante(), tela.getAlturaQuadrante(), false);
        this.addSprite(b);
        b = BitmapFactory.decodeResource(resources, R.drawable.barco_e);
        b = Bitmap.createScaledBitmap(b, 2 * tela.getLarguraQuandrante(), tela.getAlturaQuadrante(), false);
        this.addSprite(b);
        b = BitmapFactory.decodeResource(resources, R.drawable.barco_c);
        b = Bitmap.createScaledBitmap(b, tela.getLarguraQuandrante(), 2 * tela.getAlturaQuadrante(), false);
        this.addSprite(b);
        b = BitmapFactory.decodeResource(resources, R.drawable.barco_b);
        b = Bitmap.createScaledBitmap(b, tela.getLarguraQuandrante(), 2 * tela.getAlturaQuadrante(), false);
        this.addSprite(b);
        direction = RIGHT;
    }

    public void paint(Canvas canvas){

        canvas.drawBitmap(this.getSprite(direction), this.getX(), this.getY(), null);
    }

    @Override
    public void onSwipeTop() {
        setY(getY() - tela.getAlturaQuadrante());
        direction = TOP;
    }

    @Override
    public void onSwipeRight() {
        setX(getX() + tela.getLarguraQuandrante());
        direction = RIGHT;
    }

    @Override
    public void onSwipeLeft() {
        setX(getX() - tela.getLarguraQuandrante());
        direction = LEFT;
    }

    @Override
    public void onSwipeBottom() {
        setY(getY() + tela.getAlturaQuadrante());
        direction = BOTTOM;
    }
}
