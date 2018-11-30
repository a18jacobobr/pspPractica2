package practica2;

import java.util.LinkedList;
import java.util.concurrent.Semaphore;

public class ContenedorInformes {
	
	public LinkedList<InformeIntermedio> listaInformesIntermedios;
	public LinkedList<InformeFinal> listaInformesFinales;
	public static int informesIntermediosRestantes = 0;
	public static int informesFinalesListos = 0;
	private Semaphore semaforoIntermedios = new Semaphore(1);
	
	public ContenedorInformes() {
		super();
		this.listaInformesIntermedios = new LinkedList<InformeIntermedio>();
		this.listaInformesFinales = new LinkedList<InformeFinal>();
	}
	
	
	
	public LinkedList<InformeIntermedio> getListaInformesIntermedios() {
		return listaInformesIntermedios;
	}



	public void setListaInformesIntermedios(LinkedList<InformeIntermedio> listaInformesIntermedios) {
		this.listaInformesIntermedios = listaInformesIntermedios;
	}



	public LinkedList<InformeFinal> getListaInformesFinales() {
		return listaInformesFinales;
	}



	public void setListaInformesFinales(LinkedList<InformeFinal> listaInformesFinales) {
		this.listaInformesFinales = listaInformesFinales;
	}



	public void bloqueaInformesIntermedios (Becario becario) {
		try {
			semaforoIntermedios.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(!listaInformesIntermedios.isEmpty()) {
			listaInformesFinales.add(becario.creaInformeFinal(listaInformesIntermedios.poll()));
			ContenedorInformes.informesIntermediosRestantes = ContenedorInformes.informesIntermediosRestantes - 1;
			System.out.println("el becario numero "+becario.numeroBecario+" ha creado un informe final");
			informesFinalesListos = informesFinalesListos + 1;
			int inf = informesFinalesListos; 
			semaforoIntermedios.release();
		}
	}

}
