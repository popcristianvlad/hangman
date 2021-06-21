package com.popcristianvlad.hangman.service.word.provider;

import com.popcristianvlad.hangman.model.WordComplexity;

/**
 * Service used for providing random words.
 */
public interface RandomWordProviderService {

    /**
     * The default word complexity of the randomly generated word.
     */
    WordComplexity DEFAULT_WORD_COMPLEXITY = WordComplexity.EASY;

    /**
     * Returns a random word based on the provided word complexity.
     *
     * @param wordComplexity - the complexity of the randomly generated word.
     * @return a random word based on the provided word complexity.
     */
    String provideWord(WordComplexity wordComplexity);

    /**
     * Returns a random word.
     *
     * @return a random word.
     */
    default String provideWord() {
        return provideWord(DEFAULT_WORD_COMPLEXITY);
    }
}
