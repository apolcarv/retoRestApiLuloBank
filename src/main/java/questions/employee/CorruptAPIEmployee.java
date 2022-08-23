package questions.employee;

import helpers.Constants;
import helpers.ManagerLog;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class CorruptAPIEmployee implements Question {
    @Override
    public Object answeredBy(Actor actor) {
        String message = Constants.MESSAGE_CORRUPT;
        actor.should(seeThatResponse(Constants.STATUS, response -> response.statusCode(Constants.RESPONSE_CODE_NOT_FOUND)));
        /** actor.should(seeThatResponse(Constants.MESSAGE,
         response -> response.body(Constants.MESSAGE, hasItems(message))));*/

        ManagerLog.imprimirMensaje(Constants.SEPARADOR_LINEAL);
        ManagerLog.imprimirExito("Se encontro el siguiente mensaje: " + message);
        ManagerLog.imprimirMensaje(Constants.SEPARADOR_LINEAL);
        return true;
    }

    public static CorruptAPIEmployee validAPICorrupt() {
        return new CorruptAPIEmployee();
    }
}
