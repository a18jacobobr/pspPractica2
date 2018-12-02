package practica2;

public class Jefe extends Thread {

	private Familias familias;
	private ContenedorInformes contenedor;

	public Jefe(Familias familias, ContenedorInformes contenedor) {
		super();
		this.familias = familias;
		this.contenedor = contenedor;
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

	public void run() {
		while (Becario.acabado == false) { // mientras no terminen los becarios
			System.out.println("El jefe esta esperando informes");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("");
		System.out.println("Resumen estadístico final");
		System.out.println("-----------------------------------------------------");
		int tamano = contenedor.getListaInformesFinales().size();
		for (int i = 0; i < tamano; i++) {
			InformeFinal informecito = contenedor.getListaInformesFinales().get(i); // imprime el resumen estadístico
			System.out.println(informecito);
		}

	}

}
