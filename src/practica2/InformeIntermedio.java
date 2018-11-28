package practica2;

import java.util.List;

public class InformeIntermedio {
	
	public String nombreFamilia;
	public List<Integer> listaEdades;
	
	public InformeIntermedio(String nombreFamilia, List<Integer> listaEdades) {
		super();
		this.nombreFamilia = nombreFamilia;
		this.listaEdades = listaEdades;
	}

	public String getNombreFamilia() {
		return nombreFamilia;
	}

	public void setNombreFamilia(String nombreFamilia) {
		this.nombreFamilia = nombreFamilia;
	}

	public List<Integer> getListaEdades() {
		return listaEdades;
	}

	public void setListaEdades(List<Integer> listaEdades) {
		this.listaEdades = listaEdades;
	}
	
	
	
	
}
