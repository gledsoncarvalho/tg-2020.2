/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import javax.swing.JOptionPane;

/**
 *
 * @author gleds
 */
public class Grafo {

    public static void main(String[] args) {
    }

    //Método que irá ler a lista de adjacência
    public static List<Vertice> lerListaAdjacencia(String filename) {
        Scanner in;
        List<Vertice> listas = new ArrayList();

        try {
            in = new Scanner(new FileReader(System.getProperty("user.dir") + filename));
            while (in.hasNextLine()) {
                String[] linha = in.nextLine().split("\t");
                String valor = linha[0].substring(0, linha[0].indexOf(":"));
                Vertice vertice = new Vertice(valor);
                for (int i = 1; i < linha.length; i++) {
                    String valorAdj = linha[i].substring(0, linha[i].indexOf(":"));
                    float distAdj = Float.valueOf(linha[i].substring(linha[i].indexOf(":") + 1, linha[i].length()));
                    Vertice verticeAdj = new Vertice(valorAdj, distAdj);
                    vertice.getListaAdjacentes().add(verticeAdj);
                }
                listas.add(vertice);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Arquivo não encontrado!!");
        }
        return listas;
    }

    static void print(List<Vertice> listas) {
        for (Vertice vertice : listas) {
            System.out.print(vertice.getValor() + ": ");
            for (int j = 0; j < vertice.getListaAdjacentes().size(); j++) {
                System.out.print(vertice.getListaAdjacentes().get(j).getValor() + " ");
            }
            System.out.println();
        }
    }

    //1 Método dijkstra passando um vertice e o grafo como parâmetro, e retornando os menor caminho
    static void djikstra(Vertice vertice, List<Vertice> grafo) {
        Vertice raiz = vertice;
        List<Vertice> vertices = new ArrayList();
        List<Boolean> s = new ArrayList();
        List<Float> dist = new ArrayList();
        List path1 = new ArrayList();
        List path2 = new ArrayList();
        Stack caminho = new Stack();

        //Adiciona vertices do grafo na lista
        for (Vertice no : grafo) {
            vertices.add(no);
        }

        //Adiciona valores na lista s
        for (int i = 0; i < grafo.size(); i++) {
            s.add(i, false);
        }
        s.set(vertices.indexOf(vertice), true);

        //Adiciona valores na lista dist
        for (int i = 0; i < grafo.size(); i++) {
            dist.add(i, Float.POSITIVE_INFINITY);
        }
        dist.set(vertices.indexOf(vertice), (float) 0);

        //Adiciona valores na lista path1 e path2
        for (int i = 0; i < grafo.size(); i++) {
            if (i == vertices.indexOf(vertice)) {
                path1.add("-");
                path2.add("-");
            } else {
                path1.add(0);
                path2.add(0);
            }
        }

        //Pega as adjacentes do vertice e calcula os caminhos
        while (s.contains(false)) {
            Vertice controle = grafo.get(grafo.indexOf(vertice));
            for (int i = 0; i < controle.getListaAdjacentes().size(); i++) {
                Vertice a = controle.getListaAdjacentes().get(i);
                for (Vertice vertice1 : vertices) {
                    if (vertice1.getValor().equals(a.getValor())) {
                        int z = vertices.indexOf(vertice1);
                        int t = vertices.indexOf(vertice);
                        if (dist.get(z) > dist.get(t) + a.getDist()) {
                            dist.set(z, dist.get(t) + a.getDist());
                            path1.set(z, t);
                        }
                    }
                }
            }

            //Lista os caminhos buscando o menor caminho
            List<Float> listaMenor = new ArrayList();
            for (int i = 0; i < grafo.size(); i++) {
                if (!s.get(i)) {
                    listaMenor.add(dist.get(i));
                }
            }

            Collections.sort(listaMenor);

            //Adiciona "true" na lista s quando for o menor caminho
            for (int j = 0; j < grafo.size(); j++) {
                if (!s.get(j) && (dist.get(j).floatValue() == listaMenor.get(0).floatValue())) {
                    vertice = vertices.get(j);
                    s.set(j, true);
                }
            }

            //Pega os valores do path1 e transforma em vertices do path2
            for (int k = 0; k < path1.size(); k++) {
                if (path2.get(k).equals("-")) {
                    path2.set(k, "-");
                } else {
                    path2.set(k, vertices.get(Integer.parseInt(path1.get(k).toString())));
                }
            }

        }
        //Em sequencia printao o menor caminho de cada vertice a outros vertices do grafo
        for (int i = 0; i < grafo.size(); i++) {
            Vertice vertFinal = vertices.get(i);
            caminho.add(vertFinal);
            while (!caminho.contains("-")) {
                caminho.add(path2.get(vertices.indexOf(vertFinal)));
                vertFinal = path2.get(vertices.indexOf(vertFinal)) instanceof Vertice ? (Vertice) path2.get(vertices.indexOf(vertFinal)) : null;
            }
            caminho.pop();
            Collections.reverse(caminho);

            System.out.print("Distância miníma de " + raiz.getValor() + " para " + vertices.get(i).getValor() + ": " + dist.get(i) + " => CAMINHO: ");
            for (int j = 0; j < caminho.size(); j++) {
                System.out.print(" - " + (caminho.get(j) instanceof Vertice ? ((Vertice) caminho.get(j)).getValor() : null));
            }
            System.out.println("");
            caminho = new Stack();
        }

    }

    //2 Método dijkstra passando dois vertices e o grafo como parâmetro, e retornando o menor caminho entre os dois vertices
    static void dijkstra2(Vertice verticeOrigem, Vertice verticeDestino, List<Vertice> grafo) {
        Vertice raiz = verticeOrigem;
        List<Vertice> vertices = new ArrayList();
        List<Boolean> s = new ArrayList();
        List<Float> dist = new ArrayList();
        List path1 = new ArrayList();
        List path2 = new ArrayList();
        Stack caminho = new Stack();

        //Adiciona vertices do grafo na lista
        for (Vertice no : grafo) {
            vertices.add(no);
        }

        //Adiciona valores na lista s
        for (int i = 0; i < grafo.size(); i++) {
            s.add(i, false);
        }
        s.set(vertices.indexOf(verticeOrigem), true);

        //Adiciona valores a lista dist
        for (int i = 0; i < grafo.size(); i++) {
            dist.add(i, Float.POSITIVE_INFINITY);
        }
        dist.set(vertices.indexOf(verticeOrigem), (float) 0);

        //Adiciona valores a lista path1 e path2
        for (int i = 0; i < grafo.size(); i++) {
            if (i == vertices.indexOf(verticeOrigem)) {
                path1.add("-");
                path2.add("-");
            } else {
                path1.add(0);
                path2.add(0);
            }
        }
        //Pega os adjacentes e calcula os caminhos entre eles
        while (!s.get(vertices.indexOf(verticeDestino))) {
            Vertice controle = grafo.get(grafo.indexOf(verticeOrigem));
            for (int i = 0; i < controle.getListaAdjacentes().size(); i++) {
                Vertice a = controle.getListaAdjacentes().get(i);
                for (Vertice vertice1 : vertices) {
                    if (vertice1.getValor().equals(a.getValor())) {
                        int z = vertices.indexOf(vertice1);
                        int t = vertices.indexOf(verticeOrigem);
                        if (dist.get(z) > dist.get(t) + a.getDist()) {
                            dist.set(z, dist.get(t) + a.getDist());
                            path1.set(z, t);
                        }
                    }
                }
            }

            List<Float> listaMenor = new ArrayList();

            //Lista os caminhos em busca do menor caminho
            for (int i = 0; i < grafo.size(); i++) {
                if (!s.get(i)) {
                    listaMenor.add(dist.get(i));
                }
            }

            Collections.sort(listaMenor);
            //Adiciona "true" a lista s quando for o menor caminho
            for (int j = 0; j < grafo.size(); j++) {
                if (!s.get(j) && (dist.get(j).floatValue() == listaMenor.get(0).floatValue())) {
                    verticeOrigem = vertices.get(j);
                    s.set(j, true);
                }
            }
            //Pega os valores de path1 e transforma em vértices no path2
            for (int k = 0; k < path1.size(); k++) {
                if (path2.get(k).equals("-")) {
                    path2.set(k, "-");
                } else {
                    path2.set(k, vertices.get(Integer.parseInt(path1.get(k).toString())));
                }
            }
        }
        //Faz sequência do menor caminho
        Vertice vertFinal = verticeDestino;
        caminho.add(vertFinal);

        while (!caminho.contains("-")) {
            caminho.add(path2.get(vertices.indexOf(vertFinal)));
            vertFinal = path2.get(vertices.indexOf(vertFinal)) instanceof Vertice ? (Vertice) path2.get(vertices.indexOf(vertFinal)) : null;
        }
        caminho.pop();
        Collections.reverse(caminho);
        //Printa o menor caminho de um vértice a outro vértice

        System.out.print("Distância miníma de " + raiz.getValor() + " para " + verticeDestino.getValor() + ": " + dist.get(vertices.indexOf(verticeDestino)) + " => CAMINHO: ");
        for (int j = 0; j < caminho.size(); j++) {
            System.out.print(" - " + (caminho.get(j) instanceof Vertice ? ((Vertice) caminho.get(j)).getValor() : null));
        }
        System.out.println("");
    }

}
