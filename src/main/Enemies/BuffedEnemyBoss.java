package main.Enemies;


import main.Enemies.BuffedEnemyBossBullet;
import main.Game;
import main.GameObject;
import main.Handler;
import main.ID;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;


public class BuffedEnemyBoss extends GameObject {
    private Handler handler;

    Random r=new Random();
    private int timer=60;
    private int timer2=40;
    public BuffedEnemyBoss(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler=handler;
        velX=0;
        velY=2;


    }
    public Rectangle getBounds()
    {
        return new Rectangle((int)x,(int)y,96,96);
    }


    public void tick() {
        x+=velX;
        y+=velY;
        if(timer<=0) velY=0;
        else timer--;
        if(timer<=0) timer2--;
        if(timer2<=0)
        {
            if(velX == 0) velX = 2;

            if(velX > 0)
                velX += 0.01f;

            else if(velX < 0)
                velX -= 0.01f;


            int spawn=r.nextInt(10);
            if(spawn==0) handler.addObject(new BuffedEnemyBossBullet((int)x+64, (int)y+64,ID.BuffedEnemyBoss, handler));
        }
//		if(y<=0||y>=Game.HEIGHT -32) velY*=-1;
        if(x<=0||x>= Game.WIDTH -96) velX*=-1;
        //handler.addObject(new Trail(x, y, ID.Trail, Color.red, 96, 96, 0.02f, handler));
    }

    public void render(Graphics g) {
         Color DARK_RED = new Color(139, 0,0);

        g.setColor(DARK_RED);
        g.fillRect((int)x, (int)y, 112, 112);
    }

}
