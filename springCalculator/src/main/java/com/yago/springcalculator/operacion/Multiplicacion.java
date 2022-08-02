package com.yago.springcalculator.operacion;

import java.math.BigDecimal;

public class Multiplicacion implements MathOperation {

	@Override
	public BigDecimal calcular(BigDecimal n1, BigDecimal n2) {
		return n1.multiply(n2);
	}

}
