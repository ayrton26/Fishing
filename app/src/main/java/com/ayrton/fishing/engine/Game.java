package com.ayrton.fishing.engine;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import com.ayrton.fishing.engine.elements.util.Cores;
import com.ayrton.fishing.engine.elements.util.Tela;

import java.util.ArrayList;

/**
 * Created by ayrton on 13/10/17.
 */

public class Game extends SurfaceView implements Runnable, View.OnTouchListener {
    private boolean started;
    private SurfaceHolder surfaceHolder;
    private Tela tela;
    private int[][] elementos;

    public Game(Context context) {
        super(context);
        started = false;
        surfaceHolder = getHolder();
        tela = new Tela(this.getContext());
        setOnTouchListener(this);
        elementos = new int[16][9];
    }


    public void start(){
        started = true;
        reset();
        new Thread(this).start();
    }

    public void reset() {

    }

    @Override
    public void run() {
        while (true) {
            if (!this.surfaceHolder.getSurface().isValid()) {
                continue;
            }
            Canvas canvas = this.surfaceHolder.lockCanvas();

            canvas.drawRect(0, 0, tela.getLargura(), tela.getAltura(), Cores.getBlue());

            this.surfaceHolder.unlockCanvasAndPost(canvas);
        }
    }

    public void end() {
        started = false;
    }

    @Override
    public boolean onTouch(View v, MotionEvent e) {
        return false;
    }

}

