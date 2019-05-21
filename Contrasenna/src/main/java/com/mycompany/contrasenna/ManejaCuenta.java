/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.contrasenna;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.hibernate.HibernateException;
import org.hibernate.Query;

/**
 *
 * @author usuario
 */

public class ManejaCuenta extends Maneja{
    
       private static final char[] HEXADECIMAL = { '0', '1', '2', '3',
        '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
    
    public void crearClave(){

        Scanner input = new Scanner(System.in);
        String descrip = "";
        String pass = "";

        System.out.println("Nueva Cuenta");
        System.out.println("Contraseña: ");

        pass = input.next();

        System.out.println("Descripcion: ");
        descrip = input.next();

        /*Cuenta cuenta=new Cuenta();
        //cuenta.setId(1);
        cuenta.setIdUser(1);
        cuenta.setContrasena(pass);
        cuenta.setNombre(descrip);*/
        try {
            iniciaOperacion();

            /*
            getSesion().createQuery("INSERT INTO Cuenta (id_user ,contrasena, nombre) "
                    + "VALUES (" + 1 + ",'" + pass + "','" + descrip + "');");
             */
            
            Query query = getSesion().createSQLQuery("INSERT INTO CUENTA (id_user, contrasena, nombre) VALUES (:valor1, :valor2, :valor3)");
            query.setParameter("valor1", 1);
            query.setParameter("valor2", pass);
            query.setParameter("valor3", descrip);
            query.executeUpdate();


        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            finalizaOperacion();
        }

    }

    
    
    
    
     public String hash(String stringToHash) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] bytes = md.digest(stringToHash.getBytes());
            StringBuilder sb = new StringBuilder(2 * bytes.length);
            for (int i = 0; i < bytes.length; i++) {
                int low = (int) (bytes[i] & 0x0f);
                int high = (int) ((bytes[i] & 0xf0) >> 4);
                sb.append(HEXADECIMAL[high]);
                sb.append(HEXADECIMAL[low]);
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            //exception handling goes here
            return null;
        }
    }



    public void listarClaves() {

        List<Cuenta> lista = ObtenerClaves();
        for (int i = 0; i < lista.size(); i++) {

            Cuenta cuenta = lista.get(i);

            System.out.println("\nID: " + cuenta.getId());
            System.out.println("Contraseña: " + cuenta.getContrasena());
            System.out.println("Descripcion: " + cuenta.getNombre());
            System.out.println("");


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
