 # language: es
  #Proyecto: Reto tecnico LuloBank ->  https://www.lulobank.com/
  #Elaborado: Ing.Alejandro Polo Carvajal
  #Email: alejandropolocarvajal@gmail.com
  #sitio: https://www.linkedin.com/in/alejandro-polo-carvajal-790b79186/

 Característica: Ejecucion completa de los casos de pruebas RETO TECNICO LULOBANK de las Dummy api example (Delete)

   @DeleteEmployeeSuccess
   Escenario: 001 - Consume el servicio para validar codigo de respuesta
     Dado  que el usuario llama el servicio para eliminar un registro
     Cuando consume el servicio eliminar empleado
     Entonces el servicio responde exitoso

   @DeleteEmployeeSuccessFul
   Escenario: 002 - Se consume el servicio para consultar un empleado
     Dado  que el usuario llama el servicio para eliminar un registro
     Cuando consume el servicio eliminar empleado
     Entonces valida que arroje resultado de busqueda de forma exitosa


   @DeleteEmployeeFail
   Escenario: 003 - La api NO se puede consumir por alteracion del endpoint
     Dado  que el usuario llama el servicio para eliminar un registro
     Cuando consume el endpoint corrupto eliminar empleado
     Entonces el servicio NO responde  exitosamente