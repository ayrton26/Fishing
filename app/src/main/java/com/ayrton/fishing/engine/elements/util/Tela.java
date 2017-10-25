package com.ayrton.fishing.engine.elements.util;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

/**
 * Created by ayrton on 23/08/17.
 */

public class Tela {
    private DisplayMetrics displayMetrics;
    private int quantidadeQuadranteHorizontal;
    private int quantidadeQuadranteVertical;

    public Tela(Context context, int quantidadeQuadranteHorizontal, int quantidadeQuadranteVertical){
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display d = wm.getDefaultDisplay();
        this.displayMetrics = new DisplayMetrics();
        d.getMetrics(this.displayMetrics);
        this.quantidadeQuadranteHorizontal = quantidadeQuadranteHorizontal;
        this.quantidadeQuadranteVertical = quantidadeQuadranteVertical;

    }

    public int getAltura(){
        return this.displayMetrics.heightPixels;
    }
    public int getLargura(){
        return this.displayMetrics.widthPixels;
    }

    public int getQuantidadeQuadranteHorizontal(){
        return this.quantidadeQuadranteHorizontal;
    }
    public int getQuantidadeQuadranteVertical(){
        return this.quantidadeQuadranteVertical;
    }

    public int getLarguraQuandrante(){
        return getLargura()/getQuantidadeQuadranteHorizontal();
    }
    public int getAlturaQuadrante(){
        return getAltura()/getQuantidadeQuadranteVertical();
    }

    public int quadranteX2Pixels(int x){
        return x * getLarguraQuandrante();
    }
    public int quadranteY2Pixels(int y){
        return y * getAlturaQuadrante();
    }
}
