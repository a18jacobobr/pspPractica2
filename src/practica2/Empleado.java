package practica2;

import java.util.ArrayList;
import java.util.List;

import aedi.arbol.EnlazadoArbolBinario;

public class Empleado {
	
	private String nombre;
	private List<Integer> listado;
	
	public Empleado(String nombre) {
		super();
		this.nombre = nombre;
		listado = new ArrayList<Integer>();
	}
	
	public void llenaLaLista (EnlazadoArbolBinario arbolDatos, Familia family) {
		
		
		
		listado = ArbolUtil.devuelveValoresArbol(family.getArbolito());
	}
	public void vaciaLista () {
		
	}

}
