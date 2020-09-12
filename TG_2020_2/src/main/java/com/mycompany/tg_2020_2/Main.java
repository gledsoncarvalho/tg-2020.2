/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tg_2020_2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gleds
 */
public class Main {

    public static void main(String[] args) {
        String filename = "\\grafo-25000.txt";

        List<ArrayList> grafo = Grafo.lerListaAdjacencia(filename);
    }

}
