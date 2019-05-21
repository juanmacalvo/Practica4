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
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int i;
        int salir=0;
        
        Maneja conexion = new Maneja();

        ManejaUsuario mu = new ManejaUsuario();
        ManejaCuenta mc = new ManejaCuenta();

        System.out.println("accesoAplicacion");
        
        mu.accesoAplicacion();
        
        do {
            System.out.println("Elige las opciones ");
            System.out.println("1- configurarUsuario");
            System.out.println("2- crearClave");
            System.out.println("3- listarClaves");
            System.out.println("4- Salir");
            i = input.nextInt();

            switch (i) {
                case 1: {
                    mu.configurarUsuario();

                }
                break;
                case 2: {

                    mc.crearClave();
                }
                break;
                case 3: {

                    mc.listarClaves();
                }
                break;
                case 4: {

                    salir=1;
                }
                break;

            }


        } while (salir == 0);
        

        conexion.cerrarSesion();

    }

}
