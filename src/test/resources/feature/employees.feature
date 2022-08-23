 # language: es
  #Proyecto: Reto tecnico LuloBank ->  https://www.lulobank.com/
  #Elaborado: Ing.Alejandro Polo Carvajal
  #Email: alejandropolocarvajal@gmail.com
  #sitio: https://www.linkedin.com/in/alejandro-polo-carvajal-790b79186/

 Característica: Ejecucion completa de los casos de pruebas RETO TECNICO LULOBANK de las Dummy api example (Employees)

   @EmployeesSuccess
   Escenario: 001 - Consume el servicio para validar codigo de respuesta
     Dado  que el usuario llama el servicio consulta de empleados
     Cuando consume el servicio consulta de empleado
     Entonces el servicio responde de forma exitosa

     @EmployeesSuccessFul
   Escenario: 002 - Se consume el servicio para consultar todos los empleados
     Dado  que el usuario llama el servicio consulta de empleados
     Cuando consume el servicio consulta de empleado
     Entonces valida que arroje resultados de busqueda de forma exitosa


   @EmployeesFail
   Escenario: 003 - La api NO se puede consumir por alteracion del endpoint
     Dado  que el usuario llama el servicio consulta de empleados
     Cuando consume el servicio corrupto consulta de empleado
     Entonces el servicio NO responde de forma exitosa