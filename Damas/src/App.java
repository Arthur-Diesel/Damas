import Model.*;
import View.Views;
import Controller.*;
import java.util.ArrayList;
import java.util.Scanner;

import Controller.*;

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
        Pieces.add(new Pawn(2, 1, 'B'));
        Pieces.add(new Pawn(2, 3, 'B'));
        Pieces.add(new Pawn(2, 5, 'B'));
        Pieces.add(new Pawn(2, 7, 'B'));

        Pieces.add(new Pawn(5, 0, 'p'));
        Pieces.add(new Pawn(5, 2, 'p'));
        Pieces.add(new Pawn(5, 4, 'p'));
        Pieces.add(new Pawn(5, 6, 'p'));
        Pieces.add(new Pawn(6, 1, 'p'));
        Pieces.add(new Pawn(6, 3, 'p'));
        Pieces.add(new Pawn(6, 5, 'p'));
        Pieces.add(new Pawn(6, 7, 'p'));
        Pieces.add(new Pawn(7, 0, 'P'));
        Pieces.add(new Pawn(7, 2, 'P'));
        Pieces.add(new Pawn(7, 4, 'P'));
        Pieces.add(new Dama(7, 6, 'P'));
        
        
       


        views.ShowBoard(Pieces);
        boolean aux = false;
        int xLinhaAntes;
        int yColunaAntes;
        for (int i = 0; i < 10; i++) {
            do {
                System.out.println("Infome a linha e coluna da peça que vc deseja mudar");
                 xLinhaAntes = scanner.nextInt();
                 yColunaAntes = scanner.nextInt();
                
                aux = verificador.CasaComPeca(Pieces,xLinhaAntes,yColunaAntes);
            } while (aux == false);
             int xLinhaDepois;
             int yColunaDepois;
             
            do {
                 System.out.println("Infome a linha e coluna para deslocar a peça escolhida");
                 xLinhaDepois = scanner.nextInt();
                 yColunaDepois = scanner.nextInt();
                
                aux = verificador.MovimentoPossivelPeao(Pieces,xLinhaAntes,yColunaAntes,xLinhaDepois,yColunaDepois);   
            } while (aux == false);
            aux = false;
            //aux=verificador.moverPeaoComer(Pieces, xLinhaAntes, yColunaAntes, xLinhaDepois, yColunaDepois);
            
            aux = verificador.moverPeao(Pieces, xLinhaAntes, yColunaAntes, xLinhaDepois, yColunaDepois);
            if (aux == true) {
                System.out.println("PODE COMER");
            }else{
                System.out.println("NAO PODE");
                
            }
            
            System.out.println(aux);
     
             
     
            views.ShowBoard(Pieces);
            
        }

         
    }
}