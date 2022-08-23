package stepDefinitions;

import helpers.Constants;
import helpers.ManagerLog;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import questions.delete.CorruptAPIDeleteEmployee;
import questions.delete.DeleteResponseQuestion;
import questions.delete.DeleteStatusQuestion;
import tasks.delete.Call;
import utils.data.DataFaker;
import utils.enums.RestService;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class DeleteEmployeeStepDefinition {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Dado("que el usuario llama el servicio para eliminar un registro")
    public void queElUsuarioLlamaElServicioParaEliminarUnRegistro() {
        ManagerLog.imprimirMensaje(Constants.MR_ROBOT + " Call Service: " + Constants.BASE_URL);
    }

    @Cuando("consume el servicio eliminar empleado")
    public void consumeElServicioEliminarEmpleado() {
        OnStage.theActorCalled(Constants.MR_ROBOT).attemptsTo(Call.service().deleteEmployee(RestService.DELETE.getUri() + "" + DataFaker.idEmployee() + ""));
    }

    @Cuando("consume el endpoint corrupto eliminar empleado")
    public void consumeElEndpointCorruptoEliminarEmpleado() {
        OnStage.theActorCalled(Constants.MR_ROBOT).attemptsTo(Call.service().deleteEmployeeEndpointCorrupt(RestService.DELETE.getUri() + "" + DataFaker.idEmployee() + ""));
    }

    @Entonces("el servicio responde exitoso")
    public void elServicioRespondeExitoso() {
        theActorInTheSpotlight().should(seeThat(DeleteStatusQuestion.confirmStatusSuccessFul()));
    }

    @Entonces("valida que arroje resultado de busqueda de forma exitosa")
    public void validaQueArrojeResultadoDeBusquedaDeFormaExitosa() {
        theActorInTheSpotlight().should(seeThat(DeleteResponseQuestion.ConfirRegisterDeleted()));
    }

    @Entonces("el servicio NO responde  exitosamente")
    public void elServicioNORespondeExitosamente() {
        theActorInTheSpotlight().should(seeThat(CorruptAPIDeleteEmployee.validAPICorrupt()));
    }
}
