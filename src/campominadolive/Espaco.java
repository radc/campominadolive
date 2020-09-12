/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package campominadolive;

import java.util.ArrayList;

/**
 *
 * @author ruhanconceicao
 */
public class Espaco {

    boolean minado;
    boolean clicado;
    boolean revelado;
    boolean marcado;  

    ArrayList<Espaco> vizinhos;
    
    JButtonEspaco button;

    public Espaco() {
        this.minado = false;
        this.revelado = false;
        this.marcado = false;
        this.clicado = false;

        this.vizinhos = new ArrayList();
    }

    
    public void adicionarVizinhos(Espaco e){
        this.vizinhos.add(e);
    }
    
    //Metodo minar: indica que o espaco tem uma mina
    //Se o espaco ja tem uma mina, ele retorna false
    //Se o espaco nao tinha uma mina antes, retorna verdadeiro    
    public boolean minar() {
        if (!this.minado) {
            this.minado = true;
            return true;
        } else {
            return false;
        }

    }  
    
    public boolean marcar(){
        this.marcado = !this.marcado;
        return this.marcado;
    }   
    
    //-1 clicou numa mina
    //0 nao possui minas nos vizinhos
    //n possui n minas nos vizinhos
    public int clicar(){
        this.clicado = true;
        if(this.minado){
            return -1;
        }
        else{
            return numMinasNosVizinhos();
        }
    }
    
    public int numMinasNosVizinhos(){
        int n = 0;
        for (Espaco vizinho : this.vizinhos) {
            if(vizinho.minado) n++;
        }
        return n;
    }
    
    public void reset(){
        this.minado = false;
        this.revelado = false;
        this.marcado = false;
        this.clicado = false;
    }
    
    public boolean isFinalizado(){
        if(this.minado && this.marcado) return true;
        if(!this.minado && !this.marcado && this.clicado) return true;
        return false;
    }
    
    public void setButton(JButtonEspaco button){
        this.button = button;
    }
    
    

    @Override
    public String toString() {
        if (this.minado)
            return "-1";
        return "+" + this.numMinasNosVizinhos();
    }
    
    
    
}

