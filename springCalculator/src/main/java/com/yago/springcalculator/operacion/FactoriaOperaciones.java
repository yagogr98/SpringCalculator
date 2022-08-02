package com.yago.springcalculator.operacion;

import com.yago.springcalculator.exception.OperacionNoImplementadaException;

public class FactoriaOperaciones {
	
	public static MathOperation getOperacion(String tipoOperacion) throws OperacionNoImplementadaException {

		if (tipoOperacion.equals("add")) {
			return new Suma();
		} else if (tipoOperacion.equals("sub")) {
			return new Resta();
		} else if (tipoOperacion.equals("div")) {
			return new Division();
		} else if (tipoOperacion.equals("mul")) {
			return new Multiplicacion();
		} else {
			OperacionNoImplementadaException e =  new OperacionNoImplementadaException("Operacion no reconocida");
			throw e;
		}

	}

}
