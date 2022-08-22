package helpers;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class DataFaker {
    private DataFaker(){}
    private static Faker faker = Faker.instance(new Locale("es", "CO"), new Random());
    private static final List<String> datosDeBusqueda = new ArrayList<>();
    private static final String LOG_CLASE = "Utils -> ";
    public static List<String> generarNombreParaBusqueda() {
        datosDeBusqueda.add(faker.options().option("Doris Wilder", "Caesar Vance", "Yuri Berry", "Jenette Caldwell",
                "Tiger Nixon", "Garrett Winters", "Ashton Cox", "Cedric Kelly", "Airi Satou"));
        ManagerLog.imprimirExito(LOG_CLASE + "la generacion del nombre  para la busqueda se genero exitosamente");
        return datosDeBusqueda;
    }
}
