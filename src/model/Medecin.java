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
public class Medecin {
    private int idMedecin;
    private String nomMedecin;
    private String prenomMedecin;
    private String telMedecin;

    public Medecin(int idMedecin,String nomMedecin,String prenomMedecin,String telMedecin){
        this.idMedecin=idMedecin;
        this.nomMedecin=nomMedecin;
        this.prenomMedecin=prenomMedecin;
        this.telMedecin=telMedecin;
    }
    
    public String getNomMedecin(){
        return nomMedecin;
    }
    
    public int getIdMedecin(){
        return idMedecin;
    }
    
    public String getPrenomMedecin(){
        return prenomMedecin;   
    }
    
    public String getTelMedecin(){
        return telMedecin;   
    }
   
    public String toString(){
        return "Dr "+this.getPrenomMedecin()+" "+this.getNomMedecin();
    }
    
    
}
