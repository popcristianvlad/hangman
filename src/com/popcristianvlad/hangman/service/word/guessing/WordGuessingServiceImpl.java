package com.popcristianvlad.hangman.service.word.guessing;

import com.popcristianvlad.hangman.model.Player;
import com.popcristianvlad.hangman.model.WordGuessingState;

/**
 * Implementation of {@link WordGuessingService}.
 */
public class WordGuessingServiceImpl implements WordGuessingService {

    public WordGuessingServiceImpl() {
    }

    @Override
    public boolean isWordGuessingOver(WordGuessingState wordGuessingState) {
        return wordGuessingState.isGameOver();
    }

    @Override
    public boolean isWordGuessingWon(WordGuessingState wordGuessingState) {
        return wordGuessingState.isGameOver() && wordGuessingState.isGameWon();
    }

    @Override
    public boolean isCharacterAlreadyGuessed(WordGuessingState wordGuessingState, char character) {
        return wordGuessingState.getHitCharacters().contains(character);
    }

    @Override
    public boolean isCharacterAlreadyMissed(WordGuessingState wordGuessingState, char character) {
        return wordGuessingState.getMissedCharacters().contains(character);
    }

    @Override
    public void checkCharacterAndAdjustHangmanState(WordGuessingState wordGuessingState, char character) {
        if (wordGuessingState.getWordToGuessCharacters().contains(character)) {
            markACorrectlyGuessedCharacter(wordGuessingState, character);
            wordGuessingState.getHitCharacters().add(character);

            if (!wordGuessingState.getWordToGuessMask().contains(WordGuessingState.MASK_CHARACTER)) {
                wordGuessingState.setGameOver();
                wordGuessingState.setGameWon();
            }
        } else {
            wordGuessingState.getMissedCharacters().add(character);
            wordGuessingState.increaseCurrentNumberOfMissedCharacters();

            if (wordGuessingState.getCurrentNumberOfMissedCharacters() >= wordGuessingState.getMaxNumberOfMissedCharacters()) {
                wordGuessingState.setGameOver();
            }
        }
    }

    @Override
    public void adjustScoreForWinning(Player player) {
        player.getScore().addPoints();
    }

    @Override
    public void adjustScoreForLoosing(Player player) {
        player.getScore().subtractPoints();
    }

    /**
     * Marks a character as correctly guessed.
     *
     * @param wordGuessingState - the state of the word guessing.
     * @param character         - a correctly guess character.
     */
    private void markACorrectlyGuessedCharacter(WordGuessingState wordGuessingState, char character) {
        for (int i = 0; i < wordGuessingState.getWordToGuessCharacters().size(); i++) {
            if (wordGuessingState.getWordToGuessCharacters().get(i).equals(character)) {
                wordGuessingState.getWordToGuessMask().set(i, character);
            }
        }
    }
}
