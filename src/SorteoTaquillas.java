import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class SorteoTaquillas {

	static Participante[] listaParticipantes = new Participante[200];
	static Participante[] listaDAI = new Participante[100];
	private static int numPart = 0, numDAI = 0;

	public static void main(String[] args) throws Exception {
		for (int i = 0; i < listaParticipantes.length; i++)
			listaParticipantes[i] = null;
		
		for (int i = 0; i < listaDAI.length; i++)
			listaDAI[i] = null;

		// Leer el fichero de los participantes y de los miembros de la DAI y
		// hacer una lista de los participantes
		Scanner kbd = new Scanner(System.in).useLocale(Locale.US);

		Scanner listaNombre = null;
		Scanner listaNombreDAI = null;
		String nombreFich = new String();
		try {
			System.out
					.println("¿En qué fichero se encuentran los nombres de los participantes? (Dirección/nombrearchivo.txt)");
			nombreFich = kbd.next();
			listaNombre = new Scanner(new File("files/" + nombreFich));
			listaNombreDAI = new Scanner(new File("files/AlumnosDAI.txt"));

			System.out.println("\nLOS PARTICIPANTES LEIDOS SON:");

			// Añadimos los participantes a la lista
			while (listaNombre.hasNext()) {

				listaParticipantes[numPart] = new Participante(
						listaNombre.nextLine());
				System.out.println(listaParticipantes[numPart].toString());
				numPart++;
			}
			
			while (listaNombreDAI.hasNext()) {

				listaDAI[numDAI] = new Participante(
						listaNombreDAI.nextLine());
				numDAI++;
			}

		} catch (FileNotFoundException e) {
			System.out.println("Este fichero no existe, inténtelo de nuevo.\n");
		} finally {
			listaNombre.close();
			listaNombreDAI.close();
		}

		// Quitar duplicados
		System.out.println("DUPLICADOS");
		comprobarRepetidos();
		
		// Quitar DAI
		System.out.println("\nDAI");
		comprobarDAI();

		// Realizar sorteo
		Participante[] listaSorteo = randomize(listaParticipantes);

		// Mostrar resultados
		System.out.println("\nEL RESULTADO ES:");

		for (int i = 0; i < listaSorteo.length; i++){
			if (listaSorteo [i] != null){
				if (!listaSorteo[i].getNombre().equals("null"))
				System.out.println(listaSorteo[i].toString());
			}
		}

		// DOLORES DE LA RUBIA RODRIGUEZ, 30533829H
		// GARCIA SANTISO NATALIA, 53182941H
	}

	private static Participante[] randomize(Participante[] listaParticipantes) {
		Participante[] aux = new Participante[listaParticipantes.length];
		int contador = 0;
		while (listaParticipantes.length > 0) {

			// Cogemos número random
			int r = (int) (Math.random() * listaParticipantes.length);

			// Asignamos valor random a nueva lista y actualizamos la variable
			// contador
			aux[contador] = listaParticipantes[r];
			contador++;

			// Restamos el elemento al array lista
			Participante[] algoNuevo = new Participante[listaParticipantes.length - 1];

			// recorremos de 0 hasta r añadiendolos a algoNuevo
			for (int i = 0; i < r; i++) {
				algoNuevo[i] = listaParticipantes[i];
			}
			// recorremos de r hasta lista.length añadiendolos a algoNuevo
			for (int i = r + 1; i < listaParticipantes.length; i++) {
				algoNuevo[i - 1] = listaParticipantes[i];
			}
			listaParticipantes = algoNuevo;
		}
		return aux;
	}

	private static Participante[] copiarArray(Participante[] orig)
			throws Exception {
		Participante[] copia = new Participante[numPart];

		for (int j = 0; j < copia.length; j++) {
			copia[j] = new Participante(orig[j].getNombre().concat("," + orig[j].getDNI()));
		}
		return copia;
	}

	// Comprobamos que no están repetidos
	private static void comprobarRepetidos() throws Exception {
		for (int i = 0; i < listaParticipantes.length - 1; i++) {
			if (listaParticipantes[i] != null) {
				for (int j = i + 1; j < listaParticipantes.length; j++) {
					if (listaParticipantes[j] != null) {
						if (listaParticipantes[i].equals(listaParticipantes[j]))
							listaParticipantes[j] = new Participante("null, null");
					}
				}
			}
		}
	}
	
	private static void comprobarDAI () throws Exception{
		for (int i = 0; i < listaDAI.length; i++){
			if (listaDAI[i] != null) {
				for (int j = 0; j < listaParticipantes.length; j++){
					if (listaParticipantes[j] != null) {
						if (listaParticipantes[j].equals(listaDAI[i]))
							listaParticipantes[j] = new Participante("null, null");
					}
				}
			}
		}
	}
}
