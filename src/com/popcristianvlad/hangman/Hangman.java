package com.popcristianvlad.hangman;

import com.popcristianvlad.hangman.game.HangmanGame;

/**
 * Hangman Application class, i.e. the entry point in the game.
 */
public class Hangman {

    public static void main(String[] args) {
        new HangmanGame().play();
    }
}
