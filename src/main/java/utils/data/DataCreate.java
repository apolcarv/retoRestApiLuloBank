package utils.data;


import helpers.ManagerLog;
import utils.DTO.DtoCreate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static helpers.Constants.AGE;
import static helpers.Constants.SALARY;
import static helpers.Constants.NAME;

public class DataCreate {

    public List<DtoCreate> list = new ArrayList<>();
    public List<Map<String, String>> listMap = new ArrayList<>();
    public DataCreate (){

        DtoCreate create = new DtoCreate();
        create.setName(DataFaker.generarNombre().get(0));
        create.setSalary(DataFaker.generarNombre().get(0));
        create.setAge(DataFaker.generarNombre().get(0));
        list.add(create);

        Map<String, String> infoCreateEmployees = new HashMap<>();
        infoCreateEmployees.put(NAME,DataFaker.generarNombre().get(0));
        infoCreateEmployees.put(SALARY,DataFaker.generarSalario().get(0));
        infoCreateEmployees.put(AGE,DataFaker.generarEdad().get(0));
        listMap.add(infoCreateEmployees);
    ManagerLog.imprimirMensaje("Se sustrajo la info correctamente");
    }

}
