package interactions.create;

import helpers.Constants;
import helpers.ManagerLog;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.thucydides.core.util.EnvironmentVariables;
import tasks.generalGeneric.CreateGeneric;
import utils.data.DataFaker;
import static helpers.Constants.CREATE_BODY;
import static helpers.Constants.CREATE_JSON;
import static io.restassured.http.ContentType.JSON;

public class PostCreate implements Interaction {

    private final String resources;
    private final String bodyName;

    private EnvironmentVariables environmentVariables;
    private static final String LOG_CLASE = "PostCreate -> ";
    private static final String MENSAJE_GENERAL = "El servicio se consumio de forma exitosa";


    public PostCreate(String resources, String bodyName) {
        this.resources = resources;
        this.bodyName = bodyName;
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        String theRestApiBaseUrl =  EnvironmentSpecificConfiguration.from(environmentVariables).getProperty(Constants.BASE_URL);
        actor.whoCan(CallAnApi.at(theRestApiBaseUrl));
        String body = actor.recall(bodyName);
        actor.attemptsTo(CreateGeneric.messageBody(CREATE_JSON,CREATE_BODY, DataFaker.getData()));
        actor.attemptsTo(
                Post.to(resources)
                        .with(request -> request.
                                contentType(JSON)
                                .body(body)
                                .relaxedHTTPSValidation()
                        )
        );
        ManagerLog.imprimirMensaje(Constants.SEPARADOR_LINEAL);
        SerenityRest.lastResponse().body().prettyPrint();
        ManagerLog.imprimirMensaje(Constants.SEPARADOR_LINEAL);
        ManagerLog.imprimirMensaje(theRestApiBaseUrl);
        ManagerLog.imprimirMensaje(Constants.SEPARADOR_LINEAL);
        ManagerLog.imprimirMensaje(bodyName);
        ManagerLog.imprimirMensaje(Constants.SEPARADOR_LINEAL);
        ManagerLog.imprimirExito(LOG_CLASE+MENSAJE_GENERAL);
    }
    public static PostCreate service (String recources, String bodyName){
        return Tasks.instrumented(PostCreate.class,recources,bodyName);
    }
}
