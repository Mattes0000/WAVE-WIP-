package main.Enemies;

import main.*;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;


public class FastEnemy extends GameObject {
    private Handler handler;
    private BufferedImage enemy_image;
    public FastEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler=handler;
        velX=2;
        velY=9;


    }
    public Rectangle getBounds()
    {
        return new Rectangle((int)x,(int)y,16,16);
    }


    public void tick() {
        x+=velX;
        y+=velY;
        if(y<=0||y>= Game.HEIGHT -48) velY*=-1;
        if(x<=0||x>=Game.WIDTH -24) velX*=-1;
        handler.addObject(new Trail(x, y, ID.Trail, Color.cyan, 20, 20, 0.02f, handler));
    }

    public void render(Graphics g) {

        g.fillRect((int)x, (int)y, 20, 20);
    }

    public static class EnemyBossBullet extends GameObject {
        private Handler handler;
        Random r=new Random();
        public EnemyBossBullet(int x, int y, ID id,Handler handler) {
            super(x, y, id);
            this.handler=handler;
            velX=(r.nextInt(5 - -5) + -5);
            velY=5;


        }
        public Rectangle getBounds()
        {
            return new Rectangle((int)x,(int)y,16,16);
        }


        public void tick() {
            x+=velX;
            y+=velY;
    //		if(y<=0||y>=Game.HEIGHT -32) velY*=-1;
    //		if(x<=0||x>=Game.WIDTH -16) velX*=-1;
            if(y>=Game.HEIGHT) handler.removeObject(this);
            handler.addObject(new Trail(x, y, ID.Trail, Color.red, 16, 16, 0.02f, handler));
        }

        public void render(Graphics g) {

            g.setColor(Color.red);
            g.fillRect((int)x, (int)y, 16, 16);
        }

    }
}
