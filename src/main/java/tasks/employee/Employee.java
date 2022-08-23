package tasks.employee;

import interactions.employee.GetAPICorruptEmployee;
import interactions.employee.GetEmployee;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

public class Employee {
    public Performable consultAnEmployee (String resources){
        return Task.where("{0} call the consultAnEmployee service", GetEmployee.service(resources));
    }
    public Performable consultAnEmployeeEndpointCorrupt (String resources){
        return Task.where("{0} call the consultAnEmployeeEndpointCorrupt service", GetAPICorruptEmployee.service(resources));
    }
}