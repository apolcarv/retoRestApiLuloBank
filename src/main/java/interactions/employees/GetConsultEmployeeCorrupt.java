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

public class GetConsultEmployeeCorrupt implements Interaction {
    private EnvironmentVariables environmentVariables;
    private static final String LOG_CLASE = "GetConsultEmployeeCorrupt -> ";
    private static final String MENSAJE_GENERAL = "El servicio Corrupto se consumio de forma exitosa";
    private final String resources;

    public GetConsultEmployeeCorrupt(String resources) {
        this.resources = resources;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String theRestApiBaseUrl =  EnvironmentSpecificConfiguration.from(environmentVariables).getProperty(Constants.BASE_URL);
        String theRestApiBaseUrlCorrupt = theRestApiBaseUrl+"v0";
        actor.whoCan(CallAnApi.at(theRestApiBaseUrlCorrupt));
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
        ManagerLog.imprimirMensaje(theRestApiBaseUrlCorrupt);
        ManagerLog.imprimirMensaje(Constants.SEPARADOR_LINEAL);
        ManagerLog.imprimirExito(LOG_CLASE+MENSAJE_GENERAL);
    }
    public static GetConsultEmployeeCorrupt service (String resources){
        return Tasks.instrumented(GetConsultEmployeeCorrupt.class,resources);
    }
}

