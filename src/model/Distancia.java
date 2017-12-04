/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import Leitura.Importacao;



/**
 *
 * @author Math
 */
public class Distancia {
    
    public float[][] matrizDistancias;

    public Distancia(float[][] matrizDistancias) {
        this.matrizDistancias = Importacao.lerXMLDistancias();
    }

    public Distancia() {
    }

    public float[][] getMatrizDistancias() {
        return matrizDistancias;
    }

    public void setMatrizDistancias(float[][] matrizDistancias) {
        this.matrizDistancias = matrizDistancias;
    }
    
    

    
}
