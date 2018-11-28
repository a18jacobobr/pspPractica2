package practica2;

public class InformeFinal {
	
	public String nombreFamilia;
	public int media;
	
	public InformeFinal(int media) {
		super();
		this.media = media;
	}

	public InformeFinal(String nombreFamilia, int media) {
		super();
		this.nombreFamilia = nombreFamilia;
		this.media = media;
	}

	public String getNombreFamilia() {
		return nombreFamilia;
	}

	public void setNombreFamilia(String nombreFamilia) {
		this.nombreFamilia = nombreFamilia;
	}

	public int getMedia() {
		return media;
	}

	public void setMedia(int media) {
		this.media = media;
	}
	
	

}
