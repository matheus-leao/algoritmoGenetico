/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Math
 */
public class Restricao {
    
    
    String nome;
    int cont;

    public Restricao() {
    }

    public Restricao(String nome) {
        this.nome = nome;
    }
    
    public Restricao(String nome, int cont) {
        this.nome = nome;
        this.cont = cont;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCont() {
        return cont;
    }

    public void setCont(int cont) {
        this.cont = cont;
    }
    
    
}
