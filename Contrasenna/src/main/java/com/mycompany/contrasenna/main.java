/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.contrasenna;

import java.util.Scanner;

/**
 *
 * @author usuario
 */
public class main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int i = 0;

        ManejaUsuario mu = new ManejaUsuario();

        while (i != 3) {
            System.out.println("Elige las opciones ");
            System.out.println("1- configurarUsuario");
            System.out.println("2- accesoAplicacion");
            System.out.println("3- Salir");

            i = input.nextInt();
            if (i == 1) {
                System.out.println("mu.configurarUsuario");
                mu.configurarUsuario();

            } else if (i == 2) {
                System.out.println("mu.accesoAplicacion");
                mu.accesoAplicacion();

            }

        }
        //Aquí las instrucciones del método

    }

}
