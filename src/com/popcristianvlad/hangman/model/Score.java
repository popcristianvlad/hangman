package com.popcristianvlad.hangman.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * A players' score.
 */
public class Score implements Serializable {

    /**
     * Points received for guessing the word.
     */
    public static final int WINNING_POINTS = 10;

    /**
     * Points lost for not guessing the word.
     */
    public static final int LOOSING_POINTS = 10;

    /**
     * The number of points a player scored.
     */
    private int points;

    public Score() {
    }

    public int getPoints() {
        return points;
    }

    /**
     * Adds {@link Score#WINNING_POINTS} points to a players' total score.
     */
    public void addPoints() {
        points += WINNING_POINTS;
    }

    /**
     * Subtracts {@link Score#LOOSING_POINTS} points from a players' total score.
     */
    public void subtractPoints() {
        points -= LOOSING_POINTS;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Score score = (Score) o;
        return points == score.points;
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }

    @Override
    public String toString() {
        return "Score{" +
                "points=" + points +
                '}';
    }
}
