package com.yago.springCalculator.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

@Service
public class SpringCalculatorServiceImpl implements SpringCalculatorService {

	/**
	 * Método que devuelve la suma.
	 * Utiliza el metodo add de BigDecimal
	 * @param numero1
	 * @param numero2
	 * @return
	 */
	@Override
	public BigDecimal sumar(BigDecimal numero1, BigDecimal numero2) {
		
		return numero1.add(numero2);
	}
	
	/**
	 * Método que devuelve la resta.
	 * Utiliza el metodo subtract de BigDecimal
	 * @param numero1
	 * @param numero2
	 * @return
	 */
	@Override
	public BigDecimal restar(BigDecimal numero1, BigDecimal numero2) {
		return numero1.subtract(numero2);
	}


}
