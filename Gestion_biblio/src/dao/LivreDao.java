package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import beans.Etudiant;
import beans.Livre;
import principal.DatabaseConnection;

public class LivreDao {
	static DatabaseConnection db=new DatabaseConnection();
	  public static Connection conn=db.getConn();
	  
	  public static int compter() throws SQLException
		 {
		 	Statement st =conn.createStatement();
		 	String requete="select count(*) from livre";
		 	ResultSet rs=st.executeQuery(requete);
		 	while(rs.next())
		 	{
		 	return rs.getInt(1);
		 	}
		 	return 0;
		 }
		public static Livre [] Lister() throws SQLException
		{
			int i=0;
			int n=compter();
			Livre [] tab=new Livre[n];
			Statement st =conn.createStatement();
			String requete="select * from livre";
			ResultSet rs=st.executeQuery(requete);
			while(rs.next())
			{
			tab[i++]= new Livre(rs.getInt("CodeLivre"),rs.getString("TitreLivre"),rs.getString("DateDapparition"),rs.getInt("NbrLivreDispo"));
			}
			return tab;
		}
		
		public static void ajouter(Livre e) throws SQLException
		 {
			 String requete2="insert into livre values(?,?,?,?)";
				PreparedStatement ps=conn.prepareStatement(requete2);
				ps.setInt(1, e.getCodeLivre());
				ps.setString(2, e.getTitreLivre());
				ps.setString(3, e.getDateDapparition());
				ps.setInt(4, e.getNbrLivreDispo());
			ps.execute();	 
			
		 }
		public static boolean Livreequals(Livre l) throws SQLException
		{
			Statement st =conn.createStatement();
			String requete="select * from livre";
			ResultSet rs=st.executeQuery(requete);
			while(rs.next())
			{	
	                if(l.getCodeLivre()==rs.getInt("CodeLivre")&& l.getTitreLivre().equals(rs.getString("TitreLivre"))&&
	                l.getDateDapparition().equals(rs.getString("DateDapparition"))&& l.getNbrLivreDispo()==rs.getInt("NbrLivreDispo"))
	        	 return true;
	       
			}
			return false;
		}
		 public static void modifier (Livre l) throws SQLException
		 
		 {	
			 if(Livreequals(l))
			 {
			 Statement st =conn.createStatement();
			 Scanner sc=new Scanner(System.in);
			 System.out.println("entrer le  nouveau code du  livre");
			 int code=sc.nextInt();
			 sc.nextLine();
			 System.out.println("entrer le nouveau titre du livre ");
			 String TitreLivre=sc.nextLine();
			 
			 System.out.println("entrer la nouvelle date d'apparaition ");
			 String date=sc.nextLine();
			 
			 System.out.println("entrer le nouveau nombre de ce livre ");
			 int stock=sc.nextInt();
			 

			 String requete3="update  livre set CodeLivre='"+code+"',TitreLivre='"+TitreLivre+
					 "',DateDapparition='"+date+"'"+",NbrLivreDispo="+stock+" where CodeLivre="+l.getCodeLivre();
				st.executeUpdate(requete3);
			 }
			 else
			 {
				 System.out.println("Erreur");
			 }
			 
		 }

		public static void supprimerParCode(int code) throws SQLException {
			if(EmpruntDao.testerLivre(code))
			{
			Statement st =conn.createStatement();
			String requete="delete from livre where CodeLivre="+code;
			st.execute(requete);
			String requete1="delete from emprunt  where CodeLivre="+code;
			st.execute(requete1);
			}
			else
			{
				System.out.println("Erreur");
			}
		}
	  
		public static void alimenter(int code) throws SQLException
		{
			if(EmpruntDao.testerLivre(code))
			{
			Statement st =conn.createStatement();
			 Scanner sc=new Scanner(System.in);
			 System.out.println("entrer le nombre de livre à ajouter");
			 int stock=sc.nextInt();
			 sc.nextLine();
			 
			 String requete3="update  livre set NbrLivreDispo=NbrLivreDispo+"+stock +
					 " where CodeLivre="+code;
				st.executeUpdate(requete3);
			}
			else
				System.out.println("Erreur");
	
		}
	  public static void main(String[] args) throws SQLException 
		{
			Livre l=new Livre(2,"aaze","2020",122);
			//ajouter(l);
			//alimenter(l);
			//modifier(l);
			//alimenter(3);
			//modifier(l);
		}
}
