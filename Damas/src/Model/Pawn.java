package Model;

public class Pawn extends Piece {

    public Pawn(int x, int y, char color){
        super(x, y);
        this.color = Character.toLowerCase(color);
    }

    public boolean isDama(){
        return false;
    }

   

    
}