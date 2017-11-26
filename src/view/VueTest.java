/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.BaseDeDonnees;
import model.Etudiant;
import model.Matiere;
import model.RequetesSQL;

/**
 *
 * @author Quentin Lathaud
 */
public class VueTest extends JFrame{
    JLabel jlabel = new JLabel();
    JLabel jlabel2 = new JLabel();
    CardLayout cardLayout = new CardLayout();
      BaseDeDonnees bd = new BaseDeDonnees("jdbc:mysql://localhost/bddprojet","root","");
        RequetesSQL queries = new RequetesSQL(bd);
    private static int i;
    private static int j;
    private static ArrayList<Matiere> listeMatieres = new ArrayList<Matiere>();
    private static ArrayList<Etudiant> etudiants = new ArrayList<Etudiant>();
    public VueTest() throws SQLException{
        JPanel mainPanel = new JPanel();
        JPanel affichage= new JPanel();
        affichage.setLayout(cardLayout);
        ButtonGroup bGroup = new ButtonGroup();
        
        listeMatieres.add(new Matiere(1,"francais"));
        for(i=0;i<listeMatieres.size();i++){
            JButton b = new JButton();
            b.setText(listeMatieres.get(i).getNomMatiere());
            b.setActionCommand(String.valueOf(listeMatieres.get(i).getIdMatiere()));
            bGroup.add(b);
            JPanel ligne = new JPanel();
            etudiants=queries.getEtudiantsMatiere(listeMatieres.get(i));
            for(j=0;j<etudiants.size();j++){
                System.out.println("1 :"+j);
                JButton boutonsEleves = new JButton("Consulter/Editer les notes en "+listeMatieres.get(i).getNomMatiere()+ " de "+ etudiants.get(j).getNom()+" "+etudiants.get(j).getPrenom());
                boutonsEleves.setActionCommand(String.valueOf(j));
                int n=i;
                int n2=j;
                boutonsEleves.addActionListener(new ActionListener() {
                    
                public void actionPerformed(ActionEvent e) {
                   try {
                        VueNotes vn = new VueNotes(etudiants.get(n2).getMatricule(),listeMatieres.get(n).getIdMatiere());
                    } catch (SQLException ex) {
                        Logger.getLogger(VueTest.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    
                }
                });
                ligne.add(boutonsEleves);
            }
            
            affichage.add(ligne,String.valueOf(listeMatieres.get(i).getIdMatiere()));
            b.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    cardLayout.show(affichage, String.valueOf(b.getActionCommand()));
                }
                });
           mainPanel.add(b);
           mainPanel.add(affichage);
        }
        
        this.setContentPane(mainPanel);
        this.setVisible(true);
    }
    
    public int getI(){
        return i;
    }
    
    public int getJ(){
        return j;
    }
}
