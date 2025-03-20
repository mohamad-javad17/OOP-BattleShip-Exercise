
import java.util.Scanner;

public class Player {
    private String name;
    private Board Board;
    private Board attackBoard;
    protected int gridSize;
    public Player(String name, Board ownBoard, Board opponentBoard, int gridSize) {
        this.name = name;
        this.Board = ownBoard;
        this.attackBoard = opponentBoard;
        this.gridSize = gridSize;
        this.Board.placeShipsRandomly();
    }
    public String getName() {
        return name;
    }
    public Board getOwnBoard() {
        return Board;
    }
    public Board getOpponentBoard() {
        return attackBoard;
    }
    public boolean makeMove(Player opponent) {
        System.out.println("Enter your attack coordinates (e.g., A5): ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().toUpperCase();
        if (!InputValidator.isValidCoordinate(input, gridSize)) {
            System.out.println("Invalid input! Skipping your turn.");
            return false;
        }
        Coordinate coordinate = new Coordinate(input);
        return opponent.getOwnBoard().attack(coordinate);
    }
}

