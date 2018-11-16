package practica2;

public class Programa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 3 trabajadores ejecutan varias familias
		// las familias las eligen desde el listado, al que acceden individualmente (semaforo)
		// selecciona una y ejecuta la persona de contacto (libera semaforo)
		// trabajador ejecuta persona contacto para recibir los datos
		// trabajador crea informe intermedio publico
		// 
		
		// cuatro hilos -> empleado, becarios, jefe, contacto
		
		// empleado -> elige contacto y lo ejecuta, recibe sus datos(de uno en uno) y crea informe intermedio,
		// becario -> sirven cafes y barren, si hay informes hacen la media de la edad para crea un informe final
		// jefe -> recoge informes finales, espera mientras tanto
		// contacto -> recoge los datos de su familia y los devuelve de uno en uno
		// informe -> es el buffer y los informes son el recurso, que empieza = 0
		//
		
	}

}
