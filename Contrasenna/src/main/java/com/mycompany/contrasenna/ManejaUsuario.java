/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.contrasenna;

import java.util.Scanner;
import org.hibernate.HibernateException;

/**
 *
 * @author usuario
 */
public class ManejaUsuario extends Maneja {

    public void configurarUsuario() {
        Scanner input = new Scanner(System.in);
        String pass = "";
        String probar = "";
        
        System.out.println("Escriba una nueva contraseña. No escriba nada si no la quiere cambiar");

        pass = input.next();

        if (pass.length() > 0) {
            System.out.println("Vuelva a escribir su nueva contraseña");
            probar = input.next();

            if (pass.equals(probar)) {
                try {
                    iniciaOperacion();

                    Usuario user = new Usuario(1, "admin", hash(pass));
                    getSesion().update(user);

                } catch (HibernateException he) {
                    manejaExcepcion(he);
                    throw he;
                } finally {
                    finalizaOperacion();
                }

            } else {
                System.out.println("No coinciden");
            }
        }
    }

    public void accesoAplicacion() {

        Scanner input = new Scanner(System.in);
        String usuario = "admin";
        String pass = "";
        int salir=0;

        try {
            iniciaOperacion();

            Usuario user=(Usuario) getSesion().get(Usuario.class, 1);
            pass=user.getContrasena();
            
            do{
                System.out.println("Introducir contraseña: ");
                if(input.next().equals(pass)){
                    salir=1;
                }else{
                    System.out.println("No coincide la contraseña");
                }
                
            }while(salir==0);

        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            finalizaOperacion();
        }

    }

}
