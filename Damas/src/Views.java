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
        char board[][] = new char [9][9];

        /*
        Definir Numerações - ~ |

        for (int x = 0; x != 8; x++){
            board[0][x] = (char) x;
            board[x][0] = (char) x;
        }
        */

        for (Piece piece : Pieces) {
            board[piece.getX()][piece.getY()] = piece.getColor();
        }

        for(int w = 0; w != 8; w++){
            for(int z = 0; z != 8; z++){
                System.out.print(board[w][z]);
            }
            System.out.print("\n");
        }
    }

    /*
    public boolean ShowPlayer(int PlayNumber){
        if(PlayNumber % 2 == 0){
            System.out.pritln("\nVez das Peças Brancas!\n");
            return true; // É vez das peças brancas!
        } else {
            System.out.pritln("\nVez das Peças Pretas!\n");
            return false; // É vez das peças pretas!
        }
    }
    */

    /*
    public void ShowWhiteWinner(){
        System.out.println("==============================");
        System.out.println("  As pecas Brancas ganharam!  ");
        System.out.println("==============================");
    }

    public void ShowBlackWinner(){
        System.out.println("==============================");
        System.out.println("   As pecas Pretas ganharam!  ");
        System.out.println("==============================");
    }
    */

}
