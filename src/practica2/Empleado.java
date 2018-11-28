package practica2;

import java.util.ArrayList;
import java.util.List;

import aedi.arbol.EnlazadoArbolBinario;

public class Empleado extends Thread {
	
	private Familias familias;
	private ContenedorInformes contenedor;
	private String nombre;
	private List<Integer> listado;
	private String apellidoFamilia;
		
	public Empleado(Familias familias, ContenedorInformes contenedor, String nombre, List<Integer> listado,
			String apellidoFamilia) {
		super();
		this.familias = familias;
		this.contenedor = contenedor;
		this.nombre = nombre;
		this.listado = listado;
		this.apellidoFamilia = apellidoFamilia;
	}
	
	public Empleado(String nombre) {
		super();
		this.nombre = nombre;
		listado = new ArrayList<Integer>();
	}
	
	
	public Familias getFamilias() {
		return familias;
	}

	public void setFamilias(Familias familias) {
		this.familias = familias;
	}

	public ContenedorInformes getContenedor() {
		return contenedor;
	}

	public void setContenedor(ContenedorInformes contenedor) {
		this.contenedor = contenedor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Integer> getListado() {
		return listado;
	}

	public void setListado(List<Integer> listado) {
		this.listado = listado;
	}

	public String getApellidoFamilia() {
		return apellidoFamilia;
	}

	public void setApellidoFamilia(String apellidoFamilia) {
		this.apellidoFamilia = apellidoFamilia;
	}

	public void run () {
		while (familias.conjuntoFamilias.size() > 0) {
			familias.bloquear(this);
			contenedor.listaInformesIntermedios.add(generaInformeIntermedio());
			InformeIntermedio.informesRestantes = InformeIntermedio.informesRestantes + 1;
			vaciaLista();
		}
	}
	
	public void llenaLaLista (Familia family) {
		apellidoFamilia = family.getContacto();
		listado = ArbolUtil.devuelveValoresArbol(family.getArbolito());
	}
	public void vaciaLista () {
		listado.clear();
		apellidoFamilia = "";
	}

	public InformeIntermedio generaInformeIntermedio () {
		InformeIntermedio informeGenerado = new InformeIntermedio(apellidoFamilia, listado);
		return informeGenerado;
	}
	
	
}
