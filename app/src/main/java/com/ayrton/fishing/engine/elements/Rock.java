package com.ayrton.fishing.engine.elements;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

import com.ayrton.fishing.R;
import com.ayrton.fishing.engine.elements.util.Screen;

/**
 * Created by ayrton on 25/10/17.
 */

public class Rock extends Viewable {

    public Rock(int x, int y, Resources resources, Screen screen){
        super(x, y, 1, 1);
        Bitmap b = BitmapFactory.decodeResource(resources, R.drawable.rocha);
        b = Bitmap.createScaledBitmap(b, screen.getLarguraQuandrante(), screen.getAlturaQuadrante(), false);
        this.addSprite(b);
    }

    public void paint(Canvas canvas){
        canvas.drawBitmap(this.getSprite(0), this.getX(), this.getY(), null);
    }
}
