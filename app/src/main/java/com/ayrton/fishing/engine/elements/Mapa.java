package com.ayrton.fishing.engine.elements;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

import com.ayrton.fishing.R;
import com.ayrton.fishing.engine.elements.util.Tela;

import java.util.Map;

/**
 * Created by ayrton on 17/10/17.
 */

public class Mapa {
    private int[][] elementos;
    private Tela tela;
    private Recursos recursos;

    public Mapa(Tela tela, Recursos recursos){
        elementos = new int[16][9];
        elementos[0][0] = Recursos.ROCK_ID;
        elementos[10][4] = Recursos.ROCK_ID;
        this.tela = tela;
        this.recursos = recursos;
    }

    public void paint(Canvas canvas){
        for (int i = 0; i < elementos.length; i++)
            for (int j = 0; j < elementos[i].length; j++) {
                paintResource(elementos[i][j], j * (tela.getLarguraQuandrante()), i * (tela.getAlturaQuadrante()), canvas);
            }
    }

    private void paintResource(int resourceID, int x, int y, Canvas canvas){
        switch (resourceID){
            case Recursos.ROCK_ID: canvas.drawBitmap(recursos.getRock(), x, y, null);
        }
    }
}
