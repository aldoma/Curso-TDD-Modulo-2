package org.aldoma.cursotdd.modulo2.ejercicio1;

/**
 * Clase que representa una escitala para la encriptación y desencriptación de mensajes de texto.
 * 
 * @author Alberto Dominguez Matamoros
 */
public class Escitala {
	private int caras;
	private String frase;
	private String[][] escitala;
	private int largo;

	/**
	 * Constructor con inicialización explícita del número de caras de la Escitala y la frase a
	 * encriptar.
	 * 
	 * @param numCaras
	 *        número de caras de la escitala
	 * @param theFrase
	 *        frase a codificar
	 */
	public Escitala(	final int numCaras,
						final String theFrase ) {
		caras = numCaras;
		frase = theFrase;
	}

	/**
	 * Encripta una cadena de texto.
	 * 
	 * @return La cadena de texto encriptada.
	 */
	public String encrypt() {
		if (isValid()) {//comprobamos la frase las caras etc
			largo = frase.length() % caras == 0 ? frase.length() / caras : frase.length() / caras + 1; //Si el mensaje dividido entre las caras de la escitala da resto cero no sobrarían espacios
			escitala = new String[caras][largo]; //las caras representan las columnas de la escitala
			//el largo representa las filas

			int pivote = 0; //nos servirá de pivote para señalar el caracter actual en la frase

			for (int columna = 0; columna < largo; columna++) { //recorremos todas las filas DE CADA COLUMNA
				for (int fila = 0; fila < caras; fila++) { //recorremos todas las columnas
					if (pivote < frase.length()) { //Si no hemos recorrido toda la frase
						escitala[fila][columna] = String.valueOf( frase.charAt( pivote ) ); //Almacenamos el caracter que toque dentro del Array
						pivote++; //sumamos uno al pivote para apuntar al siguiente caracter de la cadena de texto a encrypt
					}
					else {
						escitala[fila][columna] = Escitala.aleatorio(); //como ya no quedan letras de la frase generamos un caracter aleatorio para cumplimentar los elementos del array
					}
				}
			}
			return toText( caras, largo ); //llamamos con la cantidad de filas
		}
		return null;
	}

	/**
	 * Desencripta una cadena de texto previamente encriptada por una escitala compatible.
	 * 
	 * @param frase2
	 *        frase a desencriptar.
	 * @return la frase desencriptada.
	 */
	public String decrypt( final String frase2 ) {
		if (isValid()) { //comprobamos la frase las caras etc
			largo = frase.length() % caras == 0 ? frase.length() / caras : frase.length() / caras + 1; //Si el mensaje dividido entre las caras de la escitala da resto cero no sobrarían espacios
			escitala = new String[largo][caras];

<<<<<<< HEAD
			int pivote = 0; //Nos servirá de pivote para la frase
=======
			int pivote = 0; //Nos servirá de pivote para la frase 
>>>>>>> refs/remotes/origin/master

			for (int columnas = 0; columnas < caras; columnas++) { //OJO esta vez la cantidad de columnas lo determinarán las caras
				for (int filas = 0; filas < largo; filas++) { //OJO esta vez las la cantidad de filas vendrá determinada por el largo.
					escitala[filas][columnas] = String.valueOf( frase2.charAt( pivote ) ); //vamos escribiendo caracter a caracter en el array bidimensional
					pivote++; //avanzamos el pivote una posición para que apunte al siguiente caracter del String a convertir.
				}
			}
			return toText( largo, caras ); //llamamos con la cantidad de filas, columnas. OJO hay que pasar como parámetro la variable que indique el máximo de filas y luego la
		} //que indique el máximo de columnas.
		return null;
	}

	private static String aleatorio() {
		final int aleatorio = (int) (Math.random() * 100) + 1; //calculamos un aleatorio de 1 a 100. Podríamos haber pusto otro rango.

		return String.valueOf( (char) aleatorio ); //Devolvemos como String el char que representa a ese número generado aleatorimente. (Código ASCII)
	}

	/**
	 * Retorna el array utilizado internamente convertido en una cadena de texto.
	 * 
	 * @param f
	 *        número de filas del array interno.
	 * @param c
	 *        número de columnas del array interno.
	 * @return una cadena de texto representando el array interno.
	 */
	private String toText(	final int f,
							final int c ) {
		final StringBuilder sb = new StringBuilder(); //Ya que no trabajamos con hilos creamos un StringBuilder que es más eficiente en estos casos

		for (int filas = 0; filas < f; filas++) { //Recorremos el array
			for (int columnas = 0; columnas < c; columnas++) {
				sb.append( escitala[filas][columnas] ); //y vamos agregando al StringBuilder caracter a carater
			}
		}
		return sb.toString(); //Devolvemos como String el contenido del StringBuilder
	}

	/**
	 * Valida si la clase se encuentra en un estado correcto para encriptar y desencriptar.
	 * 
	 * @return <code>true</code> si el estado del objeto permite las tareas de encriptación y
	 *         desencriptación, <code>false</code> en caso contrario.
	 */
	@SuppressWarnings( "nls" )
	private boolean isValid() {
		boolean correcto = false;

		if (caras > 0 && frase != null && frase.length() > caras) {
			correcto = true;
		}
		else {
			System.out
					.println( "Las cara deben ser un número entero positivo comprendido y la frase no puede ser nula. \n"
							+ ".Además la cantidad de letras de la frase no puede ser menor al número de caras" );
		}
		return correcto;
	}

	//MÉTODOS GETTERS AND SETTERS TÍPICOS.
	/**
	 * Retorna el número de caras de la escitala.
	 * 
	 * @return el número de caras de la escitala.
	 */
	public int getCaras() {
		return caras;
	}

	/**
	 * Establece el número de caras de la escitala.
	 * 
	 * @param numCaras
	 *        número de caras a establecer en la escitala.
	 */
	public void setCaras( final int numCaras ) {
		if (numCaras > 0) {
			caras = numCaras;
		}
	}

	/**
	 * Retorna la frase actual de la escitala.
	 * 
	 * @return la frase actual de la escitala.
	 */
	public String getFrase() {
		return frase;
	}

	/**
	 * Establece la frase a codificar por la escitala
	 * 
	 * @param theFrase
	 *        frase a codificar
	 */
	public void setFrase( final String theFrase ) {
		frase = theFrase;
	}
}
