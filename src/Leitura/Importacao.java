/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Leitura;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import model.CidadeCT;
import model.Funcoes;
import model.Pessoa;
import model.Restricao;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Math
 */
public class Importacao {
    
    public static ArrayList<Pessoa> listaPessoas = Importacao.lerXMLPessoas();
    public static ArrayList<CidadeCT> listaCidades = Importacao.lerXMLCidades();
    public static float[][] distancias = Importacao.lerXMLDistancias();
    //public static ArrayList<Restricao> listaRestricoes = Importacao.restricoes();
    
    public static ArrayList lerXMLPessoas() {

        try {
            //objetos para construir e fazer a leitura do documento
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse("baseXML.xml");

            //cria uma lista de pessoas. Busca no documento todas as tag pessoa
            NodeList listaDePessoas = doc.getElementsByTagName("record");

            //pego o tamanho da lista de pessoas
            int tamanhoLista = listaDePessoas.getLength();

            ArrayList<Pessoa> listaPessoa = new ArrayList();

            //Pessoa nova;
            String nome = "", area = "", subArea = "", cargoAtual = "", municipio = "", estado = "";
            String id = "", municipioId = "", estadoId = "", nivel = "";
            //varredura na lista de pessoas
            for (int i = 0; i < tamanhoLista; i++) {

                //pego cada item (pessoa) como um nó (node)
                Node noPessoa = listaDePessoas.item(i);

                //verifica se o noPessoa é do tipo element (e não do tipo texto etc)
                if (noPessoa.getNodeType() == Node.ELEMENT_NODE) {

                    //caso seja um element, converto o no Pessoa em Element pessoa
                    Element elementoPessoa = (Element) noPessoa;

                    //recupero os nos filhos do elemento pessoa (nome, idade e peso)
                    NodeList listaDeFilhosDaPessoa = elementoPessoa.getChildNodes();

                    //pego o tamanho da lista de filhos do elemento pessoa
                    int tamanhoListaFilhos = listaDeFilhosDaPessoa.getLength();

                    //varredura na lista de filhos do elemento pessoa
                    for (int j = 0; j < tamanhoListaFilhos; j++) {

                        //crio um no com o cada tag filho dentro do no pessoa (tag nome, idade e peso)
                        Node noFilho = listaDeFilhosDaPessoa.item(j);

                        //verifico se são tipo element
                        if (noFilho.getNodeType() == Node.ELEMENT_NODE) {

                            //converto o no filho em element filho
                            Element elementoFilho = (Element) noFilho;

                            //verifico em qual filho estamos pela tag
                            switch (elementoFilho.getTagName()) {
                                case "id":
                                    id = elementoFilho.getTextContent();
                                    break;
                                case "nome":
                                    nome = elementoFilho.getTextContent();
                                    break;
                                case "area":
                                    area = elementoFilho.getTextContent();
                                    break;
                                case "subArea":
                                    subArea = elementoFilho.getTextContent();
                                    break;
                                case "cargoAtual":
                                    cargoAtual = elementoFilho.getTextContent();
                                    break;
                                case "municipio":
                                    municipio = elementoFilho.getTextContent();
                                    break;
                                case "municipioId":
                                    municipioId = elementoFilho.getTextContent();
                                    break;
                                case "estado":
                                    estado = elementoFilho.getTextContent();
                                    break;
                                case "estadoId":
                                    estadoId = elementoFilho.getTextContent();
                                    break;
                                case "nivel":
                                    nivel = elementoFilho.getTextContent();
                                    break;
                            }
                        }
                    }
                    listaPessoa.add(new Pessoa(id, nome, area, subArea, cargoAtual, municipio, municipioId, estado, estadoId, nivel));

                }
            }
            return listaPessoa;

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Funcoes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(Funcoes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Funcoes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static ArrayList lerXMLCidades() {

        try {
            //objetos para construir e fazer a leitura do documento
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse("cidadeCT.xml");

            NodeList listaDeCidades = doc.getElementsByTagName("record");
            int tamanhoLista = listaDeCidades.getLength();

            ArrayList<CidadeCT> listaCidades = new ArrayList();

            //Cidade nova;
            String id = "", nome = "", custo = "";

            //varredura na lista de pessoas
            for (int i = 0; i < tamanhoLista; i++) {

                //pego cada item (pessoa) como um nó (node)
                Node noPessoa = listaDeCidades.item(i);

                //verifica se o noPessoa é do tipo element (e não do tipo texto etc)
                if (noPessoa.getNodeType() == Node.ELEMENT_NODE) {

                    //caso seja um element, converto o no Pessoa em Element pessoa
                    Element elementoPessoa = (Element) noPessoa;

                    //recupero os nos filhos do elemento pessoa (nome, idade e peso)
                    NodeList listaDeFilhosDaPessoa = elementoPessoa.getChildNodes();

                    //pego o tamanho da lista de filhos do elemento pessoa
                    int tamanhoListaFilhos = listaDeFilhosDaPessoa.getLength();

                    //varredura na lista de filhos do elemento pessoa
                    for (int j = 0; j < tamanhoListaFilhos; j++) {

                        //crio um no com o cada tag filho dentro do no pessoa (tag nome, idade e peso)
                        Node noFilho = listaDeFilhosDaPessoa.item(j);

                        //verifico se são tipo element
                        if (noFilho.getNodeType() == Node.ELEMENT_NODE) {

                            //converto o no filho em element filho
                            Element elementoFilho = (Element) noFilho;

                            //verifico em qual filho estamos pela tag
                            switch (elementoFilho.getTagName()) {
                                case "id":
                                    id = elementoFilho.getTextContent();
                                    break;
                                case "nome":
                                    nome = elementoFilho.getTextContent();
                                    break;
                                case "custo":
                                    custo = elementoFilho.getTextContent();
                                    break;

                            }
                        }
                    }
                    listaCidades.add(new CidadeCT(id, nome, custo));

                }
            }
            return listaCidades;

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Funcoes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(Funcoes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Funcoes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static float[][] lerXMLDistancias(){
        float[][] matrizDistancias;
        matrizDistancias = new float[797][52];
        
        try {
            //objetos para construir e fazer a leitura do documento
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse("distanciasCts.xml");

            NodeList listaDeCidades = doc.getElementsByTagName("distanciasCts");
            int tamanhoLista = listaDeCidades.getLength();
            
        
            
            int k =0,t=0;
            //varredura na lista de pessoas
            for (int i = 0; i < tamanhoLista; i++) {
                
                //pego cada item (pessoa) como um nó (node)
                Node noPessoa = listaDeCidades.item(i);

                //verifica se o noPessoa é do tipo element (e não do tipo texto etc)
                if (noPessoa.getNodeType() == Node.ELEMENT_NODE) {

                    //caso seja um element, converto o no Pessoa em Element pessoa
                    Element elementoPessoa = (Element) noPessoa;

                    //recupero os nos filhos do elemento pessoa (nome, idade e peso)
                    NodeList listaDeFilhosDaPessoa = elementoPessoa.getChildNodes();

                    //pego o tamanho da lista de filhos do elemento pessoa
                    int tamanhoListaFilhos = listaDeFilhosDaPessoa.getLength();
                    //System.out.println(listaDeFilhosDaPessoa.getLength());
                    //varredura na lista de filhos do elemento pessoa
                    for (int j = 0; j < tamanhoListaFilhos; j++) {

                        //crio um no com o cada tag filho dentro do no pessoa (tag nome, idade e peso)
                        Node noFilho = listaDeFilhosDaPessoa.item(j);
                        
                        //verifico se são tipo element
                        if (noFilho.getNodeType() == Node.ELEMENT_NODE) {

                            //converto o no filho em element filho
                            Element elementoFilho = (Element) noFilho;
                                
                                matrizDistancias[k][t] = Float.parseFloat(elementoFilho.getFirstChild().getTextContent());
                                if(t==51){
                                    k++;
                                    t=0;
                                }else{
                                    t++;
                                }           
                        }
                    }
                }
            }

            
            
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Funcoes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(Funcoes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Funcoes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return matrizDistancias;
        
        }
    
//    public static ArrayList restricoes(){
//        for(int i = 0; i< listaPessoas.size();i++){
//            
//        }
//    }
}
