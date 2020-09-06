/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package campominadolive;

import java.util.Random;

/**
 *
 * @author ruhanconceicao
 */
public class Campo {
    Espaco[][] matriz;    
    
    public Campo(){
        matriz = new Espaco[C.NUM_LINHAS][C.NUM_COLUNAS];
        for (int i = 0; i < C.NUM_LINHAS; i++) {
            for (int j = 0; j < C.NUM_COLUNAS; j++) {
                matriz[i][j] = new Espaco();
            }
        }
        
        for (int i = 0; i < C.NUM_LINHAS; i++) {
            for (int j = 0; j < C.NUM_COLUNAS; j++) {
                if (i > 0){
                    if (j > 0) matriz[i][j].adicionarVizinhos(matriz[i-1][j-1]);
                    matriz[i][j].adicionarVizinhos(matriz[i-1][j]);
                    if (j < C.NUM_COLUNAS-1) matriz[i][j].adicionarVizinhos(matriz[i-1][j+1]);
                }
                
                if (j > 0) matriz[i][j].adicionarVizinhos(matriz[i][j-1]);                
                if (j < C.NUM_COLUNAS-1)matriz[i][j].adicionarVizinhos(matriz[i][j+1]);
                
                if(i < C.NUM_LINHAS -1){
                    if (j > 0)matriz[i][j].adicionarVizinhos(matriz[i+1][j-1]);
                    matriz[i][j].adicionarVizinhos(matriz[i+1][j]);
                    if (j < C.NUM_COLUNAS-1)matriz[i][j].adicionarVizinhos(matriz[i+1][j+1]);
                }
            }
        }
        
    }
    
    public void adicionarMinas(){
        int n = C.NUM_MINAS;
        Random rand = new Random();
        while (n > 0){            
            int l = rand.nextInt(C.NUM_LINHAS); 
            int c = rand.nextInt(C.NUM_COLUNAS);             
            if (matriz[l][c].minar()){
                n--;
            }            
        }
        
    }
    
    public int clicar(int linha, int coluna){
        return matriz[linha][coluna].clicar();
    }
    
    public boolean isFinalizado(){        
        for (int i = 0; i < C.NUM_LINHAS; i++) {
            for (int j = 0; j < C.NUM_COLUNAS; j++) {
                if (!matriz[i][j].isFinalizado()) return false;
            }            
        }
        return true;
    }

    @Override
    public String toString() {
        String str = "";
        
        for (int i = 0; i < C.NUM_LINHAS; i++) {
            for (int j = 0; j < C.NUM_COLUNAS; j++) {
                str += matriz[i][j] + " ";
            }
            str += "\n";
        }
        return str;        
    }
    
    
    
    
    
}
