/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import model.BaseDeDonnees;
import model.RequetesSQL;
import model.Utilisateur;
/**
 *
 * @author Quentin Lathaud
 */
public class EcranConnexion extends JFrame {
    private JPanel pane = new JPanel();
    private JLabel titre = new JLabel("Écran de connexion");
    private JButton boutonConnexion = new JButton("se connecter");
    private JLabel labelLogin = new JLabel("Login : ");
    private JTextField tfLogin = new JTextField(20);
     private JLabel labelMdp = new JLabel("Mot de passe : ");
    private JPasswordField tfMdp = new JPasswordField(15);
    private Font police = new Font("Arial", Font.PLAIN, 50);
    private Font basic = new Font("Arial", Font.BOLD, 18);

    public EcranConnexion(){
        this.setTitle("Connexion utilisateur");
        this.setSize(400, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        labelLogin.setFont(basic);
        labelLogin.setBounds(10,10,80,25);
        tfLogin.setBounds(100,10,160,25);
        JPanel paneLogin= new JPanel();
        paneLogin.add(labelLogin);
        paneLogin.add(tfLogin);
        
        labelMdp.setFont(basic);
        labelMdp.setBounds(10,40,80,25);
        tfMdp.setBounds(10,80,80,25);
        JPanel paneMdp = new JPanel();
        paneMdp.add(labelMdp);
        paneMdp.add(tfMdp);
        GridLayout g1= new GridLayout(4,1);
        this.setLayout(g1);
        
        
        
        boutonConnexion.setSize(100, 0);
        
        boutonConnexion.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                BaseDeDonnees bd = new BaseDeDonnees("jdbc:mysql://localhost/bddprojet","root","");
                RequetesSQL queries = new RequetesSQL(bd);
                
               /* Utilisateur userTemp = new Utilisateur(tfLogin.getText(),tfMdp.getText());
                Utilisateur u=new Utilisateur("none","none","");
                try {
                    u=queries.getUtilisateur(userTemp);
                } catch (SQLException ex) {
                    Logger.getLogger(EcranConnexion.class.getName()).log(Level.SEVERE, null, ex);
                }
                try{
                    if(u.getDroit().equals("admin")){
                       */ try {
                           /* Utilisateur userTemp = new Utilisateur(tfLogin.getText(),tfMdp.getText());
                           Utilisateur u=new Utilisateur("none","none","");
                           try {
                           u=queries.getUtilisateur(userTemp);
                           } catch (SQLException ex) {
                           Logger.getLogger(EcranConnexion.class.getName()).log(Level.SEVERE, null, ex);
                           }
                           try{
                           if(u.getDroit().equals("admin")){
                           */ //ChoixGestion cg = new ChoixGestion();
                           FenetreModification f = new FenetreModification();
                } catch (SQLException ex) {
                    Logger.getLogger(EcranConnexion.class.getName()).log(Level.SEVERE, null, ex);
                }
                        dispose();
                    /*}
                }
                catch(NullPointerException exx){
                    JOptionPane.showMessageDialog(new JFrame(),"Login et/ou mot de passe incorrects !");
                } */
            }
        });
        
        
        JPanel paneTitre = new JPanel();
        titre.setFont(basic);
        paneTitre.add(titre);
        this.getContentPane().add(paneTitre);
        this.getContentPane().add(paneLogin);
        this.getContentPane().add(paneMdp);
        this.getContentPane().add(boutonConnexion);
        this.setVisible(true);
  }     
    

  public static void main(String[] args){

    EcranConnexion fenetre = new EcranConnexion();
    
    
  }       

}
     
