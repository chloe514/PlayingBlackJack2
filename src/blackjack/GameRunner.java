package blackjack;

import java.util.Scanner;

public class GameRunner {

    public static void main(String[] args) {
        // Play some music
        String filepath = "CasinoJazz.wav";
        PlayMusic music = new PlayMusic();
        music.playMusic(filepath);

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        System.out.print("Enter your starting balance: ");
        double balance = sc.nextDouble();

        // Create and start the game
        Game game = new Game(name, balance);
        game.play();

        // Close the scanner
        sc.close();
    }
}


