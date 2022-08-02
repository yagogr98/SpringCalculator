package com.yago.springcalculator.operacion;

import java.math.BigDecimal;

public class Resta implements MathOperation {

	@Override
	public BigDecimal calcular(BigDecimal n1, BigDecimal n2) {
		return n1.subtract(n2);
	}

}
