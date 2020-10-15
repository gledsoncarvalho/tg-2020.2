/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author franc
 */
public class Metodos {

    static private String caminho = ":\\git\\tg-2020.2\\TG_2020_2\\file1.txt";

    public static void main(String... args) throws FileNotFoundException {

        int numeroVertices = pegarNumeroVertices();

        List<Integer>[] grafo = new ArrayList[numeroVertices];
        carregarGrafoEmMemoria(grafo);
        System.out.println("Adjacentes:");
        getAdjacentes(grafo);
    }

    static int pegarNumeroVertices() throws FileNotFoundException {
        int contador = 0;
        Scanner input = new Scanner(new FileReader(caminho));
        while (input.hasNext()) {
            contador++;
            input.nextLine();
        }
        return contador;
    }

    static void ligarGrafo(List[] grafo) {
        for (int i = 0; i < grafo.length; i++) {
            grafo[i] = new ArrayList<Integer>();
        }
    }

    static void carregarGrafoEmMemoria(List[] grafo) throws FileNotFoundException {
        Scanner input = new Scanner(new FileReader(caminho));
        ligarGrafo(grafo);
        int contador = 0;
        while (input.hasNext()) {
            String line = input.nextLine();
            String[] vertices = line.split("\t");
            for (String vertice : vertices) {
                grafo[contador].add(vertice);
            }
            contador++;
        }
    }

    static void getAdjacentes(List[] grafo) {
        for (int i = 0; i < grafo.length; i++) {
            System.out.print(grafo[i].get(0) + ":");
            for (int j = 1; j < grafo[i].size(); j++) {
                System.out.print(grafo[i].get(j) + " ");
            }

            System.out.println("");

        }

    }

}
