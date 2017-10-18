package com.ayrton.fishing.engine.elements;

import android.graphics.Canvas;

import com.ayrton.fishing.engine.elements.util.Tela;

/**
 * Created by ayrton on 17/10/17.
 */

public class Mapa {
    private int[][] elementos;
    private Tela tela;
    private Recursos recursos;
    private Barco barco;

    public Mapa(Tela tela, Recursos recursos){
        elementos = new int[16][9];
        elementos[0][0] = Recursos.ROCK_ID;
        elementos[10][4] = Recursos.ROCK_ID;
        elementos[5][5] = Recursos.ISLAND_ID;
        elementos[3][3] = Recursos.BOAT_ID;
        this.tela = tela;
        this.recursos = recursos;
        barco = new Barco(tela, recursos.getResources(), 3, 3);
    }

    public void paint(Canvas canvas){
        barco.paint(canvas);
        for (int i = 0; i < elementos.length; i++)
            for (int j = 0; j < elementos[i].length; j++) {
                paintResource(elementos[i][j], j * (tela.getLarguraQuandrante()), i * (tela.getAlturaQuadrante()), canvas);
            }
    }

    private void paintResource(int resourceID, int x, int y, Canvas canvas){
        switch (resourceID){
            case Recursos.ROCK_ID: canvas.drawBitmap(recursos.getRock(), x, y, null);
                break;
            case Recursos.ISLAND_ID: canvas.drawBitmap(recursos.getIsland(), x, y, null);
                break;
        }
    }

    public void onSwipeTop() {
        this.elementos[barco.getYQuadrante()][barco.getXQuandrante()] = 0;
        barco.move(Direcao.NORTE);
        this.elementos[barco.getYQuadrante()][barco.getXQuandrante()] = Recursos.BOAT_ID;
    }
    public void onSwipeRight() {
        this.elementos[barco.getYQuadrante()][barco.getXQuandrante()] = 0;
        barco.move(Direcao.LESTE);
        this.elementos[barco.getYQuadrante()][barco.getXQuandrante()] = Recursos.BOAT_ID;
    }
    public void onSwipeLeft() {
        this.elementos[barco.getYQuadrante()][barco.getXQuandrante()] = 0;
        barco.move(Direcao.OESTE);
        this.elementos[barco.getYQuadrante()][barco.getXQuandrante()] = Recursos.BOAT_ID;
    }
    public void onSwipeBottom() {
        this.elementos[barco.getYQuadrante()][barco.getXQuandrante()] = 0;
        barco.move(Direcao.SUL);
        this.elementos[barco.getYQuadrante()][barco.getXQuandrante()] = Recursos.BOAT_ID;
    }
}
