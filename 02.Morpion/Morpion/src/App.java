import java.util.Scanner;

import com.dyma.game.TicTacToe;


public class App {
    public static void main(String[] args) throws Exception {
        
        final var scanner = new Scanner(System.in);
        final var game = new TicTacToe();

        while (true) { 
            System.out.println(game);
            System.out.println("Saisissez un nombre entre 1 et 9 : ");
            final var inputUser = scanner.nextInt();
            
        }
    }
}
