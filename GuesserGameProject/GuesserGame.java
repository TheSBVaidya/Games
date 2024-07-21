package GuesserGameProject;

import java.util.Scanner;

class Guesser{
    int guesserNum;

    public int takeNumberGuesser() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Guesser can you guess the Number: ");
        guesserNum = sc.nextInt();

        sc.close();

        return guesserNum;
    }
}

class Player{
    int playerNum;

    public int takeNumberPlayer() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Players can you guess the Number: ");
        playerNum = sc.nextInt();

        sc.close();

        return playerNum;
    }
}

class Umpire{
    int numFromGuesser;
    int numFromPlayer1;
    int numfromPlayer2;
    int numFromPlayer3;

    void collectFromGuesser() {
        Guesser g = new Guesser();

        numFromGuesser=g.takeNumberGuesser();
    }

    void collectFromPlayers() {
        Player p1 = new Player();
        Player p2 = new Player();
        Player p3 = new Player();

        numFromPlayer1=p1.takeNumberPlayer();
        numfromPlayer2=p2.takeNumberPlayer();
        numFromPlayer3=p3.takeNumberPlayer();
    }

    void compare() {

        // Scenario 1 : To check wether all player one or player 1 and player 2 won or player 1 or player 3 won
        if(numFromPlayer1 == numFromGuesser) {
            if (numfromPlayer2 == numFromGuesser && numFromPlayer3 == numFromGuesser) {
                System.out.println("All Players Won the game");
            } else if(numfromPlayer2 == numFromGuesser) {
                System.out.println("Player 1 and Player 2 Won the Game");
            } else if(numFromPlayer3 == numFromGuesser) {
                System.out.println("Player 1 and player 3 won the Game");
            } else {
                System.out.println("Player 1 won the game");
            }
        }

        // Scenario 2: To check wether player 2 won the game or player 2 and player 3 won the game
        else if (numfromPlayer2 == numFromGuesser) {
            if (numFromPlayer3 == numFromGuesser) {
                System.out.println("Player 2 and player 3 won the game");
            } else {
                System.out.println("Player 2 won the game");
            }
        }

        //Scenario 3 : only player 3 won the game
        else if(numFromPlayer3 == numFromGuesser) {
            System.out.println("Player 3 Won the Game");
        } else {
            System.out.println("No Plyer won the game (ALL LOOSE)");
        }
    }
}

public class GuesserGame {
    public static void main(String[] args) {
        
        Umpire u = new Umpire();

        u.collectFromGuesser();
        u.collectFromPlayers();
        u.compare();
    }
}
