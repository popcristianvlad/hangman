package com.popcristianvlad.hangman.service.interaction;

import com.popcristianvlad.hangman.model.Player;
import com.popcristianvlad.hangman.model.WordComplexity;
import com.popcristianvlad.hangman.model.WordGuessingState;

/**
 * Service used for interacting with the player, i.e. gathering data and showing results/messages.
 */
public interface InteractionService {

    /**
     * Reads the maximum number of attempts that the player has for guessing the word.
     *
     * @return the maximum number of attempts that the player has for guessing the word.
     */
    int readMaxNumberOfAttempts();

    /**
     * Reads the complexity of the word to be guessed.
     *
     * @return the complexity of the word to be guessed.
     */
    WordComplexity readComplexity();

    /**
     * Shows the state of the word guessing.
     *
     * @param wordGuessingState - the word guessing state.
     */
    void showWordGuessingState(WordGuessingState wordGuessingState);

    /**
     * Reads a character in attempt to guess the word.
     *
     * @return a character in attempt to guess the word.
     */
    char readCharacter();

    /**
     * Reads whether the game should continue or not.
     *
     * @return true if the game should continue, false otherwise.
     */
    boolean shouldTheGameContinue();

    /**
     * Shows a message saying that the read character is already guessed.
     */
    void showAlreadyGuessedMessage();

    /**
     * Shows a message saying that the read character is already missed.
     */
    void showAlreadyMissedMessage();

    /**
     * Shows a winning message together with the players' score.
     *
     * @param player            - the player playing the hangman game.
     * @param wordGuessingState - the state of the word guessing.
     */
    void showWinningMessageAndScore(Player player, WordGuessingState wordGuessingState);

    /**
     * Shows a loosing message together with the players' score.
     *
     * @param player            - the player playing the hangman game.
     * @param wordGuessingState - the state of the word guessing.
     */
    void showLoosingMessageScore(Player player, WordGuessingState wordGuessingState);
}
