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
public class CampoMinadoLive {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        //c.adicionarMinas();
        //System.out.println(c);
        
        Campo c = new Campo();
        c.adicionarMinas();
        JFrameCampo f = new JFrameCampo(c);
    }
    
}
