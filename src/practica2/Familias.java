package practica2;


import java.util.LinkedList;
import java.util.concurrent.Semaphore;

public class Familias {

	public LinkedList<Familia> conjuntoFamilias;
	private Semaphore primerSemaforo = new Semaphore(1);
	
	public static int familiasRestantes;



	public Familias(LinkedList<Familia> conjuntoFamilias) {
		super();
		this.conjuntoFamilias = conjuntoFamilias;
		familiasRestantes = conjuntoFamilias.size();
	}
	
	
	
	public LinkedList<Familia> getConjuntoFamilias() {
		return conjuntoFamilias;
	}



	public void setConjuntoFamilias(LinkedList<Familia> conjuntoFamilias) {
		this.conjuntoFamilias = conjuntoFamilias;
	}



	public static int getFamiliasRestantes() {
		return familiasRestantes;
	}



	public static void setFamiliasRestantes(int familiasRestantes) {
		Familias.familiasRestantes = familiasRestantes;
	}



	public void bloquear (Empleado empleado) {
				
		try {
			primerSemaforo.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (conjuntoFamilias.get(0) != null && !conjuntoFamilias.isEmpty()) {
			
			empleado.llenaLaLista(conjuntoFamilias.poll());
			System.out.println(empleado.getNombre()+" ha llenado su lista");
			familiasRestantes = familiasRestantes - 1;
			primerSemaforo.release();
		}		
	}
	
}
