/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafos2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author brenn
 */
public class Medotos {

    static private String diretorio = System.getProperty("user.dir") + "\\file3.txt";

    public static void main(String[] args) throws FileNotFoundException {
        int nVertices = NumVertices();

        List<Integer>[] grafo = new ArrayList[nVertices];
        carregarGrafo(grafo);

        print(grafo);//print do grafo completo
        ehRegular(grafo, nVertices); //se é regular
        ehCompleto(grafo, nVertices); //se é completo

        //para fazer o getAdjacentes funcionar
        ArrayList<Integer> adjacentes = new ArrayList();
        adjacentes = getAdjacentes(grafo, 1025);

        //print dos adjacentes
        System.out.print("Os adjacentes são: ");
        for (int i = 0; i < adjacentes.size(); i++) {
            System.out.print(adjacentes.get(i) + " ");
        }

        getAdjacentes(grafo, 1025);
        System.out.println("\nÉ regular? ");
        ehRegular(grafo, nVertices);
        System.out.println("É completo? ");
        ehCompleto(grafo, nVertices);

        List<Integer> verticesMarcados = buscaLargura(grafo, grafo[0].get(0));
        System.out.println("\nÉ conexo? " + ehConexo(grafo, verticesMarcados));


    }

    //conta num de vértices
    static int NumVertices() throws FileNotFoundException {
        int count = 0;
        Scanner in = new Scanner(new FileReader(diretorio));
        while (in.hasNext()) {
            count++;
            in.nextLine();
        }
        return count;
    }

    static void print(List[] grafo) {
        for (int i = 0; i < grafo.length; i++) {
            System.out.print(grafo[i].get(0) + ": ");
            for (int j = 1; j < grafo[i].size(); j++) {
                System.out.print(grafo[i].get(j) + " ");

            }
            System.out.print("(vertices adjacentes: ");
            System.out.print(grafo[i].size() - 1 + ")");
            System.out.println("");
        }

    }

    static void carregarGrafo(List[] grafo) throws FileNotFoundException {
        int count2 = 0;
        Scanner in = new Scanner(new FileReader(diretorio));
        ligarGrafo(grafo);

        while (in.hasNext()) {
            String line = in.nextLine();
            String[] vertices = line.split("\t");

            for (String vertice : vertices) {
                grafo[count2].add(Integer.parseInt(vertice));
            }
            count2++;
        }

    }

    static void ligarGrafo(List[] grafo) {
        for (int i = 0; i < grafo.length; i++) {
            grafo[i] = new ArrayList<Integer>();
        }
    }

    public static ArrayList<Integer> getAdjacentes(List[] grafo, int vertices) {
        ArrayList<Integer> adjacentes = new ArrayList();
        for (int i = 0; i < grafo.length; i++) {
            if (grafo[i].get(0).equals(vertices)) {
                for (int j = 1; j < grafo[i].size(); j++) {
                    adjacentes.add((Integer) grafo[i].get(j));
                }
            }
        }
        return adjacentes;
    }

    static boolean ehRegular(List[] grafo, int nVertices) {
        for (int i = 0; i < nVertices - 1; i++) {

            if (grafo[i].size() != grafo[i + 1].size()) {
                System.out.println("false");
                return false;
            }
        }
        System.out.println("true");
        return true;
    }

    static boolean ehCompleto(List[] grafo, int nVertices) {
        //se todos os vértices tiverem o msm numero de do num de vertices -1
        for (int i = 0; i < grafo.length; i++) {

            if (grafo[i].size() - 1 != nVertices - 1) {
                System.out.println("false");
                return false;
            }
        }
        System.out.println("true");
        return true;
    }

    static List<Integer> buscaLargura(List[] grafo, Integer verticeInicial) {
        List<Integer> fila = new ArrayList<>();
        List<Integer> verticesMarcados = new ArrayList();
        verticesMarcados.add(verticeInicial);
        fila.add(verticeInicial);
        while (fila.size() > 0) {
            Integer vertice1 = fila.get(0);
            List<Integer> listaAdjacentes = getAdjacentes(grafo, vertice1);
            for (Integer vertice : listaAdjacentes) {
                if(!verticesMarcados.contains(vertice)) {
                   verticesMarcados.add(vertice);
                   fila.add(vertice);
                }
            }
            fila.remove(0);
        }
        return verticesMarcados;
    }
    
    static boolean ehConexo(List[] grafo, List<Integer> verticesMarcados) {
        return grafo.length == verticesMarcados.size();
    }
}
