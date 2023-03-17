package main.Enemies;

import main.*;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;


public class BuffedEnemyBossBullet extends GameObject {
    private Handler handler;
    Random r=new Random();
    public BuffedEnemyBossBullet(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler=handler;
        velX=(r.nextInt(5 - -5) + -5);
        velY=5;


    }
    public Rectangle getBounds()
    {
        return new Rectangle((int)x,(int)y,20,20);
    }


    public void tick() {
        x+=velX;
        y+=velY;
//		if(y<=0||y>=Game.HEIGHT -32) velY*=-1;
//		if(x<=0||x>=Game.WIDTH -16) velX*=-1;
        if(y>= Game.HEIGHT) handler.removeObject(this);
        handler.addObject(new Trail(x, y, ID.Trail, Color.red, 20, 20, 0.04f, handler));
    }

    public void render(Graphics g) {
        Color DARK_RED = new Color(139, 0,0);

        g.setColor(DARK_RED);
        g.fillRect((int)x, (int)y, 20, 20);
    }

}
