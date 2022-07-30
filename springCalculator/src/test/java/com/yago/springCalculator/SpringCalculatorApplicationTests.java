package com.yago.springCalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.yago.springCalculator.service.SpringCalculatorService;
import com.yago.springCalculator.service.SpringCalculatorServiceImpl;

@SpringBootTest
class SpringCalculatorApplicationTests {
	SpringCalculatorService calculator;

	@BeforeEach
	void setUp() {
		calculator = new SpringCalculatorServiceImpl();
	}
	
	
	//Casos positivos
	@Test
	void casoPositivoSuma() {
		assertEquals(10005, calculator.calcular("add", new BigDecimal(10000), new BigDecimal(5)));
		assertEquals(13, calculator.calcular("add", new BigDecimal(10), new BigDecimal(3)));
		assertEquals(10.222, calculator.calcular("add", new BigDecimal(10), new BigDecimal(0.222)));
	}

	@Test
	void casoPositivoResta() {
		assertEquals(10005, calculator.calcular("sub", new BigDecimal(10010), new BigDecimal(5)));
		assertEquals(10, calculator.calcular("sub", new BigDecimal(13), new BigDecimal(3)));
		assertEquals(10, calculator.calcular("sub", new BigDecimal(10.222), new BigDecimal(0.222)));
	}
	
	@Test
	void casoPositivoMultiplicacion() {
		assertEquals(10010, calculator.calcular("mul", new BigDecimal(10010), new BigDecimal(1)));
		assertEquals(30, calculator.calcular("mul", new BigDecimal(10), new BigDecimal(3)));
		assertEquals(10, calculator.calcular("mul", new BigDecimal(20), new BigDecimal(0.5)));
	}
	
	@Test
	void casoPositivoDivision() {
		assertEquals(100, calculator.calcular("div", new BigDecimal(200), new BigDecimal(2)));
		assertEquals(30, calculator.calcular("div", new BigDecimal(15), new BigDecimal(0.5)));
		assertEquals(0.1, calculator.calcular("div", new BigDecimal(1), new BigDecimal(10)));
	}
	
	//Casos negativos
	@Test
	void parametrosNulos() {
		
		//operacion nula
		try {
			calculator.calcular(null, new BigDecimal(10010), new BigDecimal(1));
		}catch(RuntimeException e) {
			assertTrue(true);
		}
		
		//primer numero nulo
		try {
			calculator.calcular("add", null, new BigDecimal(1));
		}catch(RuntimeException e) {
			assertTrue(true);
		}
		//segundo numero nulo
		try {
			calculator.calcular("add", new BigDecimal(10010), null);
		}catch(RuntimeException e) {
			assertTrue(true);
		}
	}
	
	@Test
	void operacionInexistente() {
		
		//operacion nula
		try {
			calculator.calcular("operacioinexistente", new BigDecimal(10010), new BigDecimal(1));
		}catch(RuntimeException e) {
			assertTrue(true);
		}

	}
}
