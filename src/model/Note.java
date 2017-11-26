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
public class Note {
    private int idMatiere;
    private String matriculeUtilisateur;
    private float valeurNote;

    public Note(int idMatiere, String matriculeUtilisateur, float valeurNote) {
        this.idMatiere = idMatiere;
        this.matriculeUtilisateur = matriculeUtilisateur;
        this.valeurNote = valeurNote;
    }

    public int getIdMatiere() {
        return idMatiere;
    }

    public String getMatriculeUtilisateur() {
        return matriculeUtilisateur;
    }

    public float getValeurNote() {
        return valeurNote;
    }
    
    
}
