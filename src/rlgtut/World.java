package rlgtut;

import java.awt.Color;

public class World {
    private Tile[][] tiles;
    private int width, height;
    //getters
    public int getHeight() {
        return height;
    }
    public int getWidth() {
        return width;
    }
    public World(Tile[][] tiles){
        this.tiles = tiles;
        width = tiles.length;
        height = tiles[0].length;
    }

    public Tile getTile(int x,int y){
        if(x < 0 || x >= width || y < 0 || y >= height){
            return Tile.BOUNDS;
        }else {
            return tiles[x][y];
        }
    }

    public void dig(int x, int y){
        if(getTile(x,y).isDiggable()){
            tiles[x][y] = Tile.FLOOR;
        }
    }

    public char getGlyph(int x, int y){
        return getTile(x, y).getGlyph();
    }
    public Color getColor(int x, int y){
        return getTile(x, y).getColor();
    }

    public void addAtEmptyLocation(Creature creature) {
        int x;
        int y;

        do{
            x = (int)(Math.random() * width);
            y = (int)(Math.random() * height);
        }while(!getTile(x,y).isGround());

        creature.x = x;
        creature.y = y;

    }
}
