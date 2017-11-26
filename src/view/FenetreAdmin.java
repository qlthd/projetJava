package view;


import controller.Controller;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import static javax.swing.BorderFactory.createEmptyBorder;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu.Separator;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import model.BaseDeDonnees;
import model.Etudiant;
import model.RequetesSQL;
import model.Utilisateur;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Quentin Lathaud
 */
public class FenetreAdmin extends JFrame{
    
    private JButton boutonRetour= new JButton("Retour");
    private JLabel printImage = new JLabel(new ImageIcon("src/images/print.png"));
    private JButton editImage = new JButton(new ImageIcon("src/images/edit.png"));
    private JLabel deleteImage = new JLabel(new ImageIcon("src/images/delete.png"));
    private static JPanel c1 = new JPanel();
    private static JPanel c2 = new JPanel();
    private static JPanel mainPanel = new JPanel();
    private static JTextField t = new JTextField();
    private Font police = new Font("Segoe UI Semilight",Font.PLAIN,25);
    private Font title = new Font("Segoe UI Semilight",Font.BOLD,30);
    private static JPanel middlePanel = new JPanel(new BorderLayout());
    private static JPanel buttonsContainer = new JPanel(new GridLayout(5,1));
    private static JPanel topPanel = new JPanel(new BorderLayout(300,300));
    
    public FenetreAdmin(){
        this.setTitle("Interface Admin");
        this.setSize(1920, 1080);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        boutonRetour.setFont(police);

       
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(printImage);
        buttonsPanel.add(Box.createVerticalStrut(100));
        buttonsPanel.add(Box.createHorizontalStrut(20));
        buttonsPanel.add(editImage);
        buttonsPanel.add(Box.createHorizontalStrut(20));
        buttonsPanel.add(deleteImage);
        buttonsPanel.add(Box.createHorizontalStrut(20));
        buttonsPanel.add(boutonRetour);
        buttonsPanel.add(Box.createHorizontalStrut(30));
        
        topPanel.add(buttonsPanel, BorderLayout.EAST);
        JPanel choixClasse = new JPanel();
        JLabel labelFiltre = new JLabel("Filtre :");
        labelFiltre.setFont(police);
        JComboBox filtreClasse = new JComboBox();
        filtreClasse.setFont(police);
        filtreClasse.addItem("Classe1");
        filtreClasse.addItem("Classe2");
        choixClasse.add(Box.createHorizontalStrut(20));
        choixClasse.add(Box.createVerticalStrut(100));
        choixClasse.add(labelFiltre);
        choixClasse.add(filtreClasse);
        topPanel.add(choixClasse, BorderLayout.WEST);
        
        BaseDeDonnees bd = new BaseDeDonnees("jdbc:mysql://localhost/bddjava","root","");
        RequetesSQL queries = new RequetesSQL(bd);
        ArrayList<Etudiant> etudiants = new ArrayList();
        try {
            etudiants=queries.getEtudiants();
        } catch (SQLException ex) {
            Logger.getLogger(FenetreAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        try{
            int n;
            buttonsContainer.setLayout(new BoxLayout(buttonsContainer, BoxLayout.Y_AXIS));
            for(n=0;n<etudiants.size();n++){
                JButton b1 = new JButton(etudiants.get(n).getPrenom()+" "+etudiants.get(n).getNom());
                b1.setFont(police);
                b1.setBorder(new EmptyBorder(15, 15, 15, 15));
                b1.setPreferredSize(new Dimension(300,100));
                b1.addActionListener(new ActionListener()
            {
                    @Override
                public void actionPerformed(ActionEvent ae)
                {
                  BaseDeDonnees bd = new BaseDeDonnees("jdbc:mysql://localhost/bddprojet","root","");
                  RequetesSQL queries = new RequetesSQL(bd);
                  Etudiant etudiantTemp = new Etudiant(b1.getText(),"");
                  Etudiant etudiant =new Etudiant("none","none");
                  try {
                    etudiant=queries.getEtudiant(etudiantTemp);
                  } catch (SQLException ex) {
                        Logger.getLogger(FenetreAdmin.class.getName()).log(Level.SEVERE, null, ex);
                  }
                  try{
                    System.out.println(etudiant.getMatricule());
                }
                catch(NullPointerException exx){
                    JOptionPane.showMessageDialog(new JFrame(),"Erreur BDD !");
                }
//                  System.out.println(etudiant.getNom());
                  createInfos(etudiant);  
                  mainPanel.removeAll();
                  mainPanel.add(topPanel);
                  mainPanel.add(middlePanel);
                  mainPanel.repaint();
                  mainPanel.revalidate();
                  setPane(mainPanel);
                }
            });
                buttonsContainer.add(b1);
            }
            
        }
        catch(NullPointerException exx){
            JOptionPane.showMessageDialog(new JFrame(),"Erreur BDD !");
        }
                     
        int i;
        
        JScrollPane ss = new JScrollPane(buttonsContainer);
        ss.setBorder(createEmptyBorder());
        middlePanel.add(ss,BorderLayout.WEST);
        
        
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(topPanel);       
        mainPanel.add(middlePanel);
        this.setContentPane(mainPanel);
        this.setVisible(true);
    }
    
    public void setPane(JPanel jp){
        //this.getContentPane().removeAll();
        this.setContentPane(jp);
     //   this.getContentPane().repaint();
      //  this.getContentPane().revalidate();
        
    }
    
   public void setLabelParameters(JLabel lb, Font police, EmptyBorder b){
       lb.setFont(police);
       lb.setBorder(b);
       
   }
   
   public JPanel createContainerLabelTextField(JLabel label, Font police){
        JPanel c = new JPanel();
        c.setLayout(new BoxLayout(c, BoxLayout.X_AXIS));
        JPanel ct = new JPanel();
        
        t.setFont(police);
        ct.setLayout(new BoxLayout(ct, BoxLayout.X_AXIS));
        ct.setBorder(new EmptyBorder(0,0,0,1100));
        ct.add(t);
        ct.setPreferredSize(new Dimension(50,30));
      
        c.add(label);
        c.add(ct);
        return c;
   }
   
   public void createInfos(Etudiant etudiant){
        
       
        EmptyBorder brd = new EmptyBorder(0,0,20,0);
        EmptyBorder smallBrd = new EmptyBorder(0,0,5,0);
        
        JPanel infosContainer = new JPanel(new GridLayout(16,0));
        infosContainer.setLayout(new BoxLayout(infosContainer, BoxLayout.Y_AXIS));
        
        
        JLabel labelIdentite = new JLabel("Identite");
        setLabelParameters(labelIdentite,title,smallBrd);
        
        JLabel labelNom = new JLabel("Nom : "+etudiant.getNom());
        setLabelParameters(labelNom,police,brd);
        //c1=createContainerLabelTextField(labelNom,police);
       
        JLabel labelPrenom = new JLabel("Prenom : " +etudiant.getPrenom());
        setLabelParameters(labelPrenom,police,brd);
        //c2=createContainerLabelTextField(labelPrenom,police);
        
        
        JLabel labelAge = new JLabel("Age : ");
        setLabelParameters(labelAge,police,brd);
        JLabel labelDateNaissance = new JLabel("Date de naissance : " +etudiant.getDateNaissance());
        setLabelParameters(labelDateNaissance,police,brd);
        JLabel labelVilleNaissance = new JLabel("Ville de naissance : " +etudiant.getVilleNaissance());
        setLabelParameters(labelVilleNaissance,police,brd);
        JLabel labelPaysNaissance = new JLabel("Pays de naissance : " +etudiant.getPaysNaissance());
        setLabelParameters(labelPaysNaissance,police,brd);
        JLabel labelSexe = new JLabel("Sexe : " + etudiant.getSexe());
        setLabelParameters(labelSexe,police,brd);
        JLabel labelDateInscription = new JLabel("Date d'inscription : ");
        setLabelParameters(labelDateInscription,police,brd);
        JLabel labelEtablissementPrecedent = new JLabel("Établissement précédent : " + etudiant.getEtablissementPrecedent());
        setLabelParameters(labelEtablissementPrecedent,police,brd);
        JLabel labelAdresse = new JLabel ("Adresse : ");
        setLabelParameters(labelAdresse,police,brd);
        JLabel labelCodePostal = new JLabel("Code Postal : ");
        setLabelParameters(labelCodePostal,police,brd);
        JLabel labelVille = new JLabel("Ville : ");
        setLabelParameters(labelVille,police,brd);
        JLabel labelTelDomicile = new JLabel("Téléphone Domicile : ");
        setLabelParameters(labelTelDomicile,police,brd);
        JLabel labelTelMobile = new JLabel("Téléphone Mobile : ");
        setLabelParameters(labelTelMobile,police,brd);
        JLabel labelEmail = new JLabel("Email : ");
        setLabelParameters(labelEmail,police,brd);
        JLabel labelContact1 = new JLabel("Contact 1 ");
        setLabelParameters(labelContact1,title,smallBrd);
        JLabel labelNomContact1 = new JLabel("Nom : ");
        setLabelParameters(labelNomContact1,police,brd);
        JLabel labelPrenomContact1 = new JLabel("Prénom : ");
        setLabelParameters(labelPrenomContact1,police,brd);
        JLabel labelAdresseContact1 = new JLabel("Adresse : ");
        setLabelParameters(labelAdresseContact1,police,brd);
        JLabel labelTelephoneContact1 = new JLabel("Téléphone : ");
        setLabelParameters(labelTelephoneContact1,police,brd);
        JLabel labelEmailContact1 = new JLabel("Email : ");
        setLabelParameters(labelEmailContact1,police,brd);
        JLabel labelContact2 = new JLabel("Contact 2 ");
        setLabelParameters(labelContact2,title,smallBrd);
        JLabel labelNomContact2 = new JLabel("Nom : ");
        setLabelParameters(labelNomContact2,police,brd);
        JLabel labelPrenomContact2 = new JLabel("Prénom : ");
        setLabelParameters(labelPrenomContact2,police,brd);
        JLabel labelAdresseContact2 = new JLabel("Adresse : ");
        setLabelParameters(labelAdresseContact2,police,brd);
        JLabel labelTelephoneContact2 = new JLabel("Téléphone : ");
        setLabelParameters(labelTelephoneContact2,police,brd);
        JLabel labelEmailContact2 = new JLabel("Email : ");
        setLabelParameters(labelEmailContact2,police,brd);
        JLabel labelSante = new JLabel("Santé ");
        setLabelParameters(labelSante,title,smallBrd);
        JLabel labelIdentiteMedecin = new JLabel("Nom/Prénom du médecin traitan : ");
        setLabelParameters(labelIdentiteMedecin,police,brd);
        JLabel labelTelephoneMedecin = new JLabel("Téléphone du médecin : ");
        setLabelParameters(labelTelephoneMedecin,police,brd);
        JLabel labelVaccinations = new JLabel("Vaccinations ");
        setLabelParameters(labelVaccinations,police,brd);
        JLabel labelAllergies = new JLabel("Allergies : ");
        setLabelParameters(labelAllergies,police,brd);
        JLabel labelRemarquesMedicales = new JLabel("Remarques médicales : ");
        setLabelParameters(labelRemarquesMedicales,police,brd);

        //labelAge.setFont(police);
        //labelPrenom.setFont(police);
        infosContainer.add(labelIdentite);
        infosContainer.add(new Separator());
        infosContainer.add(labelNom);
        infosContainer.add(labelPrenom);
        infosContainer.add(labelAge);
        infosContainer.add(labelDateNaissance);
        infosContainer.add(labelVilleNaissance);
        infosContainer.add(labelPaysNaissance);
        infosContainer.add(labelSexe);
        infosContainer.add(labelDateInscription);
        infosContainer.add(labelEtablissementPrecedent);
        infosContainer.add(labelAdresse);
        infosContainer.add(labelCodePostal);
        infosContainer.add(labelVille);
        infosContainer.add(labelTelDomicile);
        infosContainer.add(labelTelMobile);
        infosContainer.add(labelEmail);
        infosContainer.add(labelContact1);
        infosContainer.add(new Separator());
        infosContainer.add(labelNomContact1);
        infosContainer.add(labelPrenomContact1);
        infosContainer.add(labelAdresseContact1);
        infosContainer.add(labelTelephoneContact1);
        infosContainer.add(labelEmailContact1);
        
        infosContainer.add(labelContact2);
        infosContainer.add(new Separator());
        infosContainer.add(labelNomContact2);
        infosContainer.add(labelPrenomContact2);
        infosContainer.add(labelAdresseContact2);
        infosContainer.add(labelTelephoneContact2);
        infosContainer.add(labelEmailContact2);
        
        infosContainer.add(labelSante);
        infosContainer.add(new Separator());
        infosContainer.add(labelIdentiteMedecin);
        infosContainer.add(labelTelephoneMedecin);
        infosContainer.add(labelVaccinations);
        infosContainer.add(labelAllergies);
        infosContainer.add(labelRemarquesMedicales);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        infosContainer.setBorder(new EmptyBorder(0, 50, 150, 15));
        JScrollPane infosScroll = new JScrollPane(infosContainer); 
        infosScroll.setBorder(createEmptyBorder());
       // infosContainer.setBackground(Color.BLUE);
                
                
                
                
       
    
       //infosScroll.setBorder(border);
        middlePanel.add(infosScroll);
        middlePanel.setBackground(Color.red);
        boutonRetour.addActionListener ( new ActionListener (){
            
            public void actionPerformed(ActionEvent e)
            {
                dispose();
                
                
            }
            
        });
        
        editImage.setBackground(null);
        editImage.setBorderPainted(false);
        editImage.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                /*System.out.println("ah");
                JPanel ct = new JPanel();
                JTextField t = new JTextField();
                t.setFont(police);
                ct.setLayout(new BoxLayout(ct, BoxLayout.X_AXIS));
                ct.setBorder(new EmptyBorder(0,0,0,1100));
                ct.add(t);
                ct.setPreferredSize(new Dimension(50,30));
                c1.add(ct);
                
                c2.add(ct);
                c1.revalidate();
                c1.repaint();
                */;
                try {                
                    FenetreModification fm = new FenetreModification();
                } catch (SQLException ex) {
                    Logger.getLogger(FenetreAdmin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        

   }
   
}
