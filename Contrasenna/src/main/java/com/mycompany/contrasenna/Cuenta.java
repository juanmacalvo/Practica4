package com.mycompany.contrasenna;
// Generated 07-may-2019 20:29:44 by Hibernate Tools 4.3.1

import javax.persistence.*;




/**
 * Cuenta generated by hbm2java
 */
public class Cuenta  implements java.io.Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int id;
     private int idUser;
     private String contrasena;
     private String nombre;

    public Cuenta() {
    }

    public Cuenta(int id, int idUser, String contrasena, String nombre) {
       this.id = id;
       this.idUser = idUser;
       this.contrasena = contrasena;
       this.nombre = nombre;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public int getIdUser() {
        return this.idUser;
    }
    
    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
    public String getContrasena() {
        return this.contrasena;
    }
    
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }




}


