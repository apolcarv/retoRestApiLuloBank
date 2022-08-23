package stepDefinitions;

import helpers.Constants;
import helpers.ManagerLog;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import questions.create.CorrupAPICreateQuestion;
import questions.create.CreateRegisterQuestion;
import questions.create.CreateStatusQuestion;
import tasks.create.Call;
import tasks.generalGeneric.CreateGeneric;
import tasks.generalGeneric.Load;
import utils.data.DataFaker;
import utils.enums.RestService;

import static helpers.Constants.CREATE_BODY;
import static helpers.Constants.CREATE_JSON;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class CreateStepDefinition {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Dado("que el usuario llama el servicio y los datos de pruebas para crear empleados")
    public void queElUsuarioLlamaElServicioYLosDatosDePruebasParaCrearEmpleados() {
        ManagerLog.imprimirMensaje(Constants.MR_ROBOT + " Call Service: " + Constants.BASE_URL);
        OnStage.theActorCalled(Constants.MR_ROBOT).attemptsTo(Load.testData());
    }
    @Cuando("consume el servicio crear empleados")
    public void consumeElServicioCrearEmpleados() {
        OnStage.theActorCalled(Constants.MR_ROBOT).attemptsTo(CreateGeneric.messageBody(CREATE_JSON,CREATE_BODY, DataFaker.getData()));
        OnStage.theActorCalled(Constants.MR_ROBOT).attemptsTo(Call.service().createEmployee(RestService.CREATE.getUri(), CREATE_BODY));
    }

    @Cuando("consume el servicio corrupto crear empleados")
    public void consumeElServicioCorruptoCrearEmpleados() {
        OnStage.theActorCalled(Constants.MR_ROBOT).attemptsTo(CreateGeneric.messageBody(CREATE_JSON,CREATE_BODY, DataFaker.getData()));
        OnStage.theActorCalled(Constants.MR_ROBOT).attemptsTo(Call.service().createEmployeeEndpointCorrupt(RestService.CREATE.getUri(), CREATE_BODY));
    }
    @Entonces("el servicio se consume de forma exitosa")
    public void elServicioSeConsumeDeFormaExitosa() {
        theActorInTheSpotlight().should(seeThat(CreateStatusQuestion.confirmStatusOK()));
    }

    @Entonces("valida que arroje el mensaje de creacion del registro del empleado exitoso")
    public void validaQueArrojeElMensajeDeCreacionDelRegistroDelEmpleadoExitoso() {
        theActorInTheSpotlight().should(seeThat(CreateRegisterQuestion.registerSucces()));
    }
    @Entonces("el servicio NO se pudo consumir")
    public void elServicioNOSePudoConsumir() {
        theActorInTheSpotlight().should(seeThat(CorrupAPICreateQuestion.validAPICorrupt()));
    }


}
