package dao;

import java.sql.*;
import java.util.Scanner;

import beans.Etudiant;
import principal.DatabaseConnection;

public class EtudiantDao {
	static DatabaseConnection db=new DatabaseConnection();
	  public static Connection conn=db.getConn();
	 
	 public static int compter() throws SQLException
	 {
	 	Statement st =conn.createStatement();
	 	String requete="select count(*) from etudiant";
	 	ResultSet rs=st.executeQuery(requete);
	 	while(rs.next())
	 	{
	 	return rs.getInt(1);
	 	}
	 	return 0;
	 }
	public static Etudiant [] Lister() throws SQLException
	{
		int i=0;
		int n=compter();
		Etudiant [] tab=new Etudiant[n];
		Statement st =conn.createStatement();
		String requete="select * from etudiant";
		ResultSet rs=st.executeQuery(requete);
		while(rs.next())
		{
		tab[i++]= new Etudiant(rs.getString("cin"),rs.getString("nom"),rs.getString("prenom"),rs.getString("filiere"));
		}
		return tab;
	}
	
	public static void ajouter(Etudiant e) throws SQLException
	 {
		 String requete2="insert into etudiant values(?,?,?,?)";
			PreparedStatement ps=conn.prepareStatement(requete2);
			ps.setString(1, e.getCin());
			ps.setString(2, e.getNom());
			ps.setString(3, e.getPrenom());
			ps.setString(4, e.getFiliere());
		ps.execute();	 
		
	 }
	
		
			public static boolean Etudiantequals(Etudiant l) throws SQLException
			 {
				Statement st =conn.createStatement();
				String requete="select * from etudiant";
				ResultSet rs=st.executeQuery(requete);
				while(rs.next())
				{	
					if(l.getCin().equals(rs.getString("cin"))&& l.getNom().equals(rs.getString("nom"))&&
	                l.getPrenom().equals(rs.getString("prenom"))&& l.getFiliere().equals(rs.getString("filiere")))
					 return true;
				
				}
				return false;
		    }
	 public static void modifier (Etudiant e) throws SQLException
	 
	 {	
		 if(Etudiantequals(e))
		 {
		 Statement st =conn.createStatement();
		 Scanner sc=new Scanner(System.in);
		 System.out.println("entrer le nouveau cin");
		 String cin=sc.nextLine();
		 
		 System.out.println("entrer le nouveau nom ");
		 String nom=sc.nextLine();
		 
		 System.out.println("entrer le nouveau prenom");
		 String prenom=sc.nextLine();
		 
		 System.out.println("entrer la nouvelle  filiere");
		 String filiere=sc.nextLine();
		 
		 String requete3="update  etudiant set cin='"+cin+"',nom='"+nom+
				 "',prenom='"+prenom+"',filiere='"+filiere+"'"+" where cin='"+e.getCin()+"'";
			st.executeUpdate(requete3);
		 }
		 else
			 System.out.println("Erreur");
		 
	 }

	
	
	public static void supprimerParCin(String cin1) throws SQLException {
		Statement st =conn.createStatement();
		String requete="delete from etudiant where cin='"+cin1+"'";
		st.execute(requete);
		  String requete1="delete from emprunt where EmprunteurCin='"+cin1+"'";
			st.execute(requete1);
	}
	public static void main(String[] args) throws SQLException 
	{
		Etudiant a=new Etudiant("bb","asz","dezz","ezeze");
		//ajouter(a);
		//modifier(a);
	}
}
