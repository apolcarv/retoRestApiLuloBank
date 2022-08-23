package interactions.employee;

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


public class GetEmployee implements Interaction {
    private EnvironmentVariables environmentVariables;
    private static final String LOG_CLASE = "GetEmployee -> ";
    private static final String MENSAJE_GENERAL = "El servicio se consumio de forma exitosa";
    private final String resources;

    public GetEmployee(String resources) {
        this.resources = resources;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String theRestApiBaseUrl =  EnvironmentSpecificConfiguration.from(environmentVariables).getProperty(Constants.BASE_URL);
        actor.whoCan(CallAnApi.at(theRestApiBaseUrl));
        actor.attemptsTo(
                Get.resource(resources)
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
    public static GetEmployee service (String resources){
        return Tasks.instrumented(GetEmployee.class,resources);
    }
}
