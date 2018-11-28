package practica2;

import java.util.List;
import java.util.concurrent.Semaphore;

public class Becario extends Thread{
	
	public int cafes;
	public ContenedorInformes contenedor;
	public Semaphore semaforoBecario;
	public Semaphore semaforoRecoger = new Semaphore(1);
	
	public Becario(int cafes, ContenedorInformes contenedor) {
		super();
		this.cafes = cafes;
		this.contenedor = contenedor;
	}
	
	public void run () {
				
		while (Familias.familiasRestantes > 0) {
			while (InformeIntermedio.informesRestantes <= 0) {
				cafes = cafes + 1;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}					
			}
			try {
				semaforoRecoger.acquire();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			contenedor.listaInformesFinales.add(creaInformeFinal(contenedor.listaInformesIntermedios.poll()));
			
		}
		
	}
	
	public InformeFinal creaInformeFinal (InformeIntermedio informe) {
		List<Integer> listaEdades =  informe.getListaEdades();
		int contador = 0;
		int suma = 0;
		for (int i = 0; i < listaEdades.size(); i++) {
			suma = suma + listaEdades.get(i);
			contador = contador + 1;
		}
		int media = suma / contador;
		InformeFinal informeFinal = new InformeFinal(media);
		return informeFinal;
	}

}
