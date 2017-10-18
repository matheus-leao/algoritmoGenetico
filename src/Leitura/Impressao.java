/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Leitura;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Time;
import java.util.ArrayList;
import model.CidadeCT;
import model.Pessoa;
import model.Restricao;
import model.Solucao;
import static view.FatoresGeneticos.nGeracoesMax;
import static view.FatoresGeneticos.tamEspacoPopulacaoInicial;
import static view.FatoresGeneticos.horaInicio;
import static view.FatoresGeneticos.horaFim;
/**
 *
 * @author Math
 */
public class Impressao {
    
        
        public static void imprimirListaPessoas(ArrayList<Pessoa> lista) {

        for (int i = 1; i <= lista.size(); i++) {
            System.out.println("Id = " + lista.get(i).getId());
            System.out.println("Nome = " + lista.get(i).getNome());
            System.out.println("Area = " + lista.get(i).getArea());
            System.out.println("SubArea = " + lista.get(i).getSubArea());
            System.out.println("Municipio = " + lista.get(i).getMunicipio());
            System.out.println("MunicipioId = " + lista.get(i).getMunicipioId());
            System.out.println("Estado = " + lista.get(i).getEstado());
            System.out.println("EstadoId = " + lista.get(i).getEstadoId());
            System.out.println("Nivel = " + lista.get(i).getNivel());
            System.out.println("\n");
        }
    }

    public static void imprimirListaCidades(ArrayList<CidadeCT> lista) {
        for (int i = 1; i <= lista.size(); i++) {
            System.out.println("Id = " + lista.get(i).getId());
            System.out.println("Nome = " + lista.get(i).getNome());
            System.out.println("Area = " + lista.get(i).getCusto());
        }
    }
    
    public static void imprimirSolucao(Solucao solucao){
        for (int i = 0; i < solucao.getSolucao().size(); i++) {
            System.out.println(i+"  "+ solucao.getSolucao().get(i));
        }
    }
    
    public static void imprimirRestricoes(ArrayList<Restricao> listaRestricoes) {
        for (int i = 1; i <= listaRestricoes.size(); i++) {
            System.out.println("Nome = " + listaRestricoes.get(i).getNome() + " Quantidade: " + listaRestricoes.get(i).getCont());
        }
    }

//    public static File criaArqTexto(String nomeArquivo){
//        
//        return arq;
//    }
    
//    public static void cabecalhoArqTexto(File arq) throws IOException{
//        BufferedWriter writer = new BufferedWriter(new FileWriter(arq));
//        horaInicio = System.currentTimeMillis();
//        String cabecalho = "";
//        cabecalho = "Geracoes: " + nGeracoesMax + "\n";
//        cabecalho += "Tamanho populacao" + tamEspacoPopulacaoInicial + "\n";
//        cabecalho += "Hora de inicio: " + horaInicio + "\n";
//        
//        //FileWriter escrever = new FileWriter(arq);
//        
//        writer.newLine();
//        writer.write(cabecalho);
//        
//    }
    
    public static void rodapeArqTexto(){
        String rodape = "";
        horaFim = System.currentTimeMillis();
        rodape = "Horario de termino: " + horaFim + "\n";
    }
}
