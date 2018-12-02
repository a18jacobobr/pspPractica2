package practica2;

import java.util.LinkedList;

public class Programa {

	public static void main(String[] args) {

		Familia family = new Familia("Pepe");
		family.setArbolito(family.generaArbol(3));
		Familia family2 = new Familia("Lopez");
		family2.setArbolito(family2.generaArbol(3));
		Familia family3 = new Familia("Saenz");
		family3.setArbolito(family3.generaArbol(3));
		Familia family4 = new Familia("Seeee");
		family4.setArbolito(family4.generaArbol(3));
		Familia family5 = new Familia("Paaa");
		family5.setArbolito(family5.generaArbol(3));
		;
		Familia family6 = new Familia("Sieieo");
		family6.setArbolito(family6.generaArbol(3));
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
		Empleado segundoEmpleado = new Empleado(conjuntoFamilias, contenedor, "PepeEmpleado");
		Empleado tercerEmpleado = new Empleado(conjuntoFamilias, contenedor, "FelipeEmpleado");

		Becario becario = new Becario(1, contenedor, conjuntoFamilias);
		Becario becario2 = new Becario(2, contenedor, conjuntoFamilias);
		Becario becario3 = new Becario(3, contenedor, conjuntoFamilias);

		Jefe jefe = new Jefe(conjuntoFamilias, contenedor);

		primerEmpleado.start();
		segundoEmpleado.start();
		tercerEmpleado.start();
		becario.start();
		becario2.start();
		becario3.start();
		jefe.start();

	}

}
