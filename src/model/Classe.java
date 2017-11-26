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
public class Classe {
    private int idClasse;
    private String niveauClasse;
    
    public Classe(int idClasse,String niveauClasse){
        this.idClasse=idClasse;
        this.niveauClasse=niveauClasse;
    }
    
    public String getNiveauClasse(){
        return niveauClasse;
    }
    
    public int getIdClasse(){
        return idClasse;
    }
    
    public String toString(){
        return this.niveauClasse;
    }
}
