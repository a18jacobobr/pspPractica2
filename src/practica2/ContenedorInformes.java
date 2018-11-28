package practica2;

import java.util.ArrayList;
import java.util.LinkedList;

public class ContenedorInformes {
	
	public LinkedList<InformeIntermedio> listaInformesIntermedios;
	public LinkedList<InformeFinal> listaInformesFinales;
	public static int informesIntermediosRestantes = 0;
	
	public ContenedorInformes() {
		super();
		this.listaInformesIntermedios = new LinkedList<InformeIntermedio>();
		this.listaInformesFinales = new LinkedList<InformeFinal>();
	}
	
	

}
