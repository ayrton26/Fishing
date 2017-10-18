package com.ayrton.fishing;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.ayrton.fishing.engine.Game;

public class MainActivity extends Activity {

    private Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        game = new Game(this);
        FrameLayout frameLayout = findViewById(R.id.container);
        frameLayout.addView(game);


    }

    @Override
    public void onResume(){
        super.onResume();
        game.start();
    }

    @Override
    public void onPause(){
        super.onPause();
        game.end();
    }
}
