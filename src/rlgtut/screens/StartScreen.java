package rlgtut.screens;

import asciiPanel.AsciiPanel;

import java.awt.event.KeyEvent;

public class StartScreen implements Screen {
    @Override
    public void displayOutput(AsciiPanel terminal) {
        terminal.write("rl tutorial", 1, 1);
        terminal.writeCenter("Press any KEY to STAR", 22);
    }

    @Override
    public Screen respondToUserInput(KeyEvent key) {
        return key.getKeyCode() == KeyEvent.VK_ENTER ? new PlayScreen() : this;
    }
}
