/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import Leitura.Importacao;

import static Leitura.Importacao.listaPessoas;

import java.util.ArrayList;

/**
 *
 * @author Math
 */
public class Solucao {
    ArrayList solucao;
    float custo;
    private int[] vetTurmas;
    private int viabilidade;
    //viabilidade == 0 viavel

    public Solucao() {
        
      
//        this.vetTurmas = new int[Importacao.listaCidadesCT.size()];
        this.solucao = new ArrayList();
    }

    public Solucao(ArrayList solucao) {
      
  //      this.vetTurmas = new int[Importacao.listaCidadesCT.size()];
        this.solucao = solucao;
    }
    public Solucao(Solucao solucao){
      
    //    this.vetTurmas = new int[Importacao.listaCidadesCT.size()];
        this.solucao = (ArrayList) solucao.getSolucao().clone();
        this.custo = solucao.getCusto();
    }

    public ArrayList getSolucao() {
        return solucao;
    }

    public void setSolucao(ArrayList solucao) {
        this.solucao = solucao;
    }

    public float getCusto() {
        return custo;
    }
    
    public void setCusto(int custo) {
        this.custo = custo;
    }
    
    public void setCusto() {
        this.custo = Funcoes.custoResposta(this);
    }

    public int[] getVetTurmas() {
        return vetTurmas;
    }

    public void setVetTurmas(int[] vetTurmas) {
        this.vetTurmas = vetTurmas;
    }

    public int getViabilidade() {
        return viabilidade;
    }

    public void setViabilidade(int viabilidade) {
        this.viabilidade = viabilidade;
    }
 
    
    
    
    /**
     *Conta a quantidade de pessoas em cada CT e retorna um vetor com a quantidade de cada um 
     */
    public void contTurmas(){
        //Cria o vetor da quantidade de alunos por turma
        for (int i = 0; i < listaPessoas.size(); i++) {
            vetTurmas[Integer.parseInt(this.solucao.get(i).toString())]++;    
        }
//        for(int z =0;z < vetTurmas.length; z++){
//            System.out.println("Ct: "+ z +"Quant Pessoas Turma: " + vetTurmas[z]);
//        }
    }
    
    
}
