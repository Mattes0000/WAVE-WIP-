package com.mattes.wave.enemies;


import com.mattes.wave.*;

import java.awt.*;
import java.util.Random;
import java.util.Random;

public class HardEnemy extends GameObject {
    private Handler handler;
    private Random r = new Random();

    public HardEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        velX = 5;
        velY = 5;


    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 16, 16);
    }


    public void tick() {
        x += velX;
        y += velY;
        if (y <= 0 || y >= Game.HEIGHT - 48) {
            if (velY < 0) velY = -(r.nextInt(7) + 1) * -1;
            else velY = (r.nextInt(7) + 1) * -1;
        }
        if (x <= 0 || x >= Game.WIDTH - 24) {
            if (velX < 0) velX = -(r.nextInt(7) + 1) * -1;
            else velX = (r.nextInt(7) + 1) * -1;
        }
        handler.addObject(new Trail(x, y, ID.Trail, Color.yellow, 20, 20, 0.02f, handler));
    }

    public void render(Graphics g) {

        g.fillRect((int) x, (int) y, 20, 20);
    }

}
