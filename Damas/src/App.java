import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        Views views = new Views();
        views.Header();

        ArrayList<Piece> Pieces = new ArrayList<>();

        // Colocar em um for \/
        // ~ Brancas ~
        Pieces.add(new Pawn(0, 1, 'b'));
        Pieces.add(new Pawn(0, 3, 'b'));
        Pieces.add(new Pawn(0, 5, 'b'));
        Pieces.add(new Pawn(0, 7, 'b'));
        Pieces.add(new Pawn(1, 0, 'b'));
        Pieces.add(new Pawn(1, 2, 'b'));
        Pieces.add(new Pawn(1, 4, 'b'));
        Pieces.add(new Pawn(1, 6, 'b'));
        Pieces.add(new Dama(2, 1, 'B'));
        Pieces.add(new Dama(2, 3, 'B'));
        Pieces.add(new Dama(2, 5, 'B'));
        Pieces.add(new Dama(2, 7, 'B'));
        
        // ~ Pretas ~ 
        Pieces.add(new Pawn(5, 0, 'p'));
        Pieces.add(new Pawn(5, 2, 'p'));
        Pieces.add(new Pawn(5, 4, 'p'));
        Pieces.add(new Pawn(5, 6, 'p'));
        Pieces.add(new Pawn(6, 1, 'p'));
        Pieces.add(new Pawn(6, 3, 'p'));
        Pieces.add(new Pawn(6, 5, 'p'));
        Pieces.add(new Pawn(6, 7, 'p'));
        Pieces.add(new Dama(7, 0, 'P'));
        Pieces.add(new Dama(7, 2, 'P'));
        Pieces.add(new Dama(7, 4, 'P'));
        Pieces.add(new Dama(7, 6, 'P'));


        views.ShowBoard(Pieces);
    }
}
