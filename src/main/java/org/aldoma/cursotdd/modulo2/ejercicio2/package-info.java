/**
 * Segundo ejercicio del módulo 2.
 * <p>
 * <h2>Enunciado del ejercicio:</h2>
 * <p>
 * El patrón de diseño Singleton se utiliza cuando queremos garantizar que sólo existirá un único
 * objeto de una clase determinada. A veces se utiliza el nombre <em>Multiton</em> cuando el número
 * de instancias es mayor de uno. A continuación tiene un ejemplo muy básico de implementación del
 * patrón Singleton en Java:
 * 
 * <pre>
 * public class SingleInstance {
 * 	static SingleInstance instance;
 * <br/>
 * 	public static SingleInstance getInstance() {
 * 		if (instance == null) {
 * 			instance = new SingleInstance();
 * 		}
 * 		return instance;
 * 	}
 * }
 * </pre>
 * <p>
 * Puedes consultar una descripción del patrón Singleton en la wikipedia <a
 * href="http://en.wikipedia.org/wiki/Singleton_pattern">aquí</a>.
 * <p>
 * ¿Cree que este patrón expone un buen diseño desde el punto de vista de las pruebas?
 * <p>
 * <Extra: si tiene práctica con el lenguaje Python también puede consultar el patrón Borg.
 * <p>
 * <h3>Respuestas:</h3>
 * <p>
 * 
 * @author Alberto Dominguez Matamoros
 */
package org.aldoma.cursotdd.modulo2.ejercicio2;

