package com.example.servingwebcontent;
import java.util.Random;
public class guessGame {
    private int prize;
    private int attempts;
    private int number;
    private boolean win;

    public int getPrize() {
        return prize;
    }

    public int getAttempts() {
        return attempts;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean getWin() {
        return win;
    }

    public guessGame() {
        prize = 100000;
        attempts= 0;
        number = generateRandomN();
    }

    private int generateRandomN(){
        Random random = new Random();
        return random.nextInt(0,11);
    }

    public void makeGuess(int g){
        if (g > 10 || g < 1){
            throw new IllegalArgumentException("El numero debe estar entre 1 y 10.");
        }
        attempts += 1;
        if (number == g){
            this.win = true;
        }
        else {
            prize -= 10000;
        }
        number = generateRandomN();
    }

    public void reset(){
        prize = 100000;
        attempts = 0;
        win = false;
    }
}
