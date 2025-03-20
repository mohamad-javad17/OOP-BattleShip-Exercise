
public class Coordinate {
    private int row;
    private int col;
    public Coordinate(String input) {
        this.col = input.charAt(0) - 'A';
        this.row = Integer.parseInt(input.substring(1));
    }
    public int getRow()
    {
        return row;
    }
    public int getCol()
    {
        return col;
    }
}