# SpringCalculator
[![Coverage Status](https://coveralls.io/repos/github/yagogr98/SpringCalculator/badge.svg?branch=master)](https://coveralls.io/github/yagogr98/SpringCalculator?branch=master)


## API Calculadora simple implementada en Springboot.

### Estructura del proyecto:
- src/main/java
  - com.yago.springCalculator
    - SpringCalculatorApplication.java
    - com.yago.springCalculator.controller
      - SpringCalculatorRestController.java
    - com.yago.springCalculator.service
      - SpringCalculatorService.java
      - SpringCalculatorServiceImpl.java
- src/test/java
  - com.yago.springCalculator
    - SpringCalculatorApplicationTests.java
- lib
  - tracer-1.0.0.jar
      
 ### Instalación del proyecto
 - Clonar repositorio
 - Ejecutar <pre><code>mvn validate</code></pre>
 - Ejecutar <pre><code>mvn verify</code></pre>
 - Ejecutar <pre><code>mvn clean install</code></pre>
 - Ejecutar .jar de la carpeta /target.

### Ejecución
Para ejecutarse única y exclusivamente necesita correr una petición REST del estilo:
<pre><code>GET http://localhost:8080/api/operar?primerOperando="primerOperando"&segundoOperando="segundoOperando"&tipoOperacion="operacion"
</code></pre>
  En lugar de "primerOperando", indicar numero de primer orden en la operación
  En lugar de "segundoOperando", indicar numero de segundo orden en la operación.
  En lugar de "operacion" indicer tipo de operación a realizar
  
  #### Ejemplo de ejecución
  <pre><code>GET http://localhost:8080/api/operar?primerOperando=3&segundoOperando=4&tipoOperacion=add
</code></pre>


## Listado de Operaciones
 - add : Suma
 - sub : Resta
 - div : Division
 - mul : Multiplicación
