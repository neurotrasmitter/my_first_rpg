package rlgtut;

import asciiPanel.AsciiPanel;
import java.awt.Color;

public enum Tile {
    FLOOR((char)250, AsciiPanel.yellow),
    WALL((char)177, AsciiPanel.yellow),
    BOUNDS('x', AsciiPanel.brightBlack),
    TREE((char)182, AsciiPanel.green);

    private char glyph;
    private Color color;
    //getters
    public char getGlyph() {
        return glyph;
    }
    public Color getColor() {
        return color;
    }
    //construct
    Tile(char glyph, Color color){
        this.glyph = glyph;
        this.color = color;
    }

    public boolean isDiggable(){
        return this == Tile.WALL;
    }

    public boolean isGround(){
        return this != Tile.WALL && this != Tile.BOUNDS && this != Tile.TREE;
    }
}
