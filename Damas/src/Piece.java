public class Piece {
    private int x;
    private int y;
    char color;

    // X É Linha!
    // Y É Coluna!

    Piece(int x, int y, char color){
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) { }
    public void setY(int y) { }
}
