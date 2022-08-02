package com.yago.springcalculator.service;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yago.springcalculator.bean.AppConfig;
import com.yago.springcalculator.exception.OperacionNoImplementadaException;
import com.yago.springcalculator.exception.ParametroIncorrectoException;
import com.yago.springcalculator.operacion.FactoriaOperaciones;

import io.corp.calculator.TracerImpl;

@Service
public class SpringCalculatorServiceImpl implements SpringCalculatorService {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringCalculatorServiceImpl.class);

	private TracerImpl tracerIteriam =AppConfig.getTracer();
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
	 * @throws ParametroIncorrectoException 
	 * @throws OperacionNoImplementadaException 
	 */
	@Override
	public BigDecimal calcular(String tipoOperacion, BigDecimal numero1, BigDecimal numero2) throws ParametroIncorrectoException, OperacionNoImplementadaException {

		LOGGER.debug("Entra en metodo del service con parametros -> tipoOp:" + tipoOperacion + " num1:" + numero1
				+ " num2:" + numero2);

		comprobarParametros(tipoOperacion, numero1, numero2);
		BigDecimal out = FactoriaOperaciones.getOperacion(tipoOperacion).calcular(numero1, numero2);
		tracerIteriam.trace(out);
		return out;

	}

	/**
	 * Metodo privado que comprueba la validez de los parametros
	 * @param tipoOperacion
	 * @param numero1
	 * @param numero2
	 * @throws ParametroIncorrectoException 
	 */
	private void comprobarParametros(String tipoOperacion, BigDecimal numero1, BigDecimal numero2) throws ParametroIncorrectoException {
		//Se comprueba que ninguno de los parametros llegue nulo
		if(numero1 == null) {
			LOGGER.error("El numero 1 es nulo");
			ParametroIncorrectoException e =  new ParametroIncorrectoException("Primer operando nulo");
			tracerIteriam.trace(e);
			throw e;
		}
		if(numero2 == null) {
			LOGGER.error("El numero 2 es nulo");
			ParametroIncorrectoException e =  new ParametroIncorrectoException("segundo operando nulo");
			tracerIteriam.trace(e);
			throw e;
		}
		if(tipoOperacion == null) {
			LOGGER.error("El tipo de operacion es nulo");
			ParametroIncorrectoException e = new ParametroIncorrectoException("Operando nulo");
			tracerIteriam.trace(e);
			throw e;
		}
	}

}
