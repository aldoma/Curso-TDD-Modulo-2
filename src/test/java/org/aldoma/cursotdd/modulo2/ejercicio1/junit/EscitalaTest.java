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
@SuppressWarnings( { "nls", "static-method" } )
public class EscitalaTest {
	/** Cadena de ejemplo en texto claro */
	private static final String TEXTO_CLARO = "En un lugar de la Mancha, de cuyo nombre no quiero acordarme";

	/** La anterior cadena encriptada con una escitala de 10 caras */
	private static final String ENCRYPT_CON_10 = "Ernu  n cyna dhoocuea  on ,nqr l oudladmiau ebergM rrmaaceoe";

	/** Una escitala de 10 caras... */
	private Escitala theSUP10;

	/** ...y su inversa (inicializada con la cadena encriptada. */
	private Escitala theSUP10Inv;

	/**
	 * <em>Placeholder</em> para protegernos de nuestros propios errores.
	 */
	@BeforeClass
	public static void oneTimeSetUp() {
		Assert.assertEquals( EscitalaTest.TEXTO_CLARO.length(), EscitalaTest.ENCRYPT_CON_10.length() );
	}

	/**
	 * Sets up the test fixture. (Called before every test case method.)
	 */
	@Before
	public void setUp() {
		theSUP10 = new Escitala( 10, EscitalaTest.TEXTO_CLARO );
		theSUP10Inv = new Escitala( 10, EscitalaTest.ENCRYPT_CON_10 );
	}

	/**
	 * Tears down the test fixture. (Called after every test case method.)
	 */
	@After
	public void tearDown() {
		theSUP10 = null;
		theSUP10Inv = null;
	}

	/**
	 * Test method for
	 * {@link org.aldoma.cursotdd.modulo2.ejercicio1.Escitala#Escitala(int, java.lang.String)}.
	 */
	@Test
	public final void testEscitala() {
		final int numCaras = 3;
		final Escitala theSUP = new Escitala( numCaras, EscitalaTest.TEXTO_CLARO );

		Assert.assertEquals( numCaras, theSUP.getCaras() );
		Assert.assertEquals( EscitalaTest.TEXTO_CLARO, theSUP.getFrase() );
	}

	/**
	 * Test method for
	 * {@link org.aldoma.cursotdd.modulo2.ejercicio1.Escitala#Escitala(int, java.lang.String)} con
	 * el número de caras igual a 0.
	 */
	@Test
	public final void testEscitala_ConZeroCaras() {
		final int numCaras = 0;
		try {
			new Escitala( numCaras, EscitalaTest.TEXTO_CLARO );
			Assert.fail( "¿Cúal es la construcción geométrica para una escitala de 0 caras?" );
		}
		catch (final IllegalArgumentException ex) {
			// Ok, este es el comportamiento esperado
		}
	}

	/**
	 * Test method for
	 * {@link org.aldoma.cursotdd.modulo2.ejercicio1.Escitala#Escitala(int, java.lang.String)} con
	 * el número de caras negativo.
	 */
	@Test
	public final void testEscitala_ConNumCarasNegativo() {
		final int numCaras = -5;
		try {
			new Escitala( numCaras, EscitalaTest.TEXTO_CLARO );
			Assert.fail( "Esta es una geometría muy avanzada para una Escitala" );
		}
		catch (final IllegalArgumentException ex) {
			// Ok, este es el comportamiento esperado
		}
	}

	/**
	 * Test method for {@link org.aldoma.cursotdd.modulo2.ejercicio1.Escitala#encrypt()}.
	 */
	@Test
	public final void testEncrypt() {
		Assert.assertEquals( EscitalaTest.ENCRYPT_CON_10, theSUP10.encrypt() );
	}

	/**
	 * Test method for {@link org.aldoma.cursotdd.modulo2.ejercicio1.Escitala#encrypt()} sobre un
	 * objeto sin inicializar.
	 */
	@Test
	public final void testEncrypt_ConNUll() {
		final Escitala theSUP = new Escitala( 2, null );
		Assert.assertNull( theSUP.encrypt() );
	}

	/**
	 * Test method for {@link org.aldoma.cursotdd.modulo2.ejercicio1.Escitala#encrypt()} con una
	 * frase con menos carácteres que caras.
	 */
	@Test
	public final void testEncrypt_ConFraseMuyCorta() {
		final Escitala theSUP = new Escitala( 20, "Muy corta" );

		Assert.assertNull( theSUP.encrypt() );
	}

	/**
	 * Test method for {@link org.aldoma.cursotdd.modulo2.ejercicio1.Escitala#encrypt()} para una
	 * frase cuya longitud no sea múltiplo del número de caras. Es decir, <blockquote>
	 * <code>len(frase)%caras <> 0</code></blockquote>
	 */
	@Test
	public final void testEncrypt_NoMultiplo() {
		final int numCaras = 7;
		final Escitala theSUP = new Escitala( numCaras, EscitalaTest.TEXTO_CLARO );
		Assert.assertFalse( EscitalaTest.ENCRYPT_CON_10.length() % numCaras == 0 );
		final String str = theSUP.encrypt();

		Assert.assertEquals( EscitalaTest.TEXTO_CLARO,
				theSUP.decrypt( str ).substring( 0, EscitalaTest.TEXTO_CLARO.length() ) );
	}

	/**
	 * Test method for
	 * {@link org.aldoma.cursotdd.modulo2.ejercicio1.Escitala#decrypt(java.lang.String)}.
	 */
	@Test
	public final void testDecrypt() {
		Assert.assertEquals( EscitalaTest.TEXTO_CLARO, theSUP10Inv.decrypt( EscitalaTest.ENCRYPT_CON_10 ) );
	}

	/**
	 * Test method for {@link org.aldoma.cursotdd.modulo2.ejercicio1.Escitala#decrypt(String)} sobre
	 * un objeto sin inicializar.
	 */
	@Test
	public final void testDecrypt_ConNUll() {
		final Escitala theSUP = new Escitala( 2, null );
		Assert.assertNull( theSUP.decrypt( EscitalaTest.ENCRYPT_CON_10 ) );
	}

	/**
	 * Test method for {@link org.aldoma.cursotdd.modulo2.ejercicio1.Escitala#getCaras()}.
	 */
	@Test
	public final void testGetCaras() {
		Assert.assertEquals( 10, theSUP10.getCaras() );
	}

	/**
	 * Test method for {@link org.aldoma.cursotdd.modulo2.ejercicio1.Escitala#getFrase()}.
	 */
	@Test
	public final void testGetFrase() {
		Assert.assertEquals( EscitalaTest.TEXTO_CLARO, theSUP10.getFrase() );
	}

	/**
	 * Test method for
	 * {@link org.aldoma.cursotdd.modulo2.ejercicio1.Escitala#setFrase(java.lang.String)}.
	 */
	@Test
	public final void testSetFrase() {
		final String frase = "Texto de prueba";
		theSUP10.setFrase( frase );

		Assert.assertEquals( frase, theSUP10.getFrase() );
	}

}
