package practica2;

public class Jefe extends Thread {
	
	public Familias familias;
	public ContenedorInformes contenedor;
	
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
	
	
	public void run () {
		while (familias.getConjuntoFamilias().size() != ContenedorInformes.informesFinalesListos ) {
			System.out.println("El jefe esta esperando informes");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for (int i = 0; i > contenedor.getListaInformesFinales().size(); i++) {
			contenedor.getListaInformesFinales().get(i).toString();
		}
		
	}
	
	

}
