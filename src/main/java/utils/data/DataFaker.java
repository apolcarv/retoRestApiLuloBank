package utils.data;

import com.github.javafaker.Faker;
import helpers.ManagerLog;
import utils.DTO.DtoCreate;

import java.util.*;

public class DataFaker {
    private DataFaker(){}
    private static Map<String,Object> map = new HashMap<>();
    public List<DtoCreate> list = new ArrayList<>();
    private static Faker faker = Faker.instance(new Locale("es", "CO"), new Random());
    private static final List<String> dataNames = new ArrayList<>();
    private static final List<String> dataSalary = new ArrayList<>();
    private static final List<String> dataAge = new ArrayList<>();
    private static DataCreate dataCreate = new DataCreate();
    private static final String LOG_CLASE = "DataFaker -> ";
    public static List<String> generarNombre() {
        dataNames.add(faker.options().option("Doris Wilder", "Caesar Vance", "Yuri Berry", "Jenette Caldwell",
                "Tiger Nixon", "Garrett Winters", "Ashton Cox", "Cedric Kelly", "Airi Satou"));
        ManagerLog.imprimirExito(LOG_CLASE + "la generacion del nombre  para la busqueda se genero exitosamente");
        return dataNames;
    }
    public static List<String> generarSalario() {
        dataSalary.add(faker.options().option("7000000", "6000000", "1000000", "4700000",
                "1800000", "2500000", "3500000", "5500000", "1014000"));
        ManagerLog.imprimirExito(LOG_CLASE + "la generacion del salario se genero exitosamente");
        return dataSalary;
    }

    public static List<String> generarEdad() {
        dataAge.add(faker.options().option("18", "19", "20", "21",
                "30", "36", "37", "25", "28"));
        ManagerLog.imprimirExito(LOG_CLASE + "la generacion de la edad se genero exitosamente");
        return dataAge;
    }
    public static void setData(){
        map.putAll(dataCreate.listMap.get(0));
    }
    public static Map<String, Object> getData(){return map;}
}
