/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.contrasenna;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.hibernate.HibernateException;

/**
 *
 * @author usuario
 */
public class ManejaCuenta extends Maneja {

    public void crearClave() {

        Scanner input = new Scanner(System.in);
        String descrip = "";
        String pass = "";

        System.out.println("Nueva Cuenta");
        System.out.println("Contraseña: ");

        pass = input.next();

        System.out.println("Descripcion: ");
        descrip = input.next();

        /*Cuenta cuenta=new Cuenta();
        
        cuenta.setIdUser(1);
        cuenta.setContrasena(pass);
        cuenta.setNombre(descrip);*/
        try {
            iniciaOperacion();

            getSesion().createSQLQuery("INSERT INTO Cuenta (id_user ,contrasena, nombre )\n"
                    + "VALUES (" + 1 + ",'" + pass + "','" + descrip + "');");

        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            finalizaOperacion();
        }

    }

    public void listarClaves() {

        List<Cuenta> lista = ObtenerClaves();
        for (int i = 0; i < 10; i++) {

            Cuenta cuenta = lista.get(i);

            System.out.println("ID: " + cuenta.getId());
            System.out.println("Contraseña: " + cuenta.getContrasena());
            System.out.println("Descripcion: " + cuenta.getNombre());

        }
    }

    private List<Cuenta> ObtenerClaves() {

        List<Cuenta> lista = new ArrayList<>();
        try {
            iniciaOperacion();

            lista = getSesion().createQuery("from Cuenta").list();

        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            finalizaOperacion();
        }

        return lista;

    }

}
