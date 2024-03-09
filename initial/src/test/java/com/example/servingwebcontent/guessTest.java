package com.example.servingwebcontent;

import static org.junit.Assert.*;
import org.junit.Test;

public class guessTest {

    @Test
    public void shouldGiveWinWhenCorrectGuess(){
        guessGame guessGame = new guessGame();
        int number = 1;
        int guess = 1;

        guessGame.setNumber(number);
        guessGame.makeGuess(guess);
        assertTrue(guessGame.getWin());
    }

    @Test
    public void shouldSubstractMoneyWhenIncorrectGuess(){
        guessGame guessGame = new guessGame();
        int number = 5;
        int guess = 1;

        guessGame.setNumber(number);
        guessGame.makeGuess(guess);
        assertEquals(90000, guessGame.getPrize());
    }

    @Test
    public void shouldThrowExceptionWhenNumberIsNotInRange(){
        guessGame guessGame = new guessGame();
        int guess = 11;

        assertThrows(IllegalArgumentException.class, () -> guessGame.makeGuess(guess));
    }

    @Test
    public void shouldAddAttempt(){
        guessGame guessGame = new guessGame();
        int guess = 1;

        guessGame.makeGuess(guess);
        assertEquals(1, guessGame.getAttempts());
    }
}
