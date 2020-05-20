package rlgtut;

import rlgtut.Creature;
import rlgtut.Tile;

public class CreatureAI {
    protected Creature creature;

    public CreatureAI(Creature creature){
        this.creature = creature;
        this.creature.setCreatureAI(this);
    }

    public void onEnter(int x, int y, Tile tile){

    }
}
