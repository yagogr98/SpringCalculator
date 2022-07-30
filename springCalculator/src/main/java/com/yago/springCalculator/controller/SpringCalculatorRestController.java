package com.yago.springCalculator.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yago.springCalculator.service.SpringCalculatorService;

import io.corp.calculator.TracerAPI;
import io.corp.calculator.TracerImpl;

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
     */
    @GetMapping("/operar")
    public Double operar(@RequestParam(name = "tipoOperacion") String tipoOperacion, @RequestParam(name = "primerOperando") BigDecimal numero1, @RequestParam(name = "segundoOperando") BigDecimal numero2){
        
    	return springCalculatorService.calcular(tipoOperacion, numero1, numero2);

    }
    

}
