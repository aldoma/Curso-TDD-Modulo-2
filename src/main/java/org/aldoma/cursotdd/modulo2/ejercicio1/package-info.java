/**
 * Primer ejercicio del módulo 2.
 * <p>
 * <h2>Enunciado del ejercicio:</h2>
 * <p>
 * El siguiente código Java ha sido tomado de una solución colgada en Solveet para resolver la
 * criptografía Escítala (<a
 * href="http://www.solveet.com/exercises/Criptografia-La-Escitala-Espartana/147">página
 * original</a>).
 * <p>
 * Puede encontrar el archivo de código fuente en los materiales del curso.
 * <p>
 * ¿Es posible mejorar el diseño, organización y legibilidad del código fuente anterior? Escriba un
 * listado de posibles malos olores y propuestas de refactorización.
 * <p>
 * <h3>Respuestas:</h3>
 * <p>
 * En realidad he realizado la refactorización. El resultado puede verse en
 * {@link org.aldoma.cursotdd.modulo2.ejercicio1.Escitala} y sus test unitarios en
 * {@link org.aldoma.cursotdd.modulo2.ejercicio1.junit.EscitalaTest}.
 * <p>
 * Aunque sé que, en un principio, no es correcto, la refactorización aplicada incluye cambios en el
 * interface. Creo que estos cambios son necesario para disponer de una clase que represente más
 * fielmente el objeto del MundoReal&#8482; que intenta modelar y, por tanto, que sea más fácil de
 * utilizar.
 * 
 * @author Alberto Dominguez Matamoros
 */
package org.aldoma.cursotdd.modulo2.ejercicio1;

