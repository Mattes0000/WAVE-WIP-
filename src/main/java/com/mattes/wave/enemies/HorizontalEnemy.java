package com.mattes.wave.enemies;


import com.mattes.wave.*;

import java.awt.*;
import java.awt.image.BufferedImage;

public class HorizontalEnemy extends GameObject {

    private Handler handler;
    private BufferedImage enemy_image;

    public HorizontalEnemy(float x, float y, ID id, Handler handler) {
        super(x, y, id);
        this.handler=handler;
        velX = 35;


    }


    public Rectangle getBounds()
    {
        return new Rectangle((int)x,(int)y,20,20);
    }


    public void tick() {
        x+=velX;
        y+=velY;
        if(y<=0||y>= Game.HEIGHT -48) velY*=-1;
        if(x<=0||x>=Game.WIDTH -24) velX*=-1;
        handler.addObject(new Trail(x, y, ID.Trail, Color.red, 20, 20, 0.08f, handler));
    }

    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect((int)x, (int)y, 20, 20);
    }
}
