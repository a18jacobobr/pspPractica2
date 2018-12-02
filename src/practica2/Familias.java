package practica2;

import java.util.LinkedList;
import java.util.concurrent.Semaphore;

public class Familias {

	public LinkedList<Familia> conjuntoFamilias;
	private Semaphore primerSemaforo = new Semaphore(1);

	public Familias(LinkedList<Familia> conjuntoFamilias) {
		super();
		this.conjuntoFamilias = conjuntoFamilias;

	}

	public LinkedList<Familia> getConjuntoFamilias() {
		return conjuntoFamilias;
	}

	public void setConjuntoFamilias(LinkedList<Familia> conjuntoFamilias) {
		this.conjuntoFamilias = conjuntoFamilias;
	}

	public boolean bloquear(Empleado empleado) {

		try {
			if (primerSemaforo.tryAcquire()) { // se ejecuta si es true
				if (!conjuntoFamilias.isEmpty()) { // comprueba que todavia hay familias que consultar
					Familia fam = conjuntoFamilias.poll(); // recopila los datos
					if (fam != null) { // comprueba que la familia no es null
						empleado.llenaLaLista(fam); // recoge los datos
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
