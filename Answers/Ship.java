public class Ship {
    private String name;
    private int size;
    private int hit;
    public Ship(String name, int size) {
        this.name = name;
        this.size = size;
        this.hit = 0;
    }
    public String getName()
    {
        return name;
    }
    public int getSize()
    {
        return size;
    }
    public void hit()
    {
        hit++;
    }
    public boolean isSunk()
    {
        return hit >= size;
    }
}
