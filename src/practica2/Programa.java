package practica2;

import java.util.LinkedList;
import java.util.List;

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
	
		//recursividad llamando al propio metodo para crear el arbol, en la profundidad deaseada (int profundidad) -> else y dejar de llamar al propio metodo
		
		Familia family = new Familia("Pepe");
		family.generaArbol(3);
		Familia family2 = new Familia("Lopez");
		family.generaArbol(3);	
		Familia family3 = new Familia("Saenz");
		family.generaArbol(3);
		Familia family4 = new Familia("Seeee");
		family.generaArbol(3);
		Familia family5 = new Familia("Paaa");
		family.generaArbol(3);
		Familia family6 = new Familia("Sieieo");
		family.generaArbol(3);
		LinkedList<Familia> listaFamilias = new LinkedList<Familia>();
		listaFamilias.add(family);
		listaFamilias.add(family2);
		listaFamilias.add(family3);
		listaFamilias.add(family4);
		listaFamilias.add(family5);
		listaFamilias.add(family6);
	
		
		
		Familias conjuntoFamilias = new Familias(listaFamilias);
		
		ContenedorInformes contenedor = new ContenedorInformes();
		
		Empleado primerEmpleado = new Empleado(conjuntoFamilias, contenedor, "JuanEmpleado");
//		Empleado segundoEmpleado = new Empleado(conjuntoFamilias, contenedor, "PepeEmpleado");
//		Empleado tercerEmpleado = new Empleado(conjuntoFamilias, contenedor, "FelipeEmpleado");
		
//		Becario becario = new Becario(1, contenedor);
//		Becario becario2 = new Becario(2, contenedor);
//		Becario becario3 = new Becario(3, contenedor);
//		
//		Jefe jefe = new Jefe(conjuntoFamilias, contenedor);
		
		primerEmpleado.start();
//		segundoEmpleado.start();
//		tercerEmpleado.start();
//		becario.start();
//		becario2.start();
//		becario3.start();
//		jefe.start();
		
		
//		List<Integer> misValores = ArbolUtil.devuelveValoresArbol(family.getArbolito());
		
		
		
		
		
	}

}
