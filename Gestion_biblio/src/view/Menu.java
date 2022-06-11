package view;

import java.sql.SQLException;
import java.util.Scanner;

import beans.Etudiant;
import beans.Livre;

import dao.EmpruntDao;
import dao.EnregistrerCsv;
import dao.EtudiantDao;
import dao.LivreDao;

public class Menu {

	public static void menu0() throws SQLException
	{
        Scanner sc=new Scanner(System.in); 

		System.out.println("G�rer les livres, appuyez sur � 1 �");
		System.out.println("G�rer les �tudiants, appuyez sur � 2 �");
		System.out.println("Emprunter un livre, appuyez sur � 3�");
		System.out.println("Remettre un livre, appuyez sur � 4 �");
		System.out.println("Enregistrer les donn�es dans des fichiers CSV, appuyez sur � 5 �");
		System.out.println("Pour quitter le programme, appuyez sur � 0 �");
		 while(true)
	        {
	        System.out.println("\ndonner votre choix principale");
	        int choix=sc.nextInt();
	        sc.nextLine();
	       if(choix==0) break;
	        	switch(choix)
	        	{
	        	case 1:
	        		menu1();
					break;
	        	case 2:
	        		menu2();
	    			break;
	        	case 3:
	        		EmpruntDao.emprunter();
	        		break;
	        	case 4:
	        		EmpruntDao.remettre();
					 break;
	        	case 5:
	        		EnregistrerCsv.enregistrerEnCsv();
					 break;
					 
					 default:
						 System.out.println("!!!erreur:le numero n'existe pas");
	        	
	        	}
	        }
		
	}
	
	public static void menu1() throws SQLException
	{
		 Scanner sc=new Scanner(System.in); 

			System.out.println("Lister les livres, appuyez sur � 1 �");
			System.out.println("Alimenter le stock d�un livre, appuyez sur � 2 �");
			System.out.println("Ajouter un livre, appuyez sur � 3�");
			System.out.println("Modifier un livre , appuyez sur � 4 �");
			System.out.println("Supprimer un livre, appuyez sur � 5 �");
			System.out.println("Pour quitter le programme, appuyez sur � 0 �");
			 while(true)
		        {
		        System.out.println("\ndonner votre choix pour la gestion des livres");
		        int choix=sc.nextInt();
		        sc.nextLine();
		       if(choix==0) break;
		        	switch(choix)
		        	{
		        	case 1:
		        		 Livre[]l;
		       		  l= LivreDao.Lister();
		       		  
		       		  for(Livre e:l)
		       		  {
		       			  System.out.println(e);
		       		  }
						break;
		        	case 2:
		        		 System.out.println("entrer le code du livre � alimenter");
		    			 int n=sc.nextInt();
		    			if(EmpruntDao.testerLivre(n))
		    			{
		    				LivreDao.alimenter(n);
		    			}
		    			break;
		        	case 3:
		        		System.out.println("donner le nombre des livres � inserer");
		        		 int n1=sc.nextInt();
		        		 sc.nextLine();
		        		for(int i=0;i<n1;i++)
						{
		        			System.out.println("entrer le code du livre");
		       			 int code=sc.nextInt();
		       			 sc.nextLine();
		       			 System.out.println("entrer le titre du livre ");
		       			 String TitreLivre=sc.nextLine();
		       			 
		       			 System.out.println("entrer la date d'apparaition");
		       			 String date=sc.nextLine();
		       			 
		       			 System.out.println("entrer le nombre de ce livre");
		       			 int stock=sc.nextInt();
				        
		                Livre e1=new Livre(code,TitreLivre,date,stock);
		                LivreDao.ajouter(e1);
					    
						}
		        		break;
		        	case 4:
		        		System.out.println("entrer le code du livre � modifier");
		       			 int code=sc.nextInt();
		       			 sc.nextLine();
		       			 System.out.println("entrer le titre du livre � modifier");
		       			 String TitreLivre=sc.nextLine();
		       			 
		       			 System.out.println("entrer la date d'apparaition � modifier");
		       			 String date=sc.nextLine();
		       			 
		       			 System.out.println("entrer le nombre de ce livre � modifier");
		       			 int stock=sc.nextInt();
				        
		                Livre e1=new Livre(code,TitreLivre,date,stock);
						 LivreDao.modifier(e1);
						 break;
		        	case 5:
		        		System.out.println("donner le code du livre a supprimer");
						 int id3=sc.nextInt();
						 LivreDao.supprimerParCode(id3);
						 break;
						 
						 default:
							 System.out.println("!!!erreur:le numero n'existe pas");
		        	
		        	}
		        }
			
	}
	
	
	public static void menu2() throws SQLException
	{
		 Scanner sc=new Scanner(System.in); 

			System.out.println("Lister les �tudiants, appuyez sur � 1 �");
			System.out.println(" Ajouter un �tudiant, appuyez sur � 2 �");
			System.out.println(" Modifier un �tudiant, appuyez sur � 3�");
			System.out.println("Supprimer un �tudiant, appuyez sur � 4 �");
			System.out.println("Pour quitter le programme, appuyez sur � 0 �");
			 while(true)
		        {
		        System.out.println("\ndonner votre choix pour la gestion des etudiants");
		        int choix=sc.nextInt();
		        sc.nextLine();
		       if(choix==0) break;
		        	switch(choix)
		        	{
		        	case 1:
		        		 Etudiant[] e;
						 e=EtudiantDao.Lister();
						 for(Etudiant l1:e)
						  {
							  System.out.println(l1);
						  }
						break;
		       
		        	case 2:
		        		System.out.println("donner le nombre des etudiants � inserer");
		        		 int n1=sc.nextInt();
		        		 sc.nextLine();
		        		for(int i=0;i<n1;i++)
						{
		        			System.out.println("entrer le cin");
		       			 String cin=sc.nextLine();
		       			 
		       			 System.out.println("entrer le nom ");
		       			 String nom=sc.nextLine();
		       			 
		       			 System.out.println("entrer le prenom");
		       			 String prenom=sc.nextLine();
		       			 
		       			 System.out.println("entrer la filiere");
		       			 String filiere=sc.nextLine();
		       			
		                Etudiant e1=new Etudiant(cin,nom,prenom,filiere);
		                EtudiantDao.ajouter(e1);
					    
						}
		        		break;
		         	case 3:
		         		System.out.println("entrer le cin � modifier");
		       			 String cin=sc.nextLine();
		       			 
		       			 System.out.println("entrer le nom � modifier");
		       			 String nom=sc.nextLine();
		       			 
		       			 System.out.println("entrer le prenom � modifier");
		       			 String prenom=sc.nextLine();
		       			 
		       			 System.out.println("entrer la filiere � modifier");
		       			 String filiere=sc.nextLine();
				        
		                Etudiant e1=new Etudiant(cin,nom,prenom,filiere);
		    			
		    				EtudiantDao.modifier(e1);
		    			
		    			break;
		        	case 4:
		        		System.out.println("donner le cin d'etudiant a supprimer");
		        		 String cin1=sc.nextLine();
		        		 EtudiantDao.supprimerParCin(cin1);
						 break;
						 
						 default:
							 System.out.println("!!!erreur:le numero n'existe pas");
		        	
		        	}
		        }
			
	}
	
	

}
