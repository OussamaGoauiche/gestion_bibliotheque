package dao;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Scanner;

import beans.Emprunt;
import beans.Etudiant;
import beans.Livre;

public class EnregistrerCsv {
	
	public static String demandeChemin()
	{
		Scanner sc=new Scanner(System.in);
		 System.out.println("entrer le chemin du dossier");
		String nomDossier=sc.nextLine();
		return nomDossier;
	}
	public static void enregistrerLivre(String nomDossier) throws SQLException {
		
		File f = new File(nomDossier+"/livre.csv");
		if (f.exists() == true)
			System.out.println("Le fichier existe déjà, veuillez le supprimer avant");
		else {
			try (FileWriter pw = new FileWriter(f,true); 
					PrintWriter out = new PrintWriter(pw);) {
				Livre[]l;
				  l= LivreDao.Lister();
				  
				  for(Livre e:l)
				  {
					  out.println(e);				  
			      }
				
			}catch (IOException e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
	}
	    }
	
	
	
	
public static void enregistrerEtudiant(String nomDossier) throws SQLException {
		
		
		File f = new File(nomDossier+"/etudiant.csv");
		if (f.exists() == true)
			System.out.println("Le fichier existe déjà, veuillez le supprimer avant");
		else {
			try (FileWriter pw = new FileWriter(f,true); 
					PrintWriter out = new PrintWriter(pw);) {
				Etudiant[] e;
				 e=EtudiantDao.Lister();
				 for(Etudiant l1:e)
				  {
					  out.println(l1);
				  }
			}catch (IOException e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
	}
	    }
	
public static void enregistrerEmprunt(String nomDossier) throws SQLException {
	
	File f = new File(nomDossier+"/emprunt.csv");
	if (f.exists() == true)
		System.out.println("Le fichier existe déjà, veuillez le supprimer avant");
	else {
		try (FileWriter pw = new FileWriter(f,true); 
				PrintWriter out = new PrintWriter(pw);) {
			Emprunt[] e1;
			 e1=EmpruntDao.Lister();
			 for(Emprunt l1:e1)
			  {
				  out.println(l1);
			  }
		}catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
}
    }

public static void enregistrerEnCsv() throws SQLException
{
	String nomDossier=demandeChemin();
	 enregistrerLivre(nomDossier);
	 enregistrerEtudiant(nomDossier);
	 enregistrerEmprunt(nomDossier);
}
	public static void main(String[] args) throws SQLException 
	{
		enregistrerEnCsv();    
	}
	
}
         
		



	

