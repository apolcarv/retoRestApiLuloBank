package stepDefinitions;

import helpers.Constants;
import helpers.ManagerLog;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import questions.delete.DeleteStatusQuestion;
import questions.update.CorruptAPIUpdateQuestion;
import questions.update.UpdateResponse;
import questions.update.UpdateStatus;
import tasks.update.Call;
import utils.data.DataFaker;
import utils.enums.RestService;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class UpdateStepDefinition {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Dado("que el usuario llama el servicio para actualizar un registro")
    public void queElUsuarioLlamaElServicioParaActualizarUnRegistro() {
        ManagerLog.imprimirMensaje(Constants.MR_ROBOT + " Call Service: " + Constants.BASE_URL);
    }
    @Cuando("consume el servicio actualizar empleado")
    public void consumeElServicioActualizarEmpleado() {
        OnStage.theActorCalled(Constants.MR_ROBOT).attemptsTo(Call.service().updateEmployee(RestService.UPDATE.getUri() + "" + DataFaker.idEmployee() + ""));
    }

    @Cuando("consume el endpoint corrupto actualizar empleado")
    public void consumeElEndpointCorruptoActualizarEmpleado() {
        OnStage.theActorCalled(Constants.MR_ROBOT).attemptsTo(Call.service().updateEmployeeEndpointCorrupt(RestService.UPDATE.getUri() + "" + DataFaker.idEmployee() + ""));
    }

    @Entonces("el servicio responde exitososamente")
    public void elServicioRespondeExitososamente() {
        theActorInTheSpotlight().should(seeThat(UpdateResponse.ConfirRegisterDeleted()));
    }
    @Entonces("valida  que arroje resultado de busqueda de forma exitosa")
    public void validaQueArrojeResultadoDeBusquedaDeFormaExitosa() {
        theActorInTheSpotlight().should(seeThat(UpdateStatus.confirmStatusSuccessFul()));
    }
    @Entonces("el servicio  NO responde exitosamente")
    public void elServicioNORespondeExitosamente() {
        theActorInTheSpotlight().should(seeThat(CorruptAPIUpdateQuestion.validAPICorrupt()));
    }
}
