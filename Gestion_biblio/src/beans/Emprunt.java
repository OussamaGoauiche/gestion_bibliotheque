package beans;

public class Emprunt {
	  private int Codemprunt;
      private int LivreEmprunte;
      private String EmprunteurCin;                    
      private String DateEmprunt;
      private String DateretourP;
	public Emprunt() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Emprunt(int codemprunt, int livreEmprunte, String EmprunteurCin, String dateEmprunt, String dateretourP) {
		super();
		Codemprunt = codemprunt;
		LivreEmprunte = livreEmprunte;
		EmprunteurCin = EmprunteurCin;
		DateEmprunt = dateEmprunt;
		DateretourP = dateretourP;
	}
	public int getCodemprunt() {
		return Codemprunt;
	}
	public void setCodemprunt(int codemprunt) {
		Codemprunt = codemprunt;
	}
	public int getLivreEmprunte() {
		return LivreEmprunte;
	}
	public void setLivreEmprunte(int livreEmprunte) {
		LivreEmprunte = livreEmprunte;
	}
	public String getEmprunteurCin() {
		return EmprunteurCin;
	}
	public void setEmprunteur(int EmprunteurCin) {
		EmprunteurCin = EmprunteurCin;
	}
	public String getDateEmprunt() {
		return DateEmprunt;
	}
	public void setDateEmprunt(String dateEmprunt) {
		DateEmprunt = dateEmprunt;
	}
	public String getDateretourP() {
		return DateretourP;
	}
	public void setDateretourP(String dateretourP) {
		DateretourP = dateretourP;
	}
	@Override
	public String toString() {
		return "Emprunt [Codemprunt=" + Codemprunt + ", LivreEmprunte=" + LivreEmprunte + ", EmprunteurCin="
				+ EmprunteurCin + ", DateEmprunt=" + DateEmprunt + ", DateretourP=" + DateretourP + "]";
	}
	
      
       
	
}
