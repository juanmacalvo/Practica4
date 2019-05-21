/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.contrasenna;

/**
 *
 * @author usuario
 */
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Random;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import static javax.xml.bind.DatatypeConverter.printBase64Binary;

public class PasswordUtils {

    public String generateSecurePassword(String password) {



        String returnValue = Base64.getEncoder().encodeToString(password.getBytes());


        return returnValue;
    }

    public boolean VerifyProvidedPassword(String providedPassword, String encodificada) {


        return encodificada.equalsIgnoreCase(generateSecurePassword(providedPassword));
        

    
    }
    
    public String mostrarContra(String pass){
        
        return new String(Base64.getDecoder().decode(pass));
        
    }
}
