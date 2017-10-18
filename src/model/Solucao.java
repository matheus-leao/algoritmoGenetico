/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import Leitura.Importacao;
import static Leitura.Importacao.listaCidades;
import static Leitura.Importacao.listaPessoas;
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import java.util.ArrayList;
import model.Funcoes;
import model.Turma;

/**
 *
 * @author Math
 */
public class Solucao {
    ArrayList solucao;
    float custo;
    private int[] vetTurmas;

    public Solucao() {
        
      
        this.vetTurmas = new int[Importacao.listaCidades.size()];
        this.solucao = new ArrayList();
    }

    public Solucao(ArrayList solucao) {
      
        this.vetTurmas = new int[Importacao.listaCidades.size()];
        this.solucao = solucao;
    }
    public Solucao(Solucao solucao){
      
        this.vetTurmas = new int[Importacao.listaCidades.size()];
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

//    public static void inicializaListaTurmas(){
//        Turma turma;
//        for(int i = 0; i < listaCidades.size(); i++){
//            turma = new Turma();
//            turma.setId(i);
//            turma.setCidade(listaCidades.get(i));
//            for(int j=0; j< solucao.getSolucao().size(); i++){
//                ArrayList vetor;
//                if((int)solucao.getSolucao().get(j) == i){
//                    turma.getVetAlunos().add(listaPessoas.get(j));
//                }
//            }
//            
//        }
//        listaTurmas.add(turma);
//    }
    
    public void setCusto(float custo) {
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
    
//    public int turmaComMenosPessoas(){
//        contTurmas();
//        int turmaComMenosPessoas = vetTurmas[0];
//        for (int i = 1; i < vetTurmas.length; i++) {
//            if(turmaComMenosPessoas > vetTurmas[i]){
//                turmaComMenosPessoas = vetTurmas[i];
//            }
//        }
//        return turmaComMenosPessoas;
//    }
    
//    public ArrayList DezTurmasComMenosPessoas(){
//        contTurmas();
//        ArrayList dezTurmasComMenosPessoas = new ArrayList();
//        
//        for(int j = 0; j < 10; j++){
//            int turmaComMenosPessoas = vetTurmas[0];
//            int posicaoTurmaComMenosPessoas = 0;
//            for (int i = 1; i < vetTurmas.length; i++) {
//                if(turmaComMenosPessoas > vetTurmas[i]){
//                    turmaComMenosPessoas = vetTurmas[i];
//                    posicaoTurmaComMenosPessoas = i;
//                }
//                
//            }
//            
//            dezTurmasComMenosPessoas.add(posicaoTurmaComMenosPessoas);
//            vetTurmas[posicaoTurmaComMenosPessoas] = 1000;
//        }
//        return dezTurmasComMenosPessoas;
//    }
    
    
}
