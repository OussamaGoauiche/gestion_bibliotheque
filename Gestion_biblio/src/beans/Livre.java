package beans;

public class Livre {

	private int CodeLivre;
	private String TitreLivre;
	private String DateDapparition;                    
	private int NbrLivreDispo;
	public Livre() {
		super();
	}
	public Livre(int codeLivre, String titreLivre, String dateDapparition, int nbrLivreDispo) {
		super();
		CodeLivre = codeLivre;
		TitreLivre = titreLivre;
		DateDapparition = dateDapparition;
		NbrLivreDispo = nbrLivreDispo;
	}
	public int getCodeLivre() {
		return CodeLivre;
	}
	public void setCodeLivre(int codeLivre) {
		CodeLivre = codeLivre;
	}
	public String getTitreLivre() {
		return TitreLivre;
	}
	public void setTitreLivre(String titreLivre) {
		TitreLivre = titreLivre;
	}
	public String getDateDapparition() {
		return DateDapparition;
	}
	public void setDateDapparition(String dateDapparition) {
		DateDapparition = dateDapparition;
	}
	public int getNbrLivreDispo() {
		return NbrLivreDispo;
	}
	public void setNbrLivreDispo(int nbrLivreDispo) {
		NbrLivreDispo = nbrLivreDispo;
	}
	@Override
	public String toString() {
		return "Livre [CodeLivre=" + CodeLivre + ", TitreLivre=" + TitreLivre + ", DateDapparition=" + DateDapparition
				+ ", NbrLivreDispo=" + NbrLivreDispo + "]";
	}
	
	
}
