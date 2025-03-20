import java.util.Random;
public class Aiplayer extends Player {
    private Random rand;
    public Aiplayer(String name, Board ownBoard, Board opponentBoard, int gridSize) {
        super(name, ownBoard, opponentBoard, gridSize); // فراخوانی سازنده کلاس والد
        this.rand = new Random();
    }
    @Override
    public boolean makeMove(Player opponent) {
        String move = generateRandomMove();
        System.out.println("AI is attacking: " + move);
        Coordinate coordinate = new Coordinate(move);
        return opponent.getOwnBoard().attack(coordinate);
    }
    private String generateRandomMove() {
        char col = (char) ('A' + rand.nextInt(gridSize));
        int row = rand.nextInt(gridSize);
        return "" + col + row;
    }
}
