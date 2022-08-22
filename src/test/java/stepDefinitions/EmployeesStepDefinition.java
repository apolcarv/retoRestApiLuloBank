package stepDefinitions;

import helpers.Constants;
import helpers.ManagerLog;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import questions.employees.ConsultEmployeesQuestion;
import questions.employees.CorruptAPIConsultEmployeesQuestion;
import questions.employees.FieldConsultEmployeesQuestion;
import tasks.employees.Call;
import utils.RestService;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class EmployeesStepDefinition {

    @Before
    public void setTheStage(){
        OnStage.setTheStage(new OnlineCast());
    }

    @Dado("que el usuario llama el servicio consulta de empleados")
    public void queElUsuarioConsumeElServicioConsultaDeEmpleados() {
        ManagerLog.imprimirMensaje(Constants.MR_ROBOT+" Call Service: "+Constants.BASE_URL);
    }
    @Cuando("consume el servicio consulta de empleado")
    public void llamaElServicioConsultaDeEmpleado() {
        OnStage.theActorCalled(Constants.MR_ROBOT).attemptsTo(Call.service().ConsultEmployees(RestService.EMPLOYEES.getUri()));
    }
    @Cuando("consume el servicio corrupto consulta de empleado")
    public void consumeElServicioCorruptoConsultaDeEmpleado() {
        OnStage.theActorCalled(Constants.MR_ROBOT).attemptsTo(Call.service().ConsultEmployeesEndpointCorrupt(RestService.EMPLOYEES.getUri()));
    }
    @Entonces("el servicio responde de forma exitosa")
    public void elServicioRespondeDeFormaExitosa() {
        theActorInTheSpotlight().should(seeThat(ConsultEmployeesQuestion.confirmEstatusSuccessFul()));
    }

    @Entonces("valida que arroje resultados de busqueda de forma exitosa")
    public void validaQueArrojeResultadosDeBusquedaDeFormaExitosa() {
        theActorInTheSpotlight().should(seeThat(FieldConsultEmployeesQuestion.validFieldJSON()));
    }

    @Entonces("el servicio NO responde de forma exitosa")
    public void elServicioNORespondeDeFormaExitosa() {
        theActorInTheSpotlight().should(seeThat(CorruptAPIConsultEmployeesQuestion.validAPICorrupt()));
    }
}
