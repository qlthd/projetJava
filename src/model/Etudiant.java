/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.sql.Date;


/**
 *
 * @author 20170027
 */
public class Etudiant {
    private String matricule;
    private String nom;
    private String prenom;                                                              
    private Date dateNaissance;
    private String villeNaissance;
    private String paysNaissance;
    private boolean sexe;
    private Date dateInscription;
    private String classe;
    private String etablissementPrecedent;
    private Medecin med;
    private String adresse;
    private String ville;
    private String pays;
    private String codePostal;
    private ArrayList<String> vaccins;
    private ArrayList<String> allergies;
    private int idClasse;

    public Etudiant(String matricule, String nom, String prenom, Date dateNaissance, String villeNaissance, String paysNaissance, boolean sexe, Date dateInscription, String classe, String etablissementPrecedent,String adresse,String ville,String pays,String codePostal,Medecin medecin, ArrayList<String> vaccins, ArrayList<String> allergies, int idClasse) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.villeNaissance = villeNaissance;
        this.paysNaissance = paysNaissance;
        this.sexe = sexe;
        this.dateInscription = dateInscription;
        this.classe = classe;
        this.etablissementPrecedent = etablissementPrecedent;
        this.adresse=adresse;
        this.ville=ville;
        this.pays=pays;
        this.codePostal=codePostal;
        this.med = medecin;
        this.vaccins = vaccins;
        this.allergies = allergies;
        this.matricule = matricule;
        this.idClasse=idClasse;
    }
    
    public Etudiant(String nom, String prenom){
        this.nom=nom;
        this.prenom=prenom;
    
    }
    
    public Etudiant(String matricule,String nom, String prenom,Date dateNaissance,String villeNaissance,String paysNaissance,boolean sexe,Date dateInscription,String classe,String etablissementPrecedent){
        this.matricule=matricule;
        this.nom=nom;
        this.prenom=prenom;
        this.dateNaissance=dateNaissance;
        this.villeNaissance =villeNaissance;
        this.paysNaissance = paysNaissance;
        this.sexe=sexe;
        this.dateInscription=dateInscription;
        this.classe=classe;
        this.etablissementPrecedent=etablissementPrecedent;
        
    }

    public Etudiant(String matricule, String nom, String prenom) {
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
    }
    
    
    public void setMatricule(String matricule){
        this.matricule=matricule;
    }
    public String getMatricule(){
        return matricule;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }
    public int getIdClasse(){
        return idClasse;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public String getVilleNaissance() {
        return villeNaissance;
    }

    public String getPaysNaissance() {
        return paysNaissance;
    }

    public boolean getSexe() {
        return sexe;
    }

    public Date getDateInscription() {
        return dateInscription;
    }

    
    public String getEtablissementPrecedent() {
        return etablissementPrecedent;
    }
    
    public String getAdresse(){
        return adresse;
    }
    
    public String getVille(){
        return ville;
    }
    
    public String getPays(){
        return pays;
    }
    
    public String getCodePostal(){
        return codePostal;
    }
    

    public Medecin getMedecin() {
        return med;
    }

    public ArrayList<String> getVaccins() {
        return vaccins;
    }

    public ArrayList<String> getAllergies() {
        return allergies;
    }

    @Override
    public String toString() {
        return "Etudiant{" + "matricule=" + matricule + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance=" + dateNaissance + ", villeNaissance=" + villeNaissance + ", paysNaissance=" + paysNaissance + ", sexe=" + sexe + ", dateInscription=" + dateInscription + ", classe=" + classe + ", etablissementPrecedent=" + etablissementPrecedent + ", med=" + med + ", vaccins=" + vaccins + ", allergies=" + allergies + ", idClasse=" + idClasse + '}';
    }
    
    public String buildMatricule(String prenom,String nom,Date dateInscription,boolean genre){
        String matricule = new String();
        prenom=prenom.toUpperCase();
        nom=nom.toUpperCase();
        String lettreGenre;
        if(genre){
            lettreGenre= new String("F");
        }
        else{
            lettreGenre=new String("M");
        }
        
        matricule += String.valueOf(prenom.charAt(0))+String.valueOf(prenom.charAt(1))+String.valueOf(nom.charAt(0))+String.valueOf(nom.charAt(1))+String.valueOf(nom.charAt(2))+String.valueOf(dateInscription.getYear())+lettreGenre;
        return matricule;
    }

}
