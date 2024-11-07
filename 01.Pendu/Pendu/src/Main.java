import comDymaGame.GuessGame;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final var scanner = new Scanner(System.in);
        final var random = new Random();
        final var words = "abuser crottes fleches continental babiole etoile bougie coup coeur malade".split(" ");
        final var wordToGuess = words[random.nextInt(words.length)];
        final var game = new GuessGame(wordToGuess, 10);

        System.out.println("Début du jeu.");

        while(true) {
            System.out.println(game);
            System.out.println("Entrez une lettre");
            final var letter = scanLetter(scanner);

            game.guessLetter(letter);

            if (game.isLost()) {
                System.out.println(game);
                System.out.println("Vous avez perdu! Le mot était : " + wordToGuess);
                break;
            }

            if (game.isWon()) {
                System.out.println(game);
                System.out.println("Vous avez gagné!");
                break;
            }


        }
    }

    private static char scanLetter(final Scanner scanner) {
        return scanner.nextLine().charAt(0);
    }

}