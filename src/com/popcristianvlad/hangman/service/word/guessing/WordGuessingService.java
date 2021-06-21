package com.popcristianvlad.hangman.service.word.guessing;

import com.popcristianvlad.hangman.model.Player;
import com.popcristianvlad.hangman.model.WordGuessingState;

/**
 * Service for controlling an {@link WordGuessingState} instance.
 */
public interface WordGuessingService {

    /**
     * Checks if the word guessing is over (won or no more left tries) .
     *
     * @param wordGuessingState - the state of the word guessing.
     * @return true if the word guessing is over (won or no more left tries), false otherwise.
     */
    boolean isWordGuessingOver(WordGuessingState wordGuessingState);

    /**
     * Checks if the word guessing is won.
     *
     * @param wordGuessingState - the state of the word guessing.
     * @return true if the word guessing is won, false otherwise.
     */
    boolean isWordGuessingWon(WordGuessingState wordGuessingState);

    /**
     * Checks if the provided character is already guessed.
     *
     * @param wordGuessingState - the state of the word guessing.
     * @param character         - character to be checked.
     * @return true if the provided character is already guessed, false otherwise.
     */
    boolean isCharacterAlreadyGuessed(WordGuessingState wordGuessingState, char character);

    /**
     * Checks if the provided character is already missed.
     *
     * @param wordGuessingState - the state of the word guessing.
     * @param character         - character to be checked.
     * @return true if the provided character is already missed, false otherwise.
     */
    boolean isCharacterAlreadyMissed(WordGuessingState wordGuessingState, char character);

    /**
     * Checks the correctness of the provided character and adjust the game state accordingly.
     *
     * @param wordGuessingState - the state of the word guessing.
     * @param character         - character to be checked.
     */
    void checkCharacterAndAdjustHangmanState(WordGuessingState wordGuessingState, char character);

    /**
     * Adjust the score of the player for the winning scenario.
     *
     * @param player - the player for which the score should be adjusted.
     */
    void adjustScoreForWinning(Player player);

    /**
     * Adjust the score of the player for the loosing scenario.
     *
     * @param player - the player for which the score should be adjusted.
     */
    void adjustScoreForLoosing(Player player);
}