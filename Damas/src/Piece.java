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
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public char getColor(){
        return this.color;
    }

    public void setX(int x) { }
    public void setY(int y) { }
}
