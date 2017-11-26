/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


/**
 *
 * @author 20170027
 */
public class RequetesSQL {
    private static BaseDeDonnees bd;

    /**
     *
     */
    public RequetesSQL(BaseDeDonnees bd){
        this.bd = bd;
    }
    /*
    public static Responsable getResponsableEtudiant(Etudiant e) throws SQLException{
        Responsable r;
        String query = "select * from responsable r, utilisateur u where u.matricule = r.responsableDe and u.matricule = ?";
        PreparedStatement ps = bd.prepare(query);
        ps.setString(1, e.getMatricule());
        ResultSet result = bd.req(ps);
        
        if(result.next()){
            r = new Responsable(result.getInt("id_personne"), result.getString("nom_personne"), result.getString("prenom_personne"), result.getString("adresse_personne"), result.getString("codepostal_personne"), result.getString("ville_personne"), result.getString("domiciletel"), result.getString("mobiletel"), result.getString("email"), result.getString("responsable_de"));
            return r;
        }
        else return null;
        
    }*/
    /*
    public static Map<String, Double> getNoteFromEtudiant(Etudiant e, String matiere) throws SQLException{
        Map<String, Double> res = new HashMap<String, Double>();
        String query = "select * from note n, matiere m, utilisateur u where n.matricule_utilisateur = u.matricule"
                + " and n.id_matiere = m.id_matiere and u.matricule = ? and m.nom_matiere = ?";
        
        PreparedStatement ps = bd.prepare(query);
        
        ps.setString(1, e.getMatricule());
        ps.setString(2, matiere);
        ResultSet result = bd.req(ps);
        while(result.next()){
            res.put(result.getString("nom_matiere"), result.getDouble("valeur_note"));
        }
        return res;
    }
    // TODO: Mettre pour l'étudiant spécifique!
    /*public static Map<String, Double> getNotesFromEtudiant(Etudiant e) throws SQLException{
        String query = "select * from note n, utilisateur u, matiere m where n.matricule_utilisateur = u.matricule"
                + " and m.id_matiere = n.id_matiere and u.matricule = ?";
        PreparedStatement ps = bd.prepare(query);
        ps.setString(1, e.getMatricule());
        ResultSet result = bd.req(ps);
        Map<String, Double> res = new HashMap<String, Double>();
        while(result.next()){
            res.put(result.getString("nom_matiere"), result.getDouble("valeur_note"));
        }
        ps.close();
        result.close();
        return res;
    }*/
    
    public Utilisateur getUtilisateur(Utilisateur user ) throws SQLException{
        String query = "select * from utilisateur u where u.username = ? and u.password= ? ";
        PreparedStatement ps = bd.prepare(query);
        ps.setString(1, user.getUsername());
        ps.setString(2,user.getPassword());
        ResultSet result = bd.req(ps);
        if(result.next()){
            Utilisateur u = new Utilisateur(result.getString("username"),result.getString("password"),result.getString("droit"));
            return u;
        }
        else return null;
    }
    
    public Etudiant getEtudiant(Etudiant e) throws SQLException{
        String query = "select * from etudiant e where e.nom = ? ";
        PreparedStatement ps = bd.prepare(query);
        ps.setString(1, e.getNom());
        ResultSet result = bd.req(ps);
        Classe c;
       
        if(result.next()){
           // Etudiant et = new Etudiant(result.getString("matricule"),result.getString("nom"),result.getString("prenom"),result.getDate("dateNaissance"),result.getString("villeNaissance"),result.getString("paysNaissance"),result.getBoolean("sexe"),result.getDate("dateInscription"),result.getInt("id_classe"),result.getString("etablissementPrecedent"),result.getString("adresse"),result.getString(),result.getString("ville_utilisateur"),result.getString("pays_utilisateur") text,result.getString("codepostal_utilisateur"),result.getString);
           Etudiant et = new Etudiant(result.getString("nom"),result.getString("prenom"));
           return et;
        }
        else return null;
    }
    
    public ArrayList<Etudiant> getEtudiants() throws SQLException{
        ArrayList<Etudiant> etudiants = new ArrayList<Etudiant>();
        ResultSet result = bd.req("select nom,prenom from etudiant");
        Etudiant e;
        while(result.next()){
            e=new Etudiant(result.getString("prenom"),result.getString("nom"));
            etudiants.add(e);
        }
        return etudiants;
    }
    
    public ArrayList<Medecin> getMedecins() throws SQLException{
        ArrayList<Medecin> medecins = new ArrayList<Medecin>();
        ResultSet result = bd.req("select id_medecin,nom_medecin,prenom_medecin,tel_medecin from medecin");
        Medecin m;
        while(result.next()){
            m=new Medecin(result.getInt("id_medecin"),result.getString("nom_medecin"),result.getString("prenom_medecin"),result.getString("tel_medecin"));
            medecins.add(m);
        }
        return medecins;
    }
    
    public void insererEtudiant(Etudiant e) throws SQLException{
        String query = "insert into etudiant VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = bd.prepare(query);
        ps.setString(1, e.getMatricule());
        ps.setString(2, e.getNom());
        ps.setString(3, e.getPrenom());
        ps.setDate(4, e.getDateNaissance());
        ps.setString(5,e.getVilleNaissance());
        ps.setString(6,e.getPaysNaissance());
        ps.setBoolean(7,e.getSexe());
        ps.setDate(8, e.getDateInscription());
        ps.setInt(9, e.getIdClasse());
        ps.setString(10, e.getEtablissementPrecedent());
        ps.setString(11, e.getAdresse());
        ps.setString(12,e.getVille());
        ps.setString(13,e.getPays());
        ps.setString(14,e.getCodePostal());
        ps.setInt(15,e.getMedecin().getIdMedecin());//e.getIdMedecin());
        bd.updateDB(ps);
        
    }
    
    public void insererPersonneResponsable(PersonneResponsable pr) throws SQLException{
        String query = "insert into personne_responsable VALUES(?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = bd.prepare(query);
        ps.setInt(1, pr.getId());
        ps.setString(2, pr.getNom());
        ps.setString(3,pr.getPrenom());
        ps.setString(4,pr.getAdresse());
        ps.setString(5,pr.getCodePostal());
        ps.setString(6,pr.getVille());
        ps.setString(7,pr.getTelDomicile());
        ps.setString(8, pr.getTelMobile());
        ps.setString(9, pr.getEmail());
        ps.setString(10, pr.getResponsableDe());
        
        bd.updateDB(ps);
        
    }
    
    public int getMaxIDPersonneResponsable() throws SQLException{
        ResultSet result = bd.req("select max(id_personne) from personne_responsable");        
        if(result==null){
            return 1;
        }
        while(result.next()){
              return result.getInt("id_personne");
             
       }
       return 1;
    }
    
    public void insererClasse(){};

      public static ArrayList<String> getClasses2() throws SQLException {
    	String query = "select * from classe;";
    	ResultSet result = BaseDeDonnees.req(query);
    	ArrayList<String> classes = new ArrayList<String>();
    	while(result.next()){
    		classes.add(result.getString("nom_classe"));
    	}
    	return classes;
    }
      
    public void insererNote(Note n) throws SQLException{
        String query = "insert into note VALUES(?,?,?)";
        PreparedStatement ps = bd.prepare(query);
        ps.setInt(1, n.getIdMatiere());
        ps.setString(2, n.getMatriculeUtilisateur());
        ps.setFloat(3, n.getValeurNote());
        bd.updateDB(ps);
        
    
    }
    
    public ArrayList<Etudiant> getEtudiantsMatiere(Matiere m) throws SQLException{
        
        String query = "select e.nom,e.prenom, e.matricule from note n, etudiant e where e.matricule in (select n.matricule_utilisateur from note n, matiere m where n.id_matiere=m.id_matiere)";
        PreparedStatement ps = bd.prepare(query);
        ResultSet result = bd.req(ps);
        ArrayList<Etudiant> listeEtudiants = new ArrayList<Etudiant>();
        if(result.next()){
           // Etudiant et = new Etudiant(result.getString("matricule"),result.getString("nom"),result.getString("prenom"),result.getDate("dateNaissance"),result.getString("villeNaissance"),result.getString("paysNaissance"),result.getBoolean("sexe"),result.getDate("dateInscription"),result.getInt("id_classe"),result.getString("etablissementPrecedent"),result.getString("adresse"),result.getString(),result.getString("ville_utilisateur"),result.getString("pays_utilisateur") text,result.getString("codepostal_utilisateur"),result.getString);
           Etudiant et = new Etudiant(result.getString("matricule"),result.getString("nom"),result.getString("prenom"));
           listeEtudiants.add(et);
        }
        return listeEtudiants;
    }
    
    public float getMoyenneMatiereEtudiant(Matiere m, Etudiant e) throws SQLException{
        String query = "select n.valeur_note from n note where n.id_matiere=? and n.matricule_utilisateur=?";
        float total=0;
        int nbNotes=0;
        PreparedStatement ps = bd.prepare(query);
        ps.setInt(1, m.getIdMatiere());
        ps.setString(2, e.getMatricule());
        ResultSet result = BaseDeDonnees.req(query);
    	while(result.next()){
    		total+=result.getFloat("valeur_note");
                nbNotes++;
    	}
        return total/nbNotes;
    	
    }
    
    public ArrayList<Note> getNotesEtudiantMatiere(String matricule,int idMatiere) throws SQLException{
       
       String query = "select * from note where id_matiere="+idMatiere+" and matricule_utilisateur='"+matricule+"'";
        PreparedStatement ps = bd.prepare(query);
        //ps.setInt(1, idMatiere);
       // ps.setString(1, matricule);
        System.out.println(ps.toString());
        ResultSet result = BaseDeDonnees.req(query);
        ArrayList<Note> notesEtudiants = new ArrayList<Note>();
    	while(result.next()){
    		Note n = new Note(result.getInt("id_matiere"),result.getString("matricule_utilisateur"),result.getInt("valeur_note"));
                notesEtudiants.add(n);
    	}
        return notesEtudiants;
    }
    
    public static ArrayList<Classe> getClasses() throws SQLException{
        String query = "select * from classe;";
        ResultSet result = BaseDeDonnees.req(query);
        ArrayList<Classe> classes = new ArrayList<Classe>();
    	while(result.next()){
            classes.add(new Classe(result.getInt("id_classe"),result.getString("niveau_classe")));
    	}
    	return classes;
        
        
    }  
      
            /*
    public static ArrayList<Etudiant> getEtudiants() throws SQLException, ParseException{
        ArrayList<Etudiant> etudiants = new ArrayList<Etudiant>();
        ResultSet result = bd.req("select * from utilisateur u, medecin m, classe c, vaccin v, allergie a where u.id_medecin = m.id_medecin AND u.idClasse = c.idClasse AND v.matricule_utilisateur = u.matricule AND a.matricule_utilisateur = u.matricule;");
        String nom="", prenom="";
        String matricule = "";
        DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
        Date dateNaissance = new java.sql.Date(df.parse("12-12-1905").getTime());
        String villeNaissance="", paysNaissance="";
        boolean sexe = true;
        Date dateInscription = new java.sql.Date(df.parse("12-12-1905").getTime());
        String classe="", etablissementPrecedent="";
        Medecin medecin = new Medecin();
        ArrayList<String> allergies = new ArrayList<String>(), vaccins = new ArrayList<String>();
        Etudiant e;
        while(result.next()){
            if(!matricule.equals(result.getString("matricule"))){
                vaccins = new ArrayList<String>();
                allergies = new ArrayList<String>();
                matricule = result.getString("matricule");
                nom = result.getString("nom");
                prenom = result.getString("prenom");
                dateNaissance = result.getDate("dateNaissance");
                villeNaissance = result.getString("villeNaissance");
                paysNaissance = result.getString("paysNaissance");
                sexe = result.getBoolean("sexe");
                dateInscription = result.getDate("dateInscription");
                classe = result.getString("niveau_classe");
                etablissementPrecedent = result.getString("etablissementPrecedent");
                medecin = new Medecin(result.getString("nom_medecin"), result.getString("prenom_medecin"), result.getString("tel_medecin"));
                vaccins.add(result.getString("nom_vaccin"));
                allergies.add(result.getString("nom_allergie"));
            }
            else if(vaccins.get(vaccins.size() - 1) != result.getString("nom_vaccin")){
                vaccins.add(result.getString("nom_vaccin"));
            }
            else if(allergies.get(allergies.size() - 1) != result.getString("nom_allergie")){
                allergies.add(result.getString("nom_allergie"));
            }
            e = new Etudiant(matricule, nom, prenom, dateNaissance, villeNaissance, paysNaissance, sexe, dateInscription, classe, etablissementPrecedent, medecin, vaccins, allergies);
            etudiants.add(e);
        }
        result.close();
        return etudiants;
    }
*/

    
}
