/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import java.util.ArrayList;
import Leitura.Importacao;
import static Leitura.Importacao.listaCidades;
import static Leitura.Importacao.listaPessoas;
import model.Turma;


/**
 *
 * @author Math
 */
public class Funcoes {
    
    public static ArrayList calculaRestricoes(Solucao solucao){
        ArrayList<Restricao> listaRestricoes = new ArrayList();    
        Restricao restricao = null;
        
        for(int i = 0; i < solucao.getSolucao().size(); i++){
            int contRestricao = 0;    
            String key = listaPessoas.get(i).getSubArea()  + listaCidades.get((int)solucao.getSolucao().get(i)).getId();
            //string com a subArea da pessoa e o id da Cidade
            
            for(int j = i + 1; j < solucao.getSolucao().size();j++){
                String key2 = listaPessoas.get(j).getSubArea()  + listaCidades.get((int)solucao.getSolucao().get(j)).getId();
            
                if(key.equals(key2)){
                    contRestricao++;
                }
            }
            
            if(contRestricao > 1){
                restricao = new Restricao(key, contRestricao);
                System.out.println();
                listaRestricoes.add(restricao);
            }
            
        }
        return listaRestricoes;
    }
    
    
    public static float custoResposta(Solucao solucao) {
        float custoTotal;
        float custoDeslocamento = 1000;

        float custosFixos =0;
        float custosVariaveis = 0;
        
        float custoHospedagem = 900;
        
        float custoCTDia = 2000;
        float numeroDias = 3;
        
        float coffeBreak = 35 * numeroDias;
        ArrayList<Turma> listaTurmas = new ArrayList();
        
        Turma turma;
        for(int i = 0; i < listaCidades.size(); i++){
            turma = new Turma();
            turma.setId(i);
            turma.setCidade(listaCidades.get(i));
            for(int j=0; j< solucao.getSolucao().size(); j++){
                ArrayList vetor;
                if((int)solucao.getSolucao().get(j) == i){
                    turma.getVetAlunos().add(listaPessoas.get(j));
                }
            }
            listaTurmas.add(turma);
        }
        int viabilidade = 0;
        String subAreaCliente = "", idCidadeCliente = "";
        for(int i = 0; i < listaTurmas.size();i++){//percorrer listaTurmas
                
                for(int j=0; j < listaTurmas.get(i).getVetAlunos().size(); j++){//percorrer a lista Alunos por Turmas
                subAreaCliente = listaTurmas.get(i).getVetAlunos().get(j).getSubArea();
                idCidadeCliente = listaTurmas.get(i).getVetAlunos().get(j).getMunicipioId();
                int cont = 0;
                    for(int x = (j+1); x < listaTurmas.get(i).getVetAlunos().size(); x++){
                        if(subAreaCliente.equals(listaTurmas.get(i).getVetAlunos().get(x).getSubArea()) && idCidadeCliente.equals(listaTurmas.get(i).getVetAlunos().get(x).getMunicipioId())){
                            cont++;
                        }
                    }
                if(cont > Math.ceil(listaTurmas.get(i).getVetAlunos().size()/20)){
                    //nao é viavel
                    solucao.setCusto((float) 1000000.0);
                    //n e viavel
                    viabilidade = 1;
                }
                
            }    
        }
        if(viabilidade==1){
            return (float) 1000000.0;
        }else{
        
            float matrizDistancias[][] = Importacao.lerXMLDistancias();
        int vetTurmas[] = new int[listaCidades.size()]; 
        
        for (int i = 0; i < listaPessoas.size(); i++) {
            //CoffeBreak ok
            if(listaCidades.get((int) solucao.getSolucao().get(i)).getCusto() == 0){
                custosVariaveis += coffeBreak;
            }else{
                custosVariaveis += coffeBreak * 2.0;
            }
            
            //deslocamento, e hospedagem
            //System.out.println("Matriz Distancias "+ matrizDistancias[Integer.parseInt(listaPessoa.get(i).getMunicipioId())-1][Integer.parseInt(solucao.getSolucao().get(i).toString())] );
            if(matrizDistancias[Integer.parseInt(listaPessoas.get(i).getMunicipioId())-1][Integer.parseInt(solucao.getSolucao().get(i).toString())] < 60.0){
                
            }else if(matrizDistancias[Integer.parseInt(listaPessoas.get(i).getMunicipioId())-1][Integer.parseInt(solucao.getSolucao().get(i).toString())] <= 300){
                    
                    if (listaPessoas.get(i).getNivel().equals("0")) {
                    custosVariaveis += custoHospedagem;
                    
                    } else if (listaPessoas.get(i).getNivel().equals("1")) {
                        custosVariaveis += custoHospedagem * 1.5;
                    
                    } else if (listaPessoas.get(i).getNivel().equals("2")) {
                        custosVariaveis += custoHospedagem * 2.0;
                    
                    }
                    
            }else if(matrizDistancias[Integer.parseInt(listaPessoas.get(i).getMunicipioId())-1][Integer.parseInt(solucao.getSolucao().get(i).toString())] > 300){
                
                
                if (listaPessoas.get(i).getNivel().equals("0")){
                custosVariaveis += custoDeslocamento;
                custosVariaveis += custoHospedagem;
                
                } else if (listaPessoas.get(i).getNivel().equals("1")) {
                    custosVariaveis += custoDeslocamento;
                    custosVariaveis += custoHospedagem * 1.5;
                
                } else if (listaPessoas.get(i).getNivel().equals("2")) {
                    custosVariaveis += custoDeslocamento * 1.5;
                    custosVariaveis += custoHospedagem * 2.0;
                }
            }   
            
        
        //cria um vetor com quantas pessoas estão em cada turma
            vetTurmas[Integer.parseInt(solucao.getSolucao().get(i).toString())]++;
            
        }
        //usando o vetor criado ele calcula quantas turmas serao criadas
        for(int z =0;z < vetTurmas.length; z++){
            int quantTurma = (int) Math.ceil(vetTurmas[z] / 20.0);
            custosFixos += custoCTDia * numeroDias * quantTurma * listaCidades.get(z).getCusto();
        }
        
        custoTotal = custosFixos + custosVariaveis;
//        System.out.println("Fixos: " + custosFixos + " Variaveis: " + custosVariaveis + " custoTotal: " + custoTotal);
        return custoTotal;
    }
            
        }
}
