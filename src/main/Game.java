package main;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.io.File;
import java.util.Random;


public class Game extends Canvas implements Runnable {

    private static final long serialVersionUID = 15755241831643964L;
    public static final int WIDTH=640,HEIGHT=WIDTH/12*9;
    private Thread thread;
    private boolean running=false;
    public static boolean paused=false;
    public int diff=0;
    public static int lvl = 1;
    public static int currentlvl = lvl;
    public static int Accesslvl = 2;
    public int frames=0;
    public static int OutputFrames;
    public static boolean bosslevel;
    private main.Handler handler;
    private Random r;
    private HUD hud;

    private static Spawn spawner;
    private Menu menu;
    private Shop shop;
    Sound sound = new Sound();


    public enum STATE{
        Menu,
        Select,
        Game,
        Help,
        Credits,
        Settings,
        Shop,
        End,
        Selectlvl1,
        Selectlvl2,
        Win,
        SelectMode,
    };
    public static STATE gameState=STATE.Menu;

    public Game(){

        main.BufferedImageLoader loader=new main.BufferedImageLoader();
        spawner =new main.Spawn(handler,hud,this);
        handler=new main.Handler();
        hud=new main.HUD();
        shop=new main.Shop(handler,hud);
        menu=new main.Menu(this, handler,hud);
        this.addKeyListener(new main.KeyInput(handler,this));
        this.addMouseListener(menu);
        this.addMouseListener(shop);

        new main.Window(WIDTH,HEIGHT,"WAVE",this);
        spawner =new main.Spawn(handler,hud,this);

        r=new Random();
        if(gameState==STATE.Game)
        {
            handler.addObject(new Player(WIDTH/2-33,HEIGHT/2-32,ID.Player,handler));
        }else{
            for(int i=0;i<20;i++) {
                handler.addObject(new MenuParticle(r.nextInt(WIDTH),r.nextInt(HEIGHT),ID.MenuParticle,handler));
            }

        }

    }

    public synchronized void start()
    {
        thread=new Thread(this);
        thread.start();
        running=true;
    }

    public synchronized void stop()
    {
        try
        {
            thread.join();
            running=false;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public void run()
    {
        this.requestFocus(); //no need to press the screen
        long lastTime=System.nanoTime();
        double amountofticks=60.0;
        double ns= 1000000000/amountofticks;

        double delta=0;
        long timer=System.currentTimeMillis();
        while(running)
        {
            long now=System.nanoTime();
            delta +=(now - lastTime)/ns;
            lastTime=now;
            while(delta>=1)
            {
                tick();
                delta--;
            }
            if(running)
                render();
            frames++;

            if(System.currentTimeMillis() - timer>1000)
            {
                timer+=1000;
                  System.out.println("FPS: "+frames);
                  OutputFrames = frames;
                frames = 0;
            }

        }
        stop();
    }
    private void tick()
    {


        if(gameState==STATE.Game)
        {

            if(!paused)
            {

                hud.tick();
                spawner.tick();
                handler.tick();

                if(HUD.HEALTH<=0) {
                    HUD.HEALTH=100;
                    gameState=STATE.End;
                    handler.clearEnemys();
                    HUD.bounds=0;
                    shop.B1 = 100;
                    shop.B2 = 100;
                    shop.B3 = 100;
                    for(int i=0;i<20;i++) {
                        handler.addObject(new MenuParticle(r.nextInt(WIDTH),r.nextInt(HEIGHT),ID.MenuParticle,handler));
                    }
                }

                if (lvl != 100 && hud.getWave() == 3) {

                        gameState= STATE.Win;
                        hud.HEALTH=100;
                        hud.bounds=0;
                        shop.B1 = 100;
                        shop.B2 = 100;
                        shop.B3 = 100;
                        handler.clearEnemys();
                        for(int i=0;i<20;i++) {
                            handler.addObject(new MenuParticle(r.nextInt(WIDTH),r.nextInt(HEIGHT),ID.MenuParticle,handler));
                        }
                    }

            }
        }
        else if(gameState==STATE.Menu||gameState==STATE.End||gameState==STATE.Select || gameState==STATE.Selectlvl1 || gameState==STATE.Selectlvl2 || gameState==STATE.Help ||gameState == STATE.Win ||gameState == STATE.Credits ||gameState == STATE.Settings||gameState == STATE.SelectMode)
        {
            menu.tick();
            handler.tick();
        }

    }



    private void render()
    {
        BufferStrategy bs= this.getBufferStrategy();
        if(bs==null)
        {
            this.createBufferStrategy(3);
            return;
        }
        Graphics g=bs.getDrawGraphics();
        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH, HEIGHT);



        if(paused)
        {
            g.setColor(Color.white);
            g.drawString("PAUSED", 100, 100);
        }
        if(gameState==STATE.Game)
        {
            hud.render(g);
            handler.render(g);
        }
        else if(gameState==STATE.Shop){
            shop.render(g);
        }
        else if(gameState==STATE.Menu||gameState==STATE.Help||gameState==STATE.End||gameState==STATE.Select ||gameState == STATE.Selectlvl1 ||gameState == STATE.Selectlvl2 ||gameState == STATE.Win ||gameState == STATE.Credits ||gameState == STATE.Settings||gameState == STATE.SelectMode)
        {
            menu.render(g);
            handler.render(g);
        }


        g.dispose();
        bs.show();
    }
    public void PlayMusic(int i) {
        sound.setFile(i);
        sound.play();
        sound.loop();
    }
    public void StopMusic() {
        sound.stop();
    }
    public void PlaySE(int i) {
        sound.setFile(i);
        sound.play();
    }

    public static int clamp(float x,float min,float max)
    {
        if(x>=max)
            return (int) (x=max);
        else if(x<=min)
            return (int) (x=min);
        else
            return (int) x;
    }

    public int getLvl() {return lvl;}
    public void setLvl(int lvl) {this.lvl =lvl;}

    public static void main(String[] args) {
        new Game();
    }

}
