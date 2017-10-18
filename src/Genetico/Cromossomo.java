/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Genetico;

import java.util.ArrayList;
import java.util.Random;
import model.Pessoa;
import static Leitura.Importacao.listaPessoas;
import static Leitura.Importacao.listaCidades;
import model.Solucao;

/**
 *
 * @author Math
 */
public class Cromossomo {
    
    public static ArrayList criaCromossomoAleatorio(){
        Random num = new Random();
        
        ArrayList<Object> resposta = new ArrayList();
        for(int x=0;x<listaPessoas.size();x++){
            resposta.add(num.nextInt(52));
        }
        return resposta;
    }
    
//    public static ArrayList criaCromossomoAleatorio2(){
//        Random num = new Random();
//        Solucao solucao = new Solucao();
//        for(int i = 0; i< listaPessoas.size(); i++){
//            solucao.getSolucao().add(num.nextInt(listaCidades.size()));
//            solucao.listaTurmas.add(null) .setVetTurmas(vetTurmas[i] = );
//        }
//    }
    
}
