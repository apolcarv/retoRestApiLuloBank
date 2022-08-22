package interactions.employees;

import helpers.Constants;
import helpers.ManagerLog;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.thucydides.core.util.EnvironmentVariables;

public class GetConsultEmployees implements Interaction {
    private EnvironmentVariables environmentVariables;
    private static final String LOG_CLASE = "GetConsultEmployees -> ";
    private static final String MENSAJE_GENERAL = "El servicio se consumio de forma exitosa";
    private final String resource;

    public GetConsultEmployees(String resource) {
        this.resource = resource;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String theRestApiBaseUrl =  EnvironmentSpecificConfiguration.from(environmentVariables).getProperty(Constants.BASE_URL);
        actor.whoCan(CallAnApi.at(theRestApiBaseUrl));
        actor.attemptsTo(
                Get.resource(resource)
                        .with(requestSpecification -> requestSpecification
                                .accept("application/json, text/plain, */*")
                                .relaxedHTTPSValidation()
                        )
        );
        ManagerLog.imprimirMensaje(Constants.SEPARADOR_LINEAL);
        SerenityRest.lastResponse().body().prettyPrint();
        ManagerLog.imprimirMensaje(Constants.SEPARADOR_LINEAL);
        ManagerLog.imprimirMensaje(theRestApiBaseUrl);
        ManagerLog.imprimirMensaje(Constants.SEPARADOR_LINEAL);
        ManagerLog.imprimirExito(LOG_CLASE+MENSAJE_GENERAL);
    }
    public static GetConsultEmployees service (String resource){
        return Tasks.instrumented(GetConsultEmployees.class,resource);
    }
}
