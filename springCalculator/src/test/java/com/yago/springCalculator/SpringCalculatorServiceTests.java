package com.yago.springCalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.yago.springcalculator.exception.OperacionNoImplementadaException;
import com.yago.springcalculator.exception.ParametroIncorrectoException;
import com.yago.springcalculator.service.SpringCalculatorService;
import com.yago.springcalculator.service.SpringCalculatorServiceImpl;


class SpringCalculatorServiceTests {
	SpringCalculatorService calculator;
	
	@BeforeEach
	public void setUp() {
		calculator =  new SpringCalculatorServiceImpl();
		
	}


	//Casos positivos
	@Test
	void casoPositivoSuma() {
		try {
			assertEquals(BigDecimal.valueOf(10005), calculator.calcular("add", BigDecimal.valueOf(10000), BigDecimal.valueOf(5)));
			assertEquals(BigDecimal.valueOf(13), calculator.calcular("add", BigDecimal.valueOf(10), BigDecimal.valueOf(3)));
			assertEquals(BigDecimal.valueOf(10.222), calculator.calcular("add", BigDecimal.valueOf(10), BigDecimal.valueOf(0.222)));
		}catch(Exception e) {
			assertTrue(false);
		}
	}

	@Test
	void casoPositivoResta() {
		try {
			assertEquals(BigDecimal.valueOf(10005), calculator.calcular("sub", BigDecimal.valueOf(10010), BigDecimal.valueOf(5)));
			assertEquals(BigDecimal.valueOf(10), calculator.calcular("sub", BigDecimal.valueOf(13), BigDecimal.valueOf(3)));
			assertEquals(BigDecimal.valueOf(10.0), calculator.calcular("sub", BigDecimal.valueOf(10.2), BigDecimal.valueOf(0.2)));
		}catch(Exception e) {
			assertTrue(false);
		}
	}

	@Test
	void casoPositivoMultiplicacion() {
		try {
			assertEquals(BigDecimal.valueOf(10010), calculator.calcular("mul", BigDecimal.valueOf(10010), BigDecimal.valueOf(1)));
			assertEquals(BigDecimal.valueOf(30), calculator.calcular("mul", BigDecimal.valueOf(10), BigDecimal.valueOf(3)));
			assertEquals(BigDecimal.valueOf(10.0), calculator.calcular("mul", BigDecimal.valueOf(20), BigDecimal.valueOf(0.5)));
		}catch(Exception e) {
			assertTrue(false);
		}
	}

	@Test
	void casoPositivoDivision() {
		try {
			assertEquals(BigDecimal.valueOf(100), calculator.calcular("div", BigDecimal.valueOf(200), BigDecimal.valueOf(2)));
			assertEquals(BigDecimal.valueOf(30), calculator.calcular("div", BigDecimal.valueOf(15), BigDecimal.valueOf(0.5)));
			assertEquals(BigDecimal.valueOf(10), calculator.calcular("div", BigDecimal.valueOf(1000), BigDecimal.valueOf(100)));
		}catch(Exception e) {
			assertTrue(false);
		}
	}
	

	//Casos negativos
	@Test
	void casoNegativoDivision() {
		//Division por cero
		try {
			assertEquals(BigDecimal.valueOf(100), calculator.calcular("div", BigDecimal.valueOf(200), BigDecimal.valueOf(0)));
		}catch(ParametroIncorrectoException e) {
			assertTrue(true);
		} catch (OperacionNoImplementadaException e) {
			assertTrue(false);
		}
	}
	
	@Test
	void parametrosNulos() {

		//operacion nula
		try {
			calculator.calcular(null, BigDecimal.valueOf(10010), BigDecimal.valueOf(1));
		}catch(OperacionNoImplementadaException e) {
			assertTrue(false);
		} catch (ParametroIncorrectoException e) {
			assertTrue(true);
		}

		//primer numero nulo
		try {
			calculator.calcular("add", null, BigDecimal.valueOf(1));
		}catch(OperacionNoImplementadaException e) {
			assertTrue(false);
		} catch (ParametroIncorrectoException e) {
			assertTrue(true);
		}
		//segundo numero nulo
		try {
			calculator.calcular("add", BigDecimal.valueOf(10010), null);
		}catch(OperacionNoImplementadaException e) {
			assertTrue(false);
		} catch (ParametroIncorrectoException e) {
			assertTrue(true);
		}
	}

	@Test
	void operacionInexistente() {

		//operacion nula
		try {
			calculator.calcular("operacioinexistente", BigDecimal.valueOf(10010), BigDecimal.valueOf(1));
		}catch(OperacionNoImplementadaException e) {
			assertTrue(true);
		} catch (ParametroIncorrectoException e) {
			assertTrue(false);
		}

	}
}
