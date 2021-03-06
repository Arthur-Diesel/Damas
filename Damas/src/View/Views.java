package View;

import java.util.ArrayList;

import Model.Pawn;
import Model.Piece;

public class Views {
    public void Header(){
        System.out.println("===================================");
        System.out.println("         Jogo de Damas             ");
        System.out.println("===================================");
        System.out.println("Regras:");
        System.out.println("1 - As pecas Brancas comecam jogando");
        System.out.println("2 - So pode andar em diagonal");
        System.out.println("3 - So pode 'comer' uma peca por vez");
        System.out.println("4 - Ao chegar no final do tabuleiro\na sua peca se torna uma Dama");
        System.out.println("5 - As pecas Damas so podem comer uma\npeca por vez");
        System.out.println("6 - O jogo acaba quando as pecas do\nadversario acabarem!");
        System.out.println("===================================\n");
    }

    public void ShowBoard(ArrayList<Piece> Pieces){
        // For montar Matrix
        char board[][] = new char [8][8];

        

        for (int x = 0; x<8; x++){
            for(int y=0; y<8; y++){
                if(board[x][y]!='b'){
                    board[x][y] = ' ';
                }
            }
            // board[0][x] = (char) x;
            // board[x][0] = (char) x;
        }
        

        for (Piece piece : Pieces) {
            board[piece.getX()][piece.getY()] = piece.getColor();
        }
        System.out.println("     1    2     3     4     5     6     7     8   ");
        for(int w = 0; w<8; w++){
            System.out.println("  -------------------------------------------------");
            System.out.print(w+1+" |");
            for(int z = 0; z<8; z++){
                System.out.print("  "+board[w][z]+"  |");
            }
            System.out.print("\n");
        }
        System.out.println("  -------------------------------------------------");
    }

    
    
    public void ShowPlayer(int PlayNumber){
        if(PlayNumber % 2 == 0){
        	System.out.print("==============================");
            System.out.print("\n| Vez das Pecas Brancas!     |\n");
            System.out.print("==============================");
        } else {
        	System.out.print("==============================");
            System.out.print("\n| Vez das Pecas Pretas!      |\n");
            System.out.print("==============================");
        }
    }

}