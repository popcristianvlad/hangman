package com.popcristianvlad.hangman.service.word.provider;

import com.popcristianvlad.hangman.model.WordComplexity;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * A default implementation of {@link RandomWordProviderService}.
 */
public class DefaultRandomWordProviderServiceImpl implements RandomWordProviderService {

    /**
     * List of words having the {@link WordComplexity#EASY} complexity.
     */
    private static final List<String> DEFAULT_EASY_WORDS = Arrays.asList(
            "box",
            "connect",
            "retire",
            "continue",
            "fail",
            "listen",
            "expensive",
            "peaceful",
            "mellow",
            "ambitious"
    );

    /**
     * List of words having the {@link WordComplexity#MEDIUM} complexity.
     */
    private static final List<String> DEFAULT_MEDIUM_WORDS = Arrays.asList(
            "questionable",
            "whispering",
            "mosquito",
            "madly",
            "rifle",
            "previously",
            "similarly",
            "entertainment",
            "announcement",
            "connection"
    );

    /**
     * List of words having the {@link WordComplexity#HARD} complexity.
     */
    private static final List<String> DEFAULT_HARD_WORDS = Arrays.asList(
            "recommendation",
            "delightfully",
            "underneath",
            "sophisticated",
            "disappointment",
            "constitutional",
            "extraterrestrial",
            "skyscraper",
            "advertisement",
            "constellation"
    );

    public DefaultRandomWordProviderServiceImpl() {
    }

    @Override
    public String provideWord(WordComplexity wordComplexity) {
        switch (wordComplexity) {
            case EASY -> {
                return DEFAULT_EASY_WORDS.get(new Random().nextInt(DEFAULT_EASY_WORDS.size()));
            }
            case MEDIUM -> {
                return DEFAULT_MEDIUM_WORDS.get(new Random().nextInt(DEFAULT_MEDIUM_WORDS.size()));
            }
            case HARD -> {
                return DEFAULT_HARD_WORDS.get(new Random().nextInt(DEFAULT_HARD_WORDS.size()));
            }
            default -> throw new RuntimeException("Internal error! Word Complexity not correctly handled.");
        }
    }
}
