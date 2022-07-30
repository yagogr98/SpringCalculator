package com.yago.springCalculator.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yago.springCalculator.service.SpringCalculatorService;

@RestController
@RequestMapping("/api") //http://127.0.0.1:8080/api/
public class SpringCalculatorRestController {


    @Autowired
    private SpringCalculatorService springCalculatorService;

    
    /**
     * Método para realizar sumas.
     * Recibe dos numeros por url.
     * @param StringId
     * @return suma de parametros
     */
    @GetMapping("/sumar/{numero1}/{numero2}")
    public BigDecimal sumar(@PathVariable BigDecimal numero1, @PathVariable BigDecimal numero2){
        
    	BigDecimal resultado = springCalculatorService.sumar(numero1,numero2);

        
        return resultado;
    }
    
    /**
     * Método para realizar restas.
     * Recibe dos numeros por url.
     * @param StringId
     * @return resta de parametros
     */
    @GetMapping("/restar/{numero1}/{numero2}")
    public BigDecimal restar(@PathVariable BigDecimal numero1, @PathVariable BigDecimal numero2){
        
    	BigDecimal resultado = springCalculatorService.restar(numero1,numero2);

        
        return resultado;
    }

}
