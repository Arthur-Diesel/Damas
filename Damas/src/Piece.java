public class Piece {
    private int x;
    private int y;
    char color;

    // X É Linha!
    // Y É Coluna!
    // b é Peão branco!
    // B é dama branca!
    // p é Peão preto!
    // P é dama preta!

    Piece(int x, int y){
        this.x = x;
        this.y = y;
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
