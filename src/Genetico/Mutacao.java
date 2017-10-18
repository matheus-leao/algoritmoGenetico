/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Genetico;

import static Leitura.Importacao.listaCidades;
import static Leitura.Importacao.listaPessoas;
import java.util.ArrayList;
import java.util.Random;
import model.Solucao;
import static view.FatoresGeneticos.nGeracoesMax;

/**
 *
 * @author Math
 */
public class Mutacao {

    public float quantNumSeraoAlterados = 0;

    public float getQuantNumSeraoAlterados() {
        return quantNumSeraoAlterados;
    }

    public void setQuantNumSeraoAlterados(float quantNumSeraoAlterados) {
        this.quantNumSeraoAlterados = quantNumSeraoAlterados;
    }

    public void setQuantNumSeraoAlterados(int quantNumSeraoAlterados) {
        this.quantNumSeraoAlterados = quantNumSeraoAlterados;
    }

    public static int pctOcorrerMutacao(int nGeracoes) {
        int possibilidadeOcorrer = (int) (5 + (70 - (70 / nGeracoesMax) * nGeracoes));
        return possibilidadeOcorrer;
    }

    public static int OcorreMutacao() {
        Random num = new Random();
        return num.nextInt(100);
    }

    public Solucao Random(Solucao solucao) {
        Solucao novaSolucao = new Solucao(solucao);
        Random numCt = new Random();
        for (int x = 0; x < (quantNumSeraoAlterados / 100) * listaPessoas.size(); x++) {
            novaSolucao.getSolucao().set((numCt.nextInt(listaPessoas.size())), numCt.nextInt(listaCidades.size()));
        }
        novaSolucao.setCusto();
        return novaSolucao;
    }

    public static Solucao BitFlip(Solucao solucao) {
        Solucao novaSolucao = new Solucao(solucao);
        Random numCt = new Random();
        novaSolucao.getSolucao().set((numCt.nextInt(listaPessoas.size())), numCt.nextInt(listaCidades.size()));
        novaSolucao.setCusto();
        return novaSolucao;
    }

    public static Solucao DoubleFlip(Solucao solucao) {
        Solucao novaSolucao = new Solucao(solucao);
        Random numCt = new Random();
        for (int x = 0; x < 2; x++) {
            novaSolucao.getSolucao().set((numCt.nextInt(listaPessoas.size())), numCt.nextInt(listaCidades.size()));
        }
        novaSolucao.setCusto();
        return novaSolucao;
    }

    public static Solucao fecharCT(Solucao solucao) {
        Solucao novaSolucao = new Solucao(solucao);
        Random numCt = new Random();
        int ctFechado = numCt.nextInt(listaCidades.size());
        for (int x = 0; x < solucao.getSolucao().size(); x++) {
            if (solucao.getSolucao().get(x).equals(ctFechado)) {
                do {
                    novaSolucao.getSolucao().set(x, numCt.nextInt(listaCidades.size()));
                } while (numCt.nextInt(listaCidades.size()) == ctFechado);
            }
        }
        novaSolucao.setCusto();
        return novaSolucao;
    }
}
//    public static Solucao fecharCTMenosPessoas(Solucao solucao) {
//        Solucao novaSolucao = new Solucao(solucao);
//        Random numCt = new Random();
//        int ctFechado = novaSolucao.turmaComMenosPessoas();
//        for (int x = 0; x < solucao.getSolucao().size(); x++) {
//            if (solucao.getSolucao().get(x).equals(ctFechado)) {
//                do {
//                    novaSolucao.getSolucao().set(x, numCt.nextInt(listaCidades.size()));
//                } while (numCt.nextInt(listaCidades.size()) == ctFechado);
//            }
//        }
//        novaSolucao.setCusto();
//        return novaSolucao;
//    }
    
//    public static Solucao fecharCTeColocarEmoutro(Solucao solucao, int ctFechado, int praQualCtVai) {
//        Solucao novaSolucao = new Solucao(solucao);
//        for (int x = 0; x < solucao.getSolucao().size(); x++) {
//            if (solucao.getSolucao().get(x).equals(ctFechado)) {
//                    novaSolucao.getSolucao().set(x, praQualCtVai);
//            }
//        }
//        novaSolucao.setCusto();
//        return novaSolucao;
//    }
//    
//    public static Solucao mudarDezTurmasComMenosPessoas(Solucao solucao){
//        Solucao novaSolucao = solucao;
//        ArrayList turmasMenosPessoas = novaSolucao.DezTurmasComMenosPessoas();
//        for (int i = turmasMenosPessoas.size()/2; i < turmasMenosPessoas.size(); i++) {
//            //fecharCTeColocarEmoutro(Solucao solucao, int ctFechado, int praQualCtVai)
//            novaSolucao = fecharCTeColocarEmoutro(novaSolucao, (int)turmasMenosPessoas.get(i-turmasMenosPessoas.size()/2), (int)turmasMenosPessoas.get(i));
//            //novaSolucao = fecharCTeColocarEmoutro(novaSolucao, Integer.parseInt(turmasMenosPessoas.get(i).toString()), Integer.parseInt(turmasMenosPessoas.get((i+4)).toString()));
//        }    
//        return novaSolucao;
//    }
//}
