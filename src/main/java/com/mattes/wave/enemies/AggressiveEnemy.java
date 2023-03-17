package com.mattes.wave.enemies;

import com.mattes.wave.Game;
import com.mattes.wave.GameObject;
import com.mattes.wave.Handler;
import com.mattes.wave.ID;
import com.mattes.wave.Trail;

import java.awt.*;
import java.awt.image.BufferedImage;

import static com.mattes.wave.Game.STATE.Game;

public class AggressiveEnemy extends GameObject {

    private Handler handler;
    private BufferedImage enemy_image;

    public AggressiveEnemy(float x, float y, ID id, Handler handler) {
        super(x, y, id);
        this.handler=handler;
        velY = 20;
        velX = -5;


    }

    public AggressiveEnemy(float x, float y, ID id) {
        super(x, y, id);
    }


    public Rectangle getBounds()
    {
        return new Rectangle((int)x,(int)y,20,20);
    }


    public void tick() {
        x+=velX;
        y+=velY;
        // TODO Game? Game's not exposing these properly
        if(y<=0||y>= Game.HEIGHT -48) velY*=-1;
        if(x<=0||x>=Game.WIDTH -24) velX*=-1;
        handler.addObject(new Trail(x, y, ID.Trail, Color.red, 20, 20, 0.02f, handler));
    }

    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect((int)x, (int)y, 20, 20);
    }
}
