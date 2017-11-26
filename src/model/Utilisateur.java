/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Quentin Lathaud
 */
public class Utilisateur {
    private String username;
    private String password;
    private String droit;
    
    public Utilisateur(String username, String password, String droit){
        this.username = username;
        this.password = password;
        this.droit = droit;
    }
    
    public Utilisateur(String username, String password){
        this.username = username;
        this.password = password;
    }
    
    
    public Utilisateur(){}
    
    public String getUsername(){
        return username;
    }
    
    public String getPassword(){
        return password;
    }
    
    public String getDroit(){
        return droit;
    }
}
