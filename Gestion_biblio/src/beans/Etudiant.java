package beans;

public class Etudiant {
	private String cin,nom,prenom,filiere;

	
	public Etudiant() {
		super();
	}


	public Etudiant(String cin, String nom, String prenom, String filiere) {
		super();
		this.cin = cin;
		this.nom = nom;
		this.prenom = prenom;
		this.filiere = filiere;
	}


	public String getCin() {
		return cin;
	}


	public void setCin(String cin) {
		this.cin = cin;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getFiliere() {
		return filiere;
	}


	public void setFiliere(String filiere) {
		this.filiere = filiere;
	}


	@Override
	public String toString() {
		return "Etudiant [cin=" + cin + ", nom=" + nom + ", prenom=" + prenom + ", filiere=" + filiere + "]";
	}


	
}
