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
        String filename = "\\file1.txt";

        // Faz a leitura do arquivo.txt e armazena na estrutura.
        List<ArrayList> grafo = Grafo.lerListaAdjacencia(filename);
        Grafo.print(grafo);
    }

}