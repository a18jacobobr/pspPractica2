package practica2;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Familias {

	public ArrayList<Familia> conjuntoFamilias;
	private Semaphore primerSemaforo;
	private boolean recogiendoDatos = false;


	public Familias(ArrayList<Familia> conjuntoFamilias) {
		super();
		this.conjuntoFamilias = conjuntoFamilias;
	}
	
	public void bloquear () {
		
		if (recogiendoDatos == true) {
			primerSemaforo.acquire();
		} 	
		recogiendoDatos = true;
		
		
			
		soy el empleeado i
		si no hay nadie en family j entro
		si hay alguien pruebo otro
		si estan ocupados bloqueo
		
		pillo recurso
		
		si hay alguien esperando a familia i libero sobre familia i
		si no hay nadie no hago na
		
		
	}
	
}
