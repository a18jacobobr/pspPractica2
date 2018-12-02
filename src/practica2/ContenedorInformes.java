package practica2;

import java.util.LinkedList;
import java.util.concurrent.Semaphore;

public class ContenedorInformes {

	private LinkedList<InformeIntermedio> listaInformesIntermedios;
	private LinkedList<InformeFinal> listaInformesFinales;

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

	public boolean bloqueaInformesIntermedios(Becario becario) {

		if (semaforoIntermedios.tryAcquire()) {															//si es true ejecuta
			if (!listaInformesIntermedios.isEmpty() && listaInformesIntermedios.peek() != null) {		//si la lista de informes intermedios no esta vacia y lo que tenga dentro no es null
				InformeIntermedio finalillo = listaInformesIntermedios.poll();
				if (finalillo != null) {																//vuelve a comprobar q no sea null
					listaInformesFinales.add(becario.creaInformeFinal(finalillo));						//crea el informe final
				}
				semaforoIntermedios.release();

				return true;
			}
		}

		return false;
	}

}
