package practica2;


import java.util.LinkedList;
import java.util.List;
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



	public boolean bloquear (Empleado empleado) {
				
		try {
			if ( primerSemaforo.tryAcquire() ) {
				if (!conjuntoFamilias.isEmpty()) {
					Familia fam = conjuntoFamilias.poll();
					if (fam != null) {
						empleado.llenaLaLista(fam);
						System.out.println(empleado.getNombre()+" ha llenado su lista");
						familiasRestantes = familiasRestantes - 1;
						if (!conjuntoFamilias.isEmpty())
							primerSemaforo.release();
						return true;
					}
				}
			}
			return false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
}
