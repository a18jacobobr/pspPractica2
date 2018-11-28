package practica2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.Semaphore;

public class Familias {

	public LinkedList<Familia> conjuntoFamilias;
	private Semaphore primerSemaforo;
	private boolean recogiendoDatos = false;
	private int esperando = 0;
	public static int familiasRestantes;



	public Familias(LinkedList<Familia> conjuntoFamilias) {
		super();
		this.conjuntoFamilias = conjuntoFamilias;
		familiasRestantes = conjuntoFamilias.size();
	}
	
	public void bloquear (Empleado empleado) {
		
		if (recogiendoDatos == true) {
			try {
				esperando = esperando + 1;
				primerSemaforo.acquire();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 	
		recogiendoDatos = true;
		empleado.llenaLaLista(conjuntoFamilias.poll());
		familiasRestantes = familiasRestantes - 1;
		if (esperando > 0) {
			primerSemaforo.release();
			esperando = esperando - 1;
		}
		recogiendoDatos = false;
				
	}
	
}
