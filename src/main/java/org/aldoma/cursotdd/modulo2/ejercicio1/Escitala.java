package org.aldoma.cursotdd.modulo2.ejercicio1;

/**
 * Clase que representa una escitala para la encriptación y desencriptación de mensajes de texto.
 * 
 * @author Alberto Dominguez Matamoros
 */
public class Escitala {
	/** Número de caras de la escitala. */
	private final int caras;

	/**
	 * Constructor con inicialización explícita del número de caras de la Escitala.
	 * 
	 * @param numCaras
	 *        número de caras de la escitala
	 * @throws IllegalArgumentException
	 *         si el número de caras no es un entero positivo mayor que 1
	 */
	public Escitala( final int numCaras )
			throws IllegalArgumentException {
		if (1 >= numCaras) {
			throw new IllegalArgumentException(
					"El número de caras de una escitala ha de ser un entero positivo mayor que 1." ); //$NON-NLS-1$
		}
		caras = numCaras;
	}

	/**
	 * Encripta una cadena de texto.
	 * <p>
	 * <strong>¡Atención!</strong> Esta función es no determinista.
	 * <p>
	 * Ademas, es importante tener en cuenta que la longuitud de la cadena de texto retornada es
	 * igual al primer múltiplo del número de caras de la escitala igual o superior a la longuitud
	 * de la frase a encriptar.
	 * 
	 * @param frase
	 *        frase a encriptar
	 * @return La cadena de texto encriptada.
	 * @see <a href="http://es.wikipedia.org/wiki/Algoritmo_no_determinista">Algoritmo no
	 *      determinista</a>
	 */
	public String encrypt( final String frase ) {
		String result = null;
		if (isValid( frase )) {
			//Si el mensaje dividido entre las caras de la escitala da resto cero no sobrarían espacios
			final int largo = frase.length() % caras == 0 ? frase.length() / caras : frase.length() / caras + 1;
			final char[][] escitala = new char[caras][largo];

			int currentPos = 0;

			for (int fila = 0; fila < caras; fila++) {
				for (int columna = 0; columna < largo; columna++) {
					escitala[fila][columna] = currentPos < frase.length() ? frase.charAt( currentPos++ ) : Escitala
							.aleatorio();
				}
			}
			result = Escitala.toText( escitala );
		}
		return result;
	}

	/**
	 * Desencripta una cadena de texto previamente encriptada por una escitala compatible.
	 * 
	 * @param frase
	 *        frase a desencriptar.
	 * @return la frase desencriptada.
	 */
	public String decrypt( final String frase ) {
		String result = null;
		if (isValid( frase )) {
			//Si el mensaje dividido entre las caras de la escitala da resto cero no sobrarían espacios
			final int largo = frase.length() % caras == 0 ? frase.length() / caras : frase.length() / caras + 1;
			final char[][] escitala = new char[largo][caras];

			int currentPos = 0;

			for (int fila = 0; fila < largo; fila++) {
				for (int columna = 0; columna < caras; columna++) {
					escitala[fila][columna] = currentPos < frase.length() ? frase.charAt( currentPos++ ) : ' ';
				}
			}
			result = Escitala.toText( escitala );
		}
		return result;
	}

	/**
	 * Genera un carácter aleatorio.
	 * <p>
	 * Función de utilidad que genera un único carácter aleatorio. Utilizado internamente para
	 * rellenar la tabla cuando cuando la longitud de la frase a encriptar no es un múltiplo del
	 * número de caras.
	 * 
	 * @return un carácter aleatorio.
	 */
	private static char aleatorio() {
		final int aleatorio = (int) (Math.random() * 100) + 1; //calculamos un aleatorio de 1 a 100. Podríamos haber pusto otro rango.

		return (char) aleatorio; //Devolvemos como String el char que representa a ese número generado aleatorimente. (Código ASCII)
	}

	/**
	 * Convierte el array bidimensional pasado como parámetro en un <code>String</code>.
	 * 
	 * @param escitala
	 *        bidimensional a convertir en una cadena.
	 * @return una cadena de texto representando el array pasado como argumento.
	 */
	private static String toText( final char[][] escitala ) {
		//Ya que no trabajamos con hilos creamos un StringBuilder que es más eficiente en estos casos
		final StringBuilder sb = new StringBuilder( escitala.length * escitala[0].length );

		for (int c = 0; c < escitala[0].length; c++) {
			for (final char[] element : escitala) {
				sb.append( element[c] );
			}
		}
		return sb.toString();
	}

	/**
	 * Valida si la frase pasada como argumento es <em>compatible</em> con esta escitala.
	 * 
	 * @param frase
	 *        frase a validar para esta escitala.
	 * @return <code>true</code> si la <code>frase</code> es <em>compatible</em> cona la escitala,
	 *         <code>false</code> en caso contrario.
	 */
	private boolean isValid( final String frase ) {

		return frase != null && frase.length() > caras;
	}

	/**
	 * Retorna el número de caras de la escitala.
	 * 
	 * @return el número de caras de la escitala.
	 */
	public int getCaras() {
		return caras;
	}
}
