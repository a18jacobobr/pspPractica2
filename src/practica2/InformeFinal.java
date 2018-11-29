package practica2;

public class InformeFinal {
	
	public String nombreFamilia;
	public double media;
	public int edadMax;
	
	
	public InformeFinal(String nombreFamilia, double media, int edadMax) {
		super();
		this.nombreFamilia = nombreFamilia;
		this.media = media;
		this.edadMax = edadMax;
	}

	public String getNombreFamilia() {
		return nombreFamilia;
	}

	public void setNombreFamilia(String nombreFamilia) {
		this.nombreFamilia = nombreFamilia;
	}

	public double getMedia() {
		return media;
	}

	public void setMedia(int media) {
		this.media = media;
	}

	public int getEdadMax() {
		return edadMax;
	}

	public void setEdadMax(int edadMax) {
		this.edadMax = edadMax;
	}

	@Override
	public String toString() {
		return "InformeFinal [nombreFamilia=" + nombreFamilia + ", media=" + media + ", edadMax=" + edadMax + "]";
	}

	

}
