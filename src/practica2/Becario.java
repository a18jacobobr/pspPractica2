package practica2;

import java.util.List;

public class Becario extends Thread {

	private int numeroBecario;
	private ContenedorInformes contenedor;
	private Familias familiasBecario;
	private int tamanoFamilias;
	public static boolean acabado;	//indica a jefe cuando debe hacer el informe estadistico

	public void run() {
		acabado = false;
		int informesListos = contenedor.getListaInformesFinales().size();

		while (tamanoFamilias > informesListos) {			//mientras los informes intermedios listos no coincidan con el numero de familias totales
			while (contenedor.getListaInformesIntermedios().isEmpty()		//mientras el contenedor tenga informes intermedios y todavia tengamos familias por consultar
					&& !familiasBecario.getConjuntoFamilias().isEmpty()) {
				System.out.println("El becario " + numeroBecario + " esta haciendo cafes y barriendo");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			if (contenedor.bloqueaInformesIntermedios(this)) {		//devuelve true si se ha podido realizar un informe final
				informesListos = contenedor.getListaInformesFinales().size();
			}
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
		acabado = true;

	}

	public int getNumeroBecario() {
		return numeroBecario;
	}

	public void setNumeroBecario(int numeroBecario) {
		this.numeroBecario = numeroBecario;
	}

	public ContenedorInformes getContenedor() {
		return contenedor;
	}

	public void setContenedor(ContenedorInformes contenedor) {
		this.contenedor = contenedor;
	}

	public Familias getFamily() {
		return familiasBecario;
	}

	public void setFamily(Familias family) {
		familiasBecario = family;
	}

	public Becario(int numeroBecario, ContenedorInformes contenedor, Familias family) {
		super();
		this.numeroBecario = numeroBecario;
		this.contenedor = contenedor;
		familiasBecario = family;
		tamanoFamilias = family.getConjuntoFamilias().size();
	}

	public InformeFinal creaInformeFinal(InformeIntermedio informe) {
		List<Integer> listaEdades = informe.getListaEdades();
		int contador = 0;
		int suma = 0;
		int edadMax = 0;
		for (int i = 0; i < listaEdades.size(); i++) {
			suma = suma + listaEdades.get(i);
			if (edadMax < listaEdades.get(i)) {
				edadMax = listaEdades.get(i);
			}
			contador = contador + 1;
		}
		double media = suma / contador;

		InformeFinal informeFinal = new InformeFinal(informe.getNombreFamilia(), media, edadMax);
		System.out.println("el becario numero " + numeroBecario + " ha creado un informe final de la famila "
				+ informeFinal.getNombreFamilia());
		return informeFinal;
	}

}
