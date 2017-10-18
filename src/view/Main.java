/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import model.Solucao;
import Genetico.Cromossomo;
import Genetico.Crossover;
import Genetico.Mutacao;
import Leitura.Impressao;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import static java.time.Instant.now;
import static java.time.LocalDate.now;
import static java.time.LocalDateTime.now;
import java.util.Date;
import model.EspacoSolucao;
import model.Restricao;
import oracle.jrockit.jfr.events.ContentTypeImpl;
import static view.FatoresGeneticos.horaInicio;
import static view.FatoresGeneticos.nGeracoesMax;
import static view.FatoresGeneticos.tamEspacoPopulacaoInicial;


/**
 *
 * @author Math
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */

    public static void main(String[] args) throws FileNotFoundException, IOException{
        
        EspacoSolucao espacoSolucao = new EspacoSolucao();
        
        horaInicio = System.currentTimeMillis();
        String nomeArquivo = "Teste" + horaInicio;
        File arq = new File(nomeArquivo+".txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(arq));  
        
        String cabecalho = "";
        cabecalho = "Geracoes: " + nGeracoesMax + "\n";
        cabecalho += "Tamanho populacao" + tamEspacoPopulacaoInicial + "\n";
        cabecalho += "Hora de inicio: " + horaInicio + "\n";
        
        writer.write(cabecalho);
        writer.newLine();
        
        //inicio do programa
        int nGeracoes = 0;
        
        //resposta Alexandre
        Solucao solucao3 = new Solucao();
        int[] respostaAlexandre = {43, 39, 32, 19, 30, 44, 0, 19, 0, 0, 19, 0, 0, 0, 19, 18, 0, 19, 31, 31, 0, 0, 40, 19, 20, 0, 17, 0, 0, 0, 0, 0, 47, 31, 16, 2, 2, 39, 0, 19, 0, 0, 44, 16, 0, 19, 40, 0, 35, 35, 35, 39, 15, 40, 0, 14, 29, 12, 19, 31, 17, 20, 39, 43, 51, 29, 2, 0, 0, 6, 33, 0, 0, 51, 27, 34, 0, 0, 19, 0, 20, 40, 0, 40, 19, 19, 4, 4, 4, 40, 31, 0, 39, 9, 20, 0, 19, 39, 39, 31, 46, 12, 6, 6, 0, 14, 0, 32, 0, 0, 14, 0, 0, 18, 16, 39, 19, 0, 0, 51, 16, 0, 27, 0, 20, 39, 0, 0, 27, 31, 31, 38, 0, 31, 9, 35, 0, 0, 0, 19, 0, 31, 40, 29, 0, 16, 40, 51, 19, 0, 38, 0, 19, 17, 40, 47, 0, 40, 45, 39, 10, 40, 0, 0, 0, 0, 39, 0, 51, 46, 13, 0, 0, 19, 19, 19, 19, 0, 0, 0, 20, 20, 13, 0, 16, 0, 0, 0, 0, 46, 0, 0, 0, 0, 40, 0, 19, 0, 6, 4, 10, 0, 0, 39, 9, 29, 39, 0, 0, 4, 16, 0, 0, 0, 46, 6, 16, 6, 31, 0, 4, 31, 27, 39, 0, 0, 38, 0, 0, 0, 7, 0, 19, 10, 0, 0, 39, 46, 9, 0, 19, 0, 19, 0, 0, 0, 0, 0, 0, 16, 0, 0, 31, 38, 39, 0, 13, 19, 0, 0, 0, 0, 33, 34, 0, 0, 0, 39, 0, 0, 0, 0, 0, 27, 0, 31, 29, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 40, 19, 0, 29, 40, 0, 0, 0, 7, 0, 0, 0, 20, 0, 0, 0, 0, 0, 0, 0, 0, 7, 0, 0, 0, 0, 20, 0, 39, 0, 0, 0, 0, 0, 44, 0, 40, 0, 39, 47, 39, 46, 13, 39, 18, 31, 0, 14, 0, 19, 39, 19, 9, 20, 35, 0, 5, 0, 4, 0, 0, 9, 0, 46, 0, 0, 0, 29, 0, 0, 11, 0, 0, 0, 0, 0, 19, 19, 19, 19, 19, 19, 19, 19, 19, 0, 0, 0, 0, 0, 2, 13, 19, 0, 40, 31, 44, 14, 0, 0, 39, 40, 0, 34, 16, 31, 0, 0, 0, 35, 11, 0, 0, 32, 0, 29, 0, 0, 0, 9, 0, 12, 47, 7, 45, 29, 0, 32, 20, 9, 0, 19, 0, 4, 31, 33, 46, 0, 32, 39, 0, 35, 0, 46, 0, 27, 15, 7, 33, 34, 0, 27, 19, 3, 31, 29, 29, 0, 0, 29, 3, 0, 0, 0, 0, 0, 0, 34, 12, 0, 0, 0, 0, 19, 0, 0, 0, 0, 0, 19, 0, 0, 0, 3, 11, 31, 0, 6, 18, 20, 39, 40, 13, 20, 31, 19, 0, 0, 13, 39, 0, 27, 0, 0, 13, 0, 10, 30, 19, 35, 35, 0, 0, 0, 39, 0, 30, 0, 0, 39, 13, 38, 0, 40, 39, 20, 0, 15, 31, 44, 0, 31, 11, 0, 0, 19, 39, 50, 19, 39, 3, 6, 16, 0, 0, 43, 0, 11, 39, 0, 0, 0, 0, 15, 0, 44, 0, 0, 0, 0, 31, 31, 32, 40, 20, 31, 0, 3, 0, 31, 0, 0, 0, 0, 4, 0, 2, 6, 0, 0, 0, 0, 16, 0, 20, 19, 39, 0, 19, 28, 40, 3, 19, 2, 0, 40, 39, 0, 40, 18, 35, 3, 40, 29, 17, 31, 20, 27, 0, 0, 0, 28, 39, 0, 39, 0, 39, 20, 0, 5, 0, 27, 18, 0, 0, 19, 19, 0, 0, 0, 0, 19, 0, 0, 0, 12, 31, 0, 19, 40, 0, 19, 0, 0, 0, 3, 46, 0, 29, 7, 38, 20, 14, 0, 0, 19, 19, 2, 19, 39, 28, 14, 0, 19, 19, 0, 31, 40, 0, 5, 13, 0, 35, 4, 38, 0, 46, 0, 50, 0, 0, 12, 14, 0, 6, 18, 39, 40, 19, 13, 31, 0, 47, 7, 3, 50, 0, 0, 0, 0, 19, 0, 0, 16, 40, 1, 10, 6, 0, 28, 10, 38, 34, 0, 19, 0, 0, 19, 40, 29, 5, 0, 12, 19, 19, 0, 0, 31, 10, 1, 12, 31, 0, 4, 32, 0, 0, 0, 0, 0, 0, 0, 29, 20, 0, 11, 39, 0, 0, 27, 0, 20, 20, 40, 43, 35, 39, 7, 20, 29, 0, 2, 18, 12, 19, 38, 20, 11, 51, 0, 4, 40, 1, 2, 0, 47, 1, 39, 4, 27, 19, 0, 39, 0, 20, 0, 0, 0, 31, 0, 0, 10, 20, 40, 0, 9, 12, 1, 0, 3, 0, 4, 40, 27, 30, 0, 11, 32, 0, 12, 19, 29, 31, 0, 0, 0, 0, 20, 20, 20, 0, 31, 45, 0, 0, 15, 40, 0, 19, 0, 0, 31, 40, 7, 0, 29, 30, 0, 0, 4, 4, 13, 0, 30, 0, 0, 19, 19, 20, 20, 0, 35, 38, 6, 9, 43, 10, 6, 0, 31, 0, 0, 0, 31, 18, 0, 0, 45, 0, 0, 0, 0, 50, 0, 13, 19, 0, 20, 19, 32, 0, 29, 0, 0, 40, 9, 32, 13, 47, 19, 32, 0, 0, 33, 30, 38, 43, 0, 0, 13, 43, 0, 6, 0, 0, 19, 0, 33, 43, 0, 0, 0, 12, 39, 0, 19, 7, 31, 40, 0, 5, 39, 31, 31, 31, 0, 31, 31, 31, 0, 29, 0, 20, 0, 0, 0, 11, 0, 0, 31, 31, 1, 0, 17, 15, 0, 4, 15, 29, 0, 0, 0, 0, 17, 30, 0, 0, 46, 0, 38, 0, 0, 43, 31, 0, 0, 16, 4, 0, 34, 16, 0, 46, 0, 40, 0, 0, 0, 19, 33, 19, 0, 39, 0, 35, 1, 44, 19, 19, 0, 0, 0, 9, 12, 0, 12, 43, 40, 50, 17, 43, 6, 0, 0, 0, 28, 19, 0, 0, 0, 0, 0, 7, 0, 2, 47, 31, 7, 0, 0, 0, 39, 47, 0, 0, 11, 0, 28, 0, 43, 0, 0, 19, 0, 0, 19, 19, 40, 0, 0, 0, 9, 46, 0, 40, 0, 0, 0, 0, 0, 0, 19, 0, 0, 0, 20, 0, 43, 40, 0, 0, 0, 33, 1, 0, 19, 0, 0, 40, 0, 19, 0, 0, 0, 0, 0, 19, 30, 31, 31, 0, 0, 0, 19, 0, 0, 0, 29, 29, 31, 32, 0, 20, 20, 20, 47, 31, 0, 0, 0, 12, 0, 1, 0, 38, 17, 0, 19, 45, 30, 0, 39, 40, 50, 45, 0, 0, 0, 0, 0, 0, 19, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 31, 0, 19, 0, 19, 0, 0, 0, 17, 33, 14, 0, 19, 0, 5, 19, 19, 19, 0, 32, 29, 13, 19, 5, 10, 19, 0, 0, 29, 0, 0, 0, 20, 0, 0, 40, 0, 0, 0, 0, 0, 14, 0, 27, 0, 50, 4, 33, 0, 14, 0, 3, 7, 0, 29, 4, 31, 7, 40, 29, 40, 18, 5, 0, 0, 0, 31, 38, 0, 2, 9, 14, 0, 40, 18, 40, 0, 15, 19, 19, 0, 0, 0, 0, 0, 0, 0, 0, 0, 40, 0, 0, 0, 0, 0, 0, 0, 18, 40, 0, 3, 16, 14, 0, 5, 12, 43, 0, 0, 0, 0, 10, 30, 10, 0, 3, 20, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 45, 0, 20, 43, 0, 0, 0, 0, 0, 0, 0, 5, 47, 0, 0, 0, 12, 0, 0, 0, 0, 19, 0, 19, 19, 0, 31, 29, 19, 19, 0, 43, 1, 19, 38, 47, 44, 4, 0, 0, 0, 40, 0, 12, 0, 19, 18, 19, 40, 29, 0, 0, 0, 0, 0, 0, 40, 5, 0, 19, 40, 40, 20, 19, 19, 0, 0, 0, 19, 0, 0, 4, 0, 4, 4, 0, 0, 19, 0, 0, 0, 0, 0, 0, 0, 0, 39, 0, 31, 0, 0, 0, 20, 0, 0, 0, 0, 51, 0, 0, 14, 0, 0, 29, 20, 0, 0, 0, 29, 47, 30, 10, 0, 0, 0, 39, 0, 0, 19, 19, 20, 4, 31, 15, 15, 0, 35, 13, 11, 40, 38, 31, 0, 10, 2, 0, 20, 0, 39, 0, 5, 0, 18, 0, 6, 20, 15, 0, 0, 39, 31, 20, 0, 39, 0, 0, 0, 4, 16, 40, 7, 35, 19, 0, 0, 50, 0, 0, 4, 19, 28, 47, 46, 0, 0, 19, 0, 0, 0, 0, 0, 17, 0, 0, 0, 0, 0, 0, 0, 19, 0, 0, 0, 17, 13, 40, 0, 19, 0, 0, 0, 17, 0, 4, 0, 0, 0, 39, 0, 19, 0, 4, 4, 27, 0, 0, 31, 0, 31, 0, 19, 0, 33, 35, 9, 2, 30, 0, 0, 0, 0, 0, 40, 0, 0, 0, 0, 0, 2, 19, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 0, 40, 0, 0, 0, 0, 0, 0, 19, 0, 20, 0, 19, 19, 0, 9, 2, 34, 3, 1, 31, 31, 39, 35, 5, 6, 39, 7, 3, 4, 3, 1, 4, 2, 31, 29, 0, 0, 4, 0, 39, 0, 0, 0, 11, 0, 19, 10, 19, 0, 15, 0, 19, 19, 31, 0, 0, 0, 2, 0, 15, 15, 15, 0, 0, 43, 14, 0, 0, 0, 0, 45, 39, 51, 0, 0, 0, 43, 0, 46, 0, 0, 14, 45, 31, 4, 6, 0, 0, 19, 0, 0, 10, 43, 0, 20, 19, 33, 6, 0, 0, 0, 0, 29, 18, 31, 0, 0, 0, 17, 39, 19, 11, 0, 0, 0, 0, 28, 0, 0, 20, 19, 32, 0, 38, 0, 0, 0, 0, 32, 19, 0, 33, 0, 0, 39, 0, 15, 17, 34, 0, 4, 0, 1, 0, 18, 31, 0, 20, 0, 30, 0, 0, 15, 0, 31, 51, 4, 0, 0, 27, 30, 0, 0, 10, 3, 14, 19, 28, 0, 0, 0, 0, 31, 17, 0, 0, 0, 20, 0, 19, 5, 20, 14, 20, 0, 0, 19, 7, 0, 34, 5, 0, 9, 40, 39, 0, 0, 0, 0, 0, 40, 0, 20, 0, 0, 40, 0, 0, 0, 0, 0, 40, 0, 0, 19, 4, 0, 0, 13, 0, 16, 0, 19, 0, 15, 33, 0, 45, 40, 5, 31, 0, 39, 45, 18, 1, 0, 39, 0, 0, 0, 5, 10, 0, 29, 3, 0, 31, 51, 31, 19, 0, 27, 0, 3, 1, 31, 0, 0, 0, 0, 0, 29, 0, 39, 46, 20, 45, 40, 0, 0, 0, 0, 0, 4, 0, 4, 0, 0, 0, 0, 0, 0, 50, 0, 33, 0, 12, 0, 0, 0, 39, 0, 33, 19, 44, 5, 0, 0, 0, 0, 10, 0, 0, 29, 31, 18, 0, 19, 38, 9, 0, 19, 39, 1, 0, 0, 0, 0, 0, 20, 0, 0, 6, 0, 0, 0, 0, 0, 0, 14, 0, 19, 19, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 44, 4, 40, 0, 31, 7, 0, 10, 0, 39, 32, 0, 27, 1, 0, 0, 0, 0, 0, 0, 0, 20, 0, 13, 38, 0, 19, 40, 20, 19, 17, 19, 9, 0, 19, 0, 11, 29, 39, 19, 0, 0, 17, 11, 40, 40, 0, 15, 40, 12, 0, 0, 0, 0, 0, 44, 28, 39, 0, 0, 17, 0, 0, 31, 0, 0, 18, 0, 14, 0, 0, 0, 0, 27, 0, 0, 0, 0, 0, 0, 0, 0, 40, 0, 0, 0, 0, 0, 0, 16, 0, 0, 1, 33, 16, 0, 40, 0, 0, 20, 0, 0, 0, 39, 46, 0, 29, 19, 30, 19, 0, 32, 0, 0, 0, 19, 50, 0, 32, 7, 27, 29, 0, 0, 0, 17, 0, 9, 5, 11, 45, 0, 19, 35, 19, 19, 0, 32, 0, 32, 0, 19, 0};
//        System.out.println(respostaAlexandre.length);
        for (int i = 0; i < respostaAlexandre.length; i++) {
            solucao3.getSolucao().add(respostaAlexandre[(i)]);
        }
        solucao3.setCusto();
        System.out.println("Solucao Alexandre: "+solucao3.getCusto());
        //Inicializa o espaco solucao
            
            for (int i = 0; i < tamEspacoPopulacaoInicial; i++) {
                Solucao solucao = new Solucao(Cromossomo.criaCromossomoAleatorio());
                solucao.setCusto();
                espacoSolucao.getEspacoSolucao().add(solucao);
            }
        
        
        do {
            
                
            for (int i = 0; i < tamEspacoPopulacaoInicial; i++) {
                Mutacao mutacao = new Mutacao();
                mutacao.setQuantNumSeraoAlterados(Mutacao.pctOcorrerMutacao(nGeracoes));
                espacoSolucao.getEspacoSolucao().add(mutacao.Random(espacoSolucao.getEspacoSolucao().get(i)));
                //espacoSolucao.getEspacoSolucao().add(Mutacao.fecharCT(espacoSolucao.getEspacoSolucao().get(i)));
                espacoSolucao.getEspacoSolucao().add(Mutacao.BitFlip(espacoSolucao.getEspacoSolucao().get(i)));
                espacoSolucao.getEspacoSolucao().add(Mutacao.DoubleFlip(espacoSolucao.getEspacoSolucao().get(i)));
                //espacoSolucao.getEspacoSolucao().add(Mutacao.fecharCTMenosPessoas(espacoSolucao.getEspacoSolucao().get(i)));
            }
  //          }
            
            //crossover
            for (int i = 1; i < tamEspacoPopulacaoInicial; i++) {
                espacoSolucao.getEspacoSolucao().add(Crossover.crossoverSingle(espacoSolucao.getEspacoSolucao().get(i-1), espacoSolucao.getEspacoSolucao().get(i)));
                espacoSolucao.getEspacoSolucao().add(Crossover.crossoverDouble(espacoSolucao.getEspacoSolucao().get(i-1), espacoSolucao.getEspacoSolucao().get(i)));
                espacoSolucao.getEspacoSolucao().add(Crossover.crossoverShuffle(espacoSolucao.getEspacoSolucao().get(i-1), espacoSolucao.getEspacoSolucao().get(i)));
            } 
            
            espacoSolucao = espacoSolucao.getPctPopulacao(espacoSolucao);
            String impressao = "Geracao: " + nGeracoes + " MelhorSolucao: " + espacoSolucao.getMelhorSolucao().getCusto();
            System.out.println(impressao);
        nGeracoes++;
        if(nGeracoes % 100 == 0){
            writer.newLine();
            writer.write(impressao);
            writer.flush();
        }
        
        } while (nGeracoes < nGeracoesMax);
            
        Impressao.rodapeArqTexto();
        writer.close();
    }
}

