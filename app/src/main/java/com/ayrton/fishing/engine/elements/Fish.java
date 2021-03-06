package com.ayrton.fishing.engine.elements;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.ayrton.fishing.R;
import com.ayrton.fishing.engine.elements.util.Screen;

/**
 * Created by ayrton on 01/12/17.
 */

class Fish extends Fishable {
    public Fish(int x, int y , Resources resources, Screen screen) {
        super(x, y, 2);
        Bitmap b = BitmapFactory.decodeResource(resources, R.drawable.fish);
        b = Bitmap.createScaledBitmap(b, screen.getLarguraQuandrante(), screen.getAlturaQuadrante(), false);
        this.setSprite(b);
    }
}
