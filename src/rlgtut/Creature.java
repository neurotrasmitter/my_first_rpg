package rlgtut;

import java.awt.*;

public class Creature {
    private World world;
    public int x;
    public int y;

    private char glyph;
    public char getGlyph(){
        return glyph;
    }
    private Color color;
    public Color getColor(){
        return color;
    }

    private CreatureAI creatureAI;
    public void setCreatureAI(CreatureAI creatureAI){
        this.creatureAI = creatureAI;
    }

    public Creature(World world, char glyph, Color color){
        this.world = world;
        this.glyph = glyph;
        this.color = color;
    }

    public void dig(int x, int y){
        world.dig(x, y);
    }

    public void moveBy(int mx, int my){
        creatureAI.onEnter(x+mx, y+my, world.getTile(x+mx, y+my));
    }
}
