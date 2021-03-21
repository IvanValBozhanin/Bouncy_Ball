package com.company;

import java.awt.*;

public class Ball {
    int x = (int) (Math.random() * 400);
    int y = 0; // Current ball position
    int dx = (int) (Math.random() * 5) + 2; // Increment on ball's x-coordinate
    int dy = 2; // Increment on ball's y-coordinate
    int radius = 5; // Ball radius
    Color color = new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256));

    public Ball(int r){
        radius = r;
    }

}
