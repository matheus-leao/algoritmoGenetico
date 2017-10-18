/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Math
 */
public class Pessoa {
    private String id;
    private String nome;
    private String area;
    private String subArea;
    private String cargoAtual;
    private String municipio;
    private String municipioId;
    private String estado;
    private String estadoId;
    private String nivel;

    public Pessoa(String id, String nome, String area, String subArea, String cargoAtual, String municipio, String municipioId, String estado, String estadoId, String nivel) {
        this.id = id;
        this.nome = nome;
        this.area = area;
        this.subArea = subArea;
        this.cargoAtual = cargoAtual;
        this.municipio = municipio;
        this.municipioId = municipioId;
        this.estado = estado;
        this.estadoId = estadoId;
        this.nivel = nivel;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getSubArea() {
        return subArea;
    }

    public void setSubArea(String subArea) {
        this.subArea = subArea;
    }

    public String getCargoAtual() {
        return cargoAtual;
    }

    public void setCargoAtual(String cargoAtual) {
        this.cargoAtual = cargoAtual;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getMunicipioId() {
        return municipioId;
    }

    public void setMunicipioId(String municipioId) {
        this.municipioId = municipioId;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(String estadoId) {
        this.estadoId = estadoId;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
}
    