package com.yago.springcalculator.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yago.springcalculator.exception.OperacionNoImplementadaException;
import com.yago.springcalculator.exception.ParametroIncorrectoException;
import com.yago.springcalculator.service.SpringCalculatorService;
import com.yago.springcalculator.service.SpringCalculatorServiceImpl;

@RestController
@RequestMapping("/api") //http://127.0.0.1:8080/api/
public class SpringCalculatorRestController {

	@Autowired
    private SpringCalculatorService springCalculatorService;

    

    
    /**
     * Método para calcular.
     * Recibe dos numeros por url.
     * @param StringId
     * @return suma de parametros
     * @throws OperacionNoImplementadaException 
     * @throws ParametroIncorrectoException 
     */
    @GetMapping("/operar")
    public BigDecimal operar(@RequestParam(name = "tipoOperacion") String tipoOperacion, @RequestParam(name = "primerOperando") BigDecimal numero1, @RequestParam(name = "segundoOperando") BigDecimal numero2) throws ParametroIncorrectoException, OperacionNoImplementadaException{
        
    	return springCalculatorService.calcular(tipoOperacion, numero1, numero2);

    }
    

}
