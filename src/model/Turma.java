/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import model.CidadeCT;

/**
 *
 * @author Math
 */
public class Turma {
    int id;
    CidadeCT cidade;
    ArrayList<Pessoa> vetAlunos = new ArrayList();

    public Turma() {
    }

    public Turma(int id, CidadeCT cidade) {
        this.id = id;
        this.cidade = cidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CidadeCT getCidade() {
        return cidade;
    }

    public void setCidade(CidadeCT cidade) {
        this.cidade = cidade;
    }

    public ArrayList<Pessoa> getVetAlunos() {
        return vetAlunos;
    }

    public void setVetAlunos(ArrayList<Pessoa> vetAlunos) {
        this.vetAlunos = vetAlunos;
    }
    
    
}
