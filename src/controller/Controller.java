/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static java.awt.SystemColor.text;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.BaseDeDonnees;
import model.Etudiant;
import model.Note;
import model.PersonneResponsable;
import model.RequetesSQL;
import view.FenetreAdmin;
import view.FenetreModification;

/**
 *
 * @author Quentin Lathaud
 */
public class Controller {
    private static BaseDeDonnees bd = new BaseDeDonnees("jdbc:mysql://localhost/bddprojet","root","");
    
    public static class ControllerFenetreAdmin implements ActionListener{
            private FenetreAdmin fA;
            
            public ControllerFenetreAdmin(FenetreAdmin fA){
                this.fA=fA;
            }
            public void actionPerformed(ActionEvent ae)
            {
               
            }
            

        
   }
    
    
   public static class ControllerAjout implements ActionListener{
            private FenetreModification fm;
            
            public ControllerAjout(FenetreModification fm){
                this.fm=fm;
            }
            public void actionPerformed(ActionEvent ae)
            {
                RequetesSQL queries = new RequetesSQL(bd);
                Etudiant etudiant = new Etudiant("",fm.getTfNom(),fm.getTfPrenom(),fm.getCbDateNaissance(),fm.getTfVilleNaissance(),fm.getTfPaysNaissance(),fm.getSexe(),fm.getCbDateInscription(),fm.getSelectedClasse().getNiveauClasse(),fm.getTfEtablissementPrecedent(),fm.getTfAdresse(),fm.getTfVille(),fm.getTfPays(),fm.getTfCodePostal(),fm.getSelectedMedecin(),new ArrayList<String>(),new ArrayList<String>(),fm.getSelectedClasse().getIdClasse());
                etudiant.setMatricule(etudiant.buildMatricule(fm.getTfPrenom(),fm.getTfNom(),fm.getCbDateInscription(),fm.getSexe()));
                int newId=0;
                try {
                    newId=queries.getMaxIDPersonneResponsable()+1;
                } catch (SQLException ex) {
                    newId=1;
                }
                PersonneResponsable pr1 = new PersonneResponsable(newId,fm.getTfNomContact1(),fm.getTfPrenomContact1(),fm.getTfAdresseContact1(),fm.getTfCodePostalContact1(),fm.getTfVilleContact1(),fm.getTfTelephoneDomicileContact1(),fm.getTfTelephoneMobileContact1(),fm.getTfEmailContact1(),etudiant.getMatricule());
                PersonneResponsable pr2 = new PersonneResponsable(newId+1,fm.getTfNomContact2(),fm.getTfPrenomContact2(),fm.getTfAdresseContact2(),fm.getTfCodePostalContact2(),fm.getTfVilleContact2(),fm.getTfTelephoneDomicileContact2(),fm.getTfTelephoneMobileContact2(),fm.getTfEmailContact2(),etudiant.getMatricule());
                System.out.println(etudiant.toString());
                try {
                    queries.insererEtudiant(etudiant);
                    queries.insererPersonneResponsable(pr1);
                    queries.insererPersonneResponsable(pr2);
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
                  
                
            }
            

        
   }
  /* //Ajouter des notes pour un élève non existant
   public void actionPerformed(){
       RequetesSQL queries = new RequetesSQL(bd);
       ArrayList<Note> notes = getListeNotes();
       int i;
       for(i=0;i<notes.size();i++){
           queries.insererNote(notes.get(i));
       }
   }*/
    
}
