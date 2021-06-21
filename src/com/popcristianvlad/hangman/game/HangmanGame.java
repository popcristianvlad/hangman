package com.popcristianvlad.hangman.game;

import com.popcristianvlad.hangman.service.word.guessing.WordGuessingService;
import com.popcristianvlad.hangman.service.word.guessing.WordGuessingServiceImpl;
import com.popcristianvlad.hangman.model.Player;
import com.popcristianvlad.hangman.model.WordGuessingState;
import com.popcristianvlad.hangman.service.interaction.InteractionService;
import com.popcristianvlad.hangman.service.interaction.ConsoleInteractionServiceImpl;
import com.popcristianvlad.hangman.model.WordComplexity;
import com.popcristianvlad.hangman.service.word.provider.DefaultRandomWordProviderServiceImpl;
import com.popcristianvlad.hangman.service.word.provider.RandomWordProviderService;

/**
 * A hangman game played by one player.
 */
public class HangmanGame {

    /**
     * The player that plays the hangman game.
     */
    private final Player player;

    private final InteractionService interactionService;
    private final RandomWordProviderService randomWordProviderService;
    private final WordGuessingService wordGuessingService;

    public HangmanGame() {
        this.player = new Player();
        this.interactionService = new ConsoleInteractionServiceImpl();
        this.randomWordProviderService = new DefaultRandomWordProviderServiceImpl();
        this.wordGuessingService = new WordGuessingServiceImpl();
    }

    /**
     * Plays the hangman game.
     */
    public void play() {
        do {
            int maxNumberOfAttempts = interactionService.readMaxNumberOfAttempts();
            WordComplexity wordComplexity = interactionService.readComplexity();
            String wordToGuess = randomWordProviderService.provideWord(wordComplexity);

            WordGuessingState wordGuessingState = new WordGuessingState(wordToGuess, maxNumberOfAttempts);

            while (!wordGuessingService.isWordGuessingOver(wordGuessingState)) {
                interactionService.showWordGuessingState(wordGuessingState);
                char readCharacter = interactionService.readCharacter();

                if (wordGuessingService.isCharacterAlreadyGuessed(wordGuessingState, readCharacter)) {
                    interactionService.showAlreadyGuessedMessage();
                    continue;
                }

                if (wordGuessingService.isCharacterAlreadyMissed(wordGuessingState, readCharacter)) {
                    interactionService.showAlreadyMissedMessage();
                    continue;
                }

                wordGuessingService.checkCharacterAndAdjustHangmanState(wordGuessingState, readCharacter);
            }

            if (wordGuessingService.isWordGuessingWon(wordGuessingState)) {
                wordGuessingService.adjustScoreForWinning(player);
                interactionService.showWinningMessageAndScore(player, wordGuessingState);
            } else {
                wordGuessingService.adjustScoreForLoosing(player);
                interactionService.showLoosingMessageScore(player, wordGuessingState);
            }
        } while (interactionService.shouldTheGameContinue());
    }
}
