package practica2;

import java.util.List;
import java.util.concurrent.Semaphore;

public class Becario extends Thread{
	
	public int numeroBecario;
	public ContenedorInformes contenedor;
//	public Semaphore semaforoBecario;
	public static Semaphore semaforoRecoger = new Semaphore(1);
//	private int esperando = 0;
	
	public Becario(int numeroBecario, ContenedorInformes contenedor) {
		super();
		this.numeroBecario = numeroBecario;
		this.contenedor = contenedor;
	}
	
	public void run () {
				
		while (ContenedorInformes.informesFinalesListos < 6) {
			while (ContenedorInformes.informesIntermediosRestantes <= 0) {
				System.out.println("El becario "+numeroBecario+" esta haciendo cafes y barriendo");
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
			contenedor.bloqueaInformesIntermedios(this);
//			contenedor.listaInformesFinales.add(creaInformeFinal(contenedor.listaInformesIntermedios.poll()));
//			ContenedorInformes.informesIntermediosRestantes = ContenedorInformes.informesIntermediosRestantes - 1;
			
			semaforoRecoger.release();
			
			
		}
		
	}
	
	public InformeFinal creaInformeFinal (InformeIntermedio informe) {
		List<Integer> listaEdades =  informe.getListaEdades();
		int contador = 0;
		int suma = 0;
		int edadMax = 0;
		for (int i = 0; i < listaEdades.size(); i++) {
			suma = suma + listaEdades.get(i);
			if (edadMax < listaEdades.get(i)) {
				edadMax = listaEdades.get(i);
			}
			contador = contador + 1;
		}
		double media = suma / contador;
		
		InformeFinal informeFinal = new InformeFinal(informe.getNombreFamilia(), media, edadMax);
		return informeFinal;
	}

}
