package com.popcristianvlad.hangman.model;

import java.io.Serializable;

/**
 * The complexity of a hangman word.
 */
public enum WordComplexity implements Serializable {

    /**
     * Simple common words, consisting of few letters.
     */
    EASY,

    /**
     * Not the most common words, but not the most rarely used either.
     */
    MEDIUM,

    /**
     * Rarely used words, consisting of many letters.
     */
    HARD
}
