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
                            if(Pieces.get(index).getY() == yColunaDepois && Pieces.get(index).getX() == xLinhaDepois || Pieces.get(index).getColor() == 'b'){
                            }
                            else if(xLinhaDepois -1 == piece.getX() && yColunaDepois -1 == piece.getY()){    
                                return true;
                            }else if (xLinhaDepois -1 == piece.getX() && yColunaDepois +1 == piece.getY())  {          
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
                            }else if (xLinhaDepois +1 == piece.getX() && yColunaDepois +1 == piece.getY()){

                                return true;                   
                            }
                        }        
                         
                    }
                    
                }}
                
            }
            return false;
    }    

    public boolean moverPeaoBranco(ArrayList<Piece> Pieces, int xLinhaAntes, int yColunaAntes, int xLinhaDepois, int yColunaDepois){
        for(Piece piece : Pieces){

            if (xLinhaAntes == piece.getX() && yColunaAntes == piece.getY()) {
                if (piece.getColor() == 'b') {
                    for (int i = 0; i < 24; i++) {
                        //PROCURA SE TEM UMA PEÇA NA CASA
                        if(Pieces.get(i).getX() == xLinhaDepois && Pieces.get(i).getY() == yColunaDepois && Pieces.get(i).getColor() == 'p'/*|| Pieces.get(i).getColor() == 'P'*/){
                            if (yColunaAntes < yColunaDepois) {   
                                for (int j = 0; j < 24; j++) { 
                                    //PROCURA SE TEM NA CORNDENADA NÃO TEM NENHUMA PEÇA
                                    if (Pieces.get(j).getX() == xLinhaDepois + 1 && Pieces.get(j).getY() == yColunaDepois + 1) {
                                        System.out.println("nao foi possivel jogar");
                                        return false;
                                    }else if (j == 23) {
                                        piece.setX(xLinhaDepois + 1 );
                                        piece.setY(yColunaDepois + 1 );
                                        Pieces.get(i).setColor(' ');
                                        Pieces.get(i).setX(0);
                                        Pieces.get(i).setY(0);
                                        return true;
                                    }           
                                }
                            }else if (yColunaAntes > yColunaDepois) {
                                
                                for (int j = 0; j < 24; j++) {                                
                                    //PROCURA SE TEM NA CORNDENADA NÃO TEM NENHUMA PEÇA
                                    if (Pieces.get(j).getX() == xLinhaDepois + 1 && Pieces.get(j).getY() == yColunaDepois - 1) {
                                        System.out.println("não foi possivel jogar");
                                        return false;
                                    }else if (j == 23) {
                                        piece.setX(xLinhaDepois + 1 );
                                        piece.setY(yColunaDepois - 1 );
                                        Pieces.get(i).setColor(' ');
                                        Pieces.get(i).setX(0);
                                        Pieces.get(i).setY(0);
                                        return true;
                                    }
                                }
                            }
                        }else if (i == 23){
                            System.out.println("APENAS ANDOU");
                            piece.setX(xLinhaDepois);
                            piece.setY(yColunaDepois);
                            return true;
                        }
                    }
                    
                }

            }
        }
        return false;
    }

    public boolean moverPeaoPreto(ArrayList<Piece> Pieces, int xLinhaAntes, int yColunaAntes, int xLinhaDepois, int yColunaDepois){
        for(Piece piece : Pieces){
    
            if (xLinhaAntes == piece.getX() && yColunaAntes == piece.getY() ) {
                if (piece.getColor() == 'p') {
                    for (int i = 0; i < 24; i++) {
                        //PROCURA SE TEM UMA PEÇA NA CASA
                        if(Pieces.get(i).getX() == xLinhaDepois && Pieces.get(i).getY() == yColunaDepois && Pieces.get(i).getColor() == 'b'/*|| Pieces.get(i).getColor() == 'B'*/ ){
                            if (yColunaAntes < yColunaDepois) {
                              
                                for (int j = 0; j < 24; j++) { 
                                    //PROCURA SE TEM NA CORNDENADA NÃO TEM NENHUMA PEÇA
                                    if (Pieces.get(j).getX() == xLinhaDepois - 1 && Pieces.get(j).getY() == yColunaDepois + 1) {
                                        System.out.println("nao foi possivel jogar");
                                        return false;
                                    }else if (j == 23) {
                                        piece.setX(xLinhaDepois - 1 );
                                        piece.setY(yColunaDepois + 1 );
                                        Pieces.get(i).setColor(' ');
                                        Pieces.get(i).setX(0);
                                        Pieces.get(i).setY(0);
                                        return true;
                                    }           
                                }
                            }else if (yColunaAntes > yColunaDepois) {
                                
                                for (int j = 0; j < 24; j++) {                                
                                    //PROCURA SE TEM NA CORNDENADA NÃO TEM NENHUMA PEÇA
                                    if (Pieces.get(j).getX() == xLinhaDepois - 1 && Pieces.get(j).getY() == yColunaDepois - 1) {
                                        System.out.println("não foi possivel jogar");
                                        return false;
                                    }else if (j == 23) {
                                        piece.setX(xLinhaDepois - 1 );
                                        piece.setY(yColunaDepois - 1 );
                                        Pieces.get(i).setColor(' ');
                                        Pieces.get(i).setX(0);
                                        Pieces.get(i).setY(0);
                                        return true;
                                    }
                                }
                            }
                        }else if (i == 23){
                            System.out.println("APENAS ANDOU");
                            piece.setX(xLinhaDepois);
                            piece.setY(yColunaDepois);
                            return true;
                        }
                    }
                    
                }
            }
        }
        return false;
    }

    public void IsDama(ArrayList<Piece> Pieces,int xLinhaDepois,int yColunaDepois){
         
        for (Piece piece : Pieces) {
            if (piece.getColor() == 'b') {
                if (piece.getX() == 7) {
                    System.out.println("VIROU DAMAAA");
                    Pieces.remove(piece);
                    Pieces.add(new Dama(xLinhaDepois, yColunaDepois,'B'));
                }
            }
            if(piece.getColor() == 'p'){
                if (piece.getX() == 0) {
                    System.out.println("VIROU DAMAAAA");
                    Pieces.remove(piece);
                    Pieces.add(new Dama(xLinhaDepois, yColunaDepois,'P'));
                }
            }
            
        }

    }
    
    
    
    public void moverDama(ArrayList<Piece> Pieces, int xLinhaAntes, int yColunaAntes, int xLinhaDepois, int yColunaDepois){
    
    }
}    
   



    
