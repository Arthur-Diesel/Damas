import java.util.ArrayList;

public class Views {
    public void Header(){
        System.out.println("===================================");
        System.out.println("         Jogo de Damas             ");
        System.out.println("===================================");
        System.out.println("Regras:");
        System.out.println("1 - As pecas Brancas começa a jogar");
        System.out.println("2 - So pode andar em diagonal");
        System.out.println("3 - So pode 'comer' uma peça por vez");
        System.out.println("4 - Ao chegar no final do tabuleiro\na sua peça se torna uma Dama");
        System.out.println("5 - As peças Damas so podem comer uma\npeca por vez");
        System.out.println("6 - O jogo acaba quando as pecas do\nadversario acabarem!");
        System.out.println("===================================\n");
    }

    public void ShowBoard(ArrayList<Piece> Pieces){
        // For Montar Matrix
        char board[][] = new char [8][8];


        for (Piece piece : Pieces) {

            // System.out.print('\n');
            // System.out.println("Linha :" + piece.getX() + " Coluna: " + piece.getY());
            // System.out.print('\n');
        }

    }
}
