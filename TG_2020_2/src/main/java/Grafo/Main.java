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
public class Main {

    public static void main(String[] args) {
        // Insira a descrição da lista de adjacência .txt no valor da variável abaixo, sem remover as barras
        String filename = "\\file3.txt";

        // Faz a leitura do arquivo.txt e armazena na estrutura.
        List<Vertice> grafo = Grafo.lerListaAdjacencia(filename);
        
        //Método que irá printar o grafo passado como parâmetro
        Grafo.print(grafo);
         
        //1 Método dijkstra 
        Grafo.dijkstra(grafo.get(1), grafo);
       
        //2 Método dijkstra
        Grafo.dijkstra2(grafo.get(0), grafo.get(3), grafo);       


       
    }

}
