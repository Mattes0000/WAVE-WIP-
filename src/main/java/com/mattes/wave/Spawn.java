package com.mattes.wave;


import com.mattes.wave.enemies.BasicEnemy;
import com.mattes.wave.enemies.FastEnemy;
import com.mattes.wave.enemies.HardEnemy;
import com.mattes.wave.enemies.SmartEnemy;
import com.mattes.wave.enemies.EnemyBoss;

import java.util.Random;

public class Spawn {
    private Handler handler;
    private EnemyBoss EnemyBoss;
    private HUD hud;
    private Game game;
    private Random r = new Random();
    private int scoreKeep = 0;
    private Game.STATE gameState;



    public Spawn(Handler handler, HUD hud, Game game) {
        this.handler = handler;
        this.hud = hud;
        this.game = game;
    }

    public void tick() {


        scoreKeep++;
        if (scoreKeep >= 250) {
            scoreKeep = 0;
            hud.setWave(hud.getWave() + 1);


            if (game.lvl == 1) {
                bosslevel = false;
                    if (hud.getWave() == 2) {

                    } else if (hud.getWave() == 1000) {

                        gameState = Game.STATE.Win;
                        HUD.HEALTH = 100;
                        handler.clearEnemys();
                        for (int i = 0; i < 20; i++) {
                            handler.addObject(new MenuParticle(r.nextInt(WIDTH), r.nextInt(HEIGHT), ID.MenuParticle, handler));
                        }
                    }
            }
            if (game.lvl == 2){
                bosslevel = false;
                if (game.diff == 0) {


                    if (hud.getWave() == 2) {
                        handler.addObject(new HardEnemy(r.nextInt(WIDTH - 50), r.nextInt(HEIGHT - 50), ID.BasicEnemy, handler));
                        handler.addObject(new HardEnemy(r.nextInt(WIDTH - 50), r.nextInt(HEIGHT - 50), ID.BasicEnemy, handler));
                        handler.addObject(new HardEnemy(r.nextInt(WIDTH - 50), r.nextInt(HEIGHT - 50), ID.BasicEnemy, handler));
                        handler.addObject(new HardEnemy(r.nextInt(WIDTH - 50), r.nextInt(HEIGHT - 50), ID.BasicEnemy, handler));
                        handler.addObject(new HardEnemy(r.nextInt(WIDTH - 50), r.nextInt(HEIGHT - 50), ID.BasicEnemy, handler));
                        handler.addObject(new HardEnemy(r.nextInt(WIDTH - 50), r.nextInt(HEIGHT - 50), ID.BasicEnemy, handler));
                        handler.addObject(new HardEnemy(r.nextInt(WIDTH - 50), r.nextInt(HEIGHT - 50), ID.BasicEnemy, handler));
                        handler.addObject(new HardEnemy(r.nextInt(WIDTH - 50), r.nextInt(HEIGHT - 50), ID.BasicEnemy, handler));
                        handler.addObject(new HardEnemy(r.nextInt(WIDTH - 50), r.nextInt(HEIGHT - 50), ID.BasicEnemy, handler));
                        handler.addObject(new HardEnemy(r.nextInt(WIDTH - 50), r.nextInt(HEIGHT - 50), ID.BasicEnemy, handler));
                        handler.addObject(new HardEnemy(r.nextInt(WIDTH - 50), r.nextInt(HEIGHT - 50), ID.BasicEnemy, handler));
                        handler.addObject(new HardEnemy(r.nextInt(WIDTH - 50), r.nextInt(HEIGHT - 50), ID.BasicEnemy, handler));


                    } else if (hud.getWave() == 3) {
                        handler.addObject(new HardEnemy(r.nextInt(WIDTH - 50), r.nextInt(HEIGHT - 50), ID.BasicEnemy, handler));
                    } else if (hud.getWave() == 4) {
                        handler.addObject(new FastEnemy(r.nextInt(WIDTH - 50), r.nextInt(HEIGHT - 50), ID.FastEnemy, handler));
                    } else if (hud.getWave() == 5) {
                        handler.addObject(new SmartEnemy(r.nextInt(WIDTH - 50), r.nextInt(HEIGHT - 50), ID.SmartEnemy, handler));
                        handler.addObject(new SmartEnemy(r.nextInt(WIDTH - 50), r.nextInt(HEIGHT - 50), ID.SmartEnemy, handler));
                    } else if (hud.getWave() == 6) {
                        handler.addObject(new FastEnemy(r.nextInt(WIDTH - 50), r.nextInt(HEIGHT - 50), ID.FastEnemy, handler));
                    } else if (hud.getWave() == 7) {
                        handler.addObject(new FastEnemy(r.nextInt(WIDTH - 50), r.nextInt(HEIGHT - 50), ID.FastEnemy, handler));
                    } else if (hud.getWave() == 30) {
                        handler.clearEnemys();
                        handler.addObject(new EnemyBoss((WIDTH / 2) - 48, -120, ID.EnemyBoss, handler));
                    } else if (hud.getWave() == 45) {
                        handler.clearEnemys();
                        handler.addObject(new HardEnemy(r.nextInt(WIDTH - 50), r.nextInt(HEIGHT - 50), ID.HardEnemy, handler));
                        handler.addObject(new SmartEnemy(r.nextInt(WIDTH - 50), r.nextInt(HEIGHT - 50), ID.SmartEnemy, handler));
                        handler.addObject(new SmartEnemy(r.nextInt(WIDTH - 50), r.nextInt(HEIGHT - 50), ID.SmartEnemy, handler));
                        handler.addObject(new FastEnemy(r.nextInt(WIDTH - 50), r.nextInt(HEIGHT - 50), ID.FastEnemy, handler));
                        handler.addObject(new FastEnemy(r.nextInt(WIDTH - 50), r.nextInt(HEIGHT - 50), ID.FastEnemy, handler));
                    } else if (hud.getWave() == 50) {
                        handler.addObject(new HardEnemy(r.nextInt(WIDTH - 50), r.nextInt(HEIGHT - 50), ID.HardEnemy, handler));
                        handler.addObject(new SmartEnemy(r.nextInt(WIDTH - 50), r.nextInt(HEIGHT - 50), ID.SmartEnemy, handler));
                        handler.addObject(new HardEnemy(r.nextInt(WIDTH - 50), r.nextInt(HEIGHT - 50), ID.BasicEnemy, handler));
                        handler.addObject(new HardEnemy(r.nextInt(WIDTH - 50), r.nextInt(HEIGHT - 50), ID.BasicEnemy, handler));

                        handler.addObject(new BasicEnemy(r.nextInt(WIDTH - 50), r.nextInt(HEIGHT - 50), ID.BasicEnemy, handler));
                        handler.addObject(new HardEnemy(r.nextInt(WIDTH - 50), r.nextInt(HEIGHT - 50), ID.BasicEnemy, handler));
                    } else if (hud.getWave() == 65) {
                        handler.addObject(new SmartEnemy(r.nextInt(WIDTH - 50), r.nextInt(HEIGHT - 50), ID.SmartEnemy, handler));
                        handler.addObject(new HardEnemy(r.nextInt(WIDTH - 50), r.nextInt(HEIGHT - 50), ID.BasicEnemy, handler));
                        handler.addObject(new HardEnemy(r.nextInt(WIDTH - 50), r.nextInt(HEIGHT - 50), ID.BasicEnemy, handler));

                        handler.addObject(new SmartEnemy(r.nextInt(WIDTH - 50), r.nextInt(HEIGHT - 50), ID.SmartEnemy, handler));
                        handler.addObject(new HardEnemy(r.nextInt(WIDTH - 50), r.nextInt(HEIGHT - 50), ID.BasicEnemy, handler));
                        handler.addObject(new HardEnemy(r.nextInt(WIDTH - 50), r.nextInt(HEIGHT - 50), ID.BasicEnemy, handler));
                    } else if (hud.getWave() == 80) {
                        handler.addObject(new HardEnemy(r.nextInt(WIDTH - 50), r.nextInt(HEIGHT - 50), ID.HardEnemy, handler));
                        handler.addObject(new SmartEnemy(r.nextInt(WIDTH - 50), r.nextInt(HEIGHT - 50), ID.SmartEnemy, handler));
                        handler.addObject(new HardEnemy(r.nextInt(WIDTH - 50), r.nextInt(HEIGHT - 50), ID.BasicEnemy, handler));
                        handler.addObject(new BasicEnemy(r.nextInt(WIDTH - 50), r.nextInt(HEIGHT - 50), ID.BasicEnemy, handler));
                        handler.addObject(new BasicEnemy(r.nextInt(WIDTH - 50), r.nextInt(HEIGHT - 50), ID.BasicEnemy, handler));
                        handler.addObject(new FastEnemy(r.nextInt(WIDTH - 50), r.nextInt(HEIGHT - 50), ID.FastEnemy, handler));
                    } else if (hud.getWave() == 90) {
                        handler.clearEnemys();
                        handler.addObject(new HardEnemy(r.nextInt(WIDTH - 50), r.nextInt(HEIGHT - 50), ID.HardEnemy, handler));
                        handler.addObject(new SmartEnemy(r.nextInt(WIDTH - 50), r.nextInt(HEIGHT - 50), ID.SmartEnemy, handler));
                        handler.addObject(new SmartEnemy(r.nextInt(WIDTH - 50), r.nextInt(HEIGHT - 50), ID.SmartEnemy, handler));
                        handler.addObject(new SmartEnemy(r.nextInt(WIDTH - 50), r.nextInt(HEIGHT - 50), ID.SmartEnemy, handler));
                        handler.addObject(new SmartEnemy(r.nextInt(WIDTH - 50), r.nextInt(HEIGHT - 50), ID.SmartEnemy, handler));
                        handler.addObject(new SmartEnemy(r.nextInt(WIDTH - 50), r.nextInt(HEIGHT - 50), ID.SmartEnemy, handler));
                        handler.addObject(new SmartEnemy(r.nextInt(WIDTH - 50), r.nextInt(HEIGHT - 50), ID.SmartEnemy, handler));
                        handler.addObject(new SmartEnemy(r.nextInt(WIDTH - 50), r.nextInt(HEIGHT - 50), ID.SmartEnemy, handler));
                        handler.addObject(new SmartEnemy(r.nextInt(WIDTH - 50), r.nextInt(HEIGHT - 50), ID.SmartEnemy, handler));
                        handler.addObject(new SmartEnemy(r.nextInt(WIDTH - 50), r.nextInt(HEIGHT - 50), ID.SmartEnemy, handler));
                        handler.addObject(new SmartEnemy(r.nextInt(WIDTH - 50), r.nextInt(HEIGHT - 50), ID.SmartEnemy, handler));
                        handler.addObject(new SmartEnemy(r.nextInt(WIDTH - 50), r.nextInt(HEIGHT - 50), ID.SmartEnemy, handler));
                        handler.addObject(new SmartEnemy(r.nextInt(WIDTH - 50), r.nextInt(HEIGHT - 50), ID.SmartEnemy, handler));
                        handler.addObject(new SmartEnemy(r.nextInt(WIDTH - 50), r.nextInt(HEIGHT - 50), ID.SmartEnemy, handler));
                        handler.addObject(new SmartEnemy(r.nextInt(WIDTH - 50), r.nextInt(HEIGHT - 50), ID.SmartEnemy, handler));
                        handler.addObject(new SmartEnemy(r.nextInt(WIDTH - 50), r.nextInt(HEIGHT - 50), ID.SmartEnemy, handler));
                        handler.addObject(new SmartEnemy(r.nextInt(WIDTH - 50), r.nextInt(HEIGHT - 50), ID.SmartEnemy, handler));
                        handler.addObject(new SmartEnemy(r.nextInt(WIDTH - 50), r.nextInt(HEIGHT - 50), ID.SmartEnemy, handler));
                        handler.addObject(new SmartEnemy(r.nextInt(WIDTH - 50), r.nextInt(HEIGHT - 50), ID.SmartEnemy, handler));


                    }

                    if (game.lvl == 6) {
                        bosslevel = true;
                    }
                    if (game.lvl == 1000) {


                        if (hud.getWave() == 2) {

                        }
                    }

                }
            }
            if (game.lvl == 6){
                bosslevel = true;
            }
        }
    }
}
