package com.ayrton.fishing.engine.elements;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.ayrton.fishing.R;
import com.ayrton.fishing.engine.elements.util.Screen;

/**
 * Created by ayrton on 12/12/17.
 */

public class Tire extends Fishable {
    public Tire(int x, int y, Resources resources, Screen screen){
        super(x, y, -1);

        Bitmap b = BitmapFactory.decodeResource(resources, R.drawable.pneu);
        b = Bitmap.createScaledBitmap(b, screen.getLarguraQuandrante(), screen.getAlturaQuadrante(), false);
        this.setSprite(b);
    }
}
