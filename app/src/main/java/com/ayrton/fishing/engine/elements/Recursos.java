package com.ayrton.fishing.engine.elements;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.ayrton.fishing.R;
import com.ayrton.fishing.engine.elements.util.Tela;

/**
 * Created by ayrton on 17/10/17.
 */

public class Recursos {
    public static final int ROCK_ID = 1;

    private Bitmap rock;
    private Resources resources;

    public Recursos(Resources res, Tela tela){
        resources = res;
        Bitmap b = BitmapFactory.decodeResource(resources, R.drawable.rocha);
        rock = Bitmap.createScaledBitmap(b, tela.getLarguraQuandrante(), tela.getAlturaQuadrante(), false);
    }

    public Bitmap getRock() {
        return rock;
    }

}
