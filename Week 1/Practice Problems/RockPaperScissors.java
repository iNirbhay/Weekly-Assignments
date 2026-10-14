import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    private static final String[] MOVES = {"Rock", "Paper", "Scissors"};

    public static String playRound(String playerMove, String computerMove) {
        playerMove = playerMove.trim().toLowerCase();
        computerMove = computerMove.trim().toLowerCase();

        if (playerMove.equals(computerMove)) return "Draw";
        if ((playerMove.equals("rock") && computerMove.equals("scissors"))
                || (playerMove.equals("paper") && computerMove.equals("rock"))
                || (playerMove.equals("scissors") && computerMove.equals("paper"))) {
            return "Player Wins";
        }
        return "Computer Wins";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        final int rounds = 5;

        String[] playerMoves = new String[rounds];
        String[] computerMoves = new String[rounds];
        String[] results = new String[rounds];
        int wins = 0, losses = 0, draws = 0;

        for (int i = 0; i < rounds; i++) {
            System.out.print("Round " + (i + 1) + " - Enter Rock, Paper, or Scissors: ");
            String player = scanner.nextLine().trim();

            while (!player.equalsIgnoreCase("rock")
                    && !player.equalsIgnoreCase("paper")
                    && !player.equalsIgnoreCase("scissors")) {
                System.out.print("Invalid move. Enter Rock, Paper, or Scissors: ");
                player = scanner.nextLine().trim();
            }

            String computer = MOVES[random.nextInt(MOVES.length)];
            String result = playRound(player, computer);

            playerMoves[i] = capitalize(player);
            computerMoves[i] = computer;
            results[i] = result;

            if (result.equals("Player Wins")) wins++;
            else if (result.equals("Computer Wins")) losses++;
            else draws++;

            System.out.println("Result: " + result);
        }

        System.out.println("\nFinal Summary");
        System.out.printf("%-8s | %-12s | %-14s | %-14s%n",
                "Round", "Player Move", "Computer Move", "Result");
        System.out.println("--------------------------------------------------------------");
        for (int i = 0; i < rounds; i++) {
            System.out.printf("%-8d | %-12s | %-14s | %-14s%n",
                    i + 1, playerMoves[i], computerMoves[i], results[i]);
        }

        double winPercentage = (wins * 100.0) / rounds;
        System.out.printf("%nWins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%%n",
                wins, losses, draws, winPercentage);
        scanner.close();
    }

    private static String capitalize(String text) {
        if (text.isEmpty()) return text;
        return text.substring(0, 1).toUpperCase() + text.substring(1).toLowerCase();
    }
}
