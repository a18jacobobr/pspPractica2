package practica2;

import java.util.ArrayList;
import java.util.List;

import aedi.arbol.ArbolBinario;
import aedi.arbol.EnlazadoArbolBinario;

public class ArbolUtil {

	public static EnlazadoArbolBinario creaElArbol(int prof) {
		
		if (prof == 0) {
			return new EnlazadoArbolBinario();
		} else {
			return new EnlazadoArbolBinario((int) (Math.random()*80)+1, creaElArbol(prof-1), creaElArbol(prof-1));
		}
		
	}
	
	public static List<Integer> devuelveValoresArbol(ArbolBinario tree) {
		
		List<Integer> list = new ArrayList<>();
		
		if (!tree.esVacio()) {
			list.addAll(devuelveValoresArbol( tree.hijoIzq() ));
			list.addAll(devuelveValoresArbol( tree.hijoDer() ));
			list.add((Integer) tree.raiz());
		}
		
		return list;
	
	}
	
}
