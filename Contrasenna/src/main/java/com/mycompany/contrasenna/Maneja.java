/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.contrasenna;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author usuario
 */
public class Maneja {

    private Session sesion;
    private Transaction tx;

    public Session getSesion() {
        return sesion;
    }

    public Transaction getTx() {
        return tx;
    }

    public void iniciaOperacion() throws HibernateException {
        System.out.println("Comenzando con Hibernate");
        sesion = NewHibernateUtil.getSessionFactory().openSession(); //iniciamos una sesion hibernate
        tx = sesion.beginTransaction(); // comienza la transaccion
    }

    public void finalizaOperacion() throws HibernateException {
        System.out.println("Finalizando con Hibernate");
        tx.commit();
        sesion.close();
    }

    public void manejaExcepcion(HibernateException he) throws HibernateException {
        tx.rollback();
        System.out.println("Ocurrió un error en la capa de acceso a datos " + he.getMessage());
        System.exit(0);
    }
    
    public void cerrarSesion(){
        NewHibernateUtil.getSessionFactory().close();
}
}
