/**
 *
 */
package org.aldoma.cursotdd.modulo2.ejercicio1.junit;

import junit.framework.Assert;

import org.aldoma.cursotdd.modulo2.ejercicio1.Escitala;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Test Suite for {@link Escitala}
 * 
 * @author Alberto Dominguez Matamoros
 */
@SuppressWarnings( { "nls" } )
public class EscitalaTest {
	/** Cadena de ejemplo en texto claro */
	private static final String TEXTO_CLARO = "En un lugar de la Mancha, de cuyo nombre no quiero acordarme";

	/** La cadena de ejemplo encriptada con una escitala de 10 caras. */
	private static final String ENCRYPT_CON_10 = "EldM,umorrnuea yb od g ndorq aualce euarnrah n icm   aconeoe";

	/** La cadena de ejemplo encriptada con una escitala de 7 caras. */
	private static final String ENCRYPT_CON_7 = "EaMemurnra bid  ncreaudcuerrnehy om  aon ell, oa ua n c g doqo ";

	/** Una escitala de 10 caras. */
	private Escitala theSUP10;

	/** Una escitala de 7 caras. */
	private Escitala theSUP7;

	/**
	 * <em>Placeholder</em> para protegernos de nuestros propios errores y verificar que los datos
	 * de prueba tiene las características esperadas.
	 */
	@BeforeClass
	public static void oneTimeSetUp() {
		Assert.assertEquals( EscitalaTest.TEXTO_CLARO.length(), EscitalaTest.ENCRYPT_CON_10.length() );
		Assert.assertFalse( EscitalaTest.TEXTO_CLARO.length() == EscitalaTest.ENCRYPT_CON_7.length() );
	}

	/**
	 * Sets up the test fixture. (Called before every test case method.)
	 */
	@Before
	public void setUp() {
		theSUP10 = new Escitala( 10 );
		theSUP7 = new Escitala( 7 );

		// Tambien realizamos la verificación de los datos de prueba que no podiamos realizar
		// antes de la inicialización de los objetos.
		Assert.assertEquals( 0, EscitalaTest.TEXTO_CLARO.length() % theSUP10.getCaras() );
		Assert.assertTrue( EscitalaTest.TEXTO_CLARO.length() % theSUP7.getCaras() != 0 );
	}

	/**
	 * Tears down the test fixture. (Called after every test case method.)
	 */
	@After
	public void tearDown() {
		theSUP10 = null;
		theSUP7 = null;
	}

	/**
	 * Test method for {@link org.aldoma.cursotdd.modulo2.ejercicio1.Escitala#Escitala(int)}.
	 */
	@SuppressWarnings( "static-method" )
	@Test
	public final void testEscitala() {
		final int numCaras = 3;
		final Escitala theSUP = new Escitala( numCaras );

		Assert.assertEquals( numCaras, theSUP.getCaras() );
	}

	/**
	 * Test method for {@link org.aldoma.cursotdd.modulo2.ejercicio1.Escitala#Escitala(int)} con el
	 * número de caras igual a 0.
	 */
	@SuppressWarnings( { "unused", "static-method" } )
	@Test
	public final void testEscitala_ConZeroCaras() {
		final int numCaras = 0;
		try {
			new Escitala( numCaras );
			Assert.fail( "¿Cúal es la construcción geométrica para una escitala de 0 caras?" );
		}
		catch (final IllegalArgumentException ex) {
			// Ok, este es el comportamiento esperado
		}
	}

	/**
	 * Test method for {@link org.aldoma.cursotdd.modulo2.ejercicio1.Escitala#Escitala(int)} con el
	 * número de caras negativo.
	 */
	@SuppressWarnings( { "unused", "static-method" } )
	@Test
	public final void testEscitala_ConNumCarasNegativo() {
		final int numCaras = -5;
		try {
			new Escitala( numCaras );
			Assert.fail( "Esta es una geometría muy avanzada para una Escitala" );
		}
		catch (final IllegalArgumentException ex) {
			// Ok, este es el comportamiento esperado
		}
	}

	/**
	 * Test method for
	 * {@link org.aldoma.cursotdd.modulo2.ejercicio1.Escitala#encrypt(java.lang.String)}.
	 */
	@Test
	public final void testEncrypt() {
		Assert.assertEquals( EscitalaTest.ENCRYPT_CON_10, theSUP10.encrypt( EscitalaTest.TEXTO_CLARO ) );
	}

	/**
	 * Test method for
	 * {@link org.aldoma.cursotdd.modulo2.ejercicio1.Escitala#encrypt(java.lang.String)} con una
	 * frase con menos carácteres que caras.
	 */
	@SuppressWarnings( "static-method" )
	@Test
	public final void testEncrypt_ConFraseMuyCorta() {
		final Escitala theSUP = new Escitala( 20 );

		Assert.assertNull( theSUP.encrypt( "Muy corta" ) );
	}

	/**
	 * Test method for
	 * {@link org.aldoma.cursotdd.modulo2.ejercicio1.Escitala#encrypt(java.lang.String)} para una
	 * frase cuya longitud no sea múltiplo del número de caras. Es decir, <blockquote>
	 * <code>len(frase)%caras <> 0</code></blockquote>
	 */
	@Test
	public final void testEncrypt_NoMultiplo() {
		// Tal y como especifica la documentación de encrypt() esta es no determinista, por lo que sólo
		// podemos probarla con ayuda de su complementaria.
		final String encrypt = theSUP7.encrypt( EscitalaTest.TEXTO_CLARO );
		Assert.assertEquals( EscitalaTest.TEXTO_CLARO,
				theSUP7.decrypt( encrypt ).substring( 0, EscitalaTest.TEXTO_CLARO.length() ) );
	}

	/**
	 * Test method for
	 * {@link org.aldoma.cursotdd.modulo2.ejercicio1.Escitala#decrypt(java.lang.String)}.
	 */
	@Test
	public final void testDecrypt() {
		Assert.assertEquals( EscitalaTest.TEXTO_CLARO, theSUP10.decrypt( EscitalaTest.ENCRYPT_CON_10 ) );
	}

	/**
	 * Test method for
	 * {@link org.aldoma.cursotdd.modulo2.ejercicio1.Escitala#decrypt(java.lang.String)} de un texto
	 * cuya longuitud no es múltiplo del número de caras.
	 */
	@Test
	public final void testDecrypt_NoMultiplo() {
		Assert.assertEquals( EscitalaTest.TEXTO_CLARO,
				theSUP7.decrypt( EscitalaTest.ENCRYPT_CON_7 ).substring( 0, EscitalaTest.TEXTO_CLARO.length() ) );
	}

	/**
	 * Test method for {@link org.aldoma.cursotdd.modulo2.ejercicio1.Escitala#getCaras()}.
	 */
	@Test
	public final void testGetCaras() {
		Assert.assertEquals( 10, theSUP10.getCaras() );
	}
}
