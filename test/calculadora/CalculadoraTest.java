package calculadora;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import jdk.jfr.Timestamp;

@DisplayName("Classe para teste da calculadora")
public class CalculadoraTest {
	
	private Calculadora calc;
	
	@BeforeEach
	public void inicializa() {
		calc = new Calculadora();
	}
	
	@DisplayName("Testa a soma de dois n�meros")
	@Test
	public void testSomaDoisNumeros() {
		int soma = calc.soma(4, 5);		
		Assertions.assertEquals(9, soma);		
	}
	
	@Test
	public void testDivisaoDoisNumeros() {
		int divisao = calc.divisao(8, 4);
		assertTrue(divisao == 2);
	}
	
	@Test
	public void testDivisaoPorZero() {
		try {
			int divisao = calc.divisao(8, 0);
			fail("Exce��o n�o lan�ada");
		}catch (ArithmeticException e) {
			assertEquals("/ by zero", e.getMessage());
		}		
	}
	
	@Test
	public void testDivisaoPorZeroComAssertThrows() {
		assertThrows(ArithmeticException.class,
				() -> calc.divisao(8, 0));
	}

	@Test
	public void testSomatoria(){
		int numero = 5;
		int somatorio = calc.somatoria(numero);
		int soma = 0 ;
		for (int i; i <= numero; i++){
			soma += i;
		}
		assert.equals(soma, somatorio);
	}

	@Test
	public void testEhPositivo(){
		boolean result = calc.ehPositivo(5);
		assertTrue(result);
	}

	@Test
	public void testComparaIgual(){
		int comparador = calc.compara(5, 5);
		assertEquals(0, comparador);
	}

	@Test
	public void testComparaMaior(){
		int comparador = calc.compara(10, 5);
		assertEquals(1, comparador);
	}

	@Test
	public void testComparaMenor(){
		int comparador = calc.compara(5, 10);
		assertEquals(-1, comparador);
	}
}
