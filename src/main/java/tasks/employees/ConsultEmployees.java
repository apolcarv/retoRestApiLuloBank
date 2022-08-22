package tasks.employees;

import interactions.employees.GetConsultEmployeeCorrupt;
import interactions.employees.GetConsultEmployees;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

public class ConsultEmployees {

    public Performable ConsultEmployees (String resource){
        return Task.where("{0} call the ConsultEmployees service", GetConsultEmployees.service(resource));
    }
    public Performable ConsultEmployeesEndpointCorrupt (String resource){
        return Task.where("{0} call the ConsultEmployees service", GetConsultEmployeeCorrupt.service(resource));
    }
}
