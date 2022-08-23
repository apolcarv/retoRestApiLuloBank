 # language: es
  #Proyecto: Reto tecnico LuloBank ->  https://www.lulobank.com/
  #Elaborado: Ing.Alejandro Polo Carvajal
  #Email: alejandropolocarvajal@gmail.com
  #sitio: https://www.linkedin.com/in/alejandro-polo-carvajal-790b79186/

 Característica: Ejecucion completa de los casos de pruebas RETO TECNICO LULOBANK de las Dummy api example (Employee)

   @EmployeeSuccess
   Escenario: 001 - Consume el servicio para validar codigo de respuesta
     Dado  que el usuario llama el servicio para la consulta de un empleado en particular
     Cuando consume el servicio de empleado
     Entonces el endpoint responde de forma exitosa

   @EmployeeSuccessFul
   Escenario: 002 - Se consume el servicio para consultar un empleado
     Dado  que el usuario llama el servicio para la consulta de un empleado en particular
     Cuando consume el servicio de empleado
     Entonces valida que arroje un resultado de busqueda de forma exitosa


   @EmployeeFail
   Escenario: 003 - La api NO se puede consumir por alteracion del endpoint
     Dado  que el usuario llama el servicio para la consulta de un empleado en particular
     Cuando consume el endpoint corrupto consulta parametrizada
     Entonces el servicio NO responde exitosamente