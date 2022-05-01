package Controller;

import java.util.ArrayList;
import java.util.Scanner;

import javax.sound.midi.Soundbank;
import javax.xml.bind.ValidationEventHandler;

import Model.*;
public class Verificador {
    
    public boolean CasaComPeca(ArrayList<Piece> Pieces, int xLinha,int yColuna){
        
        for (Piece piece : Pieces) {
            if(xLinha == piece.getX() && yColuna == piece.getY()){
                return true;  
            }
        }
        return false;
    
    }


    public boolean MovimentoPossivelPeao(ArrayList<Piece> Pieces, int xLinhaAntes, int yColunaAntes, int xLinhaDepois, int yColunaDepois){
        
        for (Piece piece : Pieces) {
            if(Math.abs(xLinhaAntes- xLinhaDepois) == Math.abs(yColunaAntes - yColunaDepois)){
                if (piece.getColor() == 'b') {
                    if(xLinhaAntes == piece.getX() && yColunaAntes == piece.getY()){
        
                        for (int index = 0; index < 24; index++) {
                            if(Pieces.get(index).getY() == yColunaDepois && Pieces.get(index).getX() == xLinhaDepois || Pieces.get(index).getColor() == 'b'){}
                            else if(xLinhaDepois -1 == piece.getX() && yColunaDepois -1 == piece.getY()){ 
                                return true;
                            }else if (xLinhaDepois -1 == piece.getX() && yColunaDepois +1 == piece.getY())                  
                                return true;                   
                            }        
                        } 
                    }
                } 
                if (piece.getColor() == 'p') {
                    if(xLinhaAntes == piece.getX() && yColunaAntes == piece.getY()){
        
                        for (int index = 0; index < 24; index++) {
                            if(Pieces.get(index).getY() == yColunaDepois && Pieces.get(index).getX() == xLinhaDepois || Pieces.get(index).getColor() == 'p'){}
                            else if(xLinhaDepois +1 == piece.getX() && yColunaDepois -1 == piece.getY()){
                                

                            return true;
                            }else if (xLinhaDepois +1 == piece.getX() && yColunaDepois +1 == piece.getY())
                                

                            return true;                   
                        }        
                         
                    }
                    
                }
                
            }
            return false;
    }    

    public boolean moverPeaoComer(ArrayList<Piece> Pieces, int xLinhaAntes, int yColunaAntes, int xLinhaDepois, int yColunaDepois){

            for (Piece piece : Pieces) {
                if (xLinhaAntes == piece.getX() && yColunaAntes == piece.getY()) {
                        if (piece.getColor() == 'b') {

                                for (int i = 0; i < 24; i++) {
                                    if (Pieces.get(i).getX() == xLinhaDepois + 1 && Pieces.get(i).getY() == yColunaDepois + 1){
                                        System.out.println("ola");
                                        return false;
                                    }
                                    if (Pieces.get(i).getX() == xLinhaDepois + 1 && Pieces.get(i).getY() == yColunaDepois - 1){
                                        System.out.println("ola");
                                        return false;
                                    }
                                        if (Pieces.get(i).getX() == xLinhaDepois && Pieces.get(i).getY() == yColunaDepois) {
                                            piece.setX(xLinhaDepois + 1);
                                            System.out.println("PASSOU AQUI 1");
                                            if(yColunaDepois > yColunaAntes){    
                                                System.out.println("PASSOU AQUI 2");        
                                                piece.setY(yColunaDepois + 1);
                                                Pieces.get(i).setColor(' ');

                                                System.out.println(Pieces.get(i).getX());
                                                System.out.println(Pieces.get(i).getY());
                                                return true;
                                            }else{
                                                System.out.println("PASSOU AQUI 3");
                                                piece.setY(yColunaDepois - 1);
                                                Pieces.get(i).setColor(' ');
                                                return true;                               
                                            }
                                        }else{
                                            System.out.println("TESTE AQUI");
                                    }
                                }
                                                           
                        }
                        if (piece.getColor() == 'p') {
                            
                            for (int index = 0; index < index; index++) {
                                
                                if (Pieces.get(index).getX() == xLinhaDepois - 1 && Pieces.get(index).getY() == yColunaDepois + 1) {
                                    System.out.println("ENTROUUU");
                                    return false;
                                }
                                if (Pieces.get(index).getX() == xLinhaDepois - 1 && Pieces.get(index).getY() == yColunaDepois - 1){
                                    System.out.println("ENTROUUU 1");
                                    return false;
                                } 

                                if (Pieces.get(index).getX() == xLinhaDepois && Pieces.get(index).getY() == yColunaDepois) {
                                    piece.setX(xLinhaDepois - 1);
                                    if(yColunaDepois > yColunaAntes){
                                        System.out.println("PASSOU AQUI4");
                                        piece.setY(yColunaDepois + 1);
                                        Pieces.get(index).setColor(' ');
                                        return true;
                                    }else{
                                        System.out.println("PASSOU AQUI5");
                                        piece.setY(yColunaDepois - 1);
                                        Pieces.get(index).setColor(' ');
                                        return true;
                                    }
                                }else{
                                    System.out.println("TESTE AQUI 2");
                                }
                                
                            }
    
                        }
                    
                }
            }
        
        return false;
    }

    public boolean moverPeao(ArrayList<Piece> Pieces, int xLinhaAntes, int yColunaAntes, int xLinhaDepois, int yColunaDepois){
        for(Piece piece : Pieces){

            if (xLinhaAntes == piece.getX() && yColunaAntes == piece.getY()) {
                for (int i = 0; i < 24; i++) {
                    //PROCURA SE TEM UMA PEÇA NA CASA
                    if(Pieces.get(i).getX() == xLinhaDepois && Pieces.get(i).getY() == yColunaDepois){
                        System.out.println("------------TEM PEÇA NA LINHA DEPOIS E COLUNA DEPOIS---------");
                        System.out.println("x: "+Pieces.get(i).getX());
                        System.out.println(" y: "+Pieces.get(i).getY() );

                        for (int j = 0; j < 24; j++) {             
                            if (Pieces.get(j).getX() == xLinhaDepois + 1 && Pieces.get(j).getY() == yColunaDepois + 1) {
                                System.out.println("------------TEM PEÇA NA LINHA DEPOIS+1 E COLUNA+1 DEPOIS---------");
                                System.out.println("x: "+Pieces.get(j).getX());
                                System.out.println(" y: "+Pieces.get(j).getY() );
                                return false;
                            }
                        }
                    }
                    piece.setX(xLinhaDepois);
                    piece.setY(yColunaDepois);
                }
            }
        }
        return true;
    }
}    
   


// System.out.println("CASAS COM PEÇAS 1 ");
// System.out.print("X: "+ Pieces.get(i).getX());
// System.out.println(" Y: "+ Pieces.get(i).getY());

//     if (piece.getColor() == 'b') {
//         if (yColunaAntes > yColunaDepois) {
//             System.out.println("TENTOU COMER");
//             piece.setX(xLinhaDepois+1);
//             piece.setY(yColunaDepois - 1);
//             Pieces.get(i).setColor(' ');
//         }else{
//             System.out.println("TENTOU COMER");
//             piece.setX(xLinhaDepois+1);
//             piece.setY(yColunaDepois + 1);
//             Pieces.get(i).setColor(' ');
//         }
//     }
//     if(piece.getColor() == 'p'){
//         System.out.println("TENTOU COMER");

//         if(yColunaAntes > yColunaDepois){
//             piece.setX(xLinhaDepois-1);
//             piece.setY(yColunaDepois - 1);
//             Pieces.get(i).setColor(' ');
//         }else{
//             System.out.println("TENTOU COMER");
//             piece.setX(xLinhaDepois-1);
//             piece.setY(yColunaDepois + 1);
//             Pieces.get(i).setColor(' ');
//         }
//     }
    


    

