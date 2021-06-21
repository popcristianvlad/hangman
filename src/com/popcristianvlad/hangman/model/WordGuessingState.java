package com.popcristianvlad.hangman.model;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * The state of the word guessing
 */
public class WordGuessingState implements Serializable {

    /**
     * The displayed character for a letter that hasn't been guessed (yet).
     */
    public static final Character MASK_CHARACTER = '_';

    /**
     * The word that has to be guessed.
     */
    private final String wordToGuess;

    /**
     * Character-list representation of the word that has to be guessed.
     */
    private final List<Character> wordToGuessCharacters;

    /**
     * Character-list representation of the current state of word guessing. The guessed letters are present in this list,
     * while not-guessed characters are represented by {@link WordGuessingState#MASK_CHARACTER}.
     */
    private final List<Character> wordToGuessMask;

    /**
     * Set of missed characters (not guessed).
     */
    private final Set<Character> missedCharacters;

    /**
     * Set of hit characters (guessed).
     */
    private final Set<Character> hitCharacters;

    /**
     * Max allowed number of missed characters.
     */
    private final int maxNumberOfMissedCharacters;

    /**
     * Current number of missed characters.
     */
    private int currentNumberOfMissedCharacters;

    /**
     * Game-over flag.
     */
    private boolean isGameOver;

    /**
     * Game-won flag.
     */
    private boolean isGameWon;

    public WordGuessingState(String wordToGuess, int maxNumberOfMissedCharacters) {
        this.wordToGuess = wordToGuess;
        this.wordToGuessCharacters = wordToGuess
                .chars()
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.toList());
        this.wordToGuessMask = IntStream
                .range(0, wordToGuessCharacters.size())
                .mapToObj(ch -> MASK_CHARACTER)
                .collect(Collectors.toList());
        this.missedCharacters = new HashSet<>();
        this.hitCharacters = new HashSet<>();
        this.maxNumberOfMissedCharacters = maxNumberOfMissedCharacters;
        this.currentNumberOfMissedCharacters = 0;
        this.isGameOver = false;
        this.isGameWon = false;
    }

    public String getWordToGuess() {
        return wordToGuess;
    }

    public List<Character> getWordToGuessCharacters() {
        return wordToGuessCharacters;
    }

    public List<Character> getWordToGuessMask() {
        return wordToGuessMask;
    }

    public Set<Character> getMissedCharacters() {
        return missedCharacters;
    }

    public Set<Character> getHitCharacters() {
        return hitCharacters;
    }

    public int getMaxNumberOfMissedCharacters() {
        return maxNumberOfMissedCharacters;
    }

    public int getCurrentNumberOfMissedCharacters() {
        return currentNumberOfMissedCharacters;
    }

    public void increaseCurrentNumberOfMissedCharacters() {
        this.currentNumberOfMissedCharacters++;
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    public void setGameOver() {
        isGameOver = true;
    }

    public boolean isGameWon() {
        return isGameWon;
    }

    public void setGameWon() {
        isGameWon = true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WordGuessingState that = (WordGuessingState) o;
        return maxNumberOfMissedCharacters == that.maxNumberOfMissedCharacters && currentNumberOfMissedCharacters == that.currentNumberOfMissedCharacters && isGameOver == that.isGameOver && isGameWon == that.isGameWon && Objects.equals(wordToGuess, that.wordToGuess) && Objects.equals(wordToGuessCharacters, that.wordToGuessCharacters) && Objects.equals(wordToGuessMask, that.wordToGuessMask) && Objects.equals(missedCharacters, that.missedCharacters) && Objects.equals(hitCharacters, that.hitCharacters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(wordToGuess, wordToGuessCharacters, wordToGuessMask, missedCharacters, hitCharacters, maxNumberOfMissedCharacters, currentNumberOfMissedCharacters, isGameOver, isGameWon);
    }

    @Override
    public String toString() {
        return "WordGuessing{" +
                "wordToGuess='" + wordToGuess + '\'' +
                ", wordToGuessCharacters=" + wordToGuessCharacters +
                ", wordToGuessMask=" + wordToGuessMask +
                ", missedCharacters=" + missedCharacters +
                ", hitCharacters=" + hitCharacters +
                ", maxNumberOfMissedCharacters=" + maxNumberOfMissedCharacters +
                ", currentNumberOfMissedCharacters=" + currentNumberOfMissedCharacters +
                ", isGameOver=" + isGameOver +
                ", isGameWon=" + isGameWon +
                '}';
    }
}
