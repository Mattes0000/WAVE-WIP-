package main;
import java.awt.Color;
import java.awt.Graphics;

public class HUD {
    public static int bounds=0;
    public static int HEALTH=100;
    private int greenValue=255;
    private int score=0;
    private int frames;
    private int OutputFrames;
    public int wave=1;
    public void tick()
    {
        HEALTH=Game.clamp(HEALTH, 0, 100+(bounds/2));
        greenValue=HEALTH*2;
        greenValue=Game.clamp(greenValue,0,255);
        score++;
    }
    public void render(Graphics g)
    {
        int OutputFrames = Game.OutputFrames;
        int Level = Game.lvl;
        g.setColor(Color.gray);
        g.fillRect(15,15,200+bounds,32);
        g.setColor(new Color(75, greenValue,0));
        g.fillRect(15,15,HEALTH*2,32);
        g.setColor(Color.white);
        g.drawRect(15,15,200+bounds,32);
        g.drawString("FPS: " + OutputFrames, 15,64);
        g.drawString("Score: " + score, 15, 80);
        g.drawString("Wave: " + wave, 15, 96);
        g.drawString("Level: " + Level, 15, 112);
        g.drawString("Space for Shop", 15, 128);

    }

    public void setScore(int score) {
        this.score=score;
    }
    public int getScore() {
        return score;
    }
    public int getWave() {
        return wave;
    }
    public void setWave(int wave)
    {
        this.wave=wave;
    }


}