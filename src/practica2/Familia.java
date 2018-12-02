package practica2;

import aedi.arbol.EnlazadoArbolBinario;

public class Familia {

	public String contacto;
	public EnlazadoArbolBinario arbolito;

	public Familia(String contacto) {
		super();
		this.contacto = contacto;
		this.arbolito = new EnlazadoArbolBinario();
	}

	public EnlazadoArbolBinario generaArbol(int profundidad) {
		arbolito = ArbolUtil.creaElArbol(profundidad);
		return arbolito;
	}

	public String getContacto() {
		return contacto;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
	}

	public EnlazadoArbolBinario getArbolito() {
		return arbolito;
	}

	public void setArbolito(EnlazadoArbolBinario arbolito) {
		this.arbolito = arbolito;
	}

}
