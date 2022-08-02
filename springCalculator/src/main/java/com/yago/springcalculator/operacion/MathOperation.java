package com.yago.springcalculator.operacion;

import java.math.BigDecimal;

import com.yago.springcalculator.exception.ParametroIncorrectoException;

public interface MathOperation {
	
	/**
	 * Calcula la operacion en cuestion
	 * @param n1
	 * @param n2
	 * @return n1 op n2
	 */
	public BigDecimal calcular(BigDecimal n1, BigDecimal n2) throws ParametroIncorrectoException;
}
