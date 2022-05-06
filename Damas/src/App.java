import Model.*;
import View.Views;
import controller.Verificador;

import java.util.ArrayList;
import java.util.Scanner;


public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        
        Views views = new Views();
        Verificador verificador = new Verificador();
        views.Header();

        ArrayList<Piece> Pieces = new ArrayList<>();

        Pieces.add(new Pawn(5, 0, 'p'));
        Pieces.add(new Pawn(5, 2, 'p'));
        Pieces.add(new Pawn(5, 4, 'p'));
        Pieces.add(new Pawn(5, 6, 'p'));
        Pieces.add(new Pawn(6, 1, 'p'));
        Pieces.add(new Pawn(6, 3, 'p'));
        Pieces.add(new Pawn(6, 5, 'p'));
        Pieces.add(new Pawn(6, 7, 'b'));
        Pieces.add(new Pawn(7, 0, 'p'));
        Pieces.add(new Pawn(7, 2, 'p'));
        Pieces.add(new Pawn(7, 4, 'p'));
        Pieces.add(new Pawn(0, 0, ' '));
        
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
	    boolean aux = false;
	    int xLinhaAntes;
	    int yColunaAntes;
	    int cont=0;
	    int xLinhaDepois;
	    int yColunaDepois;
	    
	    do {
	    	
	    	do {
		    	//REPETI ATE O USUARIO DIGITAR UMA CASA VALIDA
		        do {
		            views.ShowPlayer(cont);
		            
		            //USUARIO DIGITA A LINHA E COLONA DA PECA QUE ELE QUER COMER
		            System.out.println("\n| Infome a linha e coluna da peca que vc deseja mudar:");
		            xLinhaAntes = scanner.nextInt()-1;
		            yColunaAntes = scanner.nextInt()-1;
		            
		            //VERIFICA SE EH VALIDO A CASA
		            aux = verificador.CasaComPeca(Pieces,xLinhaAntes,yColunaAntes, cont);
		            
		            if(aux==false) {
		            	System.out.println("\n| A casa que voce escolheu nao tem  nenhuma peca ou vc selecionou a cor do adversário!");
		            }
		            
		        } while (aux == false);
		        
		        if(verificador.checkDama(Pieces, xLinhaAntes, yColunaAntes) == true) {			        	
	        		System.out.println("\n| Infome a linha e coluna para deslocar a peca escolhida:");
		        	xLinhaDepois = scanner.nextInt()-1;
		        	yColunaDepois = scanner.nextInt()-1;
		        	aux = verificador.MovimentoPossivelDama(Pieces, xLinhaAntes, yColunaAntes, xLinhaDepois, yColunaDepois);
		        } else {
		        	System.out.println("\n| Infome a linha e coluna para deslocar a peca escolhida:");
		        	xLinhaDepois = scanner.nextInt()-1;
		        	yColunaDepois = scanner.nextInt()-1;		        	
		        	aux = verificador.MovimentoPossivelPeao(Pieces,xLinhaAntes,yColunaAntes,xLinhaDepois,yColunaDepois);
		        }
		        
	            if(aux == false) {
	            	System.out.println("\n| A peca nao pode ser deslocada para essa coordenada!");
	            }	            
	        } while (aux == false);
	    	
	        if (cont % 2==0) {
	        	if(verificador.checkDama(Pieces, xLinhaAntes, yColunaAntes) == true) {
	        		do {
		        		aux = verificador.moverDama(Pieces, xLinhaAntes, yColunaAntes, xLinhaDepois, yColunaDepois);
		        		if(aux==true) {		        			
		        			xLinhaAntes = xLinhaDepois;
		        			yColunaAntes = yColunaDepois;
		        			cont++;		        			
		        		}		        		
	        		}while(aux = true);
	        	} else {	        		
	        		aux = verificador.moverPeaoBranco(Pieces, xLinhaAntes, yColunaAntes, xLinhaDepois, yColunaDepois);
	        		cont++;
	        	}
	        }else{
	        	if(verificador.checkDama(Pieces, xLinhaAntes, yColunaAntes) == true) {
	        		do {
		        		aux = verificador.moverDama(Pieces, xLinhaAntes, yColunaAntes, xLinhaDepois, yColunaDepois);
		        		if(aux==true) {		        			
		        			xLinhaAntes = xLinhaDepois;
		        			yColunaAntes = yColunaDepois;
		        			cont++;		        			
		        		}		        		
	        		}while(aux = true);
	        	}else {
	        		aux = verificador.moverPeaoPreto(Pieces, xLinhaAntes, yColunaAntes, xLinhaDepois, yColunaDepois);
	        		cont++;
	        	}
	        }
	      
	        verificador.IsDama(Pieces, xLinhaDepois, yColunaDepois);
	        views.ShowBoard(Pieces);
	        
	        
	    
	    }while(verificador.win(Pieces) == false);

	    scanner.close();
    }
}