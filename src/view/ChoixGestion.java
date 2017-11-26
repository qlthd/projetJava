/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

/**
 *
 * @author Quentin Lathaud
 */
public class ChoixGestion extends JFrame{
    private JButton firstButton = new JButton("Gestion des élèves par classe");
    private JButton secondButton = new JButton("Gestion des élèves par matière");
    public ChoixGestion(){
        this.setTitle("Choix Gestion");
        this.setSize(1920, 1080);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridLayout g1 = new GridLayout(5,1);
        JPanel firstPanel = new JPanel();
        JLabel titre = new JLabel("Interfaces de gestion");
        firstButton.setPreferredSize(new Dimension(40, 40));
        firstPanel.add(titre);
        firstButton.setFocusPainted(false);
        Font font = new Font("Segoe UI Semilight",Font.PLAIN,25);
        titre.setFont(font);
       firstButton.setFont(font);
        firstButton.addActionListener ( new ActionListener (){
            
            public void actionPerformed(ActionEvent e)
            {
                FenetreAdmin a = new FenetreAdmin();
                
            }
            
        });
        secondButton.setFont(font);
        secondButton.setFocusPainted(false);
        secondButton.addActionListener ( new ActionListener (){
            
            public void actionPerformed(ActionEvent e)
            {
                
            }
            
        });
        
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                int confirmed = JOptionPane.showConfirmDialog(null,"Voulez vous quitter l'application ?", "Fermeture du programme",JOptionPane.YES_NO_OPTION);
                if (confirmed == JOptionPane.YES_OPTION) {dispose();}
                else setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            }
        });
        
        this.setLayout(g1);
        this.getContentPane().add(firstPanel);
        this.getContentPane().add(firstButton);
        this.getContentPane().add(secondButton);
        this.setVisible(true);
        
    }
    
}
