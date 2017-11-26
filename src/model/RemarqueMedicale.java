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
public class RemarqueMedicale {
    private int idRemarque;
    private String texteRemarque;
    private int idMedecin;
    private String matriculeUtilisateur;

    public RemarqueMedicale(int idRemarque, String texteRemarque, int idMedecin, String matriculeUtilisateur) {
        this.idRemarque = idRemarque;
        this.texteRemarque = texteRemarque;
        this.idMedecin = idMedecin;
        this.matriculeUtilisateur = matriculeUtilisateur;
    }

    public int getIdRemarque() {
        return idRemarque;
    }

    public String getTexteRemarque() {
        return texteRemarque;
    }

    public int getIdMedecin() {
        return idMedecin;
    }

    public String getMatriculeUtilisateur() {
        return matriculeUtilisateur;
    }
    
    
    
}
