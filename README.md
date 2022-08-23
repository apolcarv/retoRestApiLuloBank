# retoRestApiLuloBank

Prueba API QA Automation - Ejercicio tecnico Api testing

El stack técnico a utilizar es:
1. Maven para gestión de librerías.
2. Java 8 o mayor.
3. Serenity (última versión) con BDD Screenplay.
4. Cucumber (última versión) con Serenity.
5. Serenity Rest con Serenity y Screenplay
6. Hamcrest
7. Patron de diseño Screenplay utilizando la mayor cantidad de capas posibles


1. El ejercicio consta de poder realizar interacciones por medio de los Verbos comunes
   que expone un Api rest y que puedas realizar todo el proceso que involucra
   automatizar una de esas acciones necesarias para interactuar con Api.
   
* Anexo encontrarás un Api pública expuesta en internet que contiene los principales
   verbos del Api (POST, GET, DELETE, PUT) , donde puedes realizar un flujo en este
   caso para poder consultar empleados, crear empleados y eliminar registros, cabe
   resaltar que dentro de la interacción que puedas realizar con los Endpoint expuestos
   es necesario que realices validaciones sobre las respuestas que puedas obtener al
   realizar cada una de las acciones.


* Crear un escenario de prueba por cada endpoint donde se todas las validaciones
  necesarias a las diferentes respuestas de la petición

* GET
http://dummy.restapiexample.com/api/v1/employees
* POST
http://dummy.restapiexample.com/api/v1/create
* GET
http://dummy.restapiexample.com/api/v1/employee/1
* DELETE
http://dummy.restapiexample.com/api/v1/delete/2
* PUT
https://dummy.restapiexample.com/api/v1/update/21

2. (Bonus opcional) Implementar un archivo dockerfile dentro del proyecto que puedas
   levantar en un contenedor de docker y lanzar las pruebas construidas anteriormente
   usando una imagen de jenkins, dicha ejecución será mostrada en el momento de la
   sustentación del ejercicio técnico.
   ENTREGA:
   * La entrega la puedes realizar publicando tu solución en un repositorio en github
   donde estaremos validando tu implementación dándole solución al ejercicio.
   * Posteriormente podrás sustentar tu implementación y aclarar dudas y discutir
   aspectos importantes en el proyecto realizado.
   Page donde se puede encontrar toda la documentación de la API.
   https://dummy.restapiexample.com/