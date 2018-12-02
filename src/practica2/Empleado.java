package practica2;

import java.util.ArrayList;
import java.util.List;

public class Empleado extends Thread {

	private Familias familias;
	private ContenedorInformes contenedor;
	private String nombreEmpleado;
	private List<Integer> listado;
	private String apellidoFamilia;

	public Empleado(Familias familias, ContenedorInformes contenedor, String nombre) {
		super();
		this.familias = familias;
		this.contenedor = contenedor;
		this.nombreEmpleado = nombre;
		this.listado = new ArrayList<Integer>();
		this.apellidoFamilia = "";
	}

	public Empleado(String nombre) {
		super();
		this.nombreEmpleado = nombre;
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
		return nombreEmpleado;
	}

	public void setNombre(String nombre) {
		this.nombreEmpleado = nombre;
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

	public void run() {
		while (familias.getConjuntoFamilias().size() > 0) { // mientras tengamos familias
			if (familias.bloquear(this)) { // devuelve true si se creo informe intermedio
				contenedor.getListaInformesIntermedios().add(generaInformeIntermedio()); // añade el informe al contenedor
			} else {
				System.out.println("el empleado" + nombreEmpleado + " esta esperando para recoger datos");
			}
		}
	}

	public void llenaLaLista(Familia family) {
		if (family != null) {
			apellidoFamilia = family.getContacto();
			listado = ArbolUtil.devuelveValoresArbol(family.getArbolito());
		}
	}

	public InformeIntermedio generaInformeIntermedio() {
		InformeIntermedio informeGenerado = new InformeIntermedio(apellidoFamilia, listado);
		System.out.println("el empleado " + nombreEmpleado + "ha creado el informe intermedio de la familia "
				+ informeGenerado.getNombreFamilia());
		return informeGenerado;
	}

}
