import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        Views views = new Views();
        views.Header();

        ArrayList<Piece> Pieces = new ArrayList<>();

        // Colocar em um for \/
        Pieces.add(new Pawn(0, 1, 'b'));
        Pieces.add(new Pawn(0, 3, 'b'));
        Pieces.add(new Pawn(0, 5, 'b'));
        Pieces.add(new Pawn(0, 7, 'b'));
        Pieces.add(new Pawn(1, 0, 'b'));
        Pieces.add(new Pawn(1, 2, 'b'));
        Pieces.add(new Pawn(1, 4, 'b'));
        Pieces.add(new Pawn(1, 6, 'b'));
        Pieces.add(new Pawn(2, 1, 'b'));
        Pieces.add(new Pawn(2, 3, 'b'));
        Pieces.add(new Pawn(2, 5, 'b'));
        Pieces.add(new Pawn(2, 7, 'b'));

        views.ShowBoard(Pieces);
    }
}
