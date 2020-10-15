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
import javax.swing.JOptionPane;

/**
 *
 * @author gleds
 */
public class Grafo {

    public static void main(String[] args) {
    }

    public static List<ArrayList> lerListaAdjacencia(String filename) {
        System.out.println(System.getProperty("user.dir") + filename);
        Scanner in;
        List<ArrayList> listas = new ArrayList();

        try {
            in = new Scanner(new FileReader(System.getProperty("user.dir") + filename));
            while (in.hasNextLine()) {
                ArrayList listaLinha = new ArrayList();
                for (String elemento : in.nextLine().split("\t")) {
                    listaLinha.add(elemento);
                }
                listas.add(listaLinha);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Arquivo não encontrado!!");
        }
        return listas;
    }

    static void print(List<ArrayList> listas) {
        for (ArrayList linha : listas) {
            System.out.print(linha.get(0) + ": ");
            for (int j = 1; j < linha.size(); j++) {
                System.out.print(linha.get(j) + " ");
            }
            System.out.println();
        }
    }
    

}
