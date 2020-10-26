/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gleds
 */
public class Vertice {

    private String valor;
    private boolean isVisited;
    private float dist;
    private List<Vertice> listaAdjacentes;

    public Vertice(String valor) {
        this.listaAdjacentes = new ArrayList<>();
        this.valor = valor;
        this.isVisited = false;
        this.dist = 0;
    }
    
    public Vertice(String valor, float dist) {
        this.listaAdjacentes = new ArrayList<>();
        this.valor = valor;
        this.isVisited = false;
        this.dist = dist;
    }
    
    public Vertice(String valor, float dist, List<Vertice> listAdj) {
        this.listaAdjacentes = listAdj;
        this.valor = valor;
        this.isVisited = false;
        this.dist = dist;
    }

    /**
     * @return the valor
     */
    public String getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(String valor) {
        this.valor = valor;
    }

    /**
     * @return the isVisited
     */
    public boolean isIsVisited() {
        return isVisited;
    }

    /**
     * @param isVisited the isVisited to set
     */
    public void setIsVisited(boolean isVisited) {
        this.isVisited = isVisited;
    }

    /**
     * @return the dist
     */
    public float getDist() {
        return dist;
    }

    /**
     * @param dist the dist to set
     */
    public void setDist(float dist) {
        this.dist = dist;
    }

    /**
     * @return the listaAdjacentes
     */
    public List<Vertice> getListaAdjacentes() {
        return listaAdjacentes;
    }

    /**
     * @param listaAdjacentes the listaAdjacentes to set
     */
    public void setListaAdjacentes(List<Vertice> listaAdjacentes) {
        this.listaAdjacentes = listaAdjacentes;
    }

}
