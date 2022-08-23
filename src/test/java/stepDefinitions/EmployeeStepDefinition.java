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
import questions.employee.ConsultAnEmployeeQuestion;
import questions.employee.CorruptAPIEmployee;
import questions.employee.EmployeeQuestion;
import tasks.employee.Call;
import utils.data.DataFaker;
import utils.enums.RestService;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class EmployeeStepDefinition {

    @Before
    public void setTheStage(){
        OnStage.setTheStage(new OnlineCast());
    }

    @Dado("que el usuario llama el servicio para la consulta de un empleado en particular")
    public void queElUsuarioLlamaElServicioParaLaConsultaDeUnEmpleadoEnParticular() {
        ManagerLog.imprimirMensaje(Constants.MR_ROBOT+" Call Service: "+Constants.BASE_URL);
    }
    @Cuando("consume el servicio de empleado")
    public void consumeElServicioDeEmpleado() {
        OnStage.theActorCalled(Constants.MR_ROBOT).attemptsTo(Call.service().consultAnEmployee(RestService.EMPLOYEE.getUri()+""+DataFaker.idEmployee()+""));
    }

    @Cuando("consume el endpoint corrupto consulta parametrizada")
    public void consumeElEndpointCorruptoConsultaParametrizada() {
        OnStage.theActorCalled(Constants.MR_ROBOT).attemptsTo(Call.service().consultAnEmployeeEndpointCorrupt(RestService.EMPLOYEE.getUri()+""+DataFaker.idEmployee()+""));
    }
    @Entonces("el endpoint responde de forma exitosa")
    public void elEndpointRespondeDeFormaExitosa() {
        theActorInTheSpotlight().should(seeThat(EmployeeQuestion.confirmStatusSuccessFul()));
    }
    @Entonces("valida que arroje un resultado de busqueda de forma exitosa")
    public void validaQueArrojeUnResultadoDeBusquedaDeFormaExitosa() {
        theActorInTheSpotlight().should(seeThat(ConsultAnEmployeeQuestion.ConfirRegisterSucces()));
    }
    @Entonces("el servicio NO responde exitosamente")
    public void elServicioNORespondeExitosamente() {
        theActorInTheSpotlight().should(seeThat(CorruptAPIEmployee.validAPICorrupt()));
    }

}
