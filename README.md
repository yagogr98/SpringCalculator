# SpringCalculator
[![Coverage Status](https://coveralls.io/repos/github/yagogr98/SpringCalculator/badge.svg)](https://coveralls.io/github/yagogr98/SpringCalculator)



## API Calculadora simple implementada en Springboot.

### Ejecución
Para ejecutarse única y exclusivamente necesita correr una petición REST del estilo:
<pre><code>GET http://localhost:8080/api/operar?primerOperando="primerOperando"&segundoOperando="segundoOperando"&tipoOperacion="operacion"
</code></pre>
  En lugar de "primerOperando", indicar numero de primer orden en la operación
  En lugar de "segundoOperando", indicar numero de segundo orden en la operación.
  En lugar de "operacion" indicer tipo de operación a realizar

## Listado de Operaciones
 - add : Suma
 - sub : Resta
 - div : Division
 - mul : Multiplicación
