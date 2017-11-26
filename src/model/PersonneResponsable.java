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
public class PersonneResponsable {
    private int id;
    private String nom;
    private String prenom;
    private String adresse;
    private String codePostal;
    private String ville;
    private String telDomicile;
    private String telMobile;
    private String email;
    private String responsableDe;
	
    
    public PersonneResponsable(int id,String nom,String prenom,String adresse,String codePostal,String ville,String telDomicile,String telMobile,String email,String responsableDe){
        this.id=id;
        this.nom=nom;
        this.prenom=prenom;
        this.adresse=adresse;
        this.codePostal=codePostal;
        this.ville=ville;
        this.telDomicile=telDomicile;
        this.telMobile=telMobile;
        this.email=email;
        this.responsableDe=responsableDe;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public String getVille() {
        return ville;
    }

    public String getTelDomicile() {
        return telDomicile;
    }

    public String getTelMobile() {
        return telMobile;
    }

    public String getEmail() {
        return email;
    }

    public String getResponsableDe() {
        return responsableDe;
    }
    
    
    

}
