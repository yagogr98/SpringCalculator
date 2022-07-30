package com.yago.springCalculator.service;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SpringCalculatorServiceImpl implements SpringCalculatorService {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringCalculatorServiceImpl.class);

	/**
	 * Método que devuelve la suma. Utiliza el metodo add de BigDecimal
	 * 
	 * @param numero1
	 * @param numero2
	 * @return
	 */
	@Override
	public BigDecimal sumar(BigDecimal numero1, BigDecimal numero2) {

		return numero1.add(numero2);
	}

	/**
	 * Método que devuelve la resta. Utiliza el metodo subtract de BigDecimal
	 * 
	 * @param numero1
	 * @param numero2
	 * @return
	 */
	@Override
	public BigDecimal restar(BigDecimal numero1, BigDecimal numero2) {
		return numero1.subtract(numero2);
	}

	/**
	 * Método que calcula operaciones entre dos números.
	 * 
	 * @param tipoOperacion tipo de operación a ejecutar entre ambos numeros
	 *                      (+,-,*,/)
	 * @param numero1       primer Operando de la operación
	 * @param numero2       segundo Operando de la operacion
	 */
	@Override
	public Double calcular(String tipoOperacion, BigDecimal numero1, BigDecimal numero2) {

		LOGGER.debug("Entra en metodo del service con parametros -> tipoOp:" + tipoOperacion + " num1:" + numero1
				+ " num2:" + numero2);

		//Se comprueba que ninguno de los parametros llegue nulo
		if(numero1 == null) {
			LOGGER.error("El numero 1 es nulo");
			throw new RuntimeException("Primer operando nulo");
		}
		if(numero2 == null) {
			LOGGER.error("El numero 2 es nulo");
			throw new RuntimeException("segundo operando nulo");
		}
		if(tipoOperacion == null) {
			LOGGER.error("El tipo de operacion es nulo");
			throw new RuntimeException("Operando nulo");
		}
		
		BigDecimal result;
		
		if (tipoOperacion.equals("add")) {
			// Caso Suma
			
			result = numero1.add(numero2);
		} else if (tipoOperacion.equals("sub")) {
			// Caso resta
			
			result = numero1.subtract(numero2);
		} else if (tipoOperacion.equals("div")) {
			// Caso División
			Double n1 = numero1.doubleValue();
			Double n2 = numero2.doubleValue();
			
			return n1/n2;
		} else if (tipoOperacion.equals("mul")) {
			// Caso Mult.
			
			result = numero1.multiply(numero2);
		} else {
			LOGGER.error("tipo de operacion invalida: " + tipoOperacion);
			throw new RuntimeException("Operacion no reconocida");
		}
		
		return result.doubleValue();
	}

}
