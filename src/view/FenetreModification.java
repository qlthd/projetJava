/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Controller.ControllerAjout;
import controller.DateLabelFormatter;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import static javax.swing.BorderFactory.createEmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import model.BaseDeDonnees;
import model.Classe;
import model.Medecin;
import model.RequetesSQL;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

/**
 *
 * @author Quentin Lathaud
 */
public class FenetreModification extends JFrame {
    private Font police = new Font("Segoe UI Semilight",Font.PLAIN,25);
    private static JTextField tfRemarquesMedicales = new JTextField();
    private static JTextField tfNom= new JTextField();
    private static JTextField tfPrenom = new JTextField();
    private static JDatePickerImpl datePicker=getDatePicker();
    private static JTextField tfVilleNaissance = new JTextField();
    private static JTextField tfPaysNaissance = new JTextField();
    private static JTextField tfSexe = new JTextField();
    private static JDatePickerImpl datePicker2=getDatePicker();
    private static JTextField tfEtablissementPrecedent = new JTextField();
    private static JTextField tfAdresse = new JTextField();
    private static JTextField tfCodePostal = new JTextField();
    private static JTextField tfVille = new JTextField();
    private static JTextField tfTelDomicile = new JTextField();
    private static JTextField tfTelMobile = new JTextField();
    private static JTextField tfEmail = new JTextField();
    private static JTextField tfNomContact1 = new JTextField();
    private static JTextField tfPrenomContact1 = new JTextField();
    private static JTextField tfAdresseContact1 = new JTextField();
    private static JTextField tfTelephoneContact1 = new JTextField();
    private static JTextField tfEmailContact1 = new JTextField();
    private static JComboBox<Classe> cbClasse= new JComboBox<Classe>();
    private static JTextField tfNomContact2 = new JTextField();
    private static JTextField tfPrenomContact2 = new JTextField();
    private static JTextField tfAdresseContact2 = new JTextField(); 
    private static JTextField tfTelephoneContact2 = new JTextField();    
    private static JTextField tfEmailContact2 = new JTextField();
    private static JComboBox<Medecin> cbMedecins= new JComboBox<Medecin>();
    private static JTextField tfVaccinations = new JTextField();
    private static JTextField tfAllergies = new JTextField();
    private static JButton boutonValider = new JButton("Valider");
    private static JComboBox<String> cbSexe = new JComboBox<String>();
    private static JTextField tfPays = new JTextField();
    private static JTextField tfTelephoneDomicileContact1= new JTextField();
    private static JTextField tfTelephoneMobileContact1= new JTextField();
    private static JTextField tfTelephoneDomicileContact2= new JTextField();
    private static JTextField tfTelephoneMobileContact2= new JTextField();
    private static JTextField tfVilleContact1= new JTextField();
    private static JTextField tfCodePostalContact1= new JTextField();
    private static JTextField tfVilleContact2= new JTextField();
    private static JTextField tfCodePostalContact2= new JTextField();
    
    public FenetreModification() throws SQLException{
        this.setTitle("Interface Admin");
        this.setSize(700, 1080);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel mainPanel = new JPanel();
        EmptyBorder brd = new EmptyBorder(0,0,20,0);
        EmptyBorder smallBrd = new EmptyBorder(0,0,5,0);
        
        JPanel infosContainer = new JPanel(new GridLayout(16,0));
        infosContainer.setLayout(new BoxLayout(infosContainer, BoxLayout.Y_AXIS));
        
        
        JLabel labelIdentite = new JLabel("Identite");
        labelIdentite.setFont(police);
        
        JPanel c1 = new JPanel();
        JLabel labelNom = new JLabel("Nom : ");
        c1=createContainerLabelTextField(labelNom,tfNom,police);
        JPanel c2 = new JPanel();
        JLabel labelPrenom = new JLabel("Prenom : " );
        c2=createContainerLabelTextField(labelPrenom,tfPrenom,police);
        
        
    
        JPanel c3 = new JPanel();
        JLabel labelDateNaissance = new JLabel("Date de naissance : ");
        labelDateNaissance.setFont(police);
        c3.setLayout(new BoxLayout(c3, BoxLayout.X_AXIS));
        c3.add(labelDateNaissance);
        datePicker.setFont(police);
        c3.add(datePicker);
        
        
        JPanel c4 = new JPanel();
        JLabel labelVilleNaissance = new JLabel("Ville de naissance : ");
        c4=createContainerLabelTextField(labelVilleNaissance,tfVilleNaissance,police);
        
        
        JPanel c5 = new JPanel();
        JLabel labelPaysNaissance = new JLabel("Pays de naissance : " );
        c5=createContainerLabelTextField(labelPaysNaissance,tfPaysNaissance,police);
        
        JPanel c6 = new JPanel();
        JLabel labelSexe = new JLabel("Sexe : ");
        labelSexe.setFont(police);
        cbSexe.setFont(police);
        cbSexe.addItem(new String("Féminin"));
        cbSexe.addItem(new String("Masculin"));
        c6.add(labelSexe);
        c6.add(cbSexe);
        
        JPanel c7 = new JPanel();
        JLabel labelDateInscription = new JLabel("Date d'inscription : ");
        labelDateInscription.setFont(police);
        c7.setLayout(new BoxLayout(c7, BoxLayout.X_AXIS));
        c7.add(labelDateInscription);
        datePicker2.setFont(police);
        c7.add(datePicker2);
        
        JPanel c8 = new JPanel();
        JLabel labelEtablissementPrecedent = new JLabel("Établissement précédent : ");
        c8=createContainerLabelTextField(labelEtablissementPrecedent,tfEtablissementPrecedent,police);
        
        JPanel c9 = new JPanel();
        JLabel labelAdresse = new JLabel ("Adresse : ");
        c9=createContainerLabelTextField(labelAdresse,tfAdresse,police);
        
        JPanel c10 = new JPanel();
        JLabel labelCodePostal = new JLabel("Code Postal : ");
        c10=createContainerLabelTextField(labelCodePostal,tfCodePostal,police);
        
        JPanel c11 = new JPanel();
        JLabel labelVille = new JLabel("Ville : ");
        c11=createContainerLabelTextField(labelVille,tfVille,police);
        
        JPanel c32 = new JPanel();
        JLabel labelPays = new JLabel("Pays : ");
        c32=createContainerLabelTextField(labelPays,tfPays,police);
        
        JPanel c12 = new JPanel();
        JLabel labelTelDomicile = new JLabel("Téléphone Domicile : ");
        c12=createContainerLabelTextField(labelTelDomicile,tfTelDomicile,police);
        
        JPanel c13 = new JPanel();
        JLabel labelTelMobile = new JLabel("Téléphone Mobile : ");
        c13=createContainerLabelTextField(labelTelMobile,tfTelMobile,police);
                
        JPanel c14 = new JPanel();
        JLabel labelEmail = new JLabel("Email : ");
        c14=createContainerLabelTextField(labelEmail,tfEmail,police);

        
        JLabel labelContact1 = new JLabel("Contact 1 ");
        labelContact1.setFont(police);
        JPanel c15 = new JPanel();
        JLabel labelNomContact1 = new JLabel("Nom : ");
        c15=createContainerLabelTextField(labelNomContact1,tfNomContact1,police);
        
        JPanel c16 = new JPanel();
        JLabel labelPrenomContact1 = new JLabel("Prénom : ");
        c16=createContainerLabelTextField(labelPrenomContact1,tfPrenomContact1,police);
        
        JPanel c17 = new JPanel();
        JLabel labelAdresseContact1 = new JLabel("Adresse : ");
        c17=createContainerLabelTextField(labelAdresseContact1,tfAdresseContact1,police);
        
        JPanel c171 = new JPanel();
        JLabel labelVilleContact1 = new JLabel("Ville : ");
        c171=createContainerLabelTextField(labelVilleContact1,tfVilleContact1,police);
        
        JPanel c172 = new JPanel();
        JLabel labelCodePostalContact1 = new JLabel("Code Postal : ");
        c172=createContainerLabelTextField(labelCodePostalContact1,tfCodePostalContact1,police);
        
        JPanel c18 = new JPanel();
        JLabel labelTelephoneDomicileContact1 = new JLabel("Téléphone Domicile : ");
        c18=createContainerLabelTextField(labelTelephoneDomicileContact1,tfTelephoneDomicileContact1,police);
        
        JPanel c181 = new JPanel();
        JLabel labelTelephoneMobileContact1 = new JLabel("Téléphone Mobile : ");
        c181=createContainerLabelTextField(labelTelephoneMobileContact1,tfTelephoneMobileContact1,police);
        
        JPanel c19 = new JPanel();
        JLabel labelEmailContact1 = new JLabel("Email : ");
        c19=createContainerLabelTextField(labelEmailContact1,tfEmailContact1,police);
        
        JPanel c30 = new JPanel();
        JLabel labelClasse = new JLabel("Classe : ");
        labelClasse.setFont(police);
        BaseDeDonnees bd = new BaseDeDonnees("jdbc:mysql://localhost/bddprojet","root","");
        RequetesSQL queries = new RequetesSQL(bd);
        ArrayList <Classe> classes = queries.getClasses();
        int i;
        for(i=0;i<classes.size();i++){
            cbClasse.addItem(classes.get(i));
        }
        cbClasse.setFont(police);
        c30.setLayout(new BoxLayout(c30, BoxLayout.X_AXIS));
        c30.add(labelClasse);
        c30.add(cbClasse);
        
        
        JLabel labelContact2 = new JLabel("Contact 2 ");
        labelContact2.setFont(police);
        JPanel c20 = new JPanel();
        JLabel labelNomContact2 = new JLabel("Nom : ");
        c20=createContainerLabelTextField(labelNomContact2,tfNomContact2,police);
        
        JPanel c21 = new JPanel();
        JLabel labelPrenomContact2 = new JLabel("Prénom : ");
        c21=createContainerLabelTextField(labelPrenomContact2,tfPrenomContact2,police);
        
        JPanel c22 = new JPanel();
        JLabel labelAdresseContact2 = new JLabel("Adresse : ");
        c22=createContainerLabelTextField(labelAdresseContact2,tfAdresseContact2,police);
        
        JPanel c221 = new JPanel();
        JLabel labelVilleContact2 = new JLabel("Ville : ");
        c221=createContainerLabelTextField(labelVilleContact2,tfVilleContact2,police);
        
        JPanel c222 = new JPanel();
        JLabel labelCodePostalContact2 = new JLabel("Code Postal : ");
        c222=createContainerLabelTextField(labelCodePostalContact2,tfCodePostalContact2,police);
        
        JPanel c23 = new JPanel();
        JLabel labelTelephoneDomicileContact2 = new JLabel("Téléphone Domicile : ");
        c23=createContainerLabelTextField(labelTelephoneDomicileContact2,tfTelephoneDomicileContact2,police);
        
        JPanel c231 = new JPanel();
        JLabel labelTelephoneMobileContact2 = new JLabel("Téléphone Mobile : ");
        c231=createContainerLabelTextField(labelTelephoneMobileContact2,tfTelephoneMobileContact2,police);
        
        JPanel c24 = new JPanel();
        JLabel labelEmailContact2 = new JLabel("Email : ");
        c24=createContainerLabelTextField(labelEmailContact2,tfEmailContact2,police);
        
        
        JLabel labelSante = new JLabel("Santé ");
        labelSante.setFont(police);
        JPanel c25= new JPanel();
        JLabel labelNomMedecin = new JLabel("Médecin traitant : ");
        labelNomMedecin.setFont(police);
        BaseDeDonnees bd2 = new BaseDeDonnees("jdbc:mysql://localhost/bddprojet","root","");
        RequetesSQL queries2 = new RequetesSQL(bd2);
        ArrayList <Medecin> medecins = queries2.getMedecins();
        int j;
        for(j=0;j<medecins.size();j++){
            cbMedecins.addItem(medecins.get(j));
        }
        cbMedecins.setFont(police);
        c25.setLayout(new BoxLayout(c25, BoxLayout.X_AXIS));
        c25.add(labelNomMedecin);
        c25.add(cbMedecins);
        
        
        
        
        
        
        
        
        JPanel c27= new JPanel();
        JLabel labelVaccinations = new JLabel("Vaccinations ");
        c27=createContainerLabelTextField(labelVaccinations,tfVaccinations,police);
        
        JPanel c28= new JPanel();
        JLabel labelAllergies = new JLabel("Allergies : ");
        c28=createContainerLabelTextField(labelAllergies,tfAllergies,police);
        
        JPanel c29= new JPanel();
        JLabel labelRemarquesMedicales = new JLabel("Remarques médicales : "); 
        c29=createContainerLabelTextField(labelRemarquesMedicales,tfRemarquesMedicales,police);
        
        JPanel c31 = new JPanel();
        boutonValider.addActionListener(cbClasse);
        c31.add(boutonValider);
        boutonValider.addActionListener(new ControllerAjout(this));
        
        
   
        infosContainer.add(labelIdentite);
        infosContainer.add(new JPopupMenu.Separator());
        infosContainer.add(c1);
        infosContainer.add(c2);
        infosContainer.add(c3);
        infosContainer.add(c4);
        infosContainer.add(c5);
        infosContainer.add(c6);
        infosContainer.add(c7);
        infosContainer.add(c8);
        infosContainer.add(c9);
        infosContainer.add(c10);
        infosContainer.add(c11);
        infosContainer.add(c32);
        infosContainer.add(c12);
        infosContainer.add(c13);
        infosContainer.add(c14);
        infosContainer.add(c30);
        infosContainer.add(labelContact1);
        infosContainer.add(new JPopupMenu.Separator());
        infosContainer.add(c15);
        infosContainer.add(c16);
        infosContainer.add(c171);
        infosContainer.add(c17);
        infosContainer.add(c172);
        infosContainer.add(c18);
        infosContainer.add(c181);
        infosContainer.add(c19);
        
        
        infosContainer.add(labelContact2);
        infosContainer.add(new JPopupMenu.Separator());
        infosContainer.add(c20);
        infosContainer.add(c21);
        infosContainer.add(c221);
        infosContainer.add(c22);
        infosContainer.add(c222);
        infosContainer.add(c23);
        infosContainer.add(c231);
        infosContainer.add(c24);
        
        infosContainer.add(labelSante);
        infosContainer.add(new JPopupMenu.Separator());
        infosContainer.add(c25);
        infosContainer.add(c27);
        infosContainer.add(c28);
        infosContainer.add(c29);
        infosContainer.add(c31);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        infosContainer.setBorder(new EmptyBorder(0, 50, 150, 15));
        JScrollPane infosScroll = new JScrollPane(infosContainer); 
        infosScroll.setBorder(createEmptyBorder());
        
        
        
        
        
        
        
        this.setContentPane(infosScroll);
        this.setVisible(true);
    }
    
    public JPanel createContainerLabelTextField(JLabel label,JTextField t,Font police){
        JPanel c = new JPanel();
        c.setLayout(new BoxLayout(c, BoxLayout.X_AXIS));
        JPanel ct = new JPanel();
        label.setFont(police);
        t.setFont(police);
        
      
        c.add(label);
        c.add(t);
        return c;
   }
   
    public static JDatePickerImpl getDatePicker(){
        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Aujourd'hui");
        p.put("text.month", "Mois");
        p.put("text.year", "Année");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        return datePicker;
    }
    
    public String getTfNom(){
        return tfNom.getText();
    }
    
    public String getTfPrenom(){
        return tfPrenom.getText();
    }
    
    
    
    public Date getCbDateNaissance(){
       int d=datePicker.getModel().getDay();
       int m=datePicker.getModel().getMonth();
       int y=datePicker.getModel().getYear();
       return new Date(y,m,d);
//return datePicker.
    }
    
    public String getTfVilleNaissance(){
        return tfVilleNaissance.getText();
    }
    public String getTfPaysNaissance(){
        return tfPaysNaissance.getText();
    }
    
    public boolean getSexe(){
        if(cbSexe.getSelectedItem().toString()=="Femme")
            return true;
        return false;
    }
    
    public Date getCbDateInscription(){
       int d=datePicker2.getModel().getDay();
       int m=datePicker2.getModel().getMonth();
       int y=datePicker2.getModel().getYear();
       return new Date(y,m,d);
    }
    
    public String getTfEtablissementPrecedent(){
        return tfEtablissementPrecedent.getText();
    }
    
    public String getTfPays(){
        return tfPays.getText();
    }
    
    public String getTfAdresse(){
        return tfAdresse.getText();
    }
    
    public String getTfCodePostal(){
        return tfCodePostal.getText();
    }
    
    public String getTfVille(){
        return tfVille.getText();
    }
    
    public String getTfTelDomicile(){
        return tfTelDomicile.getText();
    }
    
    public String getTfTelMobile(){
        return tfTelMobile.getText();
    }
    
    public String getTfEmail(){
        return tfEmail.getText();
    }
    
    public String getTfNomContact1(){
        return tfNomContact1.getText();
    }
    
    public String getTfPrenomContact1(){
        return tfPrenomContact1.getText();
    }
    
    public String getTfVilleContact1(){
        return tfVilleContact1.getText();
    }
    
    public String getTfAdresseContact1(){
        return tfAdresseContact1.getText();
    }
    
    public String getTfCodePostalContact1(){
        return tfCodePostalContact1.getText();
    }
    
    public String getTfTelephoneMobileContact1(){
        return tfTelephoneMobileContact1.getText();
    }
    public String getTfTelephoneDomicileContact1(){
        return tfTelephoneDomicileContact1.getText();
    }
    
    public String getTfEmailContact1(){
        return tfEmailContact1.getText();
    }
    
    public Classe getSelectedClasse(){
       return (Classe)cbClasse.getSelectedItem();
    }
    
    public String getTfNomContact2(){
        return tfNomContact2.getText();
    }
    
    public String getTfPrenomContact2(){
        return tfPrenomContact2.getText();
    }
    
    public String getTfVilleContact2(){
        return tfVilleContact2.getText();
    }
    
    public String getTfAdresseContact2(){
        return tfAdresseContact2.getText();
    }
    
    public String getTfCodePostalContact2(){
        return tfCodePostalContact2.getText();
    }
    
    
    public String getTfTelephoneMobileContact2(){
        return tfTelephoneMobileContact2.getText();
    }
    public String getTfTelephoneDomicileContact2(){
        return tfTelephoneDomicileContact2.getText();
    }
    
    public String getTfEmailContact2(){
        return tfEmailContact2.getText();
    }
    
    public Medecin getSelectedMedecin(){
        return (Medecin)cbMedecins.getSelectedItem();
    } 
    
    public String getTfVaccinations(){
        return tfVaccinations.getText();
    }
    
    public String getTfAllergies(){
        return tfAllergies.getText();
    }
    
    public String getTfRemarquesMedicales(){
        return tfRemarquesMedicales.getText();
    }
    
    
    
    
  
}
