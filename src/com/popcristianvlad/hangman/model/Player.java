package com.popcristianvlad.hangman.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * A player that plays the hangman game.
 */
public class Player implements Serializable {

    /**
     * The players' score.
     */
    private final Score score;

    public Player() {
        score = new Score();
    }

    public Score getScore() {
        return score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(score, player.score);
    }

    @Override
    public int hashCode() {
        return Objects.hash(score);
    }

    @Override
    public String toString() {
        return "Player{" +
                "score=" + score +
                '}';
    }
}
