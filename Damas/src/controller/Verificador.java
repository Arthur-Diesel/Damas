package controller;
//package Controller;

import java.util.ArrayList;
//import java.ArrayUtils.removeElement;
//import java.util.Scanner;

//import javax.sound.midi.Soundbank;
import Model.Dama;
import Model.Piece;
//import javax.xml.bind.ValidationEventHandler;
public class Verificador {
    
    public boolean CasaComPeca(ArrayList<Piece> Pieces, int xLinha,int yColuna, int i){
        
        for (Piece piece : Pieces) {
        	if(i % 2 == 0) {
        		//VERIFICA SE SE O USAUARIO DIGITOU UMA CASA VALIDA E SE SELECIONOU A COR CERTA
        		if(xLinha == piece.getX() && yColuna == piece.getY() && (piece.getColor() == 'b' || piece.getColor() == 'B')){
        			return true;        		
        		}            	
            } else if (xLinha == piece.getX() && yColuna == piece.getY() && (piece.getColor() == 'P' || piece.getColor() == 'p')) {
            	return true;
            }
        }
        return false;
    
    }
    
    public boolean MovimentoPossivelPeao(ArrayList<Piece> Pieces, int xLinhaAntes, int yColunaAntes, int xLinhaDepois, int yColunaDepois){        
    	for (Piece piece : Pieces) {
            if(Math.abs(xLinhaAntes- xLinhaDepois) == Math.abs(yColunaAntes - yColunaDepois)){
            	
            	
            	
            	if(xLinhaAntes == piece.getX() && yColunaAntes == piece.getY()) {
            		
	            	//VERFIFCA SE EH PEAO BRANCO
	                if (piece.getColor() == 'b') {	                           
                        for (int index = 0; index < Pieces.size(); index++) {
                            if(xLinhaDepois == Pieces.get(index).getX() && yColunaDepois == Pieces.get(index).getY() && (Pieces.get(index).getColor() =='b' || Pieces.get(index).getColor() == 'B')){
                            	return false;                            
                            }
                        }
                        if((xLinhaDepois-1 == piece.getX() && yColunaDepois-1 == piece.getY()) || (xLinhaDepois-1 == piece.getX() && yColunaDepois+1 == piece.getY())){    
                            return true;
                        }	                    
	                }
	                //VERFIFCA SE EH PEAO PRETO
	                if (piece.getColor() == 'p') {	                    
	        
                        for (int index = 0; index < Pieces.size(); index++) {
                            if(xLinhaDepois == Pieces.get(index).getX() && yColunaDepois == Pieces.get(index).getY() && (Pieces.get(index).getColor() =='p' || Pieces.get(index).getColor() == 'P')){
                            	return false;             
                            }
                        }
                        if((xLinhaDepois+1 == piece.getX() && yColunaDepois-1 == piece.getY()) || (xLinhaDepois+1 == piece.getX() && yColunaDepois+1 == piece.getY())){    
                            return true;
                        }	                    
	                }
            	}                
            }
                
        }
            return false;
    }
    
    public boolean MovimentoPossivelDama(ArrayList<Piece> Pieces, int xLinhaAntes, int yColunaAntes, int xLinhaDepois, int yColunaDepois){
    	for (Piece piece : Pieces) {
    		 if(Math.abs(xLinhaAntes- xLinhaDepois) == Math.abs(yColunaAntes - yColunaDepois)){
    			 if(xLinhaAntes == piece.getX() && yColunaAntes == piece.getY()) {
    				 
//    				 DAMA BRANCA
    				 if(piece.getColor() == 'B') {
    					 for (int index = 0; index < Pieces.size(); index++) {
                             if(xLinhaDepois == Pieces.get(index).getX() && yColunaDepois == Pieces.get(index).getY() && (Pieces.get(index).getColor() =='b' || Pieces.get(index).getColor() == 'B')){
                             	return false;                            
                             }
                         }    					 
    				 }
    				 
//    				 DAMA PRETA
    				 if(piece.getColor() == 'P') {
    					 for (int index = 0; index < Pieces.size(); index++) {
                             if(xLinhaDepois == Pieces.get(index).getX() && yColunaDepois == Pieces.get(index).getY() && (Pieces.get(index).getColor() =='p' || Pieces.get(index).getColor() == 'P')){
                             	return false;                            
                             }
                         }
    				 }
    				 if((xLinhaDepois-1 == piece.getX() && yColunaDepois-1 == piece.getY()) || (xLinhaDepois-1 == piece.getX() && yColunaDepois+1 == piece.getY()) || (xLinhaDepois+1 == piece.getX() && yColunaDepois-1 == piece.getY()) || (xLinhaDepois+1 == piece.getX() && yColunaDepois+1 == piece.getY())){ 
    					 return true;
    				 }
    			 }
    		 }
    		
    	}
    	
    	return false;
    }
    
    public boolean moverPeaoBranco(ArrayList<Piece> Pieces, int xLinhaAntes, int yColunaAntes, int xLinhaDepois, int yColunaDepois){
        for(Piece piece : Pieces){
            if (xLinhaAntes == piece.getX() && yColunaAntes == piece.getY()) {
                if (piece.getColor() == 'b') {
                    for (int i = 0; i < Pieces.size(); i++) {
                        //PROCURA SE TEM UMA PECA NA CASA DE DESTINO
                        if(Pieces.get(i).getX() == xLinhaDepois && Pieces.get(i).getY() == yColunaDepois && (Pieces.get(i).getColor() == 'p' || Pieces.get(i).getColor() == 'P')){
                            if (yColunaAntes < yColunaDepois) {   
                                for (int j = 0; j < Pieces.size(); j++) {
                                    if (Pieces.get(j).getX() == xLinhaDepois + 1 && Pieces.get(j).getY() == yColunaDepois + 1) {
                                        System.out.println("| Nao foi possivel jogar!!");
                                        return false;
                                    }           
                                }                                
                                piece.setX(xLinhaDepois + 1 );
                                piece.setY(yColunaDepois + 1 );
                                Pieces.remove(i);
                                return true;
                            }else if (yColunaAntes > yColunaDepois) {
                                
                                for (int j = 0; j < Pieces.size(); j++) {
                                    if (Pieces.get(j).getX() == xLinhaDepois + 1 && Pieces.get(j).getY() == yColunaDepois - 1) {
                                        System.out.println("não foi possivel jogar");
                                        return false;
                                    }
                                }
                                piece.setX(xLinhaDepois + 1 );
                                piece.setY(yColunaDepois - 1 );
                                Pieces.remove(i);
                                return true;
                            }
                        }
                        
                    }
                    piece.setX(xLinhaDepois);
                    piece.setY(yColunaDepois);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean moverPeaoPreto(ArrayList<Piece> Pieces, int xLinhaAntes, int yColunaAntes, int xLinhaDepois, int yColunaDepois){
        for(Piece piece : Pieces){    
            if (xLinhaAntes == piece.getX() && yColunaAntes == piece.getY()) {
                if (piece.getColor() == 'p') {
                    for (int i = 0; i < Pieces.size(); i++) {
                        //PROCURA SE TEM UMA PECA NA CASA DE DESTINO
                        if(Pieces.get(i).getX() == xLinhaDepois && Pieces.get(i).getY() == yColunaDepois && (Pieces.get(i).getColor() == 'b'|| Pieces.get(i).getColor() == 'B')){
                        	System.out.println("TESTE");
                            
                        	if (yColunaAntes < yColunaDepois) {                              
                                for (int j = 0; j < Pieces.size(); j++) {
                                    if (Pieces.get(j).getX() == xLinhaDepois - 1 && Pieces.get(j).getY() == yColunaDepois + 1) {
                                        System.out.println("nao foi possivel jogar");
                                        return false;
                                    }
                                              
                                }
                                piece.setX(xLinhaDepois - 1 );
                                piece.setY(yColunaDepois + 1 );
                                Pieces.remove(i);
                                return true;
                            }else if (yColunaAntes > yColunaDepois) {
                                
                                for (int j = 0; j < Pieces.size(); j++) {
                                    if (Pieces.get(j).getX() == xLinhaDepois - 1 && Pieces.get(j).getY() == yColunaDepois - 1) {
                                        System.out.println("Nao foi possivel jogar");
                                        return false;
                                    }                                    
                                }
                                piece.setX(xLinhaDepois - 1 );
                                piece.setY(yColunaDepois - 1 );
                                Pieces.remove(i);
                                return true;
                            }
                        }
                    }
                    piece.setX(xLinhaDepois);
                    piece.setY(yColunaDepois);
                    return true;                    
                }
            }
        }
        return false;
    }

    public void IsDama(ArrayList<Piece> Pieces,int xLinhaDepois,int yColunaDepois){
    	int i=0;
        for (Piece piece : Pieces) {
            if (piece.getColor() == 'b') {
                if (piece.getX() == 7) {
                	System.out.print("\n==============================");
                    System.out.print("\n| SUA PECA VIROU DAMA!!      |\n");
                    System.out.print("==============================\n");
                    
                    //Pieces = removeElement(Pieces, cont);
                    
                    Pieces.add(new Dama(xLinhaDepois, yColunaDepois,'B'));
                    Pieces.remove(i);
                    break;
                }
            }
            
            if(piece.getColor() == 'p'){
                if (piece.getX() == 0) {
                	System.out.print("\n==============================");
                    System.out.print("\n| SUA PECA VIROU DAMA!!      |\n");
                    System.out.print("==============================\n");
                    
                    //Pieces = removeElement(Pieces, cont);
                    
                    Pieces.add(new Dama(xLinhaDepois, yColunaDepois,'P'));
                    Pieces.remove(i);
                    break;
                }
            }
            i++;
        }
    }
    
    public boolean checkDama(ArrayList<Piece> Pieces, int xLinhaAntes, int yColunaAntes) {
    	for(Piece piece : Pieces) {
    		if(piece.getX() == xLinhaAntes && piece.getY() == yColunaAntes && (piece.getColor() == 'P'|| piece.getColor() == 'B')) {
    			return true;
    		}
    	}
    	return false;
    }
    
    public boolean moverDama(ArrayList<Piece> Pieces, int xLinhaAntes, int yColunaAntes, int xLinhaDepois, int yColunaDepois){
    	 for(Piece piece : Pieces){
    		 if (xLinhaAntes == piece.getX() && yColunaAntes == piece.getY()) {
                 if (piece.getColor() == 'B') {
                     for (int i = 0; i < Pieces.size(); i++) {
                         //PROCURA SE TEM UMA PECA NA CASA DE DESTINO
                         if(Pieces.get(i).getX() == xLinhaDepois && Pieces.get(i).getY() == yColunaDepois && (Pieces.get(i).getColor() == 'p' || Pieces.get(i).getColor() == 'P')){
                             if (yColunaAntes < yColunaDepois) { 
//                            	 MOVIMENTA DIREITA EM BAIXO
                            	 if(xLinhaAntes > xLinhaDepois) {
                            		 for (int j = 0; j < Pieces.size(); j++) {
                            			 if (Pieces.get(j).getX() == xLinhaDepois - 1 && Pieces.get(j).getY() == yColunaDepois - 1) {
                            				 System.out.println("| Nao foi possivel jogar!!");
                            				 return false;
                            			 }           
                            		 }                              
                            		 piece.setX(xLinhaDepois - 1 );
                            		 piece.setY(yColunaDepois - 1 );
                            		 Pieces.remove(i);
                            		 return true;                            		 
                            	 } else {
//                            	 MOVIMENTA DIREITA EM CIMA
                            		 for (int j = 0; j < Pieces.size(); j++) {
                            			 if (Pieces.get(j).getX() == xLinhaDepois + 1 && Pieces.get(j).getY() == yColunaDepois - 1) {
                            				 System.out.println("| Nao foi possivel jogar!!");
                            				 return false;
                            			 }
                            		 }
                            		 System.out.println("testes");
                            		 piece.setX(xLinhaDepois + 1 );
                                     piece.setY(yColunaDepois - 1 );
                                     Pieces.remove(i);
                                     return true; 
                            	 }
                             }else if (yColunaAntes > yColunaDepois) {
//                              MOVIMENTA ESQUERDA EM BAIXO
                            	 if(xLinhaAntes > xLinhaDepois) {
	                                 for (int j = 0; j < Pieces.size(); j++) {
	                                     if (Pieces.get(j).getX() == xLinhaDepois + 1 && Pieces.get(j).getY() == yColunaDepois - 1) {
	                                         System.out.println("não foi possivel jogar");
	                                         return false;
	                                     }
	                                 }
	                                 piece.setX(xLinhaDepois - 1 );
	                                 piece.setY(yColunaDepois + 1 );
	                                 Pieces.remove(i);
	                                 return true;
                            	 } else {
//                            	MOVIMENTA ESQUERDA EM CIMA
                            		 for (int j = 0; j < Pieces.size(); j++) {
                            			 if (Pieces.get(j).getX() == xLinhaDepois - 1 && Pieces.get(j).getY() == yColunaDepois - 1) {
                            				 System.out.println("| Nao foi possivel jogar!!");
                            				 return false;
                            			 }
                            		 }
                            		 piece.setX(xLinhaDepois + 1 );
                                     piece.setY(yColunaDepois + 1 );
                                     Pieces.remove(i);
                                     return true;
                            	 }
                             }
                         }                         
                     }
                     System.out.println("testes");
                     piece.setX(xLinhaDepois);
                     piece.setY(yColunaDepois);
                     return true;
                 } 
                 
                 if (piece.getColor() == 'P') {
                     for (int i = 0; i < Pieces.size(); i++) {
                         //PROCURA SE TEM UMA PECA NA CASA DE DESTINO
                         if(Pieces.get(i).getX() == xLinhaDepois && Pieces.get(i).getY() == yColunaDepois && (Pieces.get(i).getColor() == 'b' || Pieces.get(i).getColor() == 'B')){
                             if (yColunaAntes < yColunaDepois) { 
//                            	 MOVIMENTA DIREITA EM BAIXO
                            	 if(xLinhaAntes > xLinhaDepois) {
                            		 for (int j = 0; j < Pieces.size(); j++) {
                            			 if (Pieces.get(j).getX() == xLinhaDepois - 1 && Pieces.get(j).getY() == yColunaDepois - 1) {
                            				 System.out.println("| Nao foi possivel jogar!!");
                            				 return false;
                            			 }           
                            		 }                              
                            		 piece.setX(xLinhaDepois - 1 );
                            		 piece.setY(yColunaDepois - 1 );
                            		 Pieces.remove(i);
                            		 return true;                            		 
                            	 } else {
//                            	 MOVIMENTA DIREITA EM CIMA
                            		 for (int j = 0; j < Pieces.size(); j++) {
                            			 if (Pieces.get(j).getX() == xLinhaDepois + 1 && Pieces.get(j).getY() == yColunaDepois - 1) {
                            				 System.out.println("| Nao foi possivel jogar!!");
                            				 return false;
                            			 }
                            		 }
                            		 System.out.println("testes");
                            		 piece.setX(xLinhaDepois + 1 );
                                     piece.setY(yColunaDepois - 1 );
                                     Pieces.remove(i);
                                     return true; 
                            	 }
                             }else if (yColunaAntes > yColunaDepois) {
//                              MOVIMENTA ESQUERDA EM BAIXO
                            	 if(xLinhaAntes > xLinhaDepois) {
	                                 for (int j = 0; j < Pieces.size(); j++) {
	                                     if (Pieces.get(j).getX() == xLinhaDepois + 1 && Pieces.get(j).getY() == yColunaDepois - 1) {
	                                         System.out.println("não foi possivel jogar");
	                                         return false;
	                                     }
	                                 }
	                                 piece.setX(xLinhaDepois + 1 );
	                                 piece.setY(yColunaDepois - 1 );
	                                 Pieces.remove(i);
	                                 return true;
                            	 } else {
//                            	MOVIMENTA ESQUERDA EM CIMA
                            		 for (int j = 0; j < Pieces.size(); j++) {
                            			 if (Pieces.get(j).getX() == xLinhaDepois - 1 && Pieces.get(j).getY() == yColunaDepois - 1) {
                            				 System.out.println("| Nao foi possivel jogar!!");
                            				 return false;
                            			 }
                            		 }
                            		 piece.setX(xLinhaDepois - 1 );
                                     piece.setY(yColunaDepois - 1 );
                                     Pieces.remove(i);
                                     return true;
                            	 }
                             }
                         }                         
                     }
                     System.out.println("testes");
                     piece.setX(xLinhaDepois);
                     piece.setY(yColunaDepois);
                     return true;
                 } 
             }    		 
    	 }
    	
    	return false;
    }
    
    public boolean win(ArrayList<Piece> Pieces) {
    	int p=0, b=0;
    	for(Piece piece : Pieces){
    		if (piece.getColor() == 'P' || piece.getColor() == 'p') {
    			p++;
    		}
    		if (piece.getColor() == 'b' || piece.getColor() == 'B') {
    			b++;
    		}
    	}
    	if(p != 0 && b == 0) {
    		System.out.print("\n==============================");
            System.out.print("\n| PECAS PRETAS GANHARAM     |\n");
            System.out.print("==============================\n");
    		return true;
    	} else if(b != 0 && p == 0) {
    		System.out.print("\n==============================");
            System.out.print("\n| PECAS BRANCAS GANHARAM    |\n");
            System.out.print("==============================\n");
    		return true;
    	}
    	return false;
    }    
}    
   



    

