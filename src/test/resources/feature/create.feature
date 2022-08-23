 # language: es
  #Proyecto: Reto tecnico LuloBank ->  https://www.lulobank.com/
  #Elaborado: Ing.Alejandro Polo Carvajal
  #Email: alejandropolocarvajal@gmail.com
  #sitio: https://www.linkedin.com/in/alejandro-polo-carvajal-790b79186/

 Característica: Ejecucion completa de los casos de pruebas RETO TECNICO LULOBANK de las Dummy api example (Create)

  @CreateSuccess
  Escenario: 001 - Consume el servicio para validar codigo de respuesta
   Dado  que el usuario llama el servicio y los datos de pruebas para crear empleados
   Cuando consume el servicio crear empleados
   Entonces el servicio se consume de forma exitosa


  @CreateSuccessFul
  Escenario: 002 - Se consume el servicio para crear un registro de un nuevo empleado
   Dado  que el usuario llama el servicio y los datos de pruebas para crear empleados
   Cuando consume el servicio crear empleados
   Entonces valida que arroje el mensaje de creacion del registro del empleado exitoso


  @CreateFail
  Escenario: 003 - La api NO se puede consumir por alteracion del endpoint
   Dado  que el usuario llama el servicio y los datos de pruebas para crear empleados
   Cuando consume el servicio corrupto crear empleados
   Entonces el servicio NO se pudo consumir