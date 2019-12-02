package parc201911;

import java.util.ArrayList;

public class Tarea3 {

	public static void encuentraSuma(int num_max, int num_buscado, int suma_actual, ArrayList<Integer> num_usados) {
		if(num_max == 0) {//caso base
			if(suma_actual == num_buscado) {
				System.out.println(listaAString(num_usados));
			}
		}
		else {
			suma_actual += num_max;
			num_usados.add(num_max);
			if(suma_actual < num_buscado) {
				encuentraSuma(num_max -= 1, num_buscado, suma_actual, num_usados);
			}
			else if(suma_actual == num_buscado) {
				System.out.println(listaAString(num_usados));
			}
			else {
				suma_actual -= num_max;
				num_usados.remove(num_usados.size() - 1);
				encuentraSuma(num_max -= 1, num_buscado, suma_actual, num_usados);
			}
		}		
	}
	
	public static String listaAString(ArrayList<Integer> lista) {
		String texto = "La suma es [";
		for(int num: lista) {
			texto += num + ", ";
		}
		texto = texto.substring(0, texto.lastIndexOf(", "));
		texto += "]";
		return texto;
	}
	
		
	public static void main(String[] args) {
		encuentraSuma(20, 183, 0, new ArrayList<Integer>());
	}
}
