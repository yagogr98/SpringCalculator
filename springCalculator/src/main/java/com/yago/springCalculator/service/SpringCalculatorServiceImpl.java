package com.yago.springCalculator.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import io.corp.calculator.TracerImpl;

@Service
public class SpringCalculatorServiceImpl implements SpringCalculatorService {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringCalculatorServiceImpl.class);

	private TracerImpl tracerIteriam = new TracerImpl();
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

		comprobarParametros(tipoOperacion, numero1, numero2);


		if (tipoOperacion.equals("add")) {
			// Caso Suma

			Double aux = numero1.add(numero2).doubleValue();
			tracerIteriam.trace(aux);
			LOGGER.debug(tracerIteriam.toString());
			return aux;
		} else if (tipoOperacion.equals("sub")) {
			// Caso resta

			Double aux = numero1.subtract(numero2).doubleValue();

			tracerIteriam.trace(aux);
			return aux;
		} else if (tipoOperacion.equals("div")) {
			// Caso División
			Double n1 = numero1.doubleValue();
			Double n2 = numero2.doubleValue();
			numero1.divide(numero2, RoundingMode.HALF_UP);
			Double aux =  n1/n2;
			tracerIteriam.trace(aux);
			return aux;
		} else if (tipoOperacion.equals("mul")) {
			// Caso Mult.

			Double aux = numero1.multiply(numero2).doubleValue();
			tracerIteriam.trace(aux);
			return aux;
		} else {
			LOGGER.error("tipo de operacion invalida: " + tipoOperacion);
			RuntimeException e =  new RuntimeException("Operacion no reconocida");
			tracerIteriam.trace(e);
			throw e;
		}

	}

	/**
	 * Metodo privado que comprueba la validez de los parametros
	 * @param tipoOperacion
	 * @param numero1
	 * @param numero2
	 */
	private void comprobarParametros(String tipoOperacion, BigDecimal numero1, BigDecimal numero2) {
		//Se comprueba que ninguno de los parametros llegue nulo
		if(numero1 == null) {
			LOGGER.error("El numero 1 es nulo");
			RuntimeException e =  new RuntimeException("Primer operando nulo");
			tracerIteriam.trace(e);
			throw e;
		}
		if(numero2 == null) {
			LOGGER.error("El numero 2 es nulo");
			RuntimeException e =  new RuntimeException("segundo operando nulo");
			tracerIteriam.trace(e);
			throw e;
		}
		if(tipoOperacion == null) {
			LOGGER.error("El tipo de operacion es nulo");
			RuntimeException e = new RuntimeException("Operando nulo");
			tracerIteriam.trace(e);
			throw e;
		}
	}

}
