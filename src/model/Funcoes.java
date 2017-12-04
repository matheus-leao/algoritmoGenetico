/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import java.util.ArrayList;
import Leitura.Importacao;
//import static Leitura.Importacao.listaCidades;
import static Leitura.Importacao.listaCidadesCT;
import static Leitura.Importacao.listaPessoas;
import java.text.DecimalFormat;



/**
 *
 * @author Math
 */
public class Funcoes {
    
    public static float custoResposta(Solucao solucao) {
        
        ArrayList<Turma> listaTurmas = new ArrayList();
        
        Turma turma;
        for(int i = 0; i < listaCidadesCT.size(); i++){
            turma = new Turma();
            turma.setId(i);
            turma.setCidade(listaCidadesCT.get(i));
            for(int j=0; j < listaPessoas.size(); j++){
                if((int)solucao.getSolucao().get(j) == i){
                    turma.getVetAlunos().add(listaPessoas.get(j));
                }
            }
            listaTurmas.add(turma);
        }
        int viabilidade = 0;
        String subAreaCliente = ""; 
        int idCidadeCliente = 0;
        float numeroDeTurmas;
        for(int i = 0; i < listaTurmas.size();i++){//percorrer listaTurmas
                
            for(int j=0; j < listaTurmas.get(i).getVetAlunos().size(); j++){//percorrer a lista Alunos por Turmas
                subAreaCliente = listaTurmas.get(i).getVetAlunos().get(j).getSubArea();
                idCidadeCliente = listaTurmas.get(i).getVetAlunos().get(j).getMunicipioId();
                int cont = 1;
                    for(int x = (j+1); x < listaTurmas.get(i).getVetAlunos().size(); x++){//percorrer alunos
                        if(subAreaCliente.equals(listaTurmas.get(i).getVetAlunos().get(x).getSubArea()) &&
                                idCidadeCliente == listaTurmas.get(i).getVetAlunos().get(x).getMunicipioId()){
                            cont++;
                      //      System.out.println("Cont++");
                        }
                    }
                    //ceilComp = numero de turmas
                    numeroDeTurmas = (float) ((float)listaTurmas.get(i).getVetAlunos().size()/20.0); 
                    if(cont > numeroDeTurmas || numeroDeTurmas > 16.0f){
                    //nao é viavel
                    //solucao.setCusto((float) 1000000.0);
                    //n e viavel
                    //System.out.println("nao e viavel");
                    viabilidade = 1;
                    
                    }
                
            }    
        }
        solucao.setViabilidade(viabilidade);
        //viavel == 0
        if(viabilidade != 0){
            //custoTotal += 9000000;
            return (int) 999999999;
        }else{
            
        
        float custoTotal = 0;
        float custoDeslocamento = (float) 1000.0;
        
        float custoCTDia = (float) 2000.0;
        float numeroDias = (float) 3.0;
        
        float custosFixos =0;
        float custosVariaveis = 0;
        
        float custoHospedagem = (float) (300.0 * numeroDias);
        
        float coffeBreak = (float) (35.0 * numeroDias);
        
        float matrizDistancias[][] = Importacao.lerXMLDistancias();
        int vetTurmas[] = new int[listaCidadesCT.size()]; 
        
        for (int i = 0; i < listaPessoas.size(); i++) {
        //System.out.print(listaPessoas.get(i).getId() + ";" + listaPessoas.get(i).getMunicipioId() + ";" + solucao.getSolucao().get(i) +";"+ listaPessoas.get(i).getNivel() + ";");

//CoffeBreak ok
            if(listaCidadesCT.get(((int) solucao.getSolucao().get(i))).getCusto() == 0){
                custosVariaveis += coffeBreak;
                
                //System.out.print("Coffe Break: " + coffeBreak + ";");
                
            }else{
                //float custosCoffeBreak =coffeBreak * 2.0;
                //custosVariaveis += custosCoffeBreak;
                custosVariaveis += coffeBreak * 2.0;
                //System.out.print(" Coffe Break: " + coffeBreak * 2.0 + ";");
            }
            
            
            //deslocamento, e hospedagem
            //System.out.println("Matriz Distancias "+ matrizDistancias[Integer.parseInt(listaPessoa.get(i).getMunicipioId())-1][Integer.parseInt(solucao.getSolucao().get(i).toString())] );
            if(matrizDistancias[listaPessoas.get(i).getMunicipioId()-1][Integer.parseInt(solucao.getSolucao().get(i).toString())] < 60){
                //System.out.print(" Hospedagem: " + "0;");
                //System.out.print(" Deslocamento: " + "0;");
            }else if(matrizDistancias[listaPessoas.get(i).getMunicipioId()-1][Integer.parseInt(solucao.getSolucao().get(i).toString())] < 300){
                    
                    if (listaPessoas.get(i).getNivel()-1 == 0) {
                    custosVariaveis += custoHospedagem;
//                    System.out.print(" Hospedagem: " + custoHospedagem+ ";");
//                    System.out.print(" Deslocamento: " + "0;");
                    
                    } else if (listaPessoas.get(i).getNivel()-1 == 1){
                        custosVariaveis += custoHospedagem * 1.5f;
//                        System.out.print(" Hospedagem: " + custoHospedagem * 1.5f+ ";");
//                        System.out.print(" Deslocamento: " + "0;");
                    
                    } else{
                        custosVariaveis += custoHospedagem * 2.0f;
//                        System.out.print(" Hospedagem: " + custoHospedagem * 2.0f+ ";");
//                        System.out.print(" Deslocamento: " + "0;");
                    
                    }
                    
            }else{
                
                
                if (listaPessoas.get(i).getNivel()-1 == 0){
                custosVariaveis += custoDeslocamento;
                custosVariaveis += custoHospedagem;
//                System.out.print(" Hospedagem: " + custoHospedagem+ ";");
//                System.out.print(" Deslocamento: " + custoDeslocamento+ ";");
                
                } else if (listaPessoas.get(i).getNivel()-1 == 1) {
                    custosVariaveis += custoDeslocamento;
                    custosVariaveis += custoHospedagem * 1.5f;
//                    System.out.print(" Hospedagem: " + custoHospedagem*1.5+ ";");
//                    System.out.print(" Deslocamento: " + custoDeslocamento+ ";");
                    
                } else {
                    custosVariaveis += custoDeslocamento * 1.5f;
                    custosVariaveis += custoHospedagem * 2.0f;
//                    System.out.print(" Hospedagem: " + custoHospedagem*2.0+ ";");
//                    System.out.print(" Deslocamento: " + custoDeslocamento*1.5+ ";");
                }
                
            }   
            
//        System.out.println(" custosVariaveis: " + custosVariaveis+ ";");
                
        //cria um vetor com quantas pessoas estão em cada turma
            vetTurmas[Integer.parseInt(solucao.getSolucao().get(i).toString())]++;
            
        }
//        System.out.println("Variaveis: " + custosVariaveis);
        //usando o vetor criado ele calcula quantas turmas serao criadas
        for(int z =0;z < vetTurmas.length; z++){
            float quantTurma = (float) Math.ceil(vetTurmas[z] / 20.0);
            custosFixos += custoCTDia * numeroDias * quantTurma * listaCidadesCT.get(z).getCusto();
            //custosFixos += custoCTDia * numeroDias * listaCidadesCT.get(z).getCusto();
        }
        
        DecimalFormat df = new DecimalFormat("0");
        
        custoTotal += custosFixos + custosVariaveis;
//        System.out.println("Fixos: " + df.format(custosFixos) + " Variaveis: " + df.format(custosVariaveis) + " custoTotal: " + custoTotal);
        return custoTotal;
    }
            
}
}
