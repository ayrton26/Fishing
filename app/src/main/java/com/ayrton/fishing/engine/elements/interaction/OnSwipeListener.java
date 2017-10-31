package com.ayrton.fishing.engine.elements.interaction;

import com.ayrton.fishing.engine.elements.Direction;
import com.ayrton.fishing.engine.elements.Element;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ayrton on 25/10/17.
 */

public interface OnSwipeListener {

    public boolean verifyCollision(List<Element> elements, Direction direction);
    public void onSwipeTop();
    public void onSwipeRight();
    public void onSwipeLeft();
    public void onSwipeBottom();
}
