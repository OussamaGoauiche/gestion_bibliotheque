package dao;

import java.util.Scanner;
import java.util.*;
import java.sql.*;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import beans.Etudiant;
import beans.Livre;
import beans.Emprunt;
import principal.DatabaseConnection;

public class EmpruntDao {

	
	static DatabaseConnection db=new DatabaseConnection();
	  public static Connection conn=db.getConn();
	  
	  static int getLastId() throws SQLException{
		  int id=0;
		  String requete="select max(Codemprunt ) from emprunt";
		  Statement st=conn.createStatement();
		  ResultSet rs=st.executeQuery(requete);
		  while(rs.next())
		  {
		  return rs.getInt(1);
		  }
		  return id;
		  }
	  
	  public static int compter() throws SQLException
		 {
		 	Statement st =conn.createStatement();
		 	String requete="select count(*) from emprunt";
		 	ResultSet rs=st.executeQuery(requete);
		 	while(rs.next())
		 	{
		 	return rs.getInt(1);
		 	}
		 	return 0;
		 }
	  
	  public static Emprunt [] Lister() throws SQLException
		{
			int i=0;
			int n=compter();
			Emprunt [] tab=new Emprunt[n];
			Statement st =conn.createStatement();
			String requete="select * from emprunt";
			ResultSet rs=st.executeQuery(requete);
			while(rs.next())
			{
			tab[i++]= new Emprunt(rs.getInt("Codemprunt"),rs.getInt("CodeLivre"),rs.getString("EmprunteurCin"),rs.getString("DateEmprunt"),rs.getString("DateretourP"));
			}
			return tab;
		}
	  
	  public static void emprunter() throws SQLException
		 {
		  Livre[]l;
		  l= LivreDao.Lister();
		  
		  for(Livre e:l)
		  {
			  System.out.println(e);
		  }
		  Scanner sc=new Scanner(System.in);
			 System.out.println("entrer le numero du livre a empreinter");
			 int code=sc.nextInt();
			 sc.nextLine();
			 if(testerLivre(code))
			 {
				 Etudiant[] e;
				 e=EtudiantDao.Lister();
				 for(Etudiant l1:e)
				  {
					  System.out.println(l1);
				  }
				 System.out.println("entrer votre cin");
				String cin=sc.nextLine();
				 if(testerEtudiant(cin))
				 {
					 if(nombreEmpreinter(cin)<3 && testerMemeEmprunt(cin,code)==false && stockDisp(code)>0)
					 {
						 
						 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
						 
						 
						 String requete2="insert into emprunt values(?,?,?,?,?)";
							PreparedStatement ps=conn.prepareStatement(requete2);
							ps.setInt(1, getLastId()+1);
							ps.setInt(2, code);
							ps.setString(3, cin);
							ps.setString(4, dtf.format(LocalDateTime.now()));
							ps.setString(5, "---");
							ps.execute();	 
							
							
							 String requete3="update  livre set NbrLivreDispo=NbrLivreDispo-1  where CodeLivre="+code;
								Statement st =conn.createStatement();
								st.executeUpdate(requete3);
					 }
					 else
							System.out.println("erreur");
						 
				 }
				 else
						System.out.println("erreur");
				 
			 }
			 
			 else
			System.out.println("erreur");
			
			
		 }
	public static boolean testerLivre(int code) throws SQLException
	{
		Statement st =conn.createStatement();
		String requete="select * from livre";
		ResultSet rs=st.executeQuery(requete);
		while(rs.next())
		{	
         if(code==rs.getInt("CodeLivre"))
        	 return true;
       
		}
		return false;
	}
	
	public static boolean testerEtudiant(String cin) throws SQLException 
	{
		Statement st =conn.createStatement();
		String requete="select * from etudiant";
		ResultSet rs=st.executeQuery(requete);
		while(rs.next())
		{	
         if(cin.equals(rs.getString("cin")))
        	 return true;
		}
		return false;
	}
	
	public static int nombreEmpreinter(String cin) throws SQLException
	{

		Statement st =conn.createStatement();
		String requete="select count(*) from emprunt where EmprunteurCin='"+cin+"'and DateretourP='---'";
		ResultSet rs=st.executeQuery(requete);
		while(rs.next())
		{
		return rs.getInt(1);
		}
		return 0;
	}
	
	public static boolean testerMemeEmprunt(String cin,int code) throws SQLException
	{
		Statement st =conn.createStatement();
		String requete="select * from emprunt";
		ResultSet rs=st.executeQuery(requete);
		while(rs.next())
		{	
         if(code==rs.getInt("CodeLivre") && cin.equals(rs.getString("EmprunteurCin")) && rs.getString("DateretourP").equals("---"))
        	 return true;
       
		}
		return false;
	}
	
	public static int stockDisp(int code) throws SQLException
	{
		Statement st =conn.createStatement();
		String requete="select NbrLivreDispo from livre where CodeLivre ="+code;
		ResultSet rs=st.executeQuery(requete);
		while(rs.next())
		{	
        return  rs.getInt(1);
       
		}
		return 0;
	}
	
	public static void remettre() throws SQLException 
	{
		 Etudiant[] e;
		 e=EtudiantDao.Lister();
		 for(Etudiant l1:e)
		  {
			  System.out.println(l1);
		  }
		  Scanner sc=new Scanner(System.in);
		 System.out.println("entrer votre cin");
		String cin=sc.nextLine();
		 if(testerEtudiant(cin))
		 {
			 Livre[]l;
			  l= listerEmprunt(cin);;
			  for(Livre a:l)
			  {
				  System.out.println(a);
			  }
			if(l.length!=0)
			{
			  System.out.println("voila votre les livres que vous avez emprunter");
			  System.out.println("entrer le numero du livre a remettre");
				 int code=sc.nextInt();
				 sc.nextLine();
				 if(appartient(code,l))
				 {
					 String requete3="update  livre set NbrLivreDispo=NbrLivreDispo+1  where CodeLivre="+code;
						Statement st =conn.createStatement();
						st.executeUpdate(requete3);
						
						 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

						String requete4="update  emprunt set DateretourP='"+dtf.format(LocalDateTime.now())+"' where CodeLivre="+code+" and EmprunteurCin='"+cin+"'";
						st.executeUpdate(requete4);
				 }	
				 else {
						System.out.println("vous n'avez pas emprunter ce  livre ");
		            }
			
		 }
			else {
				System.out.println("vous n'avez pas emprunter aucun livre ");
			}
	}
	}
	

      public static boolean appartient(int n,Livre [] l)
      {
    	  for(Livre e:l)
    	  {
    		  if(e.getCodeLivre()==n)
    			  return true;
    	  }
    	  return false;
      }
	  
	public static Livre[] listerEmprunt(String cin) throws SQLException
	{    
		int i=0;
		int n=nombreEmpreinter(cin);
		Livre [] tab=new Livre[n];
		Statement st =conn.createStatement();
		String requete="select livre.* from livre join emprunt on livre.CodeLivre=emprunt.CodeLivre where emprunt.EmprunteurCin='"+cin+"'and emprunt.DateretourP='---'";
		ResultSet rs=st.executeQuery(requete);

		while(rs.next())
		{
		tab[i++]= new Livre(rs.getInt("CodeLivre"),rs.getString("TitreLivre"),rs.getString("DateDapparition"),rs.getInt("NbrLivreDispo"));
		}
		return tab;
	}
	
	  public static void main(String[] args) throws SQLException 
			{
		     
		 //int n= nombreEmpreinter("aimane");
		 //System.out.println(n);
		  //remettre();
		  emprunter();
			}
}
