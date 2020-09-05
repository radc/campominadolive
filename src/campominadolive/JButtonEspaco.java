/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package campominadolive;

import java.awt.event.ActionEvent;
import javax.swing.JButton;

/**
 *
 * @author ruhanconceicao
 */
public class JButtonEspaco extends JButton {
    int linha;
    int coluna;
    Campo c;
    String text;
    
    public JButtonEspaco(Campo c){
        text = "";
        this.setText(text);
        this.c = c;
        this.addActionListener((java.awt.event.ActionEvent evt) -> {
            botaoPressionado(evt);
        });
    }
    
    private void botaoPressionado(java.awt.event.ActionEvent evt) {                                         
            System.out.println("linha: " + linha + " coluna: " + coluna );
            int ret = c.clicar(linha, coluna);
            this.text = Integer.toString(ret);
            this.setText(text);
            this.setEnabled(false);
    }  
    
    public void setPos(int linha, int coluna){
        this.linha = linha;
        this.coluna = coluna;
    }
    
}
