/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package campominadolive;

//import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author ruhanconceicao
 */
public class JFrameCampo extends JFrame {

    JPanel panel;
    JButtonEspaco[][] matBut;
    Campo c;

    public JFrameCampo(Campo c) {
        this.c = c;
        this.panel = new JPanel();
        panel.setLayout(null);
        this.add(panel);
        matBut = new JButtonEspaco[C.NUM_LINHAS][C.NUM_COLUNAS];

        int n = 0;
        for (int i = 0; i < C.NUM_LINHAS; i++) {
            for (int j = 0; j < C.NUM_COLUNAS; j++) {
                matBut[i][j] = new JButtonEspaco(this.c);
                matBut[i][j].linha = i;
                matBut[i][j].coluna = j;
                matBut[i][j].setSize(30, 30);
                matBut[i][j].setLocation(30 * j, 30 * i);
                //matBut[i][j].setText(Integer.toString(n++));
                panel.add(matBut[i][j]);

            }
        }

        confIniciais();
    }

    private void confIniciais() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(C.NUM_COLUNAS * C.TAM_ESPACO, C.NUM_LINHAS * C.TAM_ESPACO + 300);
        this.setResizable(false);

        this.setVisible(true);
    }

}
