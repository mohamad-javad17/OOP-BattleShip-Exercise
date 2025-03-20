
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean replay;

        do {
            System.out.println("Enter the grid size: ");
            int gridSize = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Do you want to play against the AI? (y/n): ");
            String aiChoice = scanner.nextLine().toLowerCase();
            boolean vsAI = aiChoice.equalsIgnoreCase("y");
            Game game = new Game(gridSize, vsAI);
            game.start();
            System.out.println("play again? (y/n): ");
            String input = scanner.nextLine().toLowerCase();
            replay= input.equalsIgnoreCase("y");
        } while (replay);
        System.out.println("good game :)");
        scanner.close();
    }
}
