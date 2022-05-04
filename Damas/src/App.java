import Model.*;
import View.Views;
import Controller.*;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        
        Views views = new Views();
        Verificador verificador = new Verificador();
        views.Header();

        ArrayList<Piece> Pieces = new ArrayList<>();

        
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

        Pieces.add(new Pawn(5, 0, 'p'));
        Pieces.add(new Pawn(5, 2, 'p'));
        Pieces.add(new Pawn(5, 4, 'p'));
        Pieces.add(new Pawn(5, 6, 'p'));
        Pieces.add(new Pawn(6, 1, 'p'));
        Pieces.add(new Pawn(6, 3, 'p'));
        Pieces.add(new Pawn(6, 5, 'p'));
        Pieces.add(new Pawn(6, 7, 'p'));
        Pieces.add(new Pawn(7, 0, 'p'));
        Pieces.add(new Pawn(7, 2, 'p'));
        Pieces.add(new Pawn(7, 4, 'p'));
        Pieces.add(new Pawn(7, 6, 'p'));
        
        
       


        views.ShowBoard(Pieces);
        boolean aux = false;
        int xLinhaAntes;
        int yColunaAntes;
        for (int i = 0; i < 20; i++) {
            do {
                if (i % 2==0) {
                    System.out.println("================= VEZ DO BRANCO =================");
                    
                }else{
                    System.out.println("================= VEZ DO PRETO =================");
                    
                }

                System.out.println("Infome a linha e coluna da peca que vc deseja mudar");
                 xLinhaAntes = scanner.nextInt();
                 yColunaAntes = scanner.nextInt();
                
                aux = verificador.CasaComPeca(Pieces,xLinhaAntes,yColunaAntes);
                if(aux==false) {
                	System.out.println("A casa que voce escolheu nao tem  nenhuma peca");
                }
            } while (aux == false);
            int xLinhaDepois;
            int yColunaDepois;
            do {
                 System.out.println("Infome a linha e coluna para deslocar a peca escolhida");
                 xLinhaDepois = scanner.nextInt();
                 yColunaDepois = scanner.nextInt();
                
                aux = verificador.MovimentoPossivelPeao(Pieces,xLinhaAntes,yColunaAntes,xLinhaDepois,yColunaDepois);  
                if(aux == false) {
                	System.out.println("A peca nao pode ser deslocada para essa coordenada");
                }
            } while (aux == false);
            aux = false;
            if (i % 2==0) {
                aux = verificador.moverPeaoBranco(Pieces, xLinhaAntes, yColunaAntes, xLinhaDepois, yColunaDepois);
            }else{ 
                aux = verificador.moverPeaoPreto(Pieces, xLinhaAntes, yColunaAntes, xLinhaDepois, yColunaDepois);
            }
          
            verificador.IsDama(Pieces, xLinhaDepois, yColunaDepois);

            
            
            
            System.out.println(aux);
     
             
     
            views.ShowBoard(Pieces);
            
        }

         
    }
}