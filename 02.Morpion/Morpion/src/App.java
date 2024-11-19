import com.dyma.exceptions.TocTacToeInvalidInputException;
import com.dyma.game.Player;
import static com.dyma.game.StringConstants.BLANK;
import com.dyma.game.TicTacToe;
import java.util.HashMap;
import java.util.Scanner;


public class App {
    public static void main(String[] args) throws Exception {
        
        //final var scanner = new Scanner(System.in);
        final var game = new TicTacToe();

        var player = Player.FIRST;
        var players = initPlayers();
        
                while (true) { 
                    try {
                        System.out.println(game);
                        System.out.println(players.get(player) + "/ Saisissez un nombre entre 1 et 9 : ");
                        final var inputUser = getInputUser();
            
                        game.processInput(player, inputUser);
                        if (game.checkwin()) {
                            System.out.println(game);
                            System.out.println("Le joueur " + players.get(player) + " a gagné la partie ! :");
                            System.out.println(game);
                            break;
                        }
                        if (game.checkDrow()) {
                            System.out.println(game);
                            System.out.println("Match nul");
                            System.out.println(game);
                            break;
                        }
            
                        player = nextPlayer(player);
                    } catch (TocTacToeInvalidInputException e) {
                        System.out.println(e.getMessage());
                    } catch (NumberFormatException e) {
                        System.out.println("Veuillez saisir un nombre valide entre 1 et 9");
                    }
                        
        
                                            
                                        }
                                    }
        
            private static HashMap<Player, String> initPlayers() {
                var players = new HashMap<Player, String>();
                var scanner = new Scanner(System.in);
                do { 
                    System.out.println("Saisissez le nom du joueur 1 : ");
                    players.put(Player.FIRST, scanner.nextLine());
                } while (players.get(Player.FIRST).equals(BLANK));
                do { 
                    System.out.println("Saisissez le nom du joueur 2 : ");
                    players.put(Player.SECOND, scanner.nextLine());
                } while (players.get(Player.SECOND).equals(BLANK));
                return players;
            
            }
            private static int getInputUser() throws TocTacToeInvalidInputException {
        final var scanner = new Scanner(System.in);
        var input = scanner.nextLine();
        if ("exit".equals(input) || "quit".equals(input)) {
            System.out.println("Merci d'avoir joué");
            System.exit(0);
        }
        var inputEntier = Integer.parseInt(input);
        if (inputEntier < 1 || inputEntier > 9) {
            throw new TocTacToeInvalidInputException("le chiffre dois être entre 1 et 9");
        }
        return inputEntier;

    }
                        
    private static Player nextPlayer(Player player) {
        if (player == Player.FIRST){
            return Player.SECOND;
        } else {
            return Player.FIRST;
        }
                                
    }
            
}
