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
public class Vaccin {
    private int idVaccin;
    private String nomVaccin;
    private String matriculeUtilisateur;

    public Vaccin(int idVaccin, String nomVaccin, String matriculeUtilisateur) {
        this.idVaccin = idVaccin;
        this.nomVaccin = nomVaccin;
        this.matriculeUtilisateur = matriculeUtilisateur;
    }

    public int getIdVaccin() {
        return idVaccin;
    }

    public String getNomVaccin() {
        return nomVaccin;
    }

    public String getMatriculeUtilisateur() {
        return matriculeUtilisateur;
    }
    
    
}
