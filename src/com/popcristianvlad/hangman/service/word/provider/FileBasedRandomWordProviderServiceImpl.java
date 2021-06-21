package com.popcristianvlad.hangman.service.word.provider;

import com.popcristianvlad.hangman.model.WordComplexity;

/**
 * A file-based implementation of {@link RandomWordProviderService}.
 */
public class FileBasedRandomWordProviderServiceImpl implements RandomWordProviderService {

    public FileBasedRandomWordProviderServiceImpl() {
    }

    @Override
    public String provideWord(WordComplexity wordComplexity) {
        throw new UnsupportedOperationException("File based word provider isn't currently supported.");
    }
}
