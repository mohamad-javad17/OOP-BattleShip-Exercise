import java.util.Scanner;

public class Game {
    private Player player1;
    private Player player2;
    private boolean player1Turn;
    public Game(int gridSize, boolean vsAI) {

        Board player1Board = new Board(gridSize);
        Board player2Board = new Board(gridSize);

        this.player1 = new Player("Player1 ", player1Board, player2Board, gridSize);
        if (vsAI) {
            this.player2 = new Aiplayer("AI player", player2Board, player1Board, gridSize);
        } else {
            this.player2 = new Player("Player2 ", player2Board, player1Board, gridSize);
        }
        this.player1Turn = true;
    }
    public void start() {
        while (!isGameOver()) {
            Player currentPlayer = player1Turn ? player1 : player2;
            Player opponentPlayer = player1Turn ? player2 : player1;

            System.out.println(currentPlayer.getName() + "'s turn:");
            System.out.println("Your tracking grid (opponent's board):");
            currentPlayer.getOpponentBoard().printattackingGrid();
            if (!currentPlayer.makeMove(opponentPlayer)) {
                player1Turn = !player1Turn;
                continue;
            }
            player1Turn = !player1Turn;
        }
        System.out.println("Game Over!");
    }
    private boolean isGameOver() {
        return player1.getOwnBoard().allShipsSunk() || player2.getOwnBoard().allShipsSunk();
    }
}










