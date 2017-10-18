/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import Genetico.Cromossomo;
import java.util.ArrayList;

/**
 *
 * @author Math
 */
public class EspacoSolucao {
    ArrayList<Solucao> espacoSolucao;
    

    public EspacoSolucao() {
        this.espacoSolucao = new ArrayList<>();
    }

    public ArrayList<Solucao> getEspacoSolucao() {
        return espacoSolucao;
    }

//    public void setMelhorSolucao(Solucao melhorSolucao) {
//        this.melhorSolucao = melhorSolucao;
//    }
    
    public void setEspacoSolucao(ArrayList<Solucao> espacoSolucao) {
        this.espacoSolucao = espacoSolucao;
    }
    
    public Solucao getMelhorSolucao(){
        Solucao melhorSolucao = new Solucao(Cromossomo.criaCromossomoAleatorio());
        melhorSolucao.setCusto(100000000);
        for (int i = 0; i < espacoSolucao.size(); i++) {
            if(melhorSolucao.getCusto() > espacoSolucao.get(i).getCusto()){
                melhorSolucao = espacoSolucao.get(i);
            }
        }
        //this.melhorSolucao = melhorSolucao;
        return melhorSolucao;
    }
    
    public Solucao getPiorSolucao(){
        Solucao piorSolucao = espacoSolucao.get(0);
        for (int i = 0; i< espacoSolucao.size();i++) {
            if (piorSolucao.getCusto() <= espacoSolucao.get(i).getCusto()) {
                piorSolucao = espacoSolucao.get(i);
            }
        }
        return piorSolucao;
    }
    
//    public EspacoSolucao get20PctPopulacao(EspacoSolucao espacoSolucao){
//        int reducaoPopulacao = (int) (espacoSolucao.getEspacoSolucao().size()*0.8);
//        for (int i = 0; i < reducaoPopulacao; i++) {
//            espacoSolucao.getEspacoSolucao().remove(espacoSolucao.getPiorSolucao());
//        }
//        return espacoSolucao;
//    }
    
    public EspacoSolucao getPctPopulacao(EspacoSolucao espacoSolucao){
        int reducaoPopulacao = (int) (espacoSolucao.getEspacoSolucao().size()*0.125);
        EspacoSolucao espacoSolucaoNovo = new EspacoSolucao();
        for (int i = 0; i < reducaoPopulacao ; i++) {
            Solucao melhorSolucaoFor = espacoSolucao.getMelhorSolucao();
            espacoSolucaoNovo.getEspacoSolucao().add(melhorSolucaoFor);
            espacoSolucao.getEspacoSolucao().remove(melhorSolucaoFor);
        }
        return espacoSolucaoNovo;
    }
}
