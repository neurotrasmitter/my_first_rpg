package rlgtut.screens;

import asciiPanel.AsciiPanel;

import java.awt.event.KeyEvent;

public class LoseScreen implements Screen {
    @Override
    public void displayOutput(AsciiPanel terminal) {
        terminal.write("You LOSE, LOSEEER", 1, 1);
        terminal.writeCenter("press [enter] to  restart", 22);
    }

    @Override
    public Screen respondToUserInput(KeyEvent key) {
        return key.getKeyCode() == KeyEvent.VK_ENTER ? new StartScreen() : this;
    }
}
