package questions.employees;

import com.github.javafaker.Faker;
import helpers.Constants;
import utils.data.DataFaker;
import helpers.ManagerLog;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import java.util.Locale;
import java.util.Random;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.CoreMatchers.hasItems;

public class FieldConsultEmployeesQuestion implements Question {
    private static Faker faker = Faker.instance(new Locale("es", "CO"), new Random());
    @Override
    public Object answeredBy(Actor actor) {
        int id  = faker.number().numberBetween(1,24);
        String employee_name = DataFaker.generarNombre().get(0);
        actor.should(seeThatResponse(Constants.REGYSTER_NUMBER,
                response -> response.body("data.id", hasItems(id))));
        actor.should(seeThatResponse(Constants.EMPLOYEE_NAME,
                response -> response.body("data.employee_name", hasItems(employee_name))));
        ManagerLog.imprimirMensaje(Constants.SEPARADOR_LINEAL);
        ManagerLog.imprimirExito("La consulta de los valores de los campos id: ["+id+"], y nombre del empleado ["+employee_name+"] son correctos");
        ManagerLog.imprimirMensaje(Constants.SEPARADOR_LINEAL);
        return true;
    }
    public static FieldConsultEmployeesQuestion validFieldJSON(){
        return new FieldConsultEmployeesQuestion();
    }
}
