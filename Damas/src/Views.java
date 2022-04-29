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
    
    // For Montar Matrix
    char board[][] = new char [8][8];
    
    /*so funciona no eclipse/ DECLARAÇÃO RESET
    public static final String ANSI_RESET = "\u001B[0m";
    //DECLARAÇÃO DAS CORES
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";*/
    
    
    public void ShowBoard(ArrayList<Piece> Pieces){
        for (int x = 0; x<8; x++){
            for(int y=0; y<8; y++){
                if(board[x][y]!='b'|| board[x][y] !='p'){
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
            	if(board[w][z] == 'p') {
            		System.out.print("  "+ board[w][z]+"  |");
            	} else if(board[w][z]=='b') {
            		System.out.print("  "+ board[w][z]+"  |");
            	}else if(board[w][z]=='P' || board[w][z]=='B') {
            		System.out.print("  " + board[w][z]+"  |");
            	} else {
            		System.out.print("  "+board[w][z]+"  |");
            	}            	
            }
            System.out.print("\n");
        }
        System.out.println("  -------------------------------------------------");
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
