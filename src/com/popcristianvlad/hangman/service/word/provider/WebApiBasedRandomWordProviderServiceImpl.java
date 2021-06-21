package com.popcristianvlad.hangman.service.word.provider;

import com.popcristianvlad.hangman.model.WordComplexity;

/**
 * A web-api-based implementation of {@link RandomWordProviderService}.
 */
public class WebApiBasedRandomWordProviderServiceImpl implements RandomWordProviderService {

    public WebApiBasedRandomWordProviderServiceImpl() {
    }

    @Override
    public String provideWord(WordComplexity wordComplexity) {
        throw new UnsupportedOperationException("Web API based word provider isn't currently supported.");
    }
}
