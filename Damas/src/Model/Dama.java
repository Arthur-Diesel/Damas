package Model;

public class Dama extends Piece {

    public Dama(int x, int y, char color){
        super(x, y);
        this.color = Character.toUpperCase(color);
    }

    public boolean isDama(){
        return true;
    }

    public void setX(int x){

    }

    public void setY(int y){

    }
}