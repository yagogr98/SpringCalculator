package com.yago.springcalculator.service;

import java.math.BigDecimal;

import com.yago.springcalculator.exception.OperacionNoImplementadaException;
import com.yago.springcalculator.exception.ParametroIncorrectoException;

public interface SpringCalculatorService {
	
	/**
	 * Método que se utilizará para sumar dos numeros indicados por parametro
	 * @param numero1
	 * @param numero2
	 * @return suma de ambos parametros
	 */
	public BigDecimal sumar(BigDecimal numero1, BigDecimal numero2);
	
	
	/**
	 * Método que se utilizará para restar dos números indicados por parametro
	 * @param numero1
	 * @param numero2
	 * @return resta de ambos numeros
	 */
	public BigDecimal restar(BigDecimal numero1, BigDecimal numero2);


	public BigDecimal calcular(String tipoOperacion, BigDecimal numero1, BigDecimal numero2) throws ParametroIncorrectoException, OperacionNoImplementadaException;

}
