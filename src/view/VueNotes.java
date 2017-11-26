/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.BaseDeDonnees;
import model.Matiere;
import model.Note;
import model.RequetesSQL;

/**
 *
 * @author Quentin Lathaud
 */
public class VueNotes extends JFrame {
    BaseDeDonnees bd = new BaseDeDonnees("jdbc:mysql://localhost/bddprojet","root","");
    RequetesSQL queries = new RequetesSQL(bd);
    public VueNotes(String matricule, int idMatiere) throws SQLException{
        JPanel jp = new JPanel();
        ArrayList<Note> listeNotes = new ArrayList<Note>();
        listeNotes=queries.getNotesEtudiantMatiere(matricule, idMatiere);
        
        JLabel labelNote1 = new JLabel("Note 1 : ");
        JTextField tfNote1 = new JTextField();
        JPanel mainPanel = new JPanel();
        JButton boutonAjouterNote = new JButton("Ajouter note");
        JButton boutonValider = new JButton("Valider");
        boutonAjouterNote.addActionListener(new ActionListener() {
                    
                public void actionPerformed(ActionEvent e) {
                    mainPanel.add(new JLabel("Note : "));
                    mainPanel.add(new JTextField(""));
                    mainPanel.revalidate();
                }
                });
        mainPanel.add(boutonAjouterNote);
        mainPanel.add(labelNote1);
        mainPanel.add(tfNote1);
        mainPanel.add(boutonValider);
        if(listeNotes!=null){
            tfNote1.setText(String.valueOf(listeNotes.get(0).getValeurNote()));
            int i;
            for(i=1;i<listeNotes.size();i++){
                JLabel labelNote = new JLabel("Note "+(i+1)+" : ");
                JTextField tfNote = new JTextField(String.valueOf(listeNotes.get(i).getValeurNote()));
                mainPanel.add(labelNote);
                mainPanel.add(tfNote);
            }
            
        }
        
        boutonValider.addActionListener(new ActionListener() {
                    
                public void actionPerformed(ActionEvent e) {
                    mainPanel.add(new JLabel("Note : "));
                    mainPanel.add(new JTextField(""));
                    mainPanel.revalidate();
                }
                });
        
        
        
        
        
        this.setContentPane(mainPanel);
        this.setVisible(true);
        
        
       
    }
}
