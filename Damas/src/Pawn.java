public class Pawn extends Piece {

    Pawn(int x, int y, char color){
        super(x, y);
        this.color = Character.toLowerCase(color);
    }

    public boolean isDama(){
        return false;
    }

    public void setX(int x){

    }

    public void setY(int y){

    }
}
