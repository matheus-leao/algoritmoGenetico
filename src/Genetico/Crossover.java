/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Genetico;


import model.Solucao;

/**
 *
 * @author Math
 */
public class Crossover {

    public Crossover() {
    }
    
    public static Solucao crossoverSingle(Solucao solucao1, Solucao solucao2){
        Solucao nova = new Solucao();
        
        if (solucao1.getSolucao().size() == solucao2.getSolucao().size()){
            for (int i = 0; i < (solucao1.getSolucao().size()/2); i++) {
                nova.getSolucao().add(solucao1.getSolucao().get(i));
                
            }
            for (int i = (solucao1.getSolucao().size()/2); i < (solucao2.getSolucao().size()); i++) {
                nova.getSolucao().add(solucao2.getSolucao().get(i));
            }
        }
        nova.setCusto();
        return nova;
    }
    
    public static Solucao crossoverDouble(Solucao solucao1, Solucao solucao2){
        Solucao nova = new Solucao();
        if (solucao1.getSolucao().size() == solucao2.getSolucao().size()){
            //499
            for (int i = 0; i < (solucao1.getSolucao().size()/4); i++) {
                nova.getSolucao().add(solucao1.getSolucao().get(i));
            }
            //999
            for (int i = (solucao1.getSolucao().size()/4); i < (solucao2.getSolucao().size()/2); i++) {
                nova.getSolucao().add(solucao2.getSolucao().get(i));
            }
            //1497
            for (int i = (solucao1.getSolucao().size()/2); i < (3*(solucao2.getSolucao().size()/4)); i++) {
                nova.getSolucao().add(solucao1.getSolucao().get(i));
            }
            for (int i = (3*(solucao2.getSolucao().size()/4)); i < (solucao2.getSolucao().size()); i++) {
                nova.getSolucao().add(solucao2.getSolucao().get(i));
            }
        }
        nova.setCusto();
        return nova;
    }
    
    public static Solucao crossoverShuffle(Solucao solucao1, Solucao solucao2){
        Solucao nova = new Solucao();
        
         if (solucao1.getSolucao().size() == solucao2.getSolucao().size()){
            for (int i = 0; i < (solucao1.getSolucao().size()); i++) {
                if(i%2==0){
                    nova.getSolucao().add(solucao1.getSolucao().get(i));
                }else{
                    nova.getSolucao().add(solucao2.getSolucao().get(i));
                }    
            }
        }
         nova.setCusto();
        return nova;
    }
}
