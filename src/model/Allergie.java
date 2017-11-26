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
public class Allergie {
    private int idAllergie;
    private String nomAllergie;
    private String matriculeUtilisateur;

    public Allergie(int idAllergie, String nomAllergie, String matriculeUtilisateur) {
        this.idAllergie = idAllergie;
        this.nomAllergie = nomAllergie;
        this.matriculeUtilisateur = matriculeUtilisateur;
    }

    public int getIdAllergie() {
        return idAllergie;
    }

    public String getNomAllergie() {
        return nomAllergie;
    }

    public String getMatriculeUtilisateur() {
        return matriculeUtilisateur;
    }
    
    
}
