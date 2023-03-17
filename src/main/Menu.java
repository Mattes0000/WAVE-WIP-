package main;

import main.Enemies.BasicEnemy;
import main.Enemies.HardEnemy;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;



public class Menu extends MouseAdapter {
    private Game game;
    private Handler handler;
    private HUD hud;
    private Random r=new Random();
    public Menu(Game game, Handler handler,HUD hud) {
        this.game=game;
        this.hud=hud;
        this.handler=handler;
    }
    public void mousePressed(MouseEvent e)
    {
        int mx=e.getX();
        int my=e.getY();
        if(game.gameState== Game.STATE.Menu) {
            //play button
            if(mouseOver(mx, my,210, 150, 200,64)) {
                game.gameState= Game.STATE.SelectMode;

                return;
            }
            if(mouseOver(mx, my,315,250,200,64)) { //mx, my,210, 250, 200,64
                game.gameState= Game.STATE.Settings;

            }
            //help button
            if(mouseOver(mx, my,105,250,200,64)) { //mx, my,210, 250, 200,64
                game.gameState= Game.STATE.Help;

            }


            //quit button
            if(mouseOver(mx, my,105,350,200,64)) { //mx, my,210, 350, 200,64
                System.exit(1);
            }

            if(mouseOver(mx, my,315,350,200,64)) { //mx, my,210, 250, 200,64
                game.gameState= Game.STATE.Credits;

            }

        }
        if(game.gameState==  Game.STATE.Credits) {
            if(mouseOver(mx, my,210,350,200,64)) {
                game.gameState= Game.STATE.Menu;
                return;
            }
        }
        if(game.gameState== Game.STATE.Select) {
            //normal button
            if(mouseOver(mx, my,210, 150, 200,64)) {
                game.gameState= Game.STATE.Game;
                handler.addObject(new Player(Game.WIDTH/2-32,Game.HEIGHT/2-32,ID.Player,handler));
                handler.clearEnemys();
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH- 50),r.nextInt(Game.HEIGHT- 50),ID.BasicEnemy,handler));
                game.diff=0;

            }
            //hard button
            if(mouseOver(mx, my,210, 250, 200,64)) {
                game.gameState= Game.STATE.Game;
                handler.addObject(new Player(Game.WIDTH/2-32,Game.HEIGHT/2-32,ID.Player,handler));
                handler.clearEnemys();
                handler.addObject(new HardEnemy(r.nextInt(Game.WIDTH- 50),r.nextInt(Game.HEIGHT- 50),ID.BasicEnemy,handler));
                game.diff=1;

            }



            //back button
            if(mouseOver(mx, my,210, 350, 200,64)) {
                game.gameState= Game.STATE.Selectlvl1;

                return;
            }

        }
        //Select Level
        if(game.gameState== Game.STATE.Selectlvl1) {

            if(mouseOver(mx, my,5,150,200,64)) {
                game.gameState= Game.STATE.Game;
                handler.addObject(new Player(Game.WIDTH/2-32,Game.HEIGHT/2-32,ID.Player,handler));
                handler.clearEnemys();
                game.lvl = 1;
                System.out.println(game.lvl);
            }

            if(mouseOver(mx, my,210,150,200,64)) {
                game.gameState= Game.STATE.Game;
                handler.addObject(new Player(Game.WIDTH/2-32,Game.HEIGHT/2-32,ID.Player,handler));
                handler.clearEnemys();
                game.lvl = 2;
                System.out.println(game.lvl);
            }

            if(mouseOver(mx, my,417,150,200,64)) {
                game.gameState= Game.STATE.Game;
                handler.addObject(new Player(Game.WIDTH/2-32,Game.HEIGHT/2-32,ID.Player,handler));
                handler.clearEnemys();
                game.lvl = 3;
                System.out.println(game.lvl);
            }

            if(mouseOver(mx, my,5,250,200,64)) {
                game.gameState= Game.STATE.Game;
                handler.addObject(new Player(Game.WIDTH/2-32,Game.HEIGHT/2-32,ID.Player,handler));
                handler.clearEnemys();
                game.lvl = 4;
                System.out.println(game.lvl);
            }
            if(mouseOver(mx, my,210, 250, 200,64)) {
                game.gameState= Game.STATE.Game;
                handler.addObject(new Player(Game.WIDTH/2-32,Game.HEIGHT/2-32,ID.Player,handler));
                handler.clearEnemys();
                game.lvl = 5;
                System.out.println(game.lvl);
            }
            if(mouseOver(mx, my,417,250,200,64)) {
                game.gameState= Game.STATE.Game;
                handler.addObject(new Player(Game.WIDTH/2-32,Game.HEIGHT/2-32,ID.Player,handler));
                handler.clearEnemys();
                game.lvl = 6;
                System.out.println(game.lvl);
            }




            //back button
            if(mouseOver(mx, my,5, 350, 200,64)) {
                game.gameState= Game.STATE.SelectMode;

                return;
            }
            if(mouseOver(mx, my,417,350,200,64)) {
                game.gameState = Game.STATE.Selectlvl2;
            }

        }
        if(game.gameState== Game.STATE.Selectlvl2) {
            //lvl 1
            if(mouseOver(mx, my,5,150,200,64)) {
                game.gameState= Game.STATE.Game;
                handler.addObject(new Player(Game.WIDTH/2-32,Game.HEIGHT/2-32,ID.Player,handler));
                handler.clearEnemys();
                game.lvl = 7;
                System.out.println(game.lvl);
            }

            if(mouseOver(mx, my,210,150,200,64)) {
                game.gameState= Game.STATE.Game;
                handler.addObject(new Player(Game.WIDTH/2-32,Game.HEIGHT/2-32,ID.Player,handler));
                handler.clearEnemys();
                game.lvl = 8;
                System.out.println(game.lvl);
            }
            if(mouseOver(mx, my,417,150,200,64)) {
                game.gameState= Game.STATE.Game;
                handler.addObject(new Player(Game.WIDTH/2-32,Game.HEIGHT/2-32,ID.Player,handler));
                handler.clearEnemys();
                game.lvl = 9;
                System.out.println(game.lvl);
            }
            if(mouseOver(mx, my,5,250,200,64)) {
                game.gameState= Game.STATE.Game;
                handler.addObject(new Player(Game.WIDTH/2-32,Game.HEIGHT/2-32,ID.Player,handler));
                handler.clearEnemys();
                game.lvl = 10;
                System.out.println(game.lvl);
            }            if(mouseOver(mx, my,210, 250, 200,64)) {
                game.gameState= Game.STATE.Game;
                handler.addObject(new Player(Game.WIDTH/2-32,Game.HEIGHT/2-32,ID.Player,handler));
                handler.clearEnemys();
                game.lvl = 11;
                System.out.println(game.lvl);
            }
            if(mouseOver(mx, my,417,250,200,64)) {
                game.gameState= Game.STATE.Game;
                handler.addObject(new Player(Game.WIDTH/2-32,Game.HEIGHT/2-32,ID.Player,handler));
                handler.clearEnemys();
                game.lvl = 12;
                System.out.println(game.lvl);
            }



            //back button
            if(mouseOver(mx, my,5, 350, 200,64)) {
                game.gameState= Game.STATE.SelectMode;

                return;
            }
            if(mouseOver(mx, my,210,350,200,64)) {
                game.gameState = Game.STATE.Selectlvl1;
            }

        }


        //back button for help
        if(game.gameState== Game.STATE.Help) {
            if(mouseOver(mx, my,210,350,200,64)) {
                game.gameState= Game.STATE.Menu;
                return;
            }
        }
        if(game.gameState== Game.STATE.Settings) {
            if(mouseOver(mx, my,210,350,200,64)) {
                game.gameState= Game.STATE.Menu;
                return;
            }
        }
        if(game.gameState== Game.STATE.End) {
            if(mouseOver(mx, my,210,350,200,64)) {
                game.gameState= Game.STATE.SelectMode;
                hud.setWave(1);
                hud.setScore(0);
            }
        }
        if(game.gameState== Game.STATE.Win) {
            if(mouseOver(mx, my,210,350,200,64)) {
                game.gameState= Game.STATE.SelectMode;
                hud.setWave(1);
                hud.setScore(0);
            }
        }
        if (game.gameState== Game.STATE.SelectMode){
            if(mouseOver(mx, my,210, 150, 200, 64)) {
                game.gameState= Game.STATE.Selectlvl1;
                return;
            }
            if(mouseOver(mx, my,210, 250, 200, 64)) {
                game.gameState= Game.STATE.Game;
                handler.addObject(new Player(Game.WIDTH/2-32,Game.HEIGHT/2-32,ID.Player,handler));
                handler.clearEnemys();
                game.lvl = 1000;
                return;
            }
            if(mouseOver(mx, my,210, 350, 200, 64)) {
                game.gameState= Game.STATE.Menu;
                return;
            }
        }
    }
    public void mouseReleased(MouseEvent e)
    {

    }


    public void tick() {

    }
    private boolean mouseOver(int mx, int my,int x, int y, int width, int height) {
        if(mx>x&&mx<x+width)
        {
            if(my>y&&my<y+height)
            {
                return true;
            }else return false;
        }else return false;
    }
    public void render(Graphics g) {
        if(game.gameState== Game.STATE.Menu) {
            Font fnt=new Font("arial",1,50);
            Font fnt2=new Font("arial",1,30);
            g.setFont(fnt);
            g.setColor(Color.white);
            g.drawString("Wave", 240, 70);

            g.setFont(fnt2);
            g.drawRect(210,150,200,64);//g.drawRect(210,150,200,64);
            g.drawString("Play", 280, 190);//g.drawString("Play", 270, 190);

            g.drawRect(105,250,200,64);//g.drawRect(210,250,200,64);
            g.drawString("Help", 170, 290);//g.drawString("Help", 270, 290);

            g.drawRect(315,250,200,64);//g.drawRect(210,250,200,64);
            g.drawString("Settings", 360, 290);//g.drawString("Help", 270, 290);


            g.drawRect(105,350,200,64);//g.drawRect(210,350,200,64);
            g.drawString("Quit", 170, 390);//g.drawString("Quit", 270, 390);

            g.drawRect(315,350,200,64);//g.drawRect(210,350,200,64);
            g.drawString("Credits", 365, 390);//g.drawString("Quit", 270, 390);
        }
        else if(game.gameState== Game.STATE.Help) {
            Font fnt=new Font("arial",1,50);
            Font fnt2=new Font("arial",1,30);
            Font fnt3=new Font("arial",1,20);
            g.setFont(fnt);
            g.setColor(Color.white);
            g.drawString("Help", 260, 70);

            g.setFont(fnt3);
            g.drawString("Use the arrow keys to move the player and dodge enemies",20,200);
            g.drawString("and P to pause the game",20,250);
            g.drawString("Press exit to close the game", 20,300);


            g.setFont(fnt2);
            g.drawRect(210,350,200,64);
            g.drawString("Back", 270, 390);
        }
        else if(game.gameState== Game.STATE.Credits) {
            Font fnt=new Font("arial",1,50);
            Font fnt2=new Font("arial",1,30);
            Font fnt3=new Font("arial",1,20);
            g.setFont(fnt);
            g.setColor(Color.white);
            g.drawString("Credits", 240, 70);

            g.setFont(fnt3);
            g.drawString("Developer (build game skeleton): RealTutsGML",20,200);
            g.drawString("Developer : Mattes",20,250);
            g.drawString("Music artist: Mattes", 20,300);


            g.setFont(fnt2);
            g.drawRect(210,350,200,64);
            g.drawString("Back", 270, 390);

        }
        else if(game.gameState== Game.STATE.Settings) {
            Font fnt=new Font("arial",1,50);
            Font fnt2=new Font("arial",1,30);
            Font fnt3=new Font("arial",1,20);
            g.setFont(fnt);
            g.setColor(Color.white);
            g.drawString("Settings", 210, 70);



            g.setFont(fnt2);
            g.drawRect(210,350,200,64);
            g.drawString("Back", 270, 390);
        }
        else if(game.gameState== Game.STATE.Select) {
            Font fnt = new Font("arial", 1, 50);
            Font fnt2 = new Font("arial", 1, 30);
            g.setFont(fnt);
            g.setColor(Color.white);
            g.drawString("SELECT DIFFICULTY", 70, 70);

            g.setFont(fnt2);
            g.drawRect(210, 150, 200, 64);
            g.drawString("Normal", 270, 190);

            g.drawRect(210, 250, 200, 64);
            g.drawString("Hard", 270, 290);

            g.drawRect(210, 350, 200, 64);
            g.drawString("Back", 270, 390);
        }
        else if (game.gameState == Game.STATE.Selectlvl1) {
            Font fnt=new Font("arial",1,50);
            Font fnt2=new Font("arial",1,30);
            g.setFont(fnt);
            g.setColor(Color.white);
            g.drawString("Select Level", 165, 50);

            g.setFont(fnt2);
            g.drawString("Page 1/2",260, 100);



            g.drawRect(5,150,200,64);
            g.drawString("Level 1", 60, 190);

            if (game.Accesslvl < 3) {
                g.setColor(Color.GRAY);
            }
            g.drawRect(210,150,200,64);
            g.drawString("Level 2", 260, 190);

            if (game.Accesslvl < 4) {
                g.setColor(Color.GRAY);
            }

            g.drawRect(417,150,200,64);
            g.drawString("Level 3", 460, 190);

            if (game.Accesslvl < 5) {
                g.setColor(Color.GRAY);
            }

            g.drawRect(5,250,200,64);
            g.drawString("Level 4", 60, 290);

            if (game.Accesslvl < 6) {
                g.setColor(Color.GRAY);
            }

            g.drawRect(210,250,200,64);
            g.drawString("Level 5", 260, 290);

            if (game.Accesslvl < 7) {
                g.setColor(Color.GRAY);
            }

            g.drawRect(417,250,200,64);
            g.drawString("Boss", 480, 290);



            g.setColor(Color.WHITE);
            g.drawRect(5,350,200,64);
            g.drawString("Back", 70, 390);


            g.drawRect(417,350,200,64);
            g.drawString("Next page", 450, 390);
            g.setColor(Color.gray);
            g.drawRect(210,350,200,64);
            g.drawString("Last page", 240, 390);



        }
        else if (game.gameState == Game.STATE.Selectlvl2) {
            Font fnt=new Font("arial",1,50);
            Font fnt2=new Font("arial",1,30);
            g.setFont(fnt);
            g.setColor(Color.white);
            g.drawString("Select Level", 165, 50);

            g.setFont(fnt2);

            g.drawString("Page 2/2",260, 100);

            g.drawRect(5,150,200,64);
            g.drawString("Level 7", 70, 190);

            g.drawRect(210,150,200,64);
            g.drawString("Level 8", 270, 190);

            g.drawRect(417,150,200,64);
            g.drawString("Level 9", 470, 190);

            g.drawRect(5,250,200,64);
            g.drawString("Level 10", 70, 290);

            g.drawRect(210,250,200,64);
            g.drawString("Level 11", 270, 290);

            g.drawRect(417,250,200,64);
            g.drawString("Super boss", 435, 290);

            g.setColor(Color.WHITE);
            g.drawRect(5,350,200,64);
            g.drawString("Back", 70, 390);
            g.setColor(Color.gray);
            g.drawRect(417,350,200,64);
            g.drawString("Next page", 450, 390);
            g.setColor(Color.WHITE);
            g.drawRect(210,350,200,64);
            g.drawString("Last page", 240, 390);



        }
        else if(game.gameState== Game.STATE.End) {
            Font fnt=new Font("arial",1,50);
            Font fnt2=new Font("arial",1,30);
            Font fnt3=new Font("arial",1,20);

            g.setFont(fnt);
            g.setColor(Color.white);
            g.drawString("Game Over", 177, 70);

            g.setFont(fnt3);
            g.drawString("You lost with a score of: "+ hud.getScore(),175,200);

            g.setFont(fnt2);
            g.drawRect(210,350,200,64);
            g.drawString("Try Again", 240, 390);
        }
        else if (game.gameState== Game.STATE.Win) {
            Font fnt=new Font("arial",1,50);
            Font fnt2=new Font("arial",1,30);
            Font fnt3=new Font("arial",1,20);

            g.setFont(fnt);
            g.setColor(Color.white);
            g.drawString("Congratulations!", 110, 70);

            g.setFont(fnt3);
            g.drawString("You have won, you may play the next level.",115,200);

            g.setFont(fnt2);
            g.drawRect(210,350,200,64);
            g.drawString("Back", 270, 390);
        }
        else if (game.gameState== Game.STATE.SelectMode){
            Font fnt = new Font("arial", 1, 50);
            Font fnt2 = new Font("arial", 1, 30);
            g.setFont(fnt);
            g.setColor(Color.white);
            g.drawString("SELECT MODE", 90, 70);

            g.setFont(fnt2);
            g.drawRect(210, 150, 200, 64);
            g.drawString("Story", 270, 190);

            g.drawRect(210, 250, 200, 64);
            g.drawString("\"Survive\"", 240, 290);

            g.drawRect(210, 350, 200, 64);
            g.drawString("Back", 270, 390);
        }



    }
}
