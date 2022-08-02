package com.yago.springcalculator.operacion;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.yago.springcalculator.exception.ParametroIncorrectoException;

public class Division implements MathOperation {

	@Override
	public BigDecimal calcular(BigDecimal n1, BigDecimal n2) throws ParametroIncorrectoException {
		
		if(n2.equals(BigDecimal.valueOf(0))) {
			ParametroIncorrectoException e =  new ParametroIncorrectoException("División por 0 no permitida");
			throw e;
		}

		return n1.divide(n2,RoundingMode.HALF_UP);
	}

}
