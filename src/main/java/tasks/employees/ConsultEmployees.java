package tasks.employees;

import interactions.employees.GetConsultEmployeeCorrupt;
import interactions.employees.GetConsultEmployees;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

public class ConsultEmployees {

    public Performable consultEmployees (String resources){
        return Task.where("{0} call the consultEmployees service", GetConsultEmployees.service(resources));
    }
    public Performable consultEmployeesEndpointCorrupt (String resources){
        return Task.where("{0} call the consultEmployeesEndpointCorrupt service", GetConsultEmployeeCorrupt.service(resources));
    }
}
