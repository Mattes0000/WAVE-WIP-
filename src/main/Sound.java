package main;


import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.InputStream;

public class Sound {
    Clip clip;
    InputStream soundURL[] = new InputStream[30];


    public Sound() {

        soundURL[0] = getClass().getResourceAsStream("/OST/Menu.wav");
        soundURL[1] = getClass().getResourceAsStream("/OST/Bosstheme.mp3");
        soundURL[2] = getClass().getResourceAsStream("/OST/upgrade.mp3");
        soundURL[3] = getClass().getResourceAsStream("/OST/Reverb.wav");
    }
    public void setFile(int i) {

        try {

            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);

        } catch(Exception e) {
            System.out.println(e);
        }
    }
    public void play() {
        clip.start();
    }
    public void loop() {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void stop() {
        clip.stop();
    }
}