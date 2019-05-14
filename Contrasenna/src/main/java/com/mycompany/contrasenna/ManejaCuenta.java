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
public class ManejaCuenta extends Maneja{
    
    
    public void crearClave(){
        
        Scanner input = new Scanner(System.in);
        String descrip = "";
        String pass = "";
        
        
        System.out.println("Nueva Cuenta");
        System.out.println("Contraseña: ");
        
        pass=input.next();
        
        System.out.println("Descripcion: ");
        descrip=input.next();
        
        Cuenta cuenta=new Cuenta();
        
        cuenta.setIdUser(1);
        cuenta.setContrasena(pass);
        cuenta.setNombre(descrip);
        
        try {
            iniciaOperacion();

            getSesion().save(cuenta);

        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            finalizaOperacion();
        }
        
    }
    
}
