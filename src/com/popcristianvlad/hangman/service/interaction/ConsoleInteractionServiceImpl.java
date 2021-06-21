package com.popcristianvlad.hangman.service.interaction;

import com.popcristianvlad.hangman.model.Player;
import com.popcristianvlad.hangman.model.Score;
import com.popcristianvlad.hangman.model.WordComplexity;
import com.popcristianvlad.hangman.model.WordGuessingState;

import java.util.Scanner;

/**
 * Console-based implementation of {@link InteractionService}.
 */
public class ConsoleInteractionServiceImpl implements InteractionService {

    private final Scanner scanner;

    public ConsoleInteractionServiceImpl() {
        scanner = new Scanner(System.in);
    }

    public int readMaxNumberOfAttempts() {
        while (true) {
            try {
                System.out.print("Please insert the maximum of allowed attempts: ");
                String nextLine = scanner.nextLine().trim();

                if (nextLine.isBlank()) {
                    System.out.println("Please enter something..");
                    continue;
                }

                int maxNumberOfAttempts = Integer.parseInt(nextLine);

                if (maxNumberOfAttempts <= 0) {
                    System.out.println("Only positive numbers allowed!");
                    continue;
                }

                return maxNumberOfAttempts;
            } catch (NumberFormatException ex) {
                System.out.println("Only numbers allowed!");
            }
        }
    }

    public void showWordGuessingState(WordGuessingState wordGuessingState) {
        StringBuilder sb = new StringBuilder();
        sb.append("Your current word: ");

        wordGuessingState
                .getWordToGuessMask()
                .forEach(sb::append);

        sb.append("; Missed characters: [");

        wordGuessingState
                .getMissedCharacters()
                .stream()
                .filter(ch -> !WordGuessingState.MASK_CHARACTER.equals(ch))
                .forEach(sb::append);

        sb.append("]; Tries left: ");
        sb.append(wordGuessingState.getMaxNumberOfMissedCharacters() - wordGuessingState.getCurrentNumberOfMissedCharacters());

        System.out.println(sb.toString());
    }

    public WordComplexity readComplexity() {
        while (true) {
            System.out.print("How complex should the word be (easy/medium/hard) ?: ");
            String nextLine = scanner.nextLine().trim().toLowerCase();

            if (nextLine.isBlank()) {
                System.out.println("Please enter something..");
                continue;
            }

            switch (nextLine) {
                case "easy":
                    return WordComplexity.EASY;
                case "medium":
                    return WordComplexity.MEDIUM;
                case "hard":
                    return WordComplexity.HARD;
                default:
                    System.out.println("Only easy/medium/hard allowed!");
            }
        }
    }

    public char readCharacter() {
        while (true) {
            System.out.print("Please insert a character: ");
            String nextLine = scanner.nextLine().trim();

            if (nextLine.isBlank()) {
                System.out.println("Please enter something..");
                continue;
            }

            if (nextLine.length() > 1) {
                System.out.println("Only one character, please!");
                continue;
            }

            if (!Character.isLetter(nextLine.charAt(0))) {
                System.out.println("Only letters, please!");
                continue;
            }

            return nextLine.charAt(0);
        }
    }

    @Override
    public boolean shouldTheGameContinue() {
        while (true) {
            System.out.print("Do you want to continue playing? (y/n, yes/no): ");
            String nextLine = scanner.nextLine().trim().toLowerCase();

            if (nextLine.isBlank()) {
                System.out.println("Please enter something..");
                continue;
            }

            switch (nextLine) {
                case "y":
                case "yes":
                    return true;
                case "n":
                case "no":
                    return false;
                default:
                    System.out.println("Only y/n, yes/no allowed!");
            }
        }
    }

    @Override
    public void showAlreadyGuessedMessage() {
        System.out.println("You already guessed this character!");
    }

    @Override
    public void showAlreadyMissedMessage() {
        System.out.println("You already missed this character!");
    }

    @Override
    public void showWinningMessageAndScore(Player player, WordGuessingState wordGuessingState) {
        System.out.println("Congrats, you guess the word '" + wordGuessingState.getWordToGuess() + "'");
        System.out.println("You got +" + Score.WINNING_POINTS + " points. Your total score is: " + player.getScore().getPoints());
    }

    @Override
    public void showLoosingMessageScore(Player player, WordGuessingState wordGuessingState) {
        System.out.println("You lost, sorry. The word you tried to guess was '" + wordGuessingState.getWordToGuess() + "'");
        System.out.println("You got -" + Score.LOOSING_POINTS + " points. Your total score is: " + player.getScore().getPoints());
    }
}
