package com.ayrton.fishing.engine.elements;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

import com.ayrton.fishing.R;
import com.ayrton.fishing.engine.elements.util.Tela;

/**
 * Created by ayrton on 18/10/17.
 */

public class Barco {

    private Bitmap boat_d;
    private Bitmap boat_e;
    private Bitmap boat_c;
    private Bitmap boat_b;
    private Direcao direcao;
    private int x;
    private int y;
    private Tela tela;

    public Barco(Tela tela, Resources resources, int x, int y){
        this.tela = tela;
        Bitmap b = BitmapFactory.decodeResource(resources, R.drawable.barco_d);
        boat_d = Bitmap.createScaledBitmap(b, tela.getLarguraQuandrante()*2, tela.getAlturaQuadrante(), false);
        b = BitmapFactory.decodeResource(resources, R.drawable.barco_e);
        boat_e = Bitmap.createScaledBitmap(b, tela.getLarguraQuandrante()*2, tela.getAlturaQuadrante(), false);
        b = BitmapFactory.decodeResource(resources, R.drawable.barco_c);
        boat_c = Bitmap.createScaledBitmap(b, tela.getLarguraQuandrante(), tela.getAlturaQuadrante()*2, false);
        b = BitmapFactory.decodeResource(resources, R.drawable.barco_b);
        boat_b = Bitmap.createScaledBitmap(b, tela.getLarguraQuandrante(), tela.getAlturaQuadrante()*2, false);
        direcao = Direcao.LESTE;
        setXY(x, y);
    }

    public void setXY(int x, int y){
        this.x = x * tela.getLarguraQuandrante();
        this.y = y * tela.getAlturaQuadrante();
    }


    public void paint(Canvas canvas) {
        switch (direcao){
            case LESTE: canvas.drawBitmap(boat_d, x, y, null);
                break;
            case OESTE: canvas.drawBitmap(boat_e, x, y, null);
                break;
            case NORTE: canvas.drawBitmap(boat_c, x, y, null);
                break;
            case SUL: canvas.drawBitmap(boat_b, x, y, null);
        }
    }

    public void move(Direcao direcao) {
        this.direcao = direcao;
        switch (direcao){
            case LESTE: x+=tela.getLarguraQuandrante();
                break;
            case OESTE: x-=tela.getLarguraQuandrante();
                break;
            case NORTE: y-=tela.getAlturaQuadrante();
                break;
            case SUL: y+=tela.getAlturaQuadrante();
        }
    }

    public int getXQuandrante() {
        return x/tela.getLarguraQuandrante();
    }

    public int getYQuadrante() {
        return y/tela.getAlturaQuadrante();
    }
}
