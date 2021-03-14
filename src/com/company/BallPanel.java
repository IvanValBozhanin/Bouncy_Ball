package com.company;

import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.event.*;

public class BallPanel extends JPanel {
    private int delay = 10;
    private ArrayList<Ball> list = new ArrayList<Ball>();
    // Create a timer with the initial delay
    protected Timer timer = new Timer(delay, new TimerListener());

    private class TimerListener implements ActionListener {
        @Override /** Handle the action event */
        public void actionPerformed(ActionEvent e) {
            repaint();
        }
    }

    public BallPanel() {
        timer.start();
    }

    public void add() {
        list.add(new Ball());
    }

    public void subtract() {
        if (list.size() > 0)
            list.remove(list.size() - 1); // Remove the last ball
    }

    public void mouseClicked(int mx, int my){
        for(int i=0;i<list.size();++i){
            int x = list.get(i).x;
            int y = list.get(i).y;
            int r = list.get(i).radius;
            if((mx-x)*(mx-x) + (my-y)*(my-y) <= r*r){
                list.remove(i);
                return;
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Ball value : list) {
            Ball ball = (Ball) value; // Get a ball
            g.setColor(ball.color); // Set ball color
            // Check boundaries
            if (ball.x < 0 || ball.x > getWidth())
                ball.dx = -ball.dx;
            if (ball.y < 0 || ball.y > getHeight())
                ball.dy = -ball.dy;
            // Adjust ball position
            ball.x += ball.dx;
            ball.y += ball.dy;
            g.fillOval(ball.x - ball.radius, ball.y - ball.radius, ball.radius * 2, ball.radius * 2);
        }
        for(int i = 0;i<list.size()-1;++i){
            int x1 = list.get(i).x;
            int y1 = list.get(i).y;
            int r1 = list.get(i).radius;
            for(int j=i+1;j<list.size();++j){
                int x2 = list.get(j).x;
                int y2 = list.get(j).y;
                int r2 = list.get(j).radius;
                if((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2) <= (r1+r2)*(r1+r2)){
                    list.get(i).radius += r2;
                    list.remove(j);
                    break;
                }
            }
        }
    }

    public void suspend() {
        timer.stop();
    }

    public void resume() {
        timer.start();
    }

    public void setDelay(int delay) {
        this.delay = delay;
        timer.setDelay(delay);
    }
}
