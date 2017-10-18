/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainsTestados;

import Genetico.Cromossomo;
import Genetico.Crossover;
import Genetico.Mutacao;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import model.EspacoSolucao;
import model.Restricao;
import model.Solucao;
import static view.FatoresGeneticos.nGeracoesMax;
import static view.FatoresGeneticos.tamEspacoPopulacaoInicial;

/**
 *
 * @author Math
 */
public class MainBitFlipDouble {
    public static void main(String[] args) throws FileNotFoundException{
        ArrayList<Restricao> listaRestricoes = new ArrayList();
        EspacoSolucao espacoSolucao = new EspacoSolucao();
        
        
        //inicio do programa
        int nGeracoes = 0;
        
        //Inicializa o espaco solucao
            
            for (int i = 0; i < tamEspacoPopulacaoInicial; i++) {
                Solucao solucao = new Solucao(Cromossomo.criaCromossomoAleatorio());
                solucao.setCusto();
                espacoSolucao.getEspacoSolucao().add(solucao);
            }
        
        
        do {
            //mutacao
            for (int i = 0; i < tamEspacoPopulacaoInicial/2; i++) {
                espacoSolucao.getEspacoSolucao().add(Mutacao.BitFlip(espacoSolucao.getEspacoSolucao().get(i)));
            }
            //crossover
            for (int i = tamEspacoPopulacaoInicial/2; i < tamEspacoPopulacaoInicial; i++) {
                espacoSolucao.getEspacoSolucao().add(Crossover.crossoverDouble(espacoSolucao.getEspacoSolucao().get(i-1), espacoSolucao.getEspacoSolucao().get(i)));
            }
//            

            espacoSolucao = espacoSolucao.getPctPopulacao(espacoSolucao);
            System.out.println("Geracao: " + nGeracoes + " MelhorSolucao: " + espacoSolucao.getMelhorSolucao().getCusto());
        nGeracoes++;
        } while (nGeracoes < nGeracoesMax);
            
//        
    }
}
