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
public class Main {
    
    static private String diretorio = "D:\\git\\tg-2020.2\\TG_2020_2\\file3.txt";
    
    public static void main (String[] args)throws FileNotFoundException{ 
        int nVertices = NumVertices();
        
        List<Integer>[] grafo = new ArrayList[nVertices];
        carregarGrafo(grafo);
        
        print(grafo);
        //getAdjacentes(grafo, 1025);    
        ehRegular(grafo, nVertices);
        ehCompleto(grafo, nVertices);
    }
 
        //conta num de vértices
    static int NumVertices() throws FileNotFoundException{
        int count = 0;
        Scanner in = new Scanner(new FileReader(diretorio));
        while (in.hasNext()){
            count++;
            in.nextLine();
        }
        return count;
        }
    
    static void print(List[] grafo){
        for (int i = 0; i < grafo.length; i++){
            System.out.print(grafo[i].get(0)+": ");
            for (int j = 1; j< grafo[i].size(); j++){
                System.out.print(grafo[i].get(j)+" ");
               
            }
            System.out.print("(vertices adjacentes: ");
            System.out.print(grafo[i].size()-1+")");
            System.out.println("");
        } 
        
    }
    
    static void carregarGrafo(List[] grafo) throws FileNotFoundException{
        int count2 = 0;
        Scanner in = new Scanner(new FileReader(diretorio));
        ligarGrafo(grafo);
        
        while (in.hasNext()){
            String line = in.nextLine();
            String[] vertices = line.split("\t");
            
            for (String vertice: vertices ){
                grafo[count2].add(Integer.parseInt(vertice));
            }
            count2++;
        }
        
    }

    static void ligarGrafo(List[] grafo){
        for (int i = 0; i < grafo.length; i++){
            grafo[i] = new ArrayList<Integer>();
        }
    }
   
    static void getAdjacentes(List[] grafo, int vertices) {//FUNCIONANDO
        //varrer o gráfico
        for (int i = 0; i < grafo.length; i++) {
            //se o vértice de saída foi igual ao vértice do parâmetro
            if (grafo[i].get(0).equals(vertices)){
                System.out.println("os adjacestes de " + vertices + " são:");
                //printar todos os adjacentes
                for (int j = 1; j < grafo[i].size(); j++) {
                    System.out.print(grafo[i].get(j) + " ");
                }
            }

        }
    }
    
    static boolean ehRegular(List[] grafo, int nVertices){
        for (int i = 0; i < nVertices-1; i++){
            
            if (grafo[i].size() != grafo[i+1].size()){
                System.out.println("false");
                return false;
            }
        }
        System.out.println("true");
        return true;
    }
  
    
    static boolean ehCompleto(List[] grafo, int nVertices){
        //se todos os vértices tiverem o msm numero de do num de vertices -1
        for (int i = 0; i< grafo.length; i++){
            
            if (grafo[i].size()-1 != nVertices-1){
                System.out.println("false");
                return false;
            }
        }
        System.out.println("true");
        return true;
    }
}

 /* static boolean ehRegular(List[] grafo){
        //criação de vetor
        int vetor[] = new int[grafo.length];
        int count = 0;
        //varrer vértices base
        for (int i = 0; i < grafo.length; i++){
            //varrer vértices adjacentes
            for (int j = 1; j < grafo[i].size(); j++){
                //variável que indica quantidade de vértices adjacentes
                int a1 = grafo[i].size()-1;
                //add esse valor ao vetor
                vetor[i] = a1;    
        }  
    }
    //varrer vetor auxiliar
    for (int k = 0; k < vetor.length-1; k++){
        //comparar os valores dos elementos
        //se for igual, retorna true
        if (vetor[k] == vetor[k+1]){
            count++;
        //se for falso retorna false
        } else {
            System.out.println("false");
            return false;
        }
    }
    //retorno do true
    System.out.println("true");
    return true;
    }*/