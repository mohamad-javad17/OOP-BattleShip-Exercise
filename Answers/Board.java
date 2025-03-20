


import java.util.Random;

public class Board {
    private int gridSize; // اندازه صفحه (به جای ثابت GRID_SIZE)
    private char[][] grid;
    private char[][] trackingGrid;
    public Board(int gridSize) {
        this.gridSize = gridSize;
        this.grid = new char[gridSize][gridSize];
        this.trackingGrid = new char[gridSize][gridSize];
        initializeGrid(grid);
        initializeGrid(trackingGrid);
    }
    private void initializeGrid(char[][] grid) {
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                grid[i][j] = '~';
            }
        }
    }
    public boolean attack(Coordinate coordinate) {
        int row = coordinate.getRow();
        int col = coordinate.getCol();
        if (row < 0 || row >= gridSize || col < 0 || col >= gridSize) {
            System.out.println("Invalid coordinates! Skipping your turn.");
            return false;
        }
        if (grid[row][col] == '+') {
            System.out.println("Hit!");
            grid[row][col] = '*';
            trackingGrid[row][col] = '*';
            return true;
        } else {
            System.out.println("Miss!");
            grid[row][col] = '0';
            trackingGrid[row][col] = '0';
            return false;
        }
    }
    public void placeShipsRandomly() {
        int[] shipSizes = {5, 4, 3, 2};
        Random rand = new Random();

        for (int size : shipSizes) {
            boolean placed = false;
            while (!placed) {
                int row = rand.nextInt(gridSize);
                int col = rand.nextInt(gridSize);
                boolean horizontal = rand.nextBoolean();
                if (canPlaceShip(size, row, col, horizontal)) {
                    placeShip(size, row, col, horizontal);
                    placed = true;
                }
            }
        }
    }
    private boolean canPlaceShip(int size, int row, int col, boolean horizontal) {
        if (horizontal) {
            if (col + size > gridSize) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                if (grid[row][col + i] != '~') {
                    return false;
                }
            }
        } else {
            if (row + size > gridSize) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                if (grid[row + i][col] != '~') {
                    return false;
                }
            }
        }
        return true;
    }
    private void placeShip(int size, int row, int col, boolean horizontal) {
        if (horizontal) {
            for (int i = 0; i < size; i++) {
                grid[row][col + i] = '+';
            }
        } else {
            for (int i = 0; i < size; i++) {
                grid[row + i][col] = '+';
            }
        }
    }
    public boolean allShipsSunk() {
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                if (grid[i][j] == '+') {
                    return false;
                }
            }
        }
        return true;
    }
    public void printgrid() {
        System.out.print("   ");
        for (int i = 0; i < gridSize; i++) {
            System.out.print((char) ('A' + i) + " ");
        }
        System.out.println();
        for (int i = 0; i < gridSize; i++) {
            System.out.print(i + "  ");
            for (int j = 0; j < gridSize; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
    public void printattackingGrid() {
        System.out.print("   ");
        for (int i = 0; i < gridSize; i++) {
            System.out.print((char) ('A' + i) + " ");
        }
        System.out.println();
        for (int i = 0; i < gridSize; i++) {
            System.out.print(i + "  ");
            for (int j = 0; j < gridSize; j++) {
                System.out.print(trackingGrid[i][j] + " ");
            }
            System.out.println();
        }
    }
}