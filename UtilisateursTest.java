/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.pb.entities;

/**
 *
 * @author vanessa
 */
public class UtilisateursTest {
    
    public static void main(String[] args) {
        
        Utilisateurs vs = new Utilisateurs();
        
        vs.setPseudo("vs");
        vs.setMdp("123");
        vs.setEmail("vs@mail.com");
        vs.setQualite("POO");
        
        System.out.println(vs.getPseudo());
        System.out.println(vs.getMdp());
        System.out.println(vs.getEmail());
        System.out.println(vs.getQualite());
        
        System.out.println("*****************");
        
        
                
    }
    
}
