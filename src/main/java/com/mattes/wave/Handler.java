package com.mattes.wave;


import java.awt.Graphics;
import java.util.ArrayList;


public class Handler {
    public ArrayList<GameObject> object=new ArrayList<GameObject>();
    public int spd=5;
    public void tick()
    {
        for(int i=0;i<object.size();i++)
        {
            GameObject tempObject=object.get(i);
            tempObject.tick();
        }
    }
    public void render(Graphics g){
        for(int i=0;i<object.size();i++)
        {
            GameObject tempObject=object.get(i);
            tempObject.render(g);
        }

    }
    public void clearEnemys() {
        for(int i=0;i<object.size();i++) {
            GameObject tempObject=object.get(i);
            if(tempObject.getId()== Player) {
                object.clear();
                if(Game.gameState!= Game.STATE.End)
                    addObject(new Player((int)tempObject.getX(),(int) tempObject.getY(), Player,this));
                if(Game.gameState!= Game.STATE.Win)
                    addObject(new Player((int)tempObject.getX(),(int) tempObject.getY(), Player,this));
            }
        }
    }
    public int addObject(GameObject object) {
        this.object.add(object);
        return 0;
    }
    public void removeObject(GameObject object)
    {
        this.object.remove(object);
    }


}
