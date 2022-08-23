 # language: es
  #Proyecto: Reto tecnico LuloBank ->  https://www.lulobank.com/
  #Elaborado: Ing.Alejandro Polo Carvajal
  #Email: alejandropolocarvajal@gmail.com
  #sitio: https://www.linkedin.com/in/alejandro-polo-carvajal-790b79186/

 Característica: Ejecucion completa de los casos de pruebas RETO TECNICO LULOBANK de las Dummy api example (Update)

   @UpdateEmployeeSuccess
   Escenario: 001 - Consume el servicio para validar codigo de respuesta
     Dado  que el usuario llama el servicio para actualizar un registro
     Cuando consume el servicio actualizar empleado
     Entonces el servicio responde exitososamente

   @UpdateEmployeeSuccessFul
   Escenario: 002 - Se consume el servicio para actualizar un empleado
     Dado  que el usuario llama el servicio para actualizar un registro
     Cuando consume el servicio actualizar empleado
     Entonces valida  que arroje resultado de busqueda de forma exitosa


   @UpdateEmployeeFail
   Escenario: 003 - La api NO se puede consumir por alteracion del endpoint
     Dado  que el usuario llama el servicio para actualizar un registro
     Cuando consume el endpoint corrupto actualizar empleado
     Entonces el servicio  NO responde exitosamente